package br.edu.ifsp.pep.gerenciador;

import br.edu.ifsp.pep.modelo.Imovel;
import br.edu.ifsp.pep.modelo.Proprietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GerenciadorImoveis {
    
    private GerenciadorProprietarios gerenciadorProprietarios;
    
    public GerenciadorImoveis () {
        gerenciadorProprietarios = new GerenciadorProprietarios();
    }
    
    public Imovel getImovel (int numero) throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM imovel "
            + "WHERE (im_num = ?);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, numero);
        
        ResultSet rs = ps.executeQuery();
        Imovel imovel = null;
        
        if (rs.next()) {
            Proprietario proprietario;
            proprietario = gerenciadorProprietarios.getProprietario(rs.getString("im_cpf_pr"));
            
            imovel = new Imovel(
                    rs.getInt("im_num"),
                   rs.getString("im_endereco"),
                    rs.getString("im_bairro"),
                    rs.getString("im_cidade"),
                    rs.getString("im_estado"),
                          rs.getString("im_padrao").toCharArray()[0],
                rs.getDouble("im_valor_aluguel"),
                          rs.getString("im_situacao").toCharArray()[0],
           rs.getDouble("im_percent_comiss"),
                          proprietario
            );
        }
            
        conexao.commit();
        ps.close();
        conexao.close();
        
        return imovel;
        
    }
    
    public ArrayList<Imovel> getTodos () throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM imovel;";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Imovel> todos = new ArrayList<>();
        
        while (rs.next()) {
            Proprietario proprietario;
            proprietario = gerenciadorProprietarios.getProprietario(rs.getString("im_cpf_pr"));
            
            Imovel imovel = new Imovel(
                    rs.getInt("im_num"),
                   rs.getString("im_endereco"),
                    rs.getString("im_bairro"),
                    rs.getString("im_cidade"),
                    rs.getString("im_estado"),
                          rs.getString("im_padrao").toCharArray()[0],
                rs.getDouble("im_valor_aluguel"),
                          rs.getString("im_situacao").toCharArray()[0],
           rs.getDouble("im_percent_comiss"),
                          proprietario
            );
            
            todos.add(imovel);
        }
        
        conexao.commit();
        ps.close();
        conexao.close();
        
        return todos;
    }
    
    public void inserirImovel (Imovel imovel) throws SQLException {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "INSERT INTO imovel (im_num, im_endereco, im_bairro, im_cidade,"
                               + " im_estado, im_padrao, im_valor_aluguel,"
                               + " im_situacao, im_percent_comiss, im_cpf_pr)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, imovel.getNumero());
        ps.setString(2, imovel.getEndereco());
        ps.setString(3, imovel.getBairro());
        ps.setString(4, imovel.getCidade());
        ps.setString(5, imovel.getEstado());
        ps.setString(6, String.valueOf(imovel.getPadrao()));
        ps.setDouble(7, imovel.getValorAluguel());
        ps.setString(8, String.valueOf(imovel.getSituacao()));
        ps.setDouble(9, imovel.getPercentualComissao());
        ps.setString(10, imovel.getProprietario().getCpf());
        
        ps.executeUpdate();
        conexao.commit();
        
        ps.close();
        conexao.close();
        
    }
}
