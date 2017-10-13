package view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import util.OperacoesCrud;
import model.Cliente;
import util.Util;
import java.util.Objects;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import controller.ClienteController;
import java.sql.Date;
import javax.swing.JOptionPane;


public class ClienteView extends javax.swing.JFrame {

  private Integer operacao;
  private String sexo;
  private DefaultTableModel modelo;
  private MaskFormatter mascaraCpf, mascaraFone;
  
  
  private Integer codigoCliente;
  private String nomeClienteTabela;
  
  
  public ClienteView()
  {
    initComponents();
    carregarDadosTabela();
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelasCliente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        try{
            mascaraCpf = new MaskFormatter("###.###.###-##");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        txtCPF =  txtCPF = new JFormattedTextField(mascaraCpf);
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txtDtNascimento = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        try{
            mascaraFone = new MaskFormatter("(##)#####-####");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        txtFone =  txtFone = new JFormattedTextField(mascaraFone);
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo)
                    .addComponent(btnSair))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabelasCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Sexo", "Data Nasc.", "Fone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelasCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelasClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelasCliente);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulário"));

        jLabel1.setText("Nome: ");

        jLabel2.setText("CPF: ");

        txtCPF.setEditable(false);
        txtCPF.setEnabled(false);
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        txtNome.setEditable(false);
        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Sexo: ");

        rbMasculino.setText("Masculino");
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });

        rbFeminino.setText("Feminino");
        rbFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFemininoActionPerformed(evt);
            }
        });

        jLabel4.setText("Data de Nascimento: ");

        txtDtNascimento.setEnabled(false);

        jLabel5.setText("Fone: ");

        txtFone.setEditable(false);
        txtFone.setEnabled(false);
        txtFone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoneActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnSalvar)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDtNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCPF)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(rbMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbFeminino)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbMasculino)
                    .addComponent(rbFeminino))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        operacao = util.OperacoesCrud.NOVO.getOperacao();
        fecharCamposPrincipal();
        limparCampos();
        abrirCamposFormulario();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtFoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoneActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limparCampos();
        fecharCamposFormulario();
        abrirCamposPrincipal();        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String mgs = "Dsesja excluir o Cliente: "+ getCodigoCliente()+" - "+getNomeClienteTabela()+"?";
        String nomeClienteTemp = getNomeClienteTabela();
        int opcaoEscolhida = JOptionPane.showConfirmDialog(null, mgs, "Exclusao", JOptionPane.YES_NO_OPTION);
        
        if(opcaoEscolhida == JOptionPane.YES_OPTION){
            Cliente cliente = new Cliente();
            cliente.setCodigo(getCodigoCliente());
            try {
                ClienteController clienteController = new ClienteController();
                clienteController.remover(cliente);
                //remove linha da tabela
                modelo.removeRow(tabelasCliente.getSelectedRow());
                JOptionPane.showMessageDialog(null, "O Cliente "+nomeClienteTemp+" foi excluido com sucesso!", "Exclusão de Cliente",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        limparCampos();
               
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtNome.getText();
        String cpf = txtCPF.getText();
        cpf = removerMascaraCpf(cpf);
        String fone = txtFone.getText();
        fone = removerMascaraFone(fone);
        
        
        Date dataNascimento = new java.sql.Date(txtDtNascimento.getDate().getTime());

        Cliente cliente = new model.Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setFone(fone);
        cliente.setSexo(sexo);
        cliente.setDataNascimento(dataNascimento);
        ClienteController clienteC = new ClienteController();

        if (Objects.equals(operacao, util.OperacoesCrud.NOVO.getOperacao())) {
          try {
            clienteC.cadastrar(cliente);

            modelo.addRow(new Object[] { clienteC.getCodigo(cliente), nome, cpf, sexo, Util.converterToString(cliente.getDataNascimento()), fone });
            JOptionPane.showMessageDialog(null, "O cliente " + cliente.getNome() + " foi cadastrado com sucesso!", "Sucesso", 1);
          } catch (java.sql.SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
        }
        else if (Objects.equals(operacao, util.OperacoesCrud.EDITAR.getOperacao())){
            try{
                cliente.setCodigo(getCodigoCliente());
                //invoca a camada controller
                clienteC.atualizar(cliente);
                //recupera as informações inseridas nos campos e atualizar linha da tabela
                
                modelo.setValueAt(nome, tabelasCliente.getSelectedRow(), 1);
                modelo.setValueAt(cpf, tabelasCliente.getSelectedRow(), 2);
                modelo.setValueAt(sexo, tabelasCliente.getSelectedRow(), 3);
                modelo.setValueAt(Util.converterToString(cliente.getDataNascimento()), tabelasCliente.getSelectedRow(), 4);
                modelo.setValueAt(fone, tabelasCliente.getSelectedRow(), 5);
                
                JOptionPane.showMessageDialog(null, "O cliente " + cliente.getNome() + " foi atualizado com sucesso!", "Sucesso", 1);
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        limparCampos();
        fecharCamposFormulario();
        abrirCamposPrincipal();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed
        rbFeminino.setSelected(false);
        sexo = rbMasculino.getText();
    }//GEN-LAST:event_rbMasculinoActionPerformed

    private void rbFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFemininoActionPerformed
        rbMasculino.setSelected(false);
        sexo = rbFeminino.getText();  
    }//GEN-LAST:event_rbFemininoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        operacao = OperacoesCrud.EDITAR.getOperacao();
        fecharCamposPrincipal();
        abrirCamposFormulario();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tabelasClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelasClienteMouseClicked
        ListSelectionModel tableSelectionModel = tabelasCliente.getSelectionModel();
        
        tabelasCliente.setSelectionModel(tableSelectionModel);
        
        setCodigoCliente(Integer.parseInt(tabelasCliente.getValueAt(tabelasCliente.getSelectedRow(), 0).toString()));
        setNomeClienteTabela(tabelasCliente.getValueAt(tabelasCliente.getSelectedRow(), 1).toString());
        
        String rowCpf = tabelasCliente.getValueAt(tabelasCliente.getSelectedRow(), 2).toString();
        String rowSexo = tabelasCliente.getValueAt(tabelasCliente.getSelectedRow(), 3).toString();
        String rowData = tabelasCliente.getValueAt(tabelasCliente.getSelectedRow(), 4).toString();
        String rowFone = tabelasCliente.getValueAt(tabelasCliente.getSelectedRow(), 5).toString();
        
        txtNome.setText(getNomeClienteTabela());
        txtCPF.setText(rowCpf);
        getSexoSelecionado(rowSexo);
        txtDtNascimento.setDate(Util.converterData(rowData));
        txtFone.setText(rowFone);
        
    }//GEN-LAST:event_tabelasClienteMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
        new SistemaView().show();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tabelasCliente;
    private javax.swing.JTextField txtCPF;
    private com.toedter.calendar.JDateChooser txtDtNascimento;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

  private void abrirCamposFormulario()
  {
    txtNome.setEditable(true);
    txtCPF.setEditable(true);
    txtFone.setEditable(true);
    rbFeminino.setEnabled(true);
    rbMasculino.setEnabled(true);
    txtNome.setEnabled(true);
    txtCPF.setEnabled(true);
    txtFone.setEnabled(true);
    txtDtNascimento.setEnabled(true);
    btnSalvar.setEnabled(true);
    btnCancelar.setEnabled(true);
  }
  
  private void abrirCamposPrincipal() {
    btnNovo.setEnabled(true);
    btnEditar.setEnabled(true);
    btnExcluir.setEnabled(true);
    btnSair.setEnabled(true);
  }
  
  private void limparCampos()
  {
    txtNome.setText("");
    txtCPF.setText("");
    txtFone.setText("");
    rbFeminino.setSelected(false);
    rbMasculino.setSelected(false);
    txtDtNascimento.setDate(null);
  }
  
  private void fecharCamposPrincipal() {
    btnNovo.setEnabled(false);
    btnEditar.setEnabled(false);
    btnExcluir.setEnabled(false);
    btnSair.setEnabled(false);
    
  }
  private void fecharCamposFormulario() {
    btnSalvar.setEnabled(false);
    btnCancelar.setEnabled(false);
    rbFeminino.setEnabled(false);
    rbMasculino.setEnabled(false);
    txtNome.setEnabled(false);
    txtCPF.setEnabled(false);
    txtFone.setEnabled(false);
    txtDtNascimento.setEnabled(false);
  }
  
  
  private void carregarDadosTabela() {
    String sql = "SELECT idCliente, nomeCliente,cpfCliente,sexoCliente,dtNascimentoCliente,FoneCliente FROM cliente";
    try {
      Connection conn = util.ConnectionFactory.getConexao();
      PreparedStatement ps = conn.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      
      tabelasCliente.setAutoResizeMode(0);
      tabelasCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
      tabelasCliente.getColumnModel().getColumn(1).setPreferredWidth(250);
      tabelasCliente.getColumnModel().getColumn(2).setPreferredWidth(110);
      tabelasCliente.getColumnModel().getColumn(3).setPreferredWidth(70);
      tabelasCliente.getColumnModel().getColumn(4).setPreferredWidth(110);
      tabelasCliente.getColumnModel().getColumn(5).setPreferredWidth(120);
      modelo = ((javax.swing.table.DefaultTableModel)tabelasCliente.getModel());
      
      while (rs.next()) {
        Integer codigo = Integer.valueOf(rs.getInt("idCliente"));
        String nome = rs.getString("nomeCliente");
        String cpf = rs.getString("cpfCliente");
        String sexo = rs.getString("sexoCliente");
        Date nascimento = rs.getDate("dtNascimentoCliente");
        String fone = rs.getString("FoneCliente");
        

        modelo.addRow(new Object[] { codigo, nome, cpf, sexo, Util.converterToString(nascimento), fone });
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public Integer getCodigoCliente() {
    return codigoCliente;
  }
  
  public void setCodigoCliente(Integer codigoCliente) {
    this.codigoCliente = codigoCliente;
  }
  
  public String getNomeClienteTabela() {
    return nomeClienteTabela;
  }
  
  public void setNomeClienteTabela(String nomeClienteTabela) {
    this.nomeClienteTabela = nomeClienteTabela;
  }
  
  private void getSexoSelecionado(String rowSexo) {
    if (rowSexo.equals("Masculino")) {
      rbMasculino.setSelected(true);
      rbFeminino.setSelected(false);
    }
    else if (rowSexo.equals("Feminino")){
      rbMasculino.setSelected(false);
      rbFeminino.setSelected(true);
    }
  }
  private String removerMascaraCpf(String fone) {
    return fone.replaceAll("[.-]", "").replaceAll("-", "");
  }
  
  private String removerMascaraFone(String fone) {
    return fone.replaceAll("[()]", "").replaceAll("-", "");
  }

  
}