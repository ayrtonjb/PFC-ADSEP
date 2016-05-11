package com.pfc.ayrton.pfc_adsep;

/**
 * Created by Ayrton on 2016-05-08.
 */
public class ServicoRequisito {

    private String id;
    private String servicoId;
    private String requisitoId;

    public ServicoRequisito(String id, String servicoId, String requisitoId) {
        this.id = id;
        this.servicoId = servicoId;
        this.requisitoId = requisitoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServicoId() {
        return servicoId;
    }

    public void setServicoId(String servicoId) {
        this.servicoId = servicoId;
    }

    public String getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(String requisitoId) {
        this.requisitoId = requisitoId;
    }
}
