package bean;

import java.io.File;

/**
 * Created by Ayrton on 2016-05-08.
 */
public class Servico {

    private String id;
    private String nome;
    private String descricao;
    private String categoriaID;

    public Servico() {
    }

    public Servico(String id, String nome, String descricao,String categoriaID) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;

        this.categoriaID = categoriaID;
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

    public String getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(String categoriaID) {
        this.categoriaID = categoriaID;
    }

}
