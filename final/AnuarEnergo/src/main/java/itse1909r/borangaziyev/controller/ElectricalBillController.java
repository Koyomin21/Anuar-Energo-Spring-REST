package itse1909r.borangaziyev.controller;

import itse1909r.borangaziyev.model.ElectricityBill;
import itse1909r.borangaziyev.service.ElectricityBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/bills")
public class ElectricalBillController {


    private ElectricityBillService billService;

    @Autowired
    public ElectricalBillController(ElectricityBillService billService) {
        this.billService = billService;
    }



    @RequestMapping(value = "/options", method = RequestMethod.OPTIONS)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS");
        return ResponseEntity.ok("Success");
    }

    @RequestMapping(value = "/checkBills",method = RequestMethod.HEAD)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ResponseEntity<List<ElectricityBill>> getBillsByUserId(@RequestParam int userId) {
        try {
            List<ElectricityBill> bills = billService.getBillsOfUser(userId);

            if(bills == null || bills.isEmpty()) return ResponseEntity.noContent().header("hasBills", "false").build();

            return ResponseEntity.noContent().header("hasBills", "true").build();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e
            );
        }
    }



}
