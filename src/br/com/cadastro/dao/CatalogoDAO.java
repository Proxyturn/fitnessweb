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

import br.com.cadastro.model.Catalogo;

@Repository
public class CatalogoDAO {
	Connection connection;
	
	@Autowired
	public CatalogoDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Catalogo catalogo){
		String sql = "insert into catalogos (identificacao, descricao) " +
					"values (?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, catalogo.getIdentificacao());
			stmt.setString(2, catalogo.getDescricao());
		
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Catalogo> lista(){
		try{
			List<Catalogo> catalogos = new ArrayList<Catalogo>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM catalogos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Catalogo catalogo = new Catalogo();
				
				catalogo.setId(rs.getLong("id"));
				catalogo.setIdentificacao(rs.getString("identificacao"));
				catalogo.setDescricao(rs.getString("descricao"));
				catalogos.add(catalogo);
			}
			rs.close();
			stmt.close();
			return catalogos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Catalogo catalogo){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from catalogos where id = ?");
			
			stmt.setLong(1, catalogo.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Catalogo buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from catalogos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Catalogo catalogo = new Catalogo();

					catalogo.setId(rs.getLong("id"));
					catalogo.setIdentificacao(rs.getString("identificacao"));
					catalogo.setDescricao(rs.getString("descricao"));
	
					
					return catalogo;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Catalogo catalogo){
		String sql = "update catalogos set identificacao=? , descricao=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, catalogo.getIdentificacao());
			stmt.setString(2, catalogo.getDescricao());
			stmt.setLong(3, catalogo.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
