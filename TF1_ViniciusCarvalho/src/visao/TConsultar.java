package visao;

import java.awt.Font;   
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException; 

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import servicos.Pesquisa;

public class TConsultar extends JFrame {

    public TConsultar() {
        initComponents();
    }
                       
    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jLabelEnunciado = new JLabel();
        
        MaskFormatter mascaraCPF = null;
		try {
			mascaraCPF = new MaskFormatter("###.###.###-##");
			mascaraCPF.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			System.out.println("Erro no formato cpf");
		}
        jFormattedTextFieldRecebeCpf = new JFormattedTextField(mascaraCPF);
        
        jButtonConsultar = new JButton();
        jButtonCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Consultar");
        setLocation(300,150);
        setResizable(false);

        jLabelTitulo.setFont(new Font("Tahoma", 0, 18));
        jLabelTitulo.setText("Consulta");

        jLabelEnunciado.setText("Digite o CPF a ser consultado:");

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabelTitulo)
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEnunciado)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextFieldRecebeCpf))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonConsultar)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEnunciado)
                    .addComponent(jFormattedTextFieldRecebeCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonCancelar)))
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

    private void jButtonConsultarActionPerformed(ActionEvent evt) {  
    	if(jFormattedTextFieldRecebeCpf.getText().equals("___.___.___-__")){
    		JOptionPane.showOptionDialog(null, "Campo CPF vazio\nAdicione o numero para pesquisa", "Erro", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, null, null);
    	}else{
    		Pesquisa.consultaPorCpf(jFormattedTextFieldRecebeCpf.getText().toString());
    	}
    	limpaCampo();
    }                                                

    private void jButtonCancelarActionPerformed(ActionEvent evt) {  
			new TelaInicial().setEnabled(true);
			dispose();
    }     
    
    public void limpaCampo(){
		jFormattedTextFieldRecebeCpf.setText(null);
	}

    // Declaracao de variaveis                    
    private JButton jButtonCancelar;
    private JButton jButtonConsultar;
    private JFormattedTextField jFormattedTextFieldRecebeCpf;
    private JLabel jLabelEnunciado;
    private JLabel jLabelTitulo;
    private JPanel jPanel;
    // Fim declaracao de variaveis                   
}