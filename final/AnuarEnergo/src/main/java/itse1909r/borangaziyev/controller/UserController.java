package itse1909r.borangaziyev.controller;

import itse1909r.borangaziyev.model.SocketMessage;
import itse1909r.borangaziyev.model.User;
import itse1909r.borangaziyev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        System.out.println(user);
        if(userService.insertUser(user)) return user.toString();

        return "Could not be inserted";
    }

    @DeleteMapping("/delete/{id:[0-9]+}")
    @ResponseBody
    public String deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id) ? "Successfully Deleted" : "Failed to Delete";
    }


    @GetMapping("/userChat")
    public String getUserChat(Model model) {
        return "chat";
    }


    @MessageMapping("/userChat")
    @SendTo("/topic/messages")
    public SocketMessage send(SocketMessage message) {
        System.out.println("Message recieved: " + message);
        SocketMessage msg = new SocketMessage();
        msg.setMessage(message.getMessage());
        msg.setDateTime(LocalDateTime.now());
        return msg;
    }
}
