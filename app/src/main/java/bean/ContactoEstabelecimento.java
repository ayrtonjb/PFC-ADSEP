package bean;

/**
 * Created by Ayrton on 2016-05-15.
 */
public class ContactoEstabelecimento {

    private String id;
    private String estabelecimento_id;
    private String telefone;
    private String telefone_movel;
    private String fax;
    private String email;

    public ContactoEstabelecimento() {

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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTelefone_movel(String telefone_movel) {
        this.telefone_movel = telefone_movel;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstabelecimento_id() {
        return estabelecimento_id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTelefone_movel() {
        return telefone_movel;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }
}
