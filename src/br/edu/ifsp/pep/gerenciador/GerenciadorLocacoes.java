package br.edu.ifsp.pep.gerenciador;
import br.edu.ifsp.pep.modelo.Imovel;
import br.edu.ifsp.pep.modelo.Locacao;
import br.edu.ifsp.pep.modelo.Locatario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciadorLocacoes {
    
    private GerenciadorLocatarios gerenciadorLocatarios;
    private GerenciadorImoveis gerenciadorImoveis;
    
    public GerenciadorLocacoes () {
        gerenciadorLocatarios = new GerenciadorLocatarios();
        gerenciadorImoveis = new GerenciadorImoveis();
    }
    
    public ArrayList<Locacao> getTodos () throws SQLException, Exception {
        
        Connection conexao = Conexao.getConexao();
        String sql;
        
        sql = "SELECT * "
            + "FROM locacao;";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Locacao> todos = new ArrayList<>();
        
        while (rs.next()) {
            Imovel imovel = gerenciadorImoveis.getImovel(rs.getInt("lc_num_im"));
            Locatario locatario = gerenciadorLocatarios.getLocatario(rs.getString("lc_cpf_lt"));
            
            Locacao locacao = new Locacao(
                    rs.getInt("lc_num_cont"),
                    LocalDate.parse(rs.getString("lc_data_cont")),
                    rs.getInt("lc_prazo_cont"),
                    rs.getDouble("lc_valor_aluguel"),
                    rs.getInt("lc_dia_venc"),
                    imovel, 
                    locatario
            );
            
            todos.add(locacao);
        }
        
        conexao.commit();
        ps.close();
        conexao.close();
        
        return todos;
    }
    
}
