package bd_stuff;

import android.util.Log;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Categoria;
import bean.ContactoEstabelecimento;
import bean.Estabelecimento;
import bean.EstabelecimentoServico;
import bean.Instituicao;
import bean.InstituicaoServico;
import bean.Requisito;
import bean.Servico;
import bean.ServicoRequisito;
import lists.Listas;


/**
 * Created by Ayrton on 2016-05-16.
 */
public class BDConnector{

    static Connection con;

    private static Connection getConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Log.d("BD", "sucesso2");

            con= DriverManager.getConnection("jdbc:mysql://10.127.127.1:3307/db_pfc_adsep","root","root");
            return con;

            // return DriverManager.getConnection("jdbc:mysql://10.71.34.1:3306/saa", "root", "choo");
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d("BD", "fail");
        }

        catch (SQLException e) {
            e.printStackTrace();
            Log.d("DB", "fail2");
        }

        Log.d("DB", "Connector e null");
        return con;
    }


    public static void load_servico() {

        con = getConnection();
        // pega a conex ã o e o Statement

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from servico");
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setId(rs.getString("id_servico"));
                servico.setNome(rs.getString("nome"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setCategoriaID(rs.getString("categoria_id"));
                Listas.servicos.add(servico);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_instituicao() {

        con = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from instituicao");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Instituicao instituicao=new Instituicao();
                instituicao.setId(rs.getString("id_instituicao"));
                instituicao.setNome(rs.getString("nome"));
                instituicao.setDescricao(rs.getString("descricao"));
                instituicao.setCategoria_id(rs.getString("categoria_id"));
                Listas.instituicoes.add(instituicao);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_estabelecimento() {

        con = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from estabelecimento");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estabelecimento estabelecimento= new Estabelecimento();

                estabelecimento.setId(rs.getString("id_estabelecimento"));
                estabelecimento.setNome(rs.getString("nome"));
                estabelecimento.setTipo(rs.getString("tipo"));
                estabelecimento.setInstituicao_id(rs.getString("instituicao_id"));
                estabelecimento.setEndereco(rs.getString("endereco"));
                estabelecimento.setLatitude(rs.getDouble("latitude"));
                estabelecimento.setLongitude(rs.getDouble("longitude"));
                estabelecimento.setContacto_estabelecimento_id(rs.getString("contacto_estabelecimento_id"));
                estabelecimento.setHorario_abertura(rs.getString("horario_abertura"));
                estabelecimento.setHorario_encerramento(rs.getString("horario_encerramento"));



                Listas.estabelecimentos.add(estabelecimento);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_categoria() {

        con = getConnection();
        System.out.println("connectou!");
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from categoria");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria= new Categoria();
                categoria.setId(rs.getString("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                Listas.categorias.add(categoria);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_requisito() {
        con = getConnection();
        // pega a conex ã o e o Statement
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from requisito");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Requisito requisito = new Requisito();
                requisito.setId(rs.getString("id_requisito"));
                requisito.setNome(rs.getString("nome"));
                requisito.setDescricao(rs.getString("descricao"));
               // requisito.setAnexo(rs.getString("anexo"));
                Listas.requisitos.add(requisito);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_instituicao_servico() {
        con = getConnection();
        // pega a conex ã o e o Statement
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from instituicao_servico");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                InstituicaoServico instituicaoServico = new InstituicaoServico();
                instituicaoServico.setId(rs.getString("id_instituicao_servico"));
                instituicaoServico.setInstituicaoId(rs.getString("instituicao_id"));
                instituicaoServico.setServicoID(rs.getString("servico_id"));

                Listas.instituicaoServicos.add(instituicaoServico);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_servico_requisito() {
        con = getConnection();
        // pega a conex ã o e o Statement
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from servico_requisito");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ServicoRequisito servicoRequisito= new ServicoRequisito();
                servicoRequisito.setId(rs.getString("id_servico_requisito"));
                servicoRequisito.setRequisitoId(rs.getString("requisito_id"));
                servicoRequisito.setServicoId(rs.getString("servico_id"));

                Listas.servicoRequisitos.add(servicoRequisito);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void load_estabeleciometo_servico() {
        con = getConnection();
        // pega a conex ã o e o Statement
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from estabelecimento_servico");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                EstabelecimentoServico estabelecimentoServico = new EstabelecimentoServico();
                estabelecimentoServico.setId(rs.getString("id_estabelecimento_servico"));
                estabelecimentoServico.setEstabelecimento_id(rs.getString("estabelecimento_id"));
                estabelecimentoServico.setServico_id(rs.getString("servico_id"));

                Listas.estabelecimentoServicos.add(estabelecimentoServico);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void load_contacto_estabelecimento() {
        con = getConnection();
        // pega a conex ã o e o Statement
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("select * from contacto_estabelecimento");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ContactoEstabelecimento contactoEstabelecimento = new ContactoEstabelecimento();
                contactoEstabelecimento.setId(rs.getString("id_contacto_estabelecimento"));
                contactoEstabelecimento.setTelefone(rs.getString("telefone"));
                contactoEstabelecimento.setTelefone_movel(rs.getString("telefone_movel"));
                contactoEstabelecimento.setFax(rs.getString("fax"));
                contactoEstabelecimento.setEmail(rs.getString("email"));

                Listas.contactoEstabelecimentos.add(contactoEstabelecimento);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
