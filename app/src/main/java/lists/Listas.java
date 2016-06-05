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
    public static int estabelecimentoEscolhidoID;
    public static String todosEstabelecimentosListcontroller;
    // 0=tela servico 1=tela instituicao
    public static ArrayList<Servico> servicos= new ArrayList<Servico>();
    public static ArrayList<Servico> currentServicosList= new ArrayList<Servico>();
    public static ArrayList<Instituicao> instituicoes= new ArrayList<Instituicao>();
    public static ArrayList<Estabelecimento> estabelecimentos= new ArrayList<Estabelecimento>();
    public static ArrayList<Estabelecimento> currentEstabelecimentosList= new ArrayList<Estabelecimento>();
    public static ArrayList<Categoria> categorias= new ArrayList<Categoria>();
    public static ArrayList<InstituicaoServico> instituicaoServicos= new ArrayList<InstituicaoServico>();
    public static ArrayList<EstabelecimentoServico> estabelecimentoServicos= new ArrayList<EstabelecimentoServico>();
    public static ArrayList<Requisito> requisitos= new ArrayList<Requisito>();
    public static ArrayList<ServicoRequisito> servicoRequisitos= new ArrayList<ServicoRequisito>();
    public static ArrayList<ContactoEstabelecimento> contactoEstabelecimentos= new ArrayList<ContactoEstabelecimento>();


    public static void setInstituicaoEscolhidaId(int instituicaoEscolhidaId) {
        Listas.instituicaoEscolhidaId = instituicaoEscolhidaId;
    }

    public static void setServicoEscolhidoId(int servicoEscolhidoId) {
        Listas.servicoEscolhidoId = servicoEscolhidoId;
    }

    public static void setEstabelecimentoEscolhidoID(int estabelecimentoEscolhidoID) {
        Listas.estabelecimentoEscolhidoID = estabelecimentoEscolhidoID;
    }

    public static void setTodosEstabelecimentosListcontroller(String todosEstabelecimentosListcontroller) {
        Listas.todosEstabelecimentosListcontroller = todosEstabelecimentosListcontroller;
    }

    public static void setCurrentEstabelecimentosList(ArrayList<Estabelecimento> currentEstabelecimentosList) {
        Listas.currentEstabelecimentosList = currentEstabelecimentosList;
    }

    public static void setCurrentServicosList(ArrayList<Servico> currentServicosList) {
        Listas.currentServicosList = currentServicosList;
    }
}
