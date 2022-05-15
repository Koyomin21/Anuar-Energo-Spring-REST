package itse1909r.borangaziyev.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SocketMessage {
    private String message;
    private LocalDateTime dateTime;

    public SocketMessage(){}
}
