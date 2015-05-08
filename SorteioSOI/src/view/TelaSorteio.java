package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dao.Dao;
import pojo.Sorteio;

public class TelaSorteio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfGrupo1;
	private JTextField tfGrupo2;
	private JTextField tfGrupo3;
	private JTextField tfGrupo4;
	private JTextField tfGrupo5;
	private JTextField tfGrupo6;
	private JTextField tfGrupo7;
	private JTextField tfGrupo8;
	private JTextField tfGrupo9;
	private JTextField tfTema1;
	private JTextField tfTema2;
	private JTextField tfTema3;
	private JTextField tfTema4;
	private JTextField tfTema5;
	private JTextField tfTema6;
	private JTextField tfTema7;
	private JTextField tfTema8;
	private JTextField tfTema9;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSorteio frame = new TelaSorteio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TelaSorteio() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		@SuppressWarnings("unused")
		final int grupos[] = new int[9];
		@SuppressWarnings("unused")
		final int temas[] = new int[9];
		
		tfGrupo1 = new JTextField();
		tfGrupo1.setEditable(false);
		tfGrupo1.setBounds(58, 11, 178, 20);
		contentPane.add(tfGrupo1);
		tfGrupo1.setColumns(10);
		
		tfGrupo2 = new JTextField();
		tfGrupo2.setEditable(false);
		tfGrupo2.setColumns(10);
		tfGrupo2.setBounds(58, 56, 178, 20);
		contentPane.add(tfGrupo2);
		
		tfGrupo3 = new JTextField();
		tfGrupo3.setEditable(false);
		tfGrupo3.setColumns(10);
		tfGrupo3.setBounds(58, 101, 178, 20);
		contentPane.add(tfGrupo3);
		
		tfGrupo4 = new JTextField();
		tfGrupo4.setEditable(false);
		tfGrupo4.setColumns(10);
		tfGrupo4.setBounds(58, 146, 178, 20);
		contentPane.add(tfGrupo4);
		
		tfGrupo5 = new JTextField();
		tfGrupo5.setEditable(false);
		tfGrupo5.setColumns(10);
		tfGrupo5.setBounds(58, 191, 178, 20);
		contentPane.add(tfGrupo5);
		
		tfGrupo6 = new JTextField();
		tfGrupo6.setEditable(false);
		tfGrupo6.setColumns(10);
		tfGrupo6.setBounds(58, 236, 178, 20);
		contentPane.add(tfGrupo6);
		
		tfGrupo7 = new JTextField();
		tfGrupo7.setEditable(false);
		tfGrupo7.setColumns(10);
		tfGrupo7.setBounds(58, 281, 178, 20);
		contentPane.add(tfGrupo7);
		
		tfGrupo8 = new JTextField();
		tfGrupo8.setEditable(false);
		tfGrupo8.setColumns(10);
		tfGrupo8.setBounds(58, 326, 178, 20);
		contentPane.add(tfGrupo8);
		
		tfGrupo9 = new JTextField();
		tfGrupo9.setEditable(false);
		tfGrupo9.setColumns(10);
		tfGrupo9.setBounds(58, 371, 178, 20);
		contentPane.add(tfGrupo9);
		
		tfTema1 = new JTextField();
		tfTema1.setEditable(false);
		tfTema1.setBounds(406, 11, 214, 20);
		contentPane.add(tfTema1);
		tfTema1.setColumns(10);
		
		tfTema2 = new JTextField();
		tfTema2.setEditable(false);
		tfTema2.setColumns(10);
		tfTema2.setBounds(406, 56, 214, 20);
		contentPane.add(tfTema2);
		
		tfTema3 = new JTextField();
		tfTema3.setEditable(false);
		tfTema3.setColumns(10);
		tfTema3.setBounds(406, 101, 214, 20);
		contentPane.add(tfTema3);
		
		tfTema4 = new JTextField();
		tfTema4.setEditable(false);
		tfTema4.setColumns(10);
		tfTema4.setBounds(406, 146, 214, 20);
		contentPane.add(tfTema4);
		
		tfTema5 = new JTextField();
		tfTema5.setEditable(false);
		tfTema5.setColumns(10);
		tfTema5.setBounds(406, 191, 214, 20);
		contentPane.add(tfTema5);
		
		tfTema6 = new JTextField();
		tfTema6.setEditable(false);
		tfTema6.setColumns(10);
		tfTema6.setBounds(406, 236, 214, 20);
		contentPane.add(tfTema6);
		
		tfTema7 = new JTextField();
		tfTema7.setEditable(false);
		tfTema7.setColumns(10);
		tfTema7.setBounds(406, 281, 214, 20);
		contentPane.add(tfTema7);
		
		tfTema8 = new JTextField();
		tfTema8.setEditable(false);
		tfTema8.setColumns(10);
		tfTema8.setBounds(406, 326, 214, 20);
		contentPane.add(tfTema8);
		
		tfTema9 = new JTextField();
		tfTema9.setEditable(false);
		tfTema9.setColumns(10);
		tfTema9.setBounds(406, 371, 214, 20);
		contentPane.add(tfTema9);
		
		JButton btnSortear = new JButton("Sortear");
		btnSortear.setBounds(58, 467, 89, 23);
		contentPane.add(btnSortear);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(58, 419, 46, 14);
		contentPane.add(lblTurno);
		
		final JComboBox cbTurno = new JComboBox();
		cbTurno.setModel(new DefaultComboBoxModel(new String[] {"T", "N"}));
		cbTurno.setBounds(114, 416, 46, 20);
		contentPane.add(cbTurno);
		
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.setBounds(58, 502, 89, 23);
		contentPane.add(btnVerificar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(531, 467, 89, 23);
		contentPane.add(btnFechar);
		
		btnSortear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {


				String turno = String.valueOf(cbTurno.getSelectedItem());
				Dao dao = new Dao();
				boolean sorteado = dao.verificaSorteio(turno);
				if (sorteado){
					JOptionPane.showMessageDialog(null, "Sorteio Já Realizado", "ERRO", 
							JOptionPane.ERROR_MESSAGE);
				} else {
					dao.insereDados(turno);
				}
				consultaSorteio(turno);				
			}
		});
		
		btnVerificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String turno = String.valueOf(cbTurno.getSelectedItem());
				consultaSorteio(turno);
				
				
			}
		});
		
		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
	
	public void consultaSorteio(String turno) {
		Dao dao = new Dao();
		List<Sorteio> listSorteio = new ArrayList<Sorteio>();
		listSorteio = dao.apresentaSorteio(turno);
		
		int cont = 0;
		for (Sorteio sorteio : listSorteio) {
			cont++;
			String data = " ";
			if (!sorteio.Data.equals("01/01/1930")){
				data = data + " - " + sorteio.Data;
			}
			switch (cont){
			
				case 1:
					tfGrupo1.setText(sorteio.nomeLider);
					tfTema1.setText(sorteio.nomeTema + data);
					break;
				case 2:
					tfGrupo2.setText(sorteio.nomeLider);
					tfTema2.setText(sorteio.nomeTema + data);
					break;
				case 3:
					tfGrupo3.setText(sorteio.nomeLider);
					tfTema3.setText(sorteio.nomeTema + data);
					break;
				case 4:
					tfGrupo4.setText(sorteio.nomeLider);
					tfTema4.setText(sorteio.nomeTema + data);
					break;
				case 5:
					tfGrupo5.setText(sorteio.nomeLider);
					tfTema5.setText(sorteio.nomeTema + data);
					break;
				case 6:
					tfGrupo6.setText(sorteio.nomeLider);
					tfTema6.setText(sorteio.nomeTema + data);
					break;
				case 7:
					tfGrupo7.setText(sorteio.nomeLider);
					tfTema7.setText(sorteio.nomeTema + data);
					break;
				case 8:
					tfGrupo8.setText(sorteio.nomeLider);
					tfTema8.setText(sorteio.nomeTema + data);
					break;
				case 9:
					tfGrupo9.setText(sorteio.nomeLider);
					tfTema9.setText(sorteio.nomeTema + data);
					break;
			}
				
					
		}

	}
}
