/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.steam_do_paraguai.view;

import com.steam_do_paraguai.model.Jogo;
import com.steam_do_paraguai.model.User;
import com.steam_do_paraguai.persistence.Persistence;
import com.steam_do_paraguai.persistence.UsuarioPersistence;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lukas-freitas
 */
public class CarrinhoPanel extends javax.swing.JPanel {
    private MenuPrincipal tela;
    private Persistence<User> usuarioPersistence;
    private List<User> lista;
    /**
     * Creates new form CarrinhoPanel
     */
    public CarrinhoPanel(MenuPrincipal tela) {
    this.tela = tela;
    usuarioPersistence = new UsuarioPersistence();
    this.lista = usuarioPersistence.findAll();
    initComponents();
    this.carregaCarrinho();
    this.carregaTotal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCartGames = new javax.swing.JTable();
        buyButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 122, 155));
        setMaximumSize(new java.awt.Dimension(708, 368));
        setMinimumSize(new java.awt.Dimension(708, 368));
        setPreferredSize(new java.awt.Dimension(708, 368));

        tableCartGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCartGames.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableCartGames);
        if (tableCartGames.getColumnModel().getColumnCount() > 0) {
            tableCartGames.getColumnModel().getColumn(0).setResizable(false);
            tableCartGames.getColumnModel().getColumn(1).setResizable(false);
            tableCartGames.getColumnModel().getColumn(2).setResizable(false);
        }

        buyButton.setText("Comprar");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        totalLabel.setBackground(new java.awt.Color(30, 30, 29));
        totalLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalLabel.setText("TOTAL: R$0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buyButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(buyButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        compraJogos();
    }//GEN-LAST:event_buyButtonActionPerformed

    private void carregaCarrinho()
    {
        List<Jogo> jogos = this.lista.get(this.tela.getIndex()).getCarrinho().getJogos();
        if(jogos.size()>0)
        {
            DefaultTableModel model = (DefaultTableModel)tableCartGames.getModel();
            for(int i = 0; i<jogos.size(); i+=1)
            {
                model.addRow(new Object[]{jogos.get(i).getNome(), jogos.get(i).getDescricao(), jogos.get(i).getPreco()});
            }
        }
    }

    private void compraJogos() {
        float total = 0;
        List<Jogo> jogos =  this.lista.get(this.tela.getIndex()).getCarrinho().getJogos();
        if(jogos.size()>0)
        {
            for(int i = 0; i<jogos.size(); i+=1)
            {
                total+=jogos.get(i).getPreco();
            }
            if(total<=this.lista.get(this.tela.getIndex()).getSaldo())
            {
                DefaultTableModel model = (DefaultTableModel)tableCartGames.getModel();
                while(jogos.size()!=0)
                {
                    this.lista.get(this.tela.getIndex()).getJogos().add(jogos.get(0));
                    this.lista.get(this.tela.getIndex()).removeSaldo(jogos.get(0).getPreco());
                    this.lista.get(this.tela.getIndex()).getCarrinho().removeJogo(jogos.get(0));
                    model.removeRow(0);
                }
                usuarioPersistence.save(lista);
                this.lista = usuarioPersistence.findAll();
                this.carregaTotal();
                
                this.carregaCarrinho();
                
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Carrinho está vazio!");
        }
        
    }
    private void carregaTotal()
    {
        String textLabel = this.totalLabel.getText();
        float total = 0;
        List<Jogo> jogos =  this.lista.get(this.tela.getIndex()).getCarrinho().getJogos();
        if(jogos.size()>0)
        {
            for(int i = 0; i<jogos.size(); i+=1)
            {
                total+=jogos.get(i).getPreco();
            }
        }
        textLabel = "Total: R$" + String.format("%.2f", total);
        textLabel.replaceAll("[.]", ",");
        this.totalLabel.setText(textLabel);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCartGames;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
