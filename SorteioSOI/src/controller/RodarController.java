package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class RodarController implements ActionListener {

	private JTextField textField;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton button;
	
	@SuppressWarnings("rawtypes")
	public RodarController(JTextField textField, JComboBox comboBox, JButton button){
		this.textField = textField;
		this.comboBox = comboBox;
		this.button = button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread tRoda = new ThreadRoda(textField, comboBox.getSelectedItem().toString(), button);
		tRoda.start();
	}

}
