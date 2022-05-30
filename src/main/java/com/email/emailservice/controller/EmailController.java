package com.email.emailservice.controller;

import com.email.emailservice.dto.ReservationConfirmationDto;
import com.email.emailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendConfirmationMail")
    public void sendConfirmationMail(@RequestBody ReservationConfirmationDto confirmationDto) {
        emailService.sendReservationConfirmationEmail(confirmationDto);
    }

}
