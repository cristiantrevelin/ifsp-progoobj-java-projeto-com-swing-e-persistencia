package br.edu.ifsp.pep.modelo;
import java.time.LocalDate;

public class Locacao {
    
    private int numeroContrato;
    private LocalDate dataContrato;
    private int prazoContrato;
    private double valorAluguel;
    private int diaVencimento;
    
    private Imovel imovel;
    private Locatario locatario;
    
    public Locacao () {}
    
    public Locacao (int numeroContrato, LocalDate dataContrato,
                    int prazoContrato, double valorAluguel,
                    int diaVencimento, Imovel imovel,
                    Locatario locatario) {
        
        this.numeroContrato = numeroContrato;
        this.dataContrato = dataContrato;
        this.prazoContrato = prazoContrato;
        this.valorAluguel = valorAluguel;
        this.diaVencimento = diaVencimento;
        this.imovel = imovel;
        this.locatario = locatario;
        
    }
    
    public int getNumeroContrato () {
        return numeroContrato;
    }
    
    public LocalDate getDataContrato () {
        return dataContrato;
    }
    
    public int getPrazoContrato () {
        return prazoContrato;
    }
    
    public double getValorAluguel () {
        return valorAluguel;
    }
    
    public int getDiaVencimento () {
        return diaVencimento;
    }
    
    public Imovel getImovel () {
        return imovel;
    }
    
    public Locatario getLocatario () {
        return locatario;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public void setDataContrato(LocalDate dataContrato) {
        this.dataContrato = dataContrato;
    }

    public void setPrazoContrato(int prazoContrato) {
        this.prazoContrato = prazoContrato;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }
}
