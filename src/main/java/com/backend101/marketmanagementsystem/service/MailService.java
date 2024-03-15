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

    public String sendMail(String destinationTo,String description) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("ruhuseyn26@gmail.com");
        message.setTo(destinationTo);
        message.setText(description);
        message.setSubject("Meshulunuz hazir");
        mailSender.send(message);
        return "Gönderildi";
    }
}
