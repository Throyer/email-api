package com.github.throyer.helloemail.controllers;

import javax.validation.Valid;

import com.github.throyer.helloemail.model.ExampleEmail;
import com.github.throyer.helloemail.services.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    private MailService service;

    @PostMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void index(@Valid @RequestBody ExampleEmail email) {
        service.send(email);
    }
}