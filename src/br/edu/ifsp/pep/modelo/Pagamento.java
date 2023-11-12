package br.edu.ifsp.pep.modelo;
import java.time.LocalDate;

public class Pagamento {
    
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    private double valorPagar;
    private double valorPago;
    
    private Locacao locacao;
    
    public Pagamento () {}
    
    public Pagamento (LocalDate dataVencimento, LocalDate dataPagamento,
                      double valorPagar, double valorPago,
                      Locacao locacao) {
        
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.valorPagar = valorPagar;
        this.valorPago = valorPago;
        this.locacao = locacao;
        
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }
    
    public void efetuarQuitacao (double valorPago) {
        
        LocalDate dataAtual = LocalDate.now();
        
        this.valorPago = valorPago;
        dataPagamento = dataAtual;
        
    }
    
}
