package com.email.emailservice.service;

import com.email.emailservice.dto.ReservationConfirmationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Async
    public void sendReservationConfirmationEmail(ReservationConfirmationDto confirmationDto) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(confirmationDto.getUserEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));

        mail.setSubject("HotelBooker - Reservation Confirmation");
        mail.setText("Greetings " + confirmationDto.getUserName() + ",\n\nYour reservations have been made.");
        javaMailSender.send(mail);
    }
}
