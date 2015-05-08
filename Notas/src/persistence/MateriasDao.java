package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Materias;

public interface MateriasDao {

	public void insereMateria(Materias materia) throws SQLException;
	public void editaMateria(Materias materia) throws SQLException;
	public void excluiMateria(Materias materia) throws SQLException;
	public Materias consultaMateria(Materias materia) throws SQLException;
	public List<Materias> listaMaterias() throws SQLException; 
	
}
