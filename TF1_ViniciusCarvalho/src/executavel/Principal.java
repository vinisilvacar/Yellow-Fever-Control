//Nome: Vinïcius da Silva Carvalho 	Data: 26/06/2015        
/* Sï¿½ntese
 * 		Objetivo: Gerenciar pessoas vacinadas
 * 		Entrada: nome, sexo, data da vacina, cpf, quantidade gravidez, estado civil. 
 * 		Saida: nome, sexo, data da vacina, cpf, quantidade gravidez, estado civil.
 */

package executavel;

import java.awt.EventQueue;  
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dados.Pessoa;
import dados.PostoControlador;
import visao.TelaInicial;

public class Principal {
	
	public static ArrayList<Pessoa> posto = new PostoControlador().getPessoas();
	
	public static void main(String args[]) {		
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });            
	}
}
