package br.edu.ifsp.pep.gerenciador;

import br.edu.ifsp.pep.modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GerenciadorPessoas {
    
    public void inserirPessoa (Pessoa pessoa) throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "INSERT INTO pessoa (pe_cpf, pe_nome, pe_email, pe_telefone) "
            + "VALUES (?, ?, ?, ?);";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, pessoa.getCpf());
        ps.setString(2, pessoa.getNome());
        ps.setString(3, pessoa.getEmail());
        ps.setString(4, pessoa.getTelefone());
        
        ps.executeUpdate();
         
        conexao.commit();
        ps.close();
        conexao.close();
        
    }
    
}
