package bean;

/**
 * Created by Ayrton on 2016-05-15.
 */
public class Estabelecimento {


    private String id;
    private String nome;
    private String tipo;
    private String instituicao_id;
    private String endereco;
    private double latitude;
    private double longitude;
    private String contacto_estabelecimento_id;
    private String horario_abertura;
    private String horario_encerramento;

    public Estabelecimento() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstituicao_id() {
        return instituicao_id;
    }

    public void setInstituicao_id(String instituicao_id) {
        this.instituicao_id = instituicao_id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getContacto_estabelecimento_id() {
        return contacto_estabelecimento_id;
    }

    public void setContacto_estabelecimento_id(String contacto_estabelecimento_id) {
        this.contacto_estabelecimento_id = contacto_estabelecimento_id;
    }

    public String getHorario_abertura() {
        return horario_abertura;
    }

    public void setHorario_abertura(String horario_abertura) {
        this.horario_abertura = horario_abertura;
    }

    public String getHorario_encerramento() {
        return horario_encerramento;
    }

    public void setHorario_encerramento(String horario_encerramento) {
        this.horario_encerramento = horario_encerramento;
    }
}
