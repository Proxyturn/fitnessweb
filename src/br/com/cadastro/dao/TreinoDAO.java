package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Treino;

@Repository
public class TreinoDAO {
	Connection connection;
	
	@Autowired
	public TreinoDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Treino treino){
		String sql = "insert into treinos (identificacao, dataInicio, dataFim, status, idTreinoUsuario) " +
					" values (?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, treino.getIdentificacao());
			
			if(treino.getDataInicio() != null)
			{
				stmt.setDate(2, new java.sql.Date(treino.getDataInicio().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(2, null);
			}
			
			if(treino.getDataFim() != null)
			{
				stmt.setDate(3, new java.sql.Date(treino.getDataFim().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(3, null);
			}
			
			stmt.setLong(4, treino.getStatus());
			stmt.setLong(5, treino.getIdTreinoUsuario());
		
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Treino> lista(){
		try{
			List<Treino> treinos = new ArrayList<Treino>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM treinos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Treino treino = new Treino();
				
				treino.setId(rs.getLong("id"));
				treino.setIdentificacao(rs.getString("identificacao"));
				if(rs.getDate("dataInicio") != null){
					Calendar dataInicio = Calendar.getInstance();
					dataInicio.setTime(rs.getDate("dataInicio"));
					treino.setDataInicio(dataInicio);
				}
				if(rs.getDate("dataFim") != null){
					Calendar dataFim = Calendar.getInstance();
					dataFim.setTime(rs.getDate("dataFim"));
					treino.setDataFim(dataFim);
				}
				treino.setStatus(rs.getLong("status"));
				treino.setIdTreinoUsuario(rs.getLong("idTreinoUsuario"));
				
				treinos.add(treino);
			}
			rs.close();
			stmt.close();
			return treinos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Treino treino){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from treinos where id = ?");
			
			stmt.setLong(1, treino.getId());
			stmt.execute();
			stmt.close();
	
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Treino buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from treinos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Treino treino = new Treino();
					
					treino.setId(rs.getLong("id"));
					treino.setIdentificacao(rs.getString("identificacao"));
					if(rs.getDate("dataInicio") != null){
						Calendar dataInicio = Calendar.getInstance();
						dataInicio.setTime(rs.getDate("dataInicio"));
						treino.setDataInicio(dataInicio);
					}
					if(rs.getDate("dataFim") != null){
						Calendar dataFim = Calendar.getInstance();
						dataFim.setTime(rs.getDate("dataFim"));
						treino.setDataFim(dataFim);
					}
					treino.setStatus(rs.getLong("status"));
					treino.setIdTreinoUsuario(rs.getLong("idTreinoUsuario"));
					
					return treino;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Treino treino){
		String sql = "update treinos set identificacao=?where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, treino.getIdentificacao());
			stmt.setLong(3, treino.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
