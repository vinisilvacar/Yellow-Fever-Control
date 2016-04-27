package visao;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import comparadores.PessoaComparator;
import servicos.*;
import dados.Pessoa;
import dados.PostoControlador;
import executavel.Principal;

public class TPesquisa extends JFrame{

    public TPesquisa() {
        initComponents();
    }
                        
    private void initComponents() {

        jPanel = new JPanel();
        jLabelEnunciado = new JLabel();
        jTextFieldRecebeNome = new JTextField();
        jButtonPesquisar = new JButton();
        jScrollPane = new JScrollPane();
        jTableResultados = new JTable();
        jLabelQuantRegistros = new JLabel();
        jSeparator = new JSeparator();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Pesquisar");
        setLocation(300,150);
        setResizable(false); 

        jLabelEnunciado.setText("Nome a pesquisar:");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableResultados.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {"Nome", "CPF", "Sexo", "Data Vacinacao"}
        ));
        jScrollPane.setViewportView(jTableResultados);

        jLabelQuantRegistros.setText("Quantidade de Registros encontrados: ");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEnunciado)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRecebeNome, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelQuantRegistros)
                            .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                            .addComponent(jSeparator))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEnunciado)
                    .addComponent(jTextFieldRecebeNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelQuantRegistros, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonPesquisarActionPerformed(ActionEvent evt) {                                                 
    	String sexo;
    	String parteNome = jTextFieldRecebeNome.getText().trim();
		List<Pessoa> pessoasPesquisadas = new ArrayList<Pessoa>();
		Object [][] resposta = new Object[pessoasPesquisadas.size()][4];
	
		if(parteNome.isEmpty()){
			JOptionPane.showMessageDialog(null, "Nome vazio ou inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
			jTableResultados.updateUI();
			limpaTabela();
		}else{
			pessoasPesquisadas = Pesquisa.pesquisaNome(Principal.posto, parteNome);
			if(pessoasPesquisadas.isEmpty() == false){
				jTableResultados.setModel(new DefaultTableModel(resposta, new String[] {"Nome", "CPF", "Sexo", "Data Vacinação"}));
				jLabelQuantRegistros.setText("Quantidade de Registros Recuperados: " + pessoasPesquisadas.size());
				
				PessoaComparator pessoaComparator = new PessoaComparator();
				Collections.sort(pessoasPesquisadas, pessoaComparator);
				
				DefaultTableModel model = (DefaultTableModel) jTableResultados.getModel();  
				model.setNumRows(0);  
  
				for (Pessoa pessoa : pessoasPesquisadas) {            
					if(pessoa.toString().contains("Masculino"))
						sexo = "Masculino";
					else
						sexo = "Feminino";
					model.addRow(new Object[]{pessoa.getNome(), pessoa.getCpf(), sexo, pessoa.getDataVacina()});             
				} 
			}
			if(pessoasPesquisadas.size() == 0){
				JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
				jTextFieldRecebeNome.setText("");
				jTableResultados.updateUI();
				limpaTabela();
			}
		} 
    }
    
    private void limpaTabela(){
    	DefaultTableModel tableModel =(DefaultTableModel) jTableResultados.getModel();  
    	while (tableModel.getRowCount() > 0) {
    		tableModel.getDataVector().removeAllElements();
    	}
    }

    // Declaracao de variaveis                   
    private JButton jButtonPesquisar;
    private JLabel jLabelEnunciado;
    private JLabel jLabelQuantRegistros;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JSeparator jSeparator;
    private JTable jTableResultados;
    private JTextField jTextFieldRecebeNome;  
    //Fim declaracao de variaveis
	
}

