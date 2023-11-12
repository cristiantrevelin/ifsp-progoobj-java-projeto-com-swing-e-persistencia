package br.edu.ifsp.pep.modelo;

public class Imovel {
    
    private int numero;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private char padrao;
    private double valorAluguel;
    private char situacao;
    private double percentualComissao;
    
    private Proprietario proprietario;
    
    public Imovel () {}
    
    public Imovel (int numero, String endereco, String bairro,
                   String cidade, String estado, char padrao,
                   double valorAluguel, char situacao,
                   double percentualComissao, 
                   Proprietario proprietario) {
        
        this.numero = numero;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.padrao = padrao;
        this.valorAluguel = valorAluguel;
        this.situacao = situacao;
        this.percentualComissao = percentualComissao;
        this.proprietario = proprietario;
        
    }

    public int getNumero() {
        return numero;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    } 
    
    public String getEstado() {
        return estado;
    } 
    
    public char getPadrao() {
        return padrao;
    }
    
    public double getValorAluguel() {
        return valorAluguel;
    }
    
    public char getSituacao() {
        return situacao;
    } 
    
    public double getPercentualComissao() {
        return percentualComissao;
    }
    
    public Proprietario getProprietario() {
        return proprietario;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    } 
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPadrao(char padrao) {
        this.padrao = padrao;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    
}
