package visao;

import java.awt.Font;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import servicos.*;
import executavel.Principal;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class TListar extends JFrame{
	public TListar() {
        initComponents();
    }
	                        
	private void initComponents() {

	jPanel = new JPanel();
	jLabelTitulo = new JLabel();
	jButtonNome = new JButton();
	jButtonDtVacina = new JButton();
	jButtonOrdemCadastro = new JButton();
	jLabelTotalCadastros = new JLabel();

	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	setTitle("Tela Listar");
	setLocation(300,150);
	setResizable(false);

	jLabelTitulo.setFont(new Font("Tahoma", 0, 24)); 
	jLabelTitulo.setText("Como deseja listar?");

	jButtonNome.setFont(new Font("Tahoma", 0, 15)); 
	jButtonNome.setText("Por Nome");
	jButtonNome.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
		jButtonNomeActionPerformed(evt);
		}
	 });

	jButtonDtVacina.setFont(new Font("Tahoma", 0, 15)); 
	jButtonDtVacina.setText("Por Data de Vacina");
	jButtonDtVacina.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent evt) {
		jButtonDtVacinaActionPerformed(evt);
	    }
	 });

	 jButtonOrdemCadastro.setFont(new Font("Tahoma", 0, 15)); 
	 jButtonOrdemCadastro.setText("Por Ordem de Cadastro");
	 jButtonOrdemCadastro.addActionListener(new ActionListener() {
	 public void actionPerformed(ActionEvent evt) {
		 jButtonOrdemCadastroActionPerformed(evt);
	     }
	  });

	 jLabelTotalCadastros.setText("Total de Cadastros: " + Principal.posto.size());

	 GroupLayout jPanel1Layout = new GroupLayout(jPanel);
	 jPanel.setLayout(jPanel1Layout);
	 jPanel1Layout.setHorizontalGroup(
	 jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jButtonNome)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonDtVacina)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonOrdemCadastro))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(124, 124, 124)
	                        .addComponent(jLabelTitulo))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(jLabelTotalCadastros)))
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabelTitulo)
	                .addGap(21, 21, 21)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonNome)
	                    .addComponent(jButtonDtVacina)
	                    .addComponent(jButtonOrdemCadastro))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
	                .addComponent(jLabelTotalCadastros)
	                .addContainerGap())
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        			.addComponent(jPanel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
	        );
	        getContentPane().setLayout(layout);
	        pack();
	    }                        

	    private void jButtonNomeActionPerformed(ActionEvent evt) {    
	    	Pesquisa.listarCadastrados("Por Nome");
	    }                                           

	    private void jButtonDtVacinaActionPerformed(ActionEvent evt) {                                                
	    	Pesquisa.listarCadastrados("Por Data Vacina");
	    }                                               

	    private void jButtonOrdemCadastroActionPerformed(ActionEvent evt) {                                                     
	        Pesquisa.listarCadastrados("Por Ordem Cadastro");
	    }                                                    

	    // Declaracao de variaveis                   
	    private JButton jButtonDtVacina;
	    private JButton jButtonNome;
	    private JButton jButtonOrdemCadastro;
	    private JLabel jLabelTitulo;
	    private JLabel jLabelTotalCadastros;
	    private JPanel jPanel;
	    // Fim declaracao de variaveis                   
}
