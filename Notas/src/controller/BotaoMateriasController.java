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

public class BotaoMateriasController implements ActionListener{

	JTextField tfCodigo, tfNome, tfCargaHoraria;
	JRadioButton rdbtnCadastrar, rdbtnEditar, rdbtnExcluir;
	@SuppressWarnings("rawtypes")
	JComboBox cbMaterias;
	
	@SuppressWarnings("rawtypes")
	public BotaoMateriasController(JTextField tfCodigo, JTextField tfNome, 
			JTextField tfCargaHoraria, JRadioButton rdbtnCadastrar, 
			JRadioButton rdbtnEditar, JRadioButton rdbtnExcluir,
			JComboBox cbMaterias){
		this.tfCodigo = tfCodigo;
		this.tfCargaHoraria = tfCargaHoraria;
		this.tfNome = tfNome;
		this.rdbtnCadastrar = rdbtnCadastrar;
		this.rdbtnEditar = rdbtnEditar;
		this.rdbtnExcluir = rdbtnExcluir;
		this.cbMaterias = cbMaterias;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Materias materia = new Materias();
		if (cbMaterias.getSelectedItem() != null){
			materia = (Materias) cbMaterias.getSelectedItem();
		}
		if (rdbtnExcluir.isSelected()){
			excluir(materia);
		} else {
			materia.setNome(tfNome.getText());
			materia.setCargaHoraria(Integer.parseInt(
					tfCargaHoraria.getText()));
			if (rdbtnCadastrar.isSelected()){
				inserir(materia);
			} else {
				if (rdbtnEditar.isSelected()){
					editar(materia);
				}
			}
		}
		limpaCampos();
	}

	private void limpaCampos() {
		tfCodigo.setText("");
		tfNome.setText("");
		tfCargaHoraria.setText("");
	}

	private void editar(Materias materia) {
		MateriasDao mDao = new MateriasDaoImpl();
		try {
			mDao.editaMateria(materia);
			MateriasController materiasController = 
					new MateriasController(cbMaterias);
			materiasController.listaMaterias();
			JOptionPane.showMessageDialog(null, 
					"Alterado com sucesso","Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void inserir(Materias materia) {
		MateriasDao mDao = new MateriasDaoImpl();
		try {
			mDao.insereMateria(materia);
			JOptionPane.showMessageDialog(null, 
					"Inserido com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void excluir(Materias materia) {
		MateriasDao mDao = new MateriasDaoImpl();
		try {
			mDao.excluiMateria(materia);
			MateriasController materiasController = 
					new MateriasController(cbMaterias);
			materiasController.listaMaterias();
			JOptionPane.showMessageDialog(null, 
					"Excluído com sucesso","Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, 
					e.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

}
