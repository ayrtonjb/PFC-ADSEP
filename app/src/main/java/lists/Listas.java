package lists;

import android.util.Log;

import java.util.ArrayList;

import bean.Categoria;
import bean.ContactoEstabelecimento;
import bean.Estabelecimento;
import bean.EstabelecimentoServico;
import bean.Instituicao;
import bean.InstituicaoServico;
import bean.Requisito;
import bean.Servico;
import bean.ServicoRequisito;

/**
 * Created by Ayrton on 2016-05-16.
 */
public class Listas {

    public static int servicoEscolhidoId;
    public static int instituicaoEscolhidaId;
    public static ArrayList<Servico> servicos= new ArrayList<Servico>();
    public static ArrayList<Instituicao> instituicoes= new ArrayList<Instituicao>();
    public static ArrayList<Estabelecimento> estabelecimentos= new ArrayList<Estabelecimento>();
    public static ArrayList<Categoria> categorias= new ArrayList<Categoria>();
    public static ArrayList<InstituicaoServico> instituicaoServicos= new ArrayList<InstituicaoServico>();
    public static ArrayList<EstabelecimentoServico> estabelecimentoServicos= new ArrayList<EstabelecimentoServico>();
    public static ArrayList<Requisito> requisitos= new ArrayList<Requisito>();
    public static ArrayList<ServicoRequisito> servicoRequisitos= new ArrayList<ServicoRequisito>();
    public static ArrayList<ContactoEstabelecimento> contactoEstabelecimentos= new ArrayList<ContactoEstabelecimento>();


public String getRequisitosDoServico(String idServico){
    String req = new String();
    ArrayList<Requisito> requisitosDoServico=new ArrayList<Requisito>();
    //procurar ID dos requisitos
    for(int i=0;i<servicoRequisitos.size();i++){

        if(servicoRequisitos.get(i).getServicoId().equalsIgnoreCase(idServico)){
            for(int i2=0;i2<requisitos.size();i2++){
                if(requisitos.get(i2).getId().equalsIgnoreCase(servicoRequisitos.get(i).getRequisitoId())){
                    requisitosDoServico.add(requisitos.get(i2));
                    Log.d("P.R.", "Apanhou "+i2);
                }
            }

        }
    }
    //colocar os requisitos na string

    for(int i3=0;i3<requisitosDoServico.size();i3++){
        String reqs="";
        String reqs0="";
        if (req.isEmpty()) {
            req="-"+requisitosDoServico.get(i3).getDescricao();
            Log.d("P.R.", "Chegou no String "+requisitosDoServico.get(i3).getDescricao()+"  req:"+req);

        }
        else {

        req=req+System.getProperty("line.separator")+"-"+requisitosDoServico.get(i3).getDescricao();
            reqs0=reqs;
            Log.d("P.R.", "Chegou no String 2 "+requisitosDoServico.get(i3).getDescricao());
           req=reqs;

        }

    }
    Log.d("P.R.","---"+req);
    return req;
}



}
