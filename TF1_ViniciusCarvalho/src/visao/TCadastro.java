package visao;

import java.awt.Font; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.text.ParseException; 

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import executavel.Principal;
import servicos.*;
import validacao.Validacao;

public class TCadastro extends JFrame{
    public TCadastro() {
        initComponents();
    }

	private void initComponents() {
	        jPanel = new JPanel();
	        jLabelTitulo = new JLabel();
	        jLabelNome = new JLabel();
	        jLabelCpf = new JLabel();
	        jLabelDataVacina = new JLabel();
	        jLabelSexo = new JLabel();
	        jTextFieldNome = new JTextField();
	        
	        MaskFormatter mascaraCPF = null;
			try {
				mascaraCPF = new MaskFormatter("###.###.###-##");
				mascaraCPF.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				System.out.println("Erro no formato cpf");
			}
	        jFormattedTextFieldCpf = new JFormattedTextField(mascaraCPF);
	        
	        MaskFormatter mascaraData = null;
			try {
				mascaraData = new MaskFormatter("##/##/####");
				mascaraData.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				System.out.println("Erro no formato data");
			}
	        jFormattedTextFieldDataVacina = new JFormattedTextField(mascaraData); 
	        
	        buttonSexo = new ButtonGroup();
	        jRadioButtonMasculino = new JRadioButton();
	        jRadioButtonFeminino = new JRadioButton();
	        jLabelEstadoCivil = new JLabel();
	        jLabelQuantGravidez = new JLabel();
	        jComboBoxEstadoCivil = new JComboBox();
	        jSpinnerQuantGravidez = new JSpinner();
	        jButtonCancelar = new JButton();
	        jButtonSalvar = new JButton();

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        jLabelTitulo.setFont(new Font("Tahoma", 0, 24)); 
	        jLabelTitulo.setText("Cadastro de Pessoas");
	        setLocation(300,150);
	        setResizable(false);

	        jLabelNome.setText("Nome Completo:");
	        jLabelCpf.setText("CPF:");
	        jLabelDataVacina.setText("Data da Vacina:");
	        jLabelSexo.setText("Sexo: ");
	        jLabelEstadoCivil.setText("Estado Civil:");
	        jLabelQuantGravidez.setText("Quantidade Gravidez:");
	        
	        jTextFieldNome.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jTextFieldNomeActionPerformed(evt);
	            }
	        });

	        jFormattedTextFieldCpf.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jTextFieldCPFActionPerformed(evt);
	            }
	        });

	        jFormattedTextFieldDataVacina.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jFormattedTextFieldDataVacinaActionPerformed(evt);
	            }
	        });

	        buttonSexo.add(jRadioButtonMasculino);
	        jRadioButtonMasculino.setText("Masculino");
	        jRadioButtonMasculino.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jRadioButtonMasculinoActionPerformed(evt);
	            }
	        });

	        buttonSexo.add(jRadioButtonFeminino);
	        jRadioButtonFeminino.setText("Feminino");
	        jRadioButtonFeminino.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jRadioButtonFemininoActionPerformed(evt);
	            }
	        });

	        jComboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] { "Solteiro", "Casado", "Separado", "Divorciado", "Vi�vo" }));
	        jComboBoxEstadoCivil.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jComboBoxEstadoCivilActionPerformed(evt);
	            }
	        });

	        jButtonCancelar.setText("Cancelar");
	        jButtonCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                jButtonCancelarActionPerformed(evt);
	            }
	        });

	        jButtonSalvar.setText("Salvar");
	        jButtonSalvar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
						jButtonSalvarActionPerformed(evt);
	            }
	        });

	        GroupLayout jPanel1Layout = new GroupLayout(jPanel);
	        jPanel.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(97, 97, 97)
	                        .addComponent(jLabelTitulo))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(21, 21, 21)
	                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(jLabelNome)
	                            .addComponent(jLabelCpf)
	                            .addComponent(jLabelDataVacina)
	                            .addComponent(jLabelSexo)
	                            .addComponent(jLabelEstadoCivil)
	                            .addComponent(jLabelQuantGravidez))
	                        .addGap(47, 47, 47)
	                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(jTextFieldNome)
	                            .addComponent(jFormattedTextFieldCpf)
	                            .addComponent(jFormattedTextFieldDataVacina)
	                            .addGroup(jPanel1Layout.createSequentialGroup()
	                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                                    .addGroup(jPanel1Layout.createSequentialGroup()
	                                        .addComponent(jRadioButtonMasculino)
	                                        .addGap(18, 18, 18)
	                                        .addComponent(jRadioButtonFeminino))
	                                    .addComponent(jComboBoxEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(jSpinnerQuantGravidez, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
	                                .addGap(0, 29, Short.MAX_VALUE)))))
	                .addContainerGap())
	            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addGap(0, 0, Short.MAX_VALUE)
	                .addComponent(jButtonSalvar)
	                .addGap(18, 18, 18)
	                .addComponent(jButtonCancelar))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
	                .addGap(34, 34, 34)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabelNome)
	                    .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabelCpf)
	                    .addComponent(jFormattedTextFieldCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabelDataVacina)
	                    .addComponent(jFormattedTextFieldDataVacina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabelSexo)
	                    .addComponent(jRadioButtonMasculino)
	                    .addComponent(jRadioButtonFeminino))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabelQuantGravidez)
	                    .addComponent(jSpinnerQuantGravidez, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabelEstadoCivil)
	                    .addComponent(jComboBoxEstadoCivil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
	                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonCancelar)
	                    .addComponent(jButtonSalvar)))
	        );

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        pack();
	    }                      

	    private void jRadioButtonMasculinoActionPerformed(ActionEvent evt) {                                              
	    	jSpinnerQuantGravidez.setEnabled(false);
	    	jComboBoxEstadoCivil.setEnabled(true);
	    }                                             

	    private void jRadioButtonFemininoActionPerformed(ActionEvent evt) {                                              
	    	jSpinnerQuantGravidez.setEnabled(true);
	    	jComboBoxEstadoCivil.setEnabled(false);
	    }                                             

	    private void jFormattedTextFieldDataVacinaActionPerformed(ActionEvent evt) {                                                     
	    }                                                    

	    private void jTextFieldCPFActionPerformed(ActionEvent evt) {                                            
	    }                                           

	    private void jTextFieldNomeActionPerformed(ActionEvent evt) {                                            
	    }                                           

	    private void jButtonSalvarActionPerformed(ActionEvent evt){                                         
	    	StringBuilder nome = null;
			String dataVacinacao = null, registro = null;
			Boolean erro;
			
			try{
				erro = false;
				if(jTextFieldNome.getText().trim().isEmpty()|| jFormattedTextFieldDataVacina.getText().trim().isEmpty()|| jFormattedTextFieldCpf.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Nao pode ter campos vazios!");
					erro=true;
				}
				nome = Validacao.validaNome(jTextFieldNome.getText());
				dataVacinacao = Validacao.validaData(jFormattedTextFieldDataVacina.getText());
				registro = Validacao.validaCpf(jFormattedTextFieldCpf.getText(), Principal.posto);
				if(nome == null || dataVacinacao == null || registro == null)
					erro = true;
			}catch(NullPointerException excPointer){
				JOptionPane.showMessageDialog(null, "Campo vazio", null, JOptionPane.ERROR_MESSAGE);
				erro=true;
			}catch(NumberFormatException excNumber){
				JOptionPane.showMessageDialog(null, "Campo invalido", null, JOptionPane.ERROR_MESSAGE);
				erro=true;
			}
			
			if(jRadioButtonMasculino.isSelected() == false && jRadioButtonFeminino.isSelected() == false)
				JOptionPane.showOptionDialog(null, "Sexo nao selecionado", "Erro", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
			
			//Opcao Sexo Masculino
	        if(jRadioButtonMasculino.isSelected()){
	        	String estadoCivil = jComboBoxEstadoCivil.getSelectedItem().toString();
	        	if(estadoCivil == null)
	        		erro = true;
	        	if(erro == false){
	        		Principal.posto.add(Servicos.cadastraHomem(nome, dataVacinacao, registro, estadoCivil)); 
		            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Confirmacao", JOptionPane.INFORMATION_MESSAGE);
		            limpaCampos();
	        	}else{
	        		//Nothing to do
	        	}
	        }
	        
	        //Opcao Sexo Feminino
	        if (jRadioButtonFeminino.isSelected()){
	        	Integer quantGravidez = 0;
	        	
		    	quantGravidez = Validacao.validaQuantGravidez(jSpinnerQuantGravidez.getValue().toString());
		    	if(quantGravidez == null)
		    		erro = true;
		   
	    	    if(erro == false){
	    	      Principal.posto.add(Servicos.cadastraMulher(nome, dataVacinacao, registro, quantGravidez));
		    	  JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Confirmacao", JOptionPane.INFORMATION_MESSAGE);
		    	  limpaCampos();
	    	    }else{
	    	    	//Nothing to do
	    	    }
	        }	        
	    }    
	    
	    public void limpaCampos(){
    		jTextFieldNome.setText(null);
    		jFormattedTextFieldDataVacina.setText(null);
    		jFormattedTextFieldCpf.setText(null);
    		buttonSexo.clearSelection();
    		jSpinnerQuantGravidez.setEnabled(true);
    		jComboBoxEstadoCivil.setEnabled(true);
    		jComboBoxEstadoCivil.setSelectedIndex(0);
    		jSpinnerQuantGravidez.setValue(0);
    	}

	    private void jButtonCancelarActionPerformed(ActionEvent evt) {                                         
	    	if (JOptionPane.showConfirmDialog(null, "Deseja retornar ao menu?", "Confirma��o", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				new TelaInicial().setVisible(true);
				dispose();
			}
	    }                                        

	    private void jComboBoxEstadoCivilActionPerformed(ActionEvent evt) {                                           
	    }                                          
	    
	    // Declara��o de Vari�veis  
	    private ButtonGroup buttonSexo;
	    private JButton jButtonSalvar;
	    private JButton jButtonCancelar;
	    private JComboBox jComboBoxEstadoCivil;
	    private JFormattedTextField jFormattedTextFieldDataVacina;
	    private JLabel jLabelTitulo;
	    private JLabel jLabelNome;
	    private JLabel jLabelCpf;
	    private JLabel jLabelDataVacina;
	    private JLabel jLabelSexo;
	    private JLabel jLabelEstadoCivil;
	    private JLabel jLabelQuantGravidez;
	    private JPanel jPanel;
	    private JRadioButton jRadioButtonMasculino;
	    private JRadioButton jRadioButtonFeminino;
	    private JSpinner jSpinnerQuantGravidez;
	    private JTextField jTextFieldNome;
	    private JTextField jFormattedTextFieldCpf;
}

