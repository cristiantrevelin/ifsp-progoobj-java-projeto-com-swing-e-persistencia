package br.edu.ifsp.pep.modelo;

public class Locatario extends Pessoa {
    
    private double limiteAluguel;
    
    public Locatario () {}
    
    public Locatario (String cpf, String nome, String email, 
                      String telefone, double limiteAluguel) {
        
        super(cpf, nome, email, telefone);
        
        this.limiteAluguel = limiteAluguel;
        
    }
    
    public double getLimiteAluguel () {
        return limiteAluguel;
    }
    
    public void setLimiteAluguel (double limiteAluguel) {
        this.limiteAluguel = limiteAluguel;
    }
    
}
