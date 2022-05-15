package itse1909r.borangaziyev.controller;

import itse1909r.borangaziyev.model.Payment;
import itse1909r.borangaziyev.model.Provider;
import itse1909r.borangaziyev.model.Rate;
import itse1909r.borangaziyev.service.ElectricityBillService;
import itse1909r.borangaziyev.service.PaymentService;
import itse1909r.borangaziyev.service.ProviderService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.io.*;
import java.util.List;


@Controller
@RequestMapping("/providers")
public class ProviderController {

    private ProviderService providerService;
    private PaymentService paymentService;

    @Value("${file.path}")
    private String filePath;

    @Autowired
    public ProviderController(ProviderService providerService, PaymentService paymentService) {
        this.providerService = providerService;
        this.paymentService = paymentService;
    }

    @PutMapping("/updateRate")
    @ResponseBody
    public String updateRate(@RequestBody Rate rate) {
        return providerService.updateRate(rate) ? "Successfully updated": "Failed to update";
    }

    @GetMapping("/providersPaged/{page:[0-9]*}/{limit:[0-9]+}/{sortByColumn:[A-z]*}")
    @ResponseBody
    public List<Provider> getPagedProviders(
            @PathVariable(name = "page") int page,
            @PathVariable(name = "limit") int limit,
            @PathVariable(name = "sortByColumn") String sortByColumn
    ) {
        return providerService.getPagedProviders(page, limit, sortByColumn);
    }

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity downloadFile(@PathVariable("fileName") String fileName) throws FileNotFoundException {

        filePath += fileName;
        File file = new File(filePath);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentLength(file.length())
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);


    }

    @PostMapping(value = "/uploadFile/{fileName}")
    public ResponseEntity uploadFile(
            @PathVariable("fileName") String fileName,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            System.out.println(fileName);
            if(fileName == null || fileName.isEmpty()) fileName = "newUploadedFile.txt";
            File uploadFile = new File(filePath+fileName);
            OutputStream outputStream = new FileOutputStream(uploadFile);

            IOUtils.copy(file.getInputStream(), outputStream);

            uploadFile.createNewFile();
            System.out.println(filePath+fileName);
            System.out.println(uploadFile.exists());

            return ResponseEntity.ok()
                    .body("Successfully uploaded!");

        } catch (FileNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
    }
}
