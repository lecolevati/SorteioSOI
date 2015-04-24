package controller;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.Dao;

public class ThreadRoda extends Thread {

	private JTextField textField;
	private String turno;
	private JButton button;
	
	public ThreadRoda(JTextField textField, String turno, JButton button){
		this.textField = textField;
		this.turno = turno;
		this.button = button;
	}

	@Override
	public void run() {
		roda();
		super.run();
	}
	
	@SuppressWarnings("deprecation")
	public void roda(){
		Thread tMusica = new ThreadMusica(textField);
		button.setEnabled(false);
		int qtd = (int)(Math.random() * 150) + 250;
		int tempo = 30;
		Dao dao = new Dao();
		boolean existe = dao.verificaGruposAp(turno);
		List<String> listaLideres = dao.retornaLideres(turno);
		String[] vetLideres = (String[]) listaLideres.toArray(new String[0]);
		if (existe){
			JOptionPane.showMessageDialog(null, "Todos inseridos", "ERRO !!!",
					JOptionPane.ERROR_MESSAGE);
			textField.setText("");
		} else {
			tMusica.start();
			int codGrupo = dao.sorteiaData(turno);
			String lider = dao.retornaLider(turno, codGrupo);
			int x = 0;
			for (int i = 1 ; i <= qtd ; i++){
				textField.setText(vetLideres[x]);
				try {
					Thread.sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (x != 8){
					x++;	
				} else {
					x = 0;
				}
				
			}
			textField.setText(lider);	
		}
		tMusica.stop();
		button.setEnabled(true);
	}
	
	
}
