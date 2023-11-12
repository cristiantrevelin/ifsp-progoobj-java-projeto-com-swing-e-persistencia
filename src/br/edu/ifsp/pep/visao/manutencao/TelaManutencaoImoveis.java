package br.edu.ifsp.pep.visao.manutencao;

import br.edu.ifsp.pep.gerenciador.GerenciadorImoveis;
import br.edu.ifsp.pep.modelo.Imovel;
import br.edu.ifsp.pep.visao.manutencao.registro.TelaRegistroImoveis;
import java.awt.Frame;
import java.sql.SQLException;

public class TelaManutencaoImoveis extends TelaManutencao {
    
    private GerenciadorImoveis gerenciadorImoveis;
    
    public TelaManutencaoImoveis(Frame parent, boolean modal) {
        super(parent, modal);
        initMyComponents();
    }
    
    private void initMyComponents () {
        gerenciadorImoveis = new GerenciadorImoveis();
        
        definirTitulo("Imóveis");
        montarTabelaDados();
        atualizarTabelaDados();
    }
    
    @Override
    public void atualizarTabelaDados() {
        
        javax.swing.table.DefaultTableModel modeloTabela;
        modeloTabela = (javax.swing.table.DefaultTableModel) getTableDados().getModel();
        modeloTabela.setRowCount(0);
        
        try {
            
            for (Imovel imovel : gerenciadorImoveis.getTodos()) {
                
                modeloTabela.addRow(new Object[] {
                    imovel.getNumero(), imovel.getCidade(), imovel.getPadrao(),
                    imovel.getSituacao(), imovel.getProprietario().getNome()
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
                "Número", "Cidade", "Padrão", "Situação", "Proprietário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class,
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }
    
    @Override
    public void exibirTelaRegistro(String modo) {
        TelaRegistroImoveis trp;
        trp = new TelaRegistroImoveis(new javax.swing.JFrame(), true, modo);
        trp.setVisible(true);
    }
    
    public static void main(String args[]) {
        
        TelaManutencao.definirLaf();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaManutencaoImoveis dialog = new TelaManutencaoImoveis(new javax.swing.JFrame(),
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
