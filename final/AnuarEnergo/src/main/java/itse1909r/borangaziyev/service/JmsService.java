package itse1909r.borangaziyev.service;

import itse1909r.borangaziyev.jms.JmsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {


    private JmsTemplate jmsTemplate;

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    protected void listenFromCustomer(JmsMessage message) {
        System.out.println("Mailbox:");
        System.out.println(message.getFrom() + " : " + message.getMessage());
    }

    @JmsListener(destination = "suggestions", containerFactory = "myFactory")
    protected void listenForSuggestions(JmsMessage message) {
        System.out.println("Suggestions:");
        System.out.println(message.getFrom() + " : " + message.getMessage());
    }

    @JmsListener(destination = "complaints", containerFactory = "myFactory")
    protected void listenToComplaints(JmsMessage message) {
        System.out.println("Complaints:");
        System.out.println(message.getFrom() + " : " + message.getMessage());
    }

    public void sendMessage(String destination, JmsMessage message) {
        jmsTemplate.convertAndSend(destination, message);
    }

}
