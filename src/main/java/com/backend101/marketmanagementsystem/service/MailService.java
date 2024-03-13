package com.backend101.marketmanagementsystem.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MailService {

    JavaMailSender mailSender;

    public String sendMail() {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("ruhuseyn26@gmail.com");
        message.setTo("vazifa.guliyeva@gmail.com");
        message.setText("Revan Exception+securityni yaz");
        message.setSubject("Isdememis Gelme!!!!!!!!!!!!!!!");
        mailSender.send(message);
        return "Gönderildi";
    }
}
