package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import persistence.MateriasDao;
import persistence.MateriasDaoImpl;

import model.Materias;

public class MateriasController {

	@SuppressWarnings("rawtypes")
	JComboBox cbMaterias;
	
	@SuppressWarnings("rawtypes")
	public MateriasController(JComboBox cbMaterias){
		this.cbMaterias = cbMaterias;
	}
	
	@SuppressWarnings("unchecked")
	public void listaMaterias(){
		List<Materias> lista = new ArrayList<Materias>();
		MateriasDao mDao = new MateriasDaoImpl();
		try {
			lista = mDao.listaMaterias();
			if (cbMaterias.getItemCount() > 0){
				cbMaterias.removeAllItems();
			}
			if (lista != null){
				for (Materias m : lista){
					cbMaterias.addItem(m);
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}






