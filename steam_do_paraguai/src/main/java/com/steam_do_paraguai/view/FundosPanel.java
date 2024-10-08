/*
Nome: Lukas Freitas de Carvalho - Matrícula: 202376033
Nome: Matheus Ribeiro Menezes - Matrícula: 202376023
Nome: João Víctor Nicácio Silva - Matrícula: 202365565C
*/
package com.steam_do_paraguai.view;

import com.steam_do_paraguai.model.Usuario;
import com.steam_do_paraguai.persistence.Persistence;
import com.steam_do_paraguai.persistence.UsuarioPersistence;
import java.util.List;

public class FundosPanel extends javax.swing.JPanel {
private MenuPrincipal tela;
private List<Usuario> lista;
private Persistence<Usuario> usuarioPersistence;

    public FundosPanel(MenuPrincipal tela) {
        this.tela = tela;
        this.usuarioPersistence = new UsuarioPersistence();
        this.lista = usuarioPersistence.findAll();
        initComponents();
        String valor = String.format("%.2f", ((Usuario) this.tela.getUsuario()).getSaldo());
        valor = valor.replaceAll("[.]",",");
        this.valorSaldoLabel.setText(valor);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mais10Button = new javax.swing.JButton();
        mais20Button = new javax.swing.JButton();
        mais50Button = new javax.swing.JButton();
        saldoLabel = new javax.swing.JLabel();
        valorSaldoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(61, 122, 155));
        setMaximumSize(new java.awt.Dimension(708, 368));
        setMinimumSize(new java.awt.Dimension(708, 368));
        setPreferredSize(new java.awt.Dimension(708, 368));

        mais10Button.setBackground(new java.awt.Color(30, 30, 29));
        mais10Button.setForeground(new java.awt.Color(255, 255, 255));
        mais10Button.setText("+10");
        mais10Button.setBorderPainted(false);
        mais10Button.setMaximumSize(new java.awt.Dimension(100, 36));
        mais10Button.setMinimumSize(new java.awt.Dimension(100, 36));
        mais10Button.setPreferredSize(new java.awt.Dimension(100, 36));
        mais10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mais10ButtonActionPerformed(evt);
            }
        });

        mais20Button.setBackground(new java.awt.Color(30, 30, 29));
        mais20Button.setForeground(new java.awt.Color(255, 255, 255));
        mais20Button.setText("+20");
        mais20Button.setBorderPainted(false);
        mais20Button.setMaximumSize(new java.awt.Dimension(100, 36));
        mais20Button.setMinimumSize(new java.awt.Dimension(100, 36));
        mais20Button.setPreferredSize(new java.awt.Dimension(100, 36));
        mais20Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mais20ButtonActionPerformed(evt);
            }
        });

        mais50Button.setBackground(new java.awt.Color(30, 30, 29));
        mais50Button.setForeground(new java.awt.Color(255, 255, 255));
        mais50Button.setText("+50");
        mais50Button.setBorderPainted(false);
        mais50Button.setMaximumSize(new java.awt.Dimension(100, 36));
        mais50Button.setMinimumSize(new java.awt.Dimension(100, 36));
        mais50Button.setPreferredSize(new java.awt.Dimension(100, 36));
        mais50Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mais50ButtonActionPerformed(evt);
            }
        });

        saldoLabel.setFont(new java.awt.Font("Source Sans Pro", 0, 48)); // NOI18N
        saldoLabel.setForeground(new java.awt.Color(255, 255, 255));
        saldoLabel.setText("SALDO: R$");

        valorSaldoLabel.setFont(new java.awt.Font("Source Sans Pro", 0, 48)); // NOI18N
        valorSaldoLabel.setForeground(new java.awt.Color(255, 255, 255));
        valorSaldoLabel.setText("0,00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saldoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valorSaldoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mais10Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mais20Button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(mais50Button, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoLabel)
                    .addComponent(valorSaldoLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mais10Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mais50Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mais20Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mais20ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mais20ButtonActionPerformed
   
        String valor =  this.valorSaldoLabel.getText();
       
        ((Usuario) this.tela.getUsuario()).adicionaSaldo(20);
        for(int i = 0; i< lista.size(); i+=1)
        {
            if(this.tela.getUsuario().getNome().equals(lista.get(i).getNome()))
            {
                lista.set(i, (Usuario) this.tela.getUsuario());

            }
        }
        usuarioPersistence.save(lista);
        valor = String.format("%.2f", ((Usuario) this.tela.getUsuario()).getSaldo());
        
        valor = valor.replaceAll("[.]",",");
        this.valorSaldoLabel.setText(valor);
        
    }//GEN-LAST:event_mais20ButtonActionPerformed

    private void mais50ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mais50ButtonActionPerformed

        String valor =  this.valorSaldoLabel.getText();
        
        ((Usuario) this.tela.getUsuario()).adicionaSaldo(50);
        for(int i = 0; i< lista.size(); i+=1)
        {
            if(this.tela.getUsuario().getNome().equals(lista.get(i).getNome()))
            {
                lista.set(i, (Usuario) this.tela.getUsuario());

            }
        }
        usuarioPersistence.save(lista);
        valor = String.format("%.2f", ((Usuario) this.tela.getUsuario()).getSaldo());
        
        valor = valor.replaceAll("[.]",",");
        this.valorSaldoLabel.setText(valor);
    }//GEN-LAST:event_mais50ButtonActionPerformed

    private void mais10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mais10ButtonActionPerformed
        
        String valor =  this.valorSaldoLabel.getText();
        
        ((Usuario) this.tela.getUsuario()).adicionaSaldo(10);
        for(int i = 0; i< lista.size(); i+=1)
        {
            if(this.tela.getUsuario().getNome().equals(lista.get(i).getNome()))
            {
                lista.set(i, (Usuario) this.tela.getUsuario());

            }
        }
        usuarioPersistence.save(lista);
        valor = String.format("%.2f", ((Usuario) this.tela.getUsuario()).getSaldo());
        
        valor = valor.replaceAll("[.]",",");
        this.valorSaldoLabel.setText(valor);
    }//GEN-LAST:event_mais10ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton mais10Button;
    private javax.swing.JButton mais20Button;
    private javax.swing.JButton mais50Button;
    private javax.swing.JLabel saldoLabel;
    private javax.swing.JLabel valorSaldoLabel;
    // End of variables declaration//GEN-END:variables
}
