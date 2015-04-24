package controller;

import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.swing.JTextField;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ThreadMusica extends Thread {

	private Player player;
	
	public ThreadMusica(JTextField textField){
		super();
	}

	@Override
	public void run() {
		tocaMusica();
		super.run();
	}
	
	private void tocaMusica(){
//		ClassLoader CLDR = this.getClass().getClassLoader();
//		InputStream fi = CLDR.getResourceAsStream("arquivos\\tema.mp3");
		InputStream fi = getClass().getClassLoader().getResourceAsStream("arquivos\\tema.mp3");
//		File arquivo = new File(ThreadMusica.class.getResource("arquivos/tema.mp3").getPath());
		try {
//			InputStream fi = new FileInputStream(arquivo);
			BufferedInputStream bis = new BufferedInputStream(fi);
			player = new Player(bis);
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
