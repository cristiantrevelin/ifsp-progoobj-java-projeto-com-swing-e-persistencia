package br.edu.ifsp.pep.gerenciador;
import br.edu.ifsp.pep.modelo.Pagamento;
import java.util.ArrayList;

public class GerenciadorPagamentos {
    
    private ArrayList<Pagamento> listaPagamentos;
    
    public GerenciadorPagamentos () {
        
        listaPagamentos = new ArrayList<>();
        
    }
    
    public ArrayList<Pagamento> getListaPagamentos () {
        return listaPagamentos;
    }
    
    public void inserirPagamento (Pagamento pagamento) {
        listaPagamentos.add(pagamento);
    }
    
    public void excluirPagamento () {}

}
