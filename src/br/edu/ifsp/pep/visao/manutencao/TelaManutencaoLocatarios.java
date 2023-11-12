package br.edu.ifsp.pep.visao.manutencao;

import br.edu.ifsp.pep.gerenciador.GerenciadorLocatarios;
import br.edu.ifsp.pep.modelo.Locatario;
import br.edu.ifsp.pep.visao.manutencao.registro.TelaRegistroLocatarios;
import java.awt.Frame;
import java.sql.SQLException;

public class TelaManutencaoLocatarios extends TelaManutencao {
    
    private GerenciadorLocatarios gerenciadorLocatarios;

    public TelaManutencaoLocatarios(Frame parent, boolean modal) {
        super(parent, modal);
        initMyComponents();
    }
    
    private void initMyComponents () {
        gerenciadorLocatarios = new GerenciadorLocatarios();
        
        definirTitulo("Locatários");
        montarTabelaDados();
        atualizarTabelaDados();
    }
    
    @Override
    public void atualizarTabelaDados() {
        javax.swing.table.DefaultTableModel modeloTabela;
        modeloTabela = (javax.swing.table.DefaultTableModel) getTableDados().getModel();
        modeloTabela.setRowCount(0);
        
        try {
            
            for (Locatario locatario : gerenciadorLocatarios.getTodos()) {
                
                modeloTabela.addRow(new Object[] {
                    locatario.getCpf(), locatario.getNome(),
                    locatario.getTelefone(), locatario.getLimiteAluguel()
                });
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro no SQL.");
        } catch (Exception ex) {
            System.out.println("Erro desconhecido");
        }
    }

    @Override
    public void montarTabelaDados() {
        getTableDados().setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cpf", "Nome", "Telefone", "Limite de Aluguel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        TelaManutencao.centralizarColunas(getTableDados());
    }
    
    @Override
    public void exibirTelaRegistro(String modo) {
        TelaRegistroLocatarios trp;
        trp = new TelaRegistroLocatarios(new javax.swing.JFrame(), true, modo);
        trp.setVisible(true);
    }
    
    public static void main(String args[]) {
        
        TelaManutencao.definirLaf();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaManutencaoLocatarios dialog = new TelaManutencaoLocatarios(new javax.swing.JFrame(),
                                                   true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
