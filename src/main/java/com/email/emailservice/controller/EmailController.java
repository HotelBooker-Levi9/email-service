package com.email.emailservice.controller;

import com.email.emailservice.dto.ReservationConfirmationDto;
import com.email.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendConfirmationMail")
    public void sendConfirmationMail(@RequestBody ReservationConfirmationDto confirmationDto) {
        emailService.sendReservationConfirmationEmail(confirmationDto);
    }

}
