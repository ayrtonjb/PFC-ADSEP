package com.pfc.ayrton.pfc_adsep;

/**
 * Created by Ayrton on 2016-05-08.
 */
public class InstituicaoServico {

    private String id;
    private String instituicaoId;
    private String servicoID;

    public InstituicaoServico(String id, String instituicaoId, String servicoID) {
        this.id = id;
        this.instituicaoId = instituicaoId;
        this.servicoID = servicoID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(String instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public String getServicoID() {
        return servicoID;
    }

    public void setServicoID(String servicoID) {
        this.servicoID = servicoID;
    }
}
