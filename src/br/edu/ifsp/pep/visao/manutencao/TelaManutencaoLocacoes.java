package br.edu.ifsp.pep.visao.manutencao;

import br.edu.ifsp.pep.gerenciador.GerenciadorLocacoes;
import br.edu.ifsp.pep.modelo.Locacao;
import br.edu.ifsp.pep.visao.manutencao.registro.TelaRegistroLocacoes;
import java.awt.Frame;
import java.sql.SQLException;

public class TelaManutencaoLocacoes extends TelaManutencao {
    
    private GerenciadorLocacoes gerenciadorLocacoes;
    
    public TelaManutencaoLocacoes(Frame parent, boolean modal) {
        super(parent, modal);
        initMyComponents();
    }
    
    private void initMyComponents () {
        gerenciadorLocacoes = new GerenciadorLocacoes();
        
        definirTitulo("Locações");
        montarTabelaDados();
        atualizarTabelaDados();
    }
    
    @Override
    public void atualizarTabelaDados() {
        
        javax.swing.table.DefaultTableModel modeloTabela;
        modeloTabela = (javax.swing.table.DefaultTableModel) getTableDados().getModel();
        modeloTabela.setRowCount(0);
        
        try {
            
            for (Locacao locacao : gerenciadorLocacoes.getTodos()) {
                
                modeloTabela.addRow(new Object[] {
                    locacao.getNumeroContrato(), locacao.getValorAluguel(),
                    locacao.getImovel().getNumero(), locacao.getLocatario().getNome()
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
                "Número do Contrato", "Aluguel", "Número do Imóvel", "Locatário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, 
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        TelaManutencao.centralizarColunas(getTableDados());
    }
    
    @Override
    public void exibirTelaRegistro(String modo) {
        TelaRegistroLocacoes trp;
        trp = new TelaRegistroLocacoes(new javax.swing.JFrame(), true, modo);
        trp.setVisible(true);
    }
    
    public static void main(String args[]) {
        
        TelaManutencao.definirLaf();

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaManutencaoLocacoes dialog = new TelaManutencaoLocacoes(new javax.swing.JFrame(),
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
