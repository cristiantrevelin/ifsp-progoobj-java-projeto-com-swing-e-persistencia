package br.edu.ifsp.pep.gerenciador;
import br.edu.ifsp.pep.modelo.Locatario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GerenciadorLocatarios {
    
    public Locatario getLocatario (String cpf) throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM locatario INNER JOIN pessoa ON (lt_cpf = pe_cpf) "
            + "WHERE (lt_cpf = ?);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cpf);
        
        ResultSet rs = ps.executeQuery();
        Locatario locatario = null;
        
        if (rs.next()) {
            locatario = new Locatario(
                     rs.getString("pe_cpf"),
                    rs.getString("pe_nome"),
                   rs.getString("pe_email"),
                 rs.getString("pe_telefone"),
             rs.getDouble("lt_limite_aluguel")
            );
        }
        
        conexao.commit();
        ps.close();
        conexao.close();
        
        return locatario;
        
    }
    
    public ArrayList<Locatario> getTodos () throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM locatario INNER JOIN pessoa ON (lt_cpf = pe_cpf);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Locatario> todos = new ArrayList<>();
        
        while (rs.next()) {
            Locatario locatario = new Locatario(
                     rs.getString("pe_cpf"),
                    rs.getString("pe_nome"),
                   rs.getString("pe_email"),
                 rs.getString("pe_telefone"),
             rs.getDouble("lt_limite_aluguel")
            );
            
            todos.add(locatario);
        }
        
        conexao.commit();
        ps.close();
        conexao.close();
        
        return todos;
    }
    
}
