package bean;

/**
 * Created by Ayrton on 2016-05-15.
 */
public class EstabelecimentoServico {

    private String id;
    private String estabelecimento_id;
    private String servico_id;

    public EstabelecimentoServico() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEstabelecimento_id(String estabelecimento_id) {
        this.estabelecimento_id = estabelecimento_id;
    }

    public void setServico_id(String servico_id) {
        this.servico_id = servico_id;
    }

    public String getEstabelecimento_id() {
        return estabelecimento_id;
    }

    public String getServico_id() {
        return servico_id;
    }
}

