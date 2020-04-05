package com.github.throyer.helloemail.model.shared;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.github.throyer.helloemail.validation.constraints.IsEmailList;

import org.thymeleaf.context.Context;

public abstract class EmailSimples {

    @NotEmpty(message = "Por favor, forneça o assunto do email.")
    private String assunto;

    @NotEmpty(message = "Por favor, informe o template do email.")
    private String template;
    
    @IsEmailList(message = "Por favor, forneça uma lista com emails validos.")
    @NotEmpty(message = "Por favor, foneça ao menos um destinatario.")
    private List<String> destinatarios = new ArrayList<>();

    public abstract Context getContext();

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String [] getDestinatarios() {
        return destinatarios.toArray(new String [destinatarios.size()]);
    }

    public void setDestinatarios(List<String> destinatarios) {
        this.destinatarios = destinatarios;
    }
}