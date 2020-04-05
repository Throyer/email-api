package com.github.throyer.helloemail.services;

import java.util.List;

import javax.mail.MessagingException;

import com.github.throyer.helloemail.model.shared.AnexoSimples;
import com.github.throyer.helloemail.model.shared.EmailSimples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;

@Service
public class MailService {

    private static Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    private static String ERROR_MESSAGE = "erro ao enviar email";

    private static final Boolean CONTENT_IS_HTML = true;
    private static final Boolean IS_MULTIPARTFILE = true;

    @Autowired
    private TemplateEngine engine;

    @Autowired
    private JavaMailSender sender;

    public void send(EmailSimples email) {

        try {

            var message = sender.createMimeMessage();

            var helper = new MimeMessageHelper(message);

            configure(email, helper);

            sender.send(message);

        } catch (MessagingException exception) {
            LOGGER.error(ERROR_MESSAGE, exception);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_MESSAGE);
        }

    }

    public void send(EmailSimples email, List<AnexoSimples> anexos) {

        try {

            var message = sender.createMimeMessage();

            var helper = new MimeMessageHelper(message, IS_MULTIPARTFILE);

            configure(email, helper);

            for (AnexoSimples anexo : anexos) {
                helper.addAttachment(anexo.getNome(), anexo.getAquivo());
            }

            sender.send(message);

        } catch (MessagingException exception) {
            LOGGER.error(ERROR_MESSAGE, exception);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ERROR_MESSAGE);
        }
    }

    private MimeMessageHelper configure(EmailSimples email, MimeMessageHelper helper) throws MessagingException {

        helper.setTo(email.getDestinatarios());

        helper.setSubject(email.getAssunto());

        helper.setText(engine.process(email.getTemplate(), email.getContext()), CONTENT_IS_HTML);

        return helper;
    }
}