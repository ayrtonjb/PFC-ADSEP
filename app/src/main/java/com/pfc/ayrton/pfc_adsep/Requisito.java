package com.pfc.ayrton.pfc_adsep;

import java.io.File;

/**
 * Created by Ayrton on 2016-05-08.
 */
public class Requisito {


    private String id;
    private String nome;
    private String descricao;
    private File anexo;

    public Requisito(String id, String nome, String descricao, File anexo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.anexo = anexo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public File getAnexo() {
        return anexo;
    }

    public void setAnexo(File anexo) {
        this.anexo = anexo;
    }
}
