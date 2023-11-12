package br.edu.ifsp.pep.gerenciador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    /*
        jdbc: protocolo
        mysql: sgbd
        localhost - endereço da máquina onde está o banco
        3306 - porta onde o servidor está ouvindo
        db_aula - nome do banco de dados
    */
    
    private static String urlBanco = "jdbc:mysql://127.0.0.1:3306/"
                                   + "imobiliaria_aluga_tudo?useSSL=false"
                                   + "&allowPublicKeyRetrieval=true"
                                   + "&useUnicode=true&useJDBCCompliantTimezoneShift=true"
                                   + "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public static Connection getConexao () {
        
        Connection conexao = null;
        
        try {
            conexao = DriverManager.getConnection(urlBanco, "root",
                                              "Bhgnjuikmt1.");
            conexao.setAutoCommit(false);
            
        } catch (SQLException ex) {
            System.out.println("Não foi possível fazer conexão com o banco.");
            System.out.println(ex.getMessage());
        }
        
        return conexao;
        
    }
}
