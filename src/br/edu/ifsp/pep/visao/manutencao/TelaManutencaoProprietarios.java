package br.edu.ifsp.pep.visao.manutencao;

import br.edu.ifsp.pep.gerenciador.GerenciadorProprietarios;
import br.edu.ifsp.pep.modelo.Proprietario;
import br.edu.ifsp.pep.visao.manutencao.registro.TelaRegistroProprietarios;
import java.sql.SQLException;

public class TelaManutencaoProprietarios extends TelaManutencao {
    
    private GerenciadorProprietarios gerenciadorProprietarios;

    public TelaManutencaoProprietarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initMyComponents();
    }
    
    private void initMyComponents () {
        gerenciadorProprietarios = new GerenciadorProprietarios();
        
        definirTitulo("Proprietários");
        montarTabelaDados();
        atualizarTabelaDados();
    }
    
    @Override
    public void atualizarTabelaDados() {
        javax.swing.table.DefaultTableModel modeloTabela;
        modeloTabela = (javax.swing.table.DefaultTableModel) getTableDados().getModel();
        modeloTabela.setRowCount(0);
        
        try {
            
            for (Proprietario proprietario : gerenciadorProprietarios.getTodos()) {
                
                modeloTabela.addRow(new Object[] {
                    proprietario.getCpf(), proprietario.getNome(),
                    proprietario.getTelefone(), proprietario.getBanco()
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
                "Cpf", "Nome", "Telefone", "Banco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        TelaManutencao.centralizarColunas(getTableDados());
    }
    
    @Override
    public void exibirTelaRegistro(String modo) {
        TelaRegistroProprietarios trp;
        trp = new TelaRegistroProprietarios(new javax.swing.JFrame(), true, modo);
        trp.setVisible(true);
    }
    
    public static void main(String args[]) {
        
        TelaManutencao.definirLaf();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaManutencaoProprietarios dialog = new TelaManutencaoProprietarios(new javax.swing.JFrame(),
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
