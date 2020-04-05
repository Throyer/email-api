package com.github.throyer.helloemail.model.shared;

import java.io.File;

public class AnexoSimples {

    private String nome;
    private File aquivo;

    public String getNome() {
        return nome;
    }

    public File getAquivo() {
        return aquivo;
    }

    public void setAquivo(File aquivo) {
        this.aquivo = aquivo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}