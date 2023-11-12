package br.edu.ifsp.pep.modelo;

public class Proprietario extends Pessoa {
    
    private String banco;
    private int agencia;
    private int conta;
    
    public Proprietario () {}
    
    public Proprietario (String cpf, String nome, String email, 
                         String telefone, String banco, 
                         int agencia, int conta) {
        
        super(cpf, nome, email, telefone);
        
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        
    }
    
    public String getBanco () {
        return banco;
    }
    
    public int getAgencia () {
        return agencia;
    }
    
    public int getConta () {
        return conta;
    }
    
    public void setBanco (String banco) {
        this.banco = banco;
    }
    
    public void setAgencia (int agencia) {
        this.agencia = agencia;
    }
    
    public void setConta (int conta) {
        this.conta = conta;
    }
}
