package DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Cliente;

public class ClienteDAO {

	// CREATE - criar (INSERT)	

	public void create(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("insert into Cliente (nomeCliente, cpfCliente, emailCliente, telefoneCliente, generoCliente, enderecoCliente, dataNascCliente) values(? , ? , ? , ? , ? , ? , ?)");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmal());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getGenero());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getDataNasc());

			stmt.executeUpdate();
			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar cliente!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	// READ - ler (SELECT)

	public ArrayList<Cliente> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from Cliente");
			rs = stmt.executeQuery();

			int i=1;
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(""+ i);
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setEmal(rs.getString(4));
				cliente.setTelefone(rs.getString(5));
				cliente.setGenero(rs.getString(6));
				cliente.setEndereco(rs.getString(7));
				cliente.setDataNasc(rs.getString(8));

				clientes.add(cliente);
				i++;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao ler informações!"); 
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
	//UPDATE - ATUALIZAR (

	public void update(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update cliente set nomeCliente = ?, cpfCliente = ?, emailCliente = ?, telefoneCliente = ?, generoCliente = ?, enderecoCliente = ?, dataNascCliente = ? where cpfCliente = ?");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmal());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getGenero());
			stmt.setString(6, cliente.getEndereco());
			stmt.setString(7, cliente.getDataNasc());
			stmt.setString(8, cliente.getCpf());

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

	public void delete(Cliente cliente) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from Cliente where idCliente = ? or cpfCliente =?");
			stmt.setString(1, cliente.getId());
			stmt.setString(2, cliente.getCpf());

			stmt.executeUpdate();
			System.out.println("Excluido com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao excluir!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	//SEARCH - PESQUISAR (SELECT)

	public ArrayList<Cliente> search(Cliente cliente1){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from Cliente where cpfCliente like ? or nomeCliente like ?");
			stmt.setString(1, "%"+cliente1.getCpf()+"%");
			stmt.setString(2, "%"+cliente1.getNome()+"%");
			rs = stmt.executeQuery();


			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setEmal(rs.getString(4));
				cliente.setTelefone(rs.getString(5));
				cliente.setGenero(rs.getString(6));
				cliente.setEndereco(rs.getString(7));
				cliente.setDataNasc(rs.getString(8));

				clientes.add(cliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao pesquisar informações!"); 
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return clientes;
	}
	
    public ArrayList<String> readClienteByNome() {
    	Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> clientes = new ArrayList<>();
    	
        try {
            stmt = con.prepareStatement("select nomeCliente from Cliente");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            	String nome;
            	nome = rs.getString(1);
            	clientes.add(nome);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler os clientes!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return clientes;
    }
}