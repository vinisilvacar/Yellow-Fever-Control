package comparadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JOptionPane;

import dados.Pessoa;

public class OrdenaDataVacina implements Comparator<Pessoa>{
		public int compare(Pessoa humano1, Pessoa humano2) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");   
			Date date1 = null, date2 = null;
			try {
				date1 = format.parse(humano1.getDataVacina());
				date2 = format.parse(humano2.getDataVacina());
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "Erro ao comparar datas");
				e.printStackTrace();
			}
			return (date1.compareTo(date2));
		}	
}
