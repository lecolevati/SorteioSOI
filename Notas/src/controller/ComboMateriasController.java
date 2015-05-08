package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import persistence.MateriasDao;
import persistence.MateriasDaoImpl;

import model.Materias;

public class ComboMateriasController implements ActionListener{

	JTextField tfCodigo, tfNome, tfCargaHoraria;
	@SuppressWarnings("rawtypes")
	JComboBox cbMaterias;
	JRadioButton rdbtnExcluir;
	
	@SuppressWarnings("rawtypes")
	public ComboMateriasController(JTextField tfCodigo, JTextField tfNome, 
			JTextField tfCargaHoraria, JComboBox cbMaterias,
			JRadioButton rdbtnExcluir){
		this.tfCodigo = tfCodigo;
		this.tfNome = tfNome;
		this.tfCargaHoraria = tfCargaHoraria;
		this.cbMaterias = cbMaterias;
		this.rdbtnExcluir = rdbtnExcluir;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (cbMaterias.getItemCount() > 0){
			if (!rdbtnExcluir.isSelected()){
				Materias materia = (Materias) cbMaterias.getSelectedItem();
				preencheCampos(materia);
			}
		}
	}

	private void preencheCampos(Materias materia) {
		MateriasDao mDao = new MateriasDaoImpl();
		Materias m = new Materias();
		try {
			m = mDao.consultaMateria(materia);
			tfCodigo.setText(String.valueOf(m.getId()));
			tfNome.setText(m.getNome());
			tfCargaHoraria.setText(String.valueOf(m.getCargaHoraria()));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

}





