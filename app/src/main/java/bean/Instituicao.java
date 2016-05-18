package bean;

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
    private String categoria_id;
    private String logo;



    public Instituicao(String id, String nome, String descricao, String categoria_id, String logo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria_id = categoria_id;
        this.logo = logo;

    }

    public Instituicao() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria_id(String categoria_id) {
        this.categoria_id = categoria_id;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria_id() {
        return categoria_id;
    }

    public String getLogo() {
        return logo;
    }
}
