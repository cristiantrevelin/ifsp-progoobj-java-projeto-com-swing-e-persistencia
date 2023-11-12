package br.edu.ifsp.pep.gerenciador;
import br.edu.ifsp.pep.modelo.Proprietario;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class GerenciadorProprietarios extends GerenciadorPessoas {
    
    public void inserirProprietario (Proprietario proprietario) throws SQLException,
                                                                       Exception {
        
        inserirPessoa(proprietario);
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "INSERT INTO proprietario (pr_cpf, pr_banco, pr_agencia, pr_conta) "
            + "VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, proprietario.getCpf());
        ps.setString(2, proprietario.getBanco());
        ps.setInt(3, proprietario.getAgencia());
        ps.setInt(4, proprietario.getConta());
        
        ps.executeUpdate();
         
        conexao.commit();
        ps.close();
        conexao.close();
 
    }
    
    public Proprietario getProprietario (String cpf) throws SQLException,
                                                            Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM proprietario INNER JOIN pessoa ON (pr_cpf = pe_cpf) "
            + "WHERE (pr_cpf = ?);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(0, cpf);
        
        ResultSet rs = ps.executeQuery();
        Proprietario proprietario = null;
        
        if (rs.next()) {
            proprietario = new Proprietario(
                    rs.getString("pe_cpf"),
                    rs.getString("pe_nome"),
                    rs.getString("pe_email"),
                    rs.getString("pe_telefone"),
                    rs.getString("pr_banco"),
                    rs.getInt("pr_agencia"),
                    rs.getInt("pr_conta")
            );
        }
            
        conexao.commit();
        ps.close();
        conexao.close();
        
        return proprietario;
        
    }
    
    public ArrayList<Proprietario> getTodos () throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM proprietario INNER JOIN pessoa ON (pr_cpf = pe_cpf);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Proprietario> todos = new ArrayList<>();
        
        while (rs.next()) {
            Proprietario proprietario = new Proprietario(
                    rs.getString("pe_cpf"),
                    rs.getString("pe_nome"),
                    rs.getString("pe_email"),
                    rs.getString("pe_telefone"),
                    rs.getString("pr_banco"),
                    rs.getInt("pr_agencia"),
                    rs.getInt("pr_conta")
            );
            
            todos.add(proprietario);
        }
        
        conexao.commit();
        ps.close();
        conexao.close();
        
        return todos;
    }
    
}
