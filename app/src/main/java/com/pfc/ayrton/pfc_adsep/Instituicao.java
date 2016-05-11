package com.pfc.ayrton.pfc_adsep;

import android.location.Location;
import android.media.Image;

import java.sql.Time;

/**
 * Created by Ayrton on 2016-05-08.
 */
public class Instituicao {

    private String id;
    private String nome;
    private String descricao;
    private String endereco;
    private Location localizacao;
    private Time horarioAbertura;
    private Time horarioEncerramento;
    private String diasServico;
    private String categoriaID;
    private Image logo;
    private Image foto;


    public Instituicao(String id, String nome, String descricao, String endereco, Location localizacao, Time horarioAbertura, Time horarioEncerramento, String diasServico, String categoriaID, Image logo, Image foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.localizacao = localizacao;
        this.horarioAbertura = horarioAbertura;
        this.horarioEncerramento = horarioEncerramento;
        this.diasServico = diasServico;
        this.categoriaID = categoriaID;
        this.logo = logo;
        this.foto = foto;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Time getHorarioAbertura() {
        return horarioAbertura;
    }

    public void setHorarioAbertura(Time horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public Time getHorarioEncerramento() {
        return horarioEncerramento;
    }

    public void setHorarioEncerramento(Time horarioEncerramento) {
        this.horarioEncerramento = horarioEncerramento;
    }

    public String getDiasServico() {
        return diasServico;
    }

    public void setDiasServico(String diasServico) {
        this.diasServico = diasServico;
    }

    public String getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(String categoriaID) {
        this.categoriaID = categoriaID;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
}
