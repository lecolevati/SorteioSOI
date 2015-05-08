package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Materias;

public class MateriasDaoImpl implements MateriasDao {

	Connection c;
	
	public MateriasDaoImpl(){
		GenericDao gDao = new GenericDaoImpl();
		c = gDao.getConnection();
	}
	
	@Override
	public void insereMateria(Materias materia) throws SQLException {
		String sql = "INSERT INTO materias VALUES (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, materia.getNome());
		ps.setInt(2, materia.getCargaHoraria());
		ps.execute();
		ps.close();
	}

	@Override
	public void editaMateria(Materias materia) throws SQLException {
		String sql = "UPDATE materias SET nome = ?, " +
				"carga_horaria = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, materia.getNome());
		ps.setInt(2, materia.getCargaHoraria());
		ps.setInt(3, materia.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiMateria(Materias materia) throws SQLException {
		String sql = "DELETE materias WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, materia.getId());
		ps.execute();
		ps.close();
	}

	@Override
	public Materias consultaMateria(Materias materia) throws SQLException {
		Materias m = new Materias();
		String sql = "SELECT id, nome, carga_horaria FROM materias " +
				"WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, materia.getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			m.setId(rs.getInt("id"));
			m.setNome(rs.getString("nome"));
			m.setCargaHoraria(rs.getInt("carga_horaria"));
		}
		ps.close();
		rs.close();
		return m;
	}

	@Override
	public List<Materias> listaMaterias() throws SQLException {
		List<Materias> lista = new ArrayList<Materias>();
		String sql = "SELECT id, nome, carga_horaria FROM materias";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Materias m = new Materias();
			m.setId(rs.getInt("id"));
			m.setNome(rs.getString("nome"));
			m.setCargaHoraria(rs.getInt("carga_horaria"));
			lista.add(m);
		}
		ps.close();
		rs.close();
		return lista;
	}

}