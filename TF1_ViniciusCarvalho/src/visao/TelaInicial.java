package visao;

import java.awt.Dimension; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import servicos.*;

public class TelaInicial extends JFrame {
	public TelaInicial() {
			initComponents();
		}
		                       
		private void initComponents() {
			JPanel jPanel = new JPanel();
		    JLabel jLabelImagem = new JLabel();
		    JLabel jLabelTitulo = new JLabel();
		    JSeparator jSeparator = new JSeparator();
		    JButton jButtonConsultar = new JButton();
		    JButton jButtonCadastrar = new JButton();
		    JButton jButtonSair = new JButton();
		    JButton jButtonListar = new JButton();
		    JButton jButtonPesquisar = new JButton();

		    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		    jLabelImagem.setIcon(new ImageIcon("Imagem/campanha.jpg")); 

		    jLabelTitulo.setFont(new Font("Tahoma", 0, 24)); 
		    jLabelTitulo.setText("Controle de Febre Amarela");
		    setLocation(300,150);
		    setResizable(false);

		    jSeparator.setOrientation(SwingConstants.VERTICAL);
		    
		    jButtonCadastrar.setText("Cadastrar");
		    jButtonCadastrar.setPreferredSize(new Dimension(130, 35));
		    jButtonCadastrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		         jButtonCadastrarActionPerformed(evt);
		        }
		     });
		    
		    jButtonListar.setText("Listar");
		    jButtonListar.setPreferredSize(new Dimension(130, 35));
		    jButtonListar.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
		           jButtonListarActionPerformed(evt);
		         }
		       });

		    jButtonConsultar.setText("Consultar");
		    jButtonConsultar.setPreferredSize(new Dimension(130, 35));
		    jButtonConsultar.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent evt) {
					jButtonConsultarActionPerformed(evt);
		       }
		     });

		     jButtonPesquisar.setText("Pesquisar");
		     jButtonPesquisar.setPreferredSize(new Dimension(130, 35));
		     jButtonPesquisar.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent evt) {
		            jButtonPesquisarActionPerformed(evt);
		           }
		        });
		       
		     jButtonSair.setText("Sair");
			 jButtonSair.setPreferredSize(new Dimension(130, 35));
			 jButtonSair.addActionListener(new ActionListener() {
			     public void actionPerformed(ActionEvent evt) {
			          jButtonSairActionPerformed(evt);
			         }
			      });

		     GroupLayout jPanel2Layout = new GroupLayout(jPanel);
		     jPanel.setLayout(jPanel2Layout);
		     jPanel2Layout.setHorizontalGroup(
		       jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
		                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addGroup(jPanel2Layout.createSequentialGroup()
		                        .addGap(55, 55, 55)
		                        .addComponent(jLabelImagem))
		                    .addGroup(jPanel2Layout.createSequentialGroup()
		                        .addGap(42, 42, 42)
		                        .addComponent(jLabelTitulo)))
		                .addGap(18, 18, 18)
		                .addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
		                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		                    .addComponent(jButtonConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jButtonSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jButtonPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jButtonListar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                    .addComponent(jButtonCadastrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                .addContainerGap())
		        );
		        jPanel2Layout.setVerticalGroup(
		            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(jPanel2Layout.createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jSeparator)
		                .addContainerGap())
		            .addGroup(jPanel2Layout.createSequentialGroup()
		                .addGap(43, 43, 43)
		                .addComponent(jLabelTitulo)
		                .addGap(39, 39, 39)
		                .addComponent(jLabelImagem, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		            .addGroup(jPanel2Layout.createSequentialGroup()
		                .addGap(26, 26, 26)
		                .addComponent(jButtonCadastrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addGap(38, 38, 38)
		                .addComponent(jButtonListar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
		                .addComponent(jButtonConsultar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addGap(40, 40, 40)
		                .addComponent(jButtonPesquisar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addGap(37, 37, 37)
		                .addComponent(jButtonSair, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addGap(36, 36, 36))
		        );

		        GroupLayout layout = new GroupLayout(getContentPane());
		        getContentPane().setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap()
		                .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		        pack();
		    }                      

		    private void jButtonPesquisarActionPerformed(ActionEvent evt) {                                         
		    	this.setEnabled(true); //Desabilitar Tela atual
		        new TPesquisa().setVisible(true); //Botao pesquisar pressionado
		    }                                        

		    private void jButtonCadastrarActionPerformed(ActionEvent evt) {                                         
		    	this.setEnabled(false); 
		        new TCadastro().setVisible(true);  
		        this.setVisible(false);
		    }                                        

		    private void jButtonListarActionPerformed(ActionEvent evt) {                                         
		    	this.setEnabled(true); 
		        new TListar().setVisible(true);  
		    }                                        

		    private void jButtonConsultarActionPerformed(ActionEvent evt){                                         
		    	this.setEnabled(true); 
		        new TConsultar().setVisible(true); 		        
		    }                                        

		    private void jButtonSairActionPerformed(ActionEvent evt) { 
		    	String simples[] = {"Sim", "N�o"};
		    	if(JOptionPane.showOptionDialog(null, "Tem certeza que deseja sair?", "Sair", 
		    			JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, simples, simples[0]) == 0)
		    		Servicos.fechaJanela();		
		    }                                        
	}

