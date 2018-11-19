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

import br.com.cadastro.model.Dia;

@Repository
public class DiaDAO {
	Connection connection;
	
	@Autowired
	public DiaDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Dia dia){
		String sql = "insert into dias (identificacao, idDiasTreino) " +
					"values (?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, dia.getIdentificacao());
			stmt.setLong(2, dia.getIdDiasTreino());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Dia> lista(){
		try{
			List<Dia> dias = new ArrayList<Dia>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM dias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Dia dia = new Dia();
				
				dia.setId(rs.getLong("id"));
				dia.setIdentificacao(rs.getString("identificacao"));
				dia.setIdDiasTreino(rs.getLong("idDiasTreino"));
				dias.add(dia);
			}
			rs.close();
			stmt.close();
			return dias;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Dia dia){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from dias where id = ?");
			
			stmt.setLong(1, dia.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Dia buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from dias");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Dia dia = new Dia();

					dia.setId(rs.getLong("id"));
					dia.setIdentificacao(rs.getString("identificacao"));
					dia.setIdDiasTreino(rs.getLong("idDiasTreino"));
	
					
					return dia;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Dia dia){
		String sql = "update dias set identificacao=? , idDiasTreino=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, dia.getIdentificacao());
			stmt.setLong(2, dia.getIdDiasTreino());
			stmt.setLong(3, dia.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
