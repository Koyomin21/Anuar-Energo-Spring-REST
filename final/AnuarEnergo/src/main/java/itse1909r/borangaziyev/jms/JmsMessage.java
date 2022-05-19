package itse1909r.borangaziyev.jms;


import lombok.Data;

@Data
public class JmsMessage {
    private String from;
    private String message;

    public JmsMessage(String from, String message) {
        this.from = from;
        this.message = message;
    }

}
