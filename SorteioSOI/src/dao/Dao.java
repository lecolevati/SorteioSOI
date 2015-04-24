package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import pojo.Sorteio;

public class Dao {

//	GenericDao genericDao = new GenericDao();
//	Connection c = genericDao.getConnection();

	public boolean limpaBase(){
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		boolean limpo = false;
		String query1 = "delete temagrupo";
		String query2 = "delete temagrupon";
		String query3 = "delete grupotarde";
		String query4 = "delete gruponoite";
		String query5 = "DBCC CHECKIDENT (grupotarde, RESEED, 0)";
		String query6 = "DBCC CHECKIDENT (gruponoite, RESEED, 0)";
		try {
			PreparedStatement ps1 = c.prepareStatement(query1);
			ps1.execute();
			PreparedStatement ps2 = c.prepareStatement(query2);
			ps2.execute();
			PreparedStatement ps3 = c.prepareStatement(query3);
			ps3.execute();
			PreparedStatement ps4 = c.prepareStatement(query4);
			ps4.execute();
			PreparedStatement ps5 = c.prepareStatement(query5);
			ps5.execute();
			PreparedStatement ps6 = c.prepareStatement(query6);
			ps6.execute();
			limpo = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return limpo;
		
	}
	
	public List<String> retornaLideres(String turno){
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		List<String> lista = new ArrayList<String>();
		String lider = "";
		String queryString = "";
		if (turno.equals("T")){
			queryString = "select lider from grupotarde";
		} else {
			queryString = "select lider from gruponoite";
		}
		ResultSet rs = null;
		
		try {

			
			PreparedStatement ps = c.prepareStatement(queryString);
			ps.execute();
			rs = ps.getResultSet();
			while (rs.next()){
				lider = rs.getString(1);
				lista.add(lider);
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	public String retornaLider(String turno, int codigoGrupo){
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		String lider = "";
		String queryString = "";
		if (turno.equals("T")){
			queryString = "select lider from grupotarde where codigo = ?";
		} else {
			queryString = "select lider from gruponoite where codigo = ?";
		}
		ResultSet rs = null;
		
		try {

			
			PreparedStatement ps = c.prepareStatement(queryString);
			ps.setInt(1, codigoGrupo);
			ps.execute();
			rs = ps.getResultSet();
			if (rs.next()){
				lider = rs.getString(1);
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lider;
		
	}
	
	public int sorteiaData (String turno){
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		int inserido = 0;
		int randomGrupo = 0;
		
		while (inserido == 0)
		try {
			
			double x = (Math.random() * 9) + 1;
			randomGrupo = (int)(x);
			
			CallableStatement cs = c.prepareCall("{call sp_cadastradata (?,?)}");
			cs.setString(1, turno);
			cs.setInt(2, randomGrupo);
			cs.execute();
			cs.close();
			inserido = 1;
		} catch (SQLException e) {
			inserido = 0;
		}
		
		return randomGrupo;
		
	}

	public void insereDados (String turno){
		
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		
		int temas[] = new int[9];
		int grupos[] = new int[9];
		
		temas = criaVetor();
		grupos = criaVetor();
		
		for (int i = 0 ; i < 9 ; i++ ){
			String query = "";
			if (turno.equals("T")){
				query = "insert into temagrupo values (?,?,?)";
			} else {
				query = "insert into temagrupon values (?,?,?)";
			}
			try {
				
				PreparedStatement ps = c.prepareStatement(query);
				ps.setInt(1, grupos[i]);
				ps.setInt(2, temas[i]);
				ps.setString(3, "01/01/1930");
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
    public List<Sorteio> apresentaSorteio (String turno){
    	GenericDao genericDao = new GenericDao();
      	Connection c = genericDao.getConnection();
		List<Sorteio> listSorteio = new ArrayList<Sorteio>();
		ResultSet rs = null;
		String query = "";
      	try{
      		if (turno.equals("T")){
      			query = "select grupotarde.lider, grupotarde.codigo as codLider, grupotarde.turno, tema.codigo, tema.sistema,"+
      				" convert(char(10),temagrupo.data,103) as data"+
      				" from grupotarde inner join temagrupo"+
      				" on grupotarde.codigo = temagrupo.codigogrupo"+
      				" inner join tema"+
      				" on tema.codigo = temagrupo.codigotema";
      		} else {
      			query = "select gruponoite.lider, gruponoite.codigo as codLider, gruponoite.turno, tema.codigo, tema.sistema,"+
      			" convert(char(10),temagrupon.data,103) as data"+
      			" from gruponoite inner join temagrupon" + 
      			" on gruponoite.codigo = temagrupon.codigogrupo" +
      			" inner join tema"+
      			" on tema.codigo = temagrupon.codigotema";
      		}
      		PreparedStatement ps = c.prepareStatement(query);
			ps.execute();
			rs = ps.getResultSet();
			while (rs.next()){
				Sorteio sorteio = new Sorteio();
				sorteio.setCodLider(rs.getInt("codLider"));
				sorteio.setCodTema(rs.getInt("codigo"));
				sorteio.setNomeLider(rs.getString("lider"));
				sorteio.setNomeTema(rs.getString("sistema"));
				sorteio.setData(rs.getString("data"));
				listSorteio.add(sorteio);
			}
			ps.close(); 
      	} catch (Exception e) {
      		e.printStackTrace();
      	}
      	return listSorteio;
    }

	
	public boolean insereGrupo (String nome, String turno) {

		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		
		boolean inserido = false;
		
		try {
			
			String queryString = "";
			if (turno.equals("T")){
				queryString = "insert into grupotarde values (?,?)";
			} else {
				queryString = "insert into gruponoite values (?,?)";
			}
			PreparedStatement ps = c.prepareStatement(queryString);
			ps.setString(1, nome);
			ps.setString(2, turno);
			ps.execute();
			ps.close();
			inserido = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO !!!", JOptionPane.ERROR_MESSAGE);
		}
		return inserido;
	}
	
	public int[] criaVetor(){
		int vetor[] = new int[9];
		
		for (int i = 0 ; i < 9 ; i++){
			double x = (Math.random() * 9) + 1;
			int randomTema = (int)(x);
			int existe = verificaVetor(vetor, randomTema);
			if (existe == 1) {
				i--;
			} else {
				vetor[i] = randomTema;
			}
		}
		
		return vetor;
	}
	
	public int verificaVetor (int[] vet, int numero){
		int existe = 0;
		for (int i = 0 ; i < 9 ; i++){
			if (vet[i] == numero){
				existe = 1;
				break;
			}
		}
		return existe;
	}
	
	public boolean verificaSorteio(String turno){
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		boolean sorteado = false;
		String query = "";
		ResultSet rs = null;
		
		if (turno.equals("T")){
			query = "select count(*) from temagrupo";
		} else {
			query = "select count(*) from temagrupon";
		}
		
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.execute();
			rs = ps.getResultSet();
			if (rs.next()){
				int valor = rs.getInt(1);
				if (valor != 0){
					sorteado = true;
				}
			}
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return sorteado;
		
	}

	public boolean verificaGruposAp(String turno){
		GenericDao genericDao = new GenericDao();
		Connection c = genericDao.getConnection();
		boolean qtd = false;
		ResultSet rs = null;
		String query = "";
		
		if (turno.equals("T")){
			query = "select count(*) from temagrupo where data = '01/01/1930'";
		} else {
			query = "select count(*) from temagrupon where data = '01/01/1930'";
		}
		
		try {
			PreparedStatement ps = c.prepareStatement(query);
			ps.execute();
			rs = ps.getResultSet();
			if (rs.next()){
				int valor = rs.getInt(1);
				if (valor == 0){
					qtd = true;
				}
			}
			ps.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return qtd;
		
	}

	
}


