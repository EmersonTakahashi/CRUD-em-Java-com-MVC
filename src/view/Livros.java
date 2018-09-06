
package view;

import bean.LivrosBean;
import controller.LivrosController;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Livros extends javax.swing.JFrame {
    
    LivrosBean lb = null;
    LivrosController lc = null;
    ResultSet rs = null;
    
    public Livros() throws SQLException {
                
        initComponents();
        this.lb = new LivrosBean();
        this.lc = new LivrosController(lb);

        this.consultarDados();
        this.TxtCodigo();
        this.ValidaNumero(txt_data);
        
    }

    private void consultarDados() throws SQLException {

        this.rs = lc.consultarDados();

        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {

            tbm.removeRow(i);

        }
        while (this.rs.next()) {

            tbm.addRow(new String[]{String.valueOf(rs.getInt("cod_livros")),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("editora"),
                rs.getString("dataLancamento")});
        }

    }
        
    private void TxtCodigo() {
        txt_codigo.enable(false);
        txt_codigo.setBackground(Color.gray);
        txt_codigo.setForeground(Color.black);
    }

    private void ValidaNumero(JTextField Numero) {
        long valor;
        if (Numero.getText().length() != 0) {
            try {
                valor = Long.parseLong(Numero.getText());
            } catch (NumberFormatException ex) {
                // JOptionPane.showMessageDialog(null, "Esse Campo só aceita números", "Informação", JOptionPane.INFORMATION_MESSAGE);
                Numero.grabFocus();
            }
        }
    }
    
    public void carregarDados(Object codigo) {

        try {

            this.rs = lc.carregarDados(codigo);

            while (this.rs.next()) {

                txt_codigo.setText(String.valueOf(rs.getInt("cod_livros")));
                txt_titulo.setText(rs.getString("titulo"));
                txt_autor.setText(rs.getString("autor"));
                txt_editora.setText(rs.getString("editora"));
                txt_data.setText(rs.getString("dataLancamento"));

            }

        } catch (SQLException ex) {

            Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public void filtrar() throws SQLException {

        lb.setTitulo(txt_pesquisar.getText());
        this.rs = lc.filtrar();

        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {

            tbm.removeRow(i);

        }
        while (this.rs.next()) {

            tbm.addRow(new String[]{String.valueOf(rs.getInt("cod_livros")),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("editora"),
                rs.getString("dataLancamento")});
        }

    }

    public void limparCampos() {

        txt_codigo.setText("");
        txt_autor.setText("");
        txt_data.setText("");
        txt_editora.setText("");
        txt_titulo.setText("");
        txt_pesquisar.setText("");

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        txt_autor = new javax.swing.JTextField();
        txt_editora = new javax.swing.JTextField();
        txt_data = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txt_data = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        btn_alterar = new javax.swing.JButton();
        btn_criar = new javax.swing.JButton();
        txt_pesquisar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btn_excluir = new javax.swing.JButton();
        btn_limpar = new javax.swing.JButton();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txt_data = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        txt_codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(124, 83, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciar Livros");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Título:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Autor(a):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editora:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data  Lançamento:");

        txt_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_dataMouseClicked(evt);
            }
        });

        btn_alterar.setBackground(new java.awt.Color(0, 102, 0));
        btn_alterar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_alterar.setForeground(new java.awt.Color(255, 255, 0));
        btn_alterar.setText("Alterar");
        btn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterarActionPerformed(evt);
            }
        });

        btn_criar.setBackground(new java.awt.Color(0, 102, 0));
        btn_criar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_criar.setForeground(new java.awt.Color(255, 255, 0));
        btn_criar.setText("Inserir");
        btn_criar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_criarActionPerformed(evt);
            }
        });

        txt_pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisarKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pesquisar por título:");

        jTable1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título", "Autor(a)", "Editora", "Data de Lançamento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Código:");

        btn_excluir.setBackground(new java.awt.Color(0, 102, 0));
        btn_excluir.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_excluir.setForeground(new java.awt.Color(255, 255, 0));
        btn_excluir.setActionCommand("Excluir");
        btn_excluir.setLabel("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        btn_limpar.setBackground(new java.awt.Color(0, 102, 0));
        btn_limpar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_limpar.setForeground(new java.awt.Color(255, 255, 0));
        btn_limpar.setText("Limpar");
        btn_limpar.setActionCommand("Excluir");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_criar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_data)
                                    .addComponent(txt_titulo)
                                    .addComponent(txt_autor)
                                    .addComponent(txt_editora)
                                    .addComponent(txt_codigo, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_criar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_criarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_criarActionPerformed
        try {
            if (!"".equals(txt_autor.getText()) && !"".equals(txt_titulo.getText()) && !"".equals(txt_editora.getText()) && !"  /  /    ".equals(txt_data.getText())) {

                lb.setTitulo(txt_titulo.getText());
                lb.setEditora(txt_editora.getText());
                lb.setAutor(txt_autor.getText());
                lb.setDataLancamento(txt_data.getText());

                lc.inserirDados();

                this.consultarDados();
                this.limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para cadastrar um livro!");
            }

        } catch (SQLException ex) {

            Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.carregarDados(1);
    }//GEN-LAST:event_btn_criarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {

            int linha = jTable1.getSelectedRow();
            Object codigo = jTable1.getValueAt(linha, 0);
            this.carregarDados(codigo);
            btn_criar.setEnabled(false);

        } catch (Exception ex) {

            Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        this.limparCampos();

        btn_criar.setEnabled(true);
    }//GEN-LAST:event_btn_limparActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed

        if (!"".equals(txt_codigo.getText())) {
            int botaoDialogo = JOptionPane.YES_NO_OPTION;
            int resultadoDialogo = JOptionPane.showConfirmDialog(this, "Deseja Excluir?", "Seleção", botaoDialogo);

            if (resultadoDialogo == 0) {

                try {
                    
                    int codigo = Integer.parseInt(txt_codigo.getText());
                    lc.excluirDados(codigo);
                    
                    this.consultarDados();
                    this.limparCampos();
                    btn_criar.setEnabled(true);
                    
                } catch (SQLException ex) {

                    Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);

                }

            } else {

                JOptionPane.showMessageDialog(null, "Livro não excluido!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um livro na tabela!");
        }

    }//GEN-LAST:event_btn_excluirActionPerformed


    private void btn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterarActionPerformed

        if (!"".equals(txt_codigo.getText())) {
            int botaoDialogo = JOptionPane.YES_NO_OPTION;
            int resultadoDialogo = JOptionPane.showConfirmDialog(this, "Deseja Alterar?", "Seleção", botaoDialogo);

            if (resultadoDialogo == 0) {

                try {

                    int codigo = Integer.parseInt(txt_codigo.getText());
                    lb.setCodLivros(codigo);
                    lb.setTitulo(txt_titulo.getText());
                    lb.setEditora(txt_editora.getText());
                    lb.setAutor(txt_autor.getText());
                    lb.setDataLancamento(txt_data.getText());

                    lc.alterarDados();
                    this.consultarDados();

                } catch (SQLException ex) {

                    Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);

                }

            } else {

                JOptionPane.showMessageDialog(null, "Livro não alterado!");

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um livro na tabela!");
        }
    }//GEN-LAST:event_btn_alterarActionPerformed

    private void txt_pesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisarKeyReleased
        try {

            this.filtrar();

        } catch (SQLException ex) {
            Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_pesquisarKeyReleased

    private void txt_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dataMouseClicked
        txt_data.setText("");
    }//GEN-LAST:event_txt_dataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Livros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new Livros().setVisible(true);

                } catch (SQLException ex) {

                    Logger.getLogger(Livros.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar;
    private javax.swing.JButton btn_criar;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_limpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_autor;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_editora;
    private javax.swing.JTextField txt_pesquisar;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
