package com.example.MsAdolescente.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendLoginNotification(String recipientEmail, String username, String password) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject("Inicio de sesión exitoso");
        mailMessage.setText("Hola soy el usuario " + username + " ha iniciado sesión en la aplicación. Contraseña: " + password);
        javaMailSender.send(mailMessage);
    }
}