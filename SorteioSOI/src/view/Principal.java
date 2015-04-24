package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Principal {

	private JFrame frame;
	private final Sair sair = new Sair();
	private final Cadastro cadastro = new Cadastro();
	private final SorteioConsulta sorteioConsulta = new SorteioConsulta();
	private final SorteiaDatas sorteiaDatas = new SorteiaDatas();
	private final Sobre sobre = new Sobre();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnSorteio = new JMenu("Sorteio");
		menuBar.add(mnSorteio);
		
		JMenuItem mntmCadastrarGrupos = new JMenuItem("Cadastrar Grupos");
		mntmCadastrarGrupos.setAction(cadastro);
		mnSorteio.add(mntmCadastrarGrupos);
		
		JMenuItem mntmSorteioEConsulta = new JMenuItem("Sorteio e Consulta");
		mntmSorteioEConsulta.setAction(sorteioConsulta);
		mnSorteio.add(mntmSorteioEConsulta);
		
		JMenuItem mntmSorteiaDatas = new JMenuItem("Sorteia Datas");
		mntmSorteiaDatas.setAction(sorteiaDatas);
		mnSorteio.add(mntmSorteiaDatas);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAction(sair);
		mnSorteio.add(mntmSair);
		
		JMenu mnMisc = new JMenu("Misc");
		menuBar.add(mnMisc);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setAction(sobre);
		mnMisc.add(mntmSobre);
	}

	private class Sair extends AbstractAction {
		public Sair() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Finaliza");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class Cadastro extends AbstractAction {
		public Cadastro() {
			putValue(NAME, "Cadastrar Grupos");
			putValue(SHORT_DESCRIPTION, "Cadastro");
		}
		public void actionPerformed(ActionEvent e) {
			CadastroGrupos cadastroGrupos = new CadastroGrupos();
			cadastroGrupos.setVisible(true);
		}
	}
	private class SorteioConsulta extends AbstractAction {
		public SorteioConsulta() {
			putValue(NAME, "Sorteio e Consulta");
			putValue(SHORT_DESCRIPTION, "Faz Sorteio e Realiza Consulta");
		}
		public void actionPerformed(ActionEvent e) {
			TelaSorteio telaSorteio = new TelaSorteio();
			telaSorteio.setVisible(true);
		}
	}
	private class SorteiaDatas extends AbstractAction {
		public SorteiaDatas() {
			putValue(NAME, "Sorteia Datas");
			putValue(SHORT_DESCRIPTION, "SorteiaDatas");
		}
		public void actionPerformed(ActionEvent e) {
			DiaAp diaAp = new DiaAp();
			diaAp.setVisible(true);
		}
	}
	private class Sobre extends AbstractAction {
		public Sobre() {
			putValue(NAME, "Sobre");
			putValue(SHORT_DESCRIPTION, "Sobre");
		}
		public void actionPerformed(ActionEvent e) {
			String texto = "Sistema de Sorteio de Grupos \n"+
				"Desenvolvido pelo \n"+
				"Prof. M.Sc. Leandro Colevati dos Santos \n"+
				"Para Uso na Disciplina \n"+
				"Sistemas Operacionais I \n \n"+
				"Todos os Direitos Reservados";
			JOptionPane.showMessageDialog(null, texto, "Sobre",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
