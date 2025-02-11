package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Cliente;
import Model.Fornecedor;

public class FornecedorDAO {
	
	// CREATE - criar (INSERT)	
	
	public void create(Fornecedor fornecedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
			try {
				stmt = con.prepareStatement("insert into Fornecedor (nomeFornecedor, cnpj, telefone, endereco) values(? , ? , ? , ?)");
				stmt.setString(1, fornecedor.getNome());
				stmt.setString(2, fornecedor.getCnpj());
				stmt.setString(3, fornecedor.getTelefone());
				stmt.setString(4, fornecedor.getEndereco());
				
				stmt.executeUpdate();
				System.out.println("Cadastrado com sucesso!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao cadastrar fornecedor!", e);
			}finally {
				ConnectionDatabase.closeConnection(con, stmt);
			}
		}
	// READ - ler (SELECT)
	
	public ArrayList<Fornecedor> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ArrayList<Fornecedor> fornecedores = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from Fornecedor");
			rs = stmt.executeQuery();
						
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getString(1));
				fornecedor.setNome(rs.getString(2));
				fornecedor.setCnpj(rs.getString(3));
				fornecedor.setTelefone(rs.getString(4));
				fornecedor.setEndereco(rs.getString(5));

				fornecedores.add(fornecedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao ler informações!"); 
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return fornecedores;
	}
	// SEARCH - PERQUISAR (SELECT)
	
	public ArrayList<Fornecedor> search(Fornecedor fornecedor1){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ArrayList<Fornecedor> fornecedores = new ArrayList();
		try {
			stmt = con.prepareStatement("select * from Fornecedor where cnpj like ? or nomeFornecedor like ?");
			stmt.setString(1, "%"+fornecedor1.getCnpj()+"%");
			stmt.setString(2, "%"+fornecedor1.getNome()+"%");
			rs = stmt.executeQuery();
						
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getString(1));
				fornecedor.setNome(rs.getString(2));
				fornecedor.setCnpj(rs.getString(3));
				fornecedor.setTelefone(rs.getString(4));
				fornecedor.setEndereco(rs.getString(5));

				fornecedores.add(fornecedor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao ler informações!"); 
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return fornecedores;
	}
	// UPDATE - ATUALIZAR (UPDATE)
	
	public void update(Fornecedor fornecedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
			try {
				stmt = con.prepareStatement("update fornecedor set nomeFornecedor = ?, cnpj = ?, telefone = ?, endereco = ? where idFornecedor = ? or cnpj = ?");
				stmt.setString(1, fornecedor.getNome());
				stmt.setString(2, fornecedor.getCnpj());
				stmt.setString(3, fornecedor.getTelefone());
				stmt.setString(4, fornecedor.getEndereco());
				stmt.setString(5, fornecedor.getId());
				stmt.setString(6, fornecedor.getCnpj());
				
				stmt.executeUpdate();
				System.out.println("Atualizado- com sucesso!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao atualizar!", e);
			}finally {
				ConnectionDatabase.closeConnection(con, stmt);
			}
	}
	//DELETE - EXCLUIR (DELETE)
	public void delete(Fornecedor fornecedor) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
			try {
				stmt = con.prepareStatement("delete from Fornecedor where idFornecedor = ? or cnpj =?");
				stmt.setString(1, fornecedor.getId());
				stmt.setString(2, fornecedor.getCnpj());
				
				stmt.executeUpdate();
				System.out.println("Excluido com sucesso!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException("Erro ao excluir!", e);
			}finally {
				ConnectionDatabase.closeConnection(con, stmt);
			}
	}	
}