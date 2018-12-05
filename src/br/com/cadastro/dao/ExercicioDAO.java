package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Exercicio;

@Repository
public class ExercicioDAO {
	Connection connection;
	
	@Autowired
	public ExercicioDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Exercicio exercicio){
		String sql = "insert into exercicios (repeticoes, idExerciciosDias, idExerciciosCatalogos) " +
					"values (?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, exercicio.getRepeticoes());
			stmt.setLong(2, exercicio.getIdExerciciosDias());
			stmt.setLong(3, exercicio.getIdExerciciosCatalogos());
		
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Exercicio> lista(){
		try{
			List<Exercicio> exercicios = new ArrayList<Exercicio>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM exercicios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Exercicio exercicio = new Exercicio();
				
				exercicio.setId(rs.getLong("id"));
				exercicio.setRepeticoes(rs.getString("repeticoes"));
				exercicio.setIdExerciciosDias(rs.getLong("idExerciciosDias"));
				exercicio.setIdExerciciosCatalogos(rs.getLong("idExerciciosCatalogos"));
				exercicios.add(exercicio);
			}
			rs.close();
			stmt.close();
			return exercicios;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Exercicio exercicio){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from exercicios where id = ?");
			
			stmt.setLong(1, exercicio.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Exercicio buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from exercicios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Exercicio exercicio = new Exercicio();

					exercicio.setId(rs.getLong("id"));
					exercicio.setRepeticoes(rs.getString("repeticoes"));
					exercicio.setIdExerciciosDias(rs.getLong("idExerciciosDias"));
					exercicio.setIdExerciciosCatalogos(rs.getLong("idExerciciosCatalogos"));
	
					
					return exercicio;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Exercicio exercicio){
		String sql = "update exercicios set repeticoes=? , idExerciciosDias=? , idExerciciosCatalogo=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, exercicio.getRepeticoes());
			stmt.setLong(2, exercicio.getIdExerciciosDias());
			stmt.setLong(3, exercicio.getIdExerciciosCatalogos());
			stmt.setLong(4, exercicio.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
