package com.github.throyer.helloemail.model;

import javax.validation.constraints.NotEmpty;

import com.github.throyer.helloemail.model.shared.EmailSimples;

import org.thymeleaf.context.Context;

public class ExampleEmail extends EmailSimples {

    @NotEmpty(message = "por favor informe a mensagem")
    private String mensagem = "Mensagem padrão";

    @Override
    public Context getContext() {
        var context = new Context();
        context.setVariable("mensagem", this.mensagem);
        return context;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}