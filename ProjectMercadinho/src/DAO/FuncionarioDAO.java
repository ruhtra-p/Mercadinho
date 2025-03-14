package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Funcionario;
import Util.Alerts;
import javafx.scene.control.Alert.AlertType;
import Model.Funcionario;

public class FuncionarioDAO {

	// CREATE - criar (INSERT)	

	public void create(Funcionario funcionario) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("insert into Funcionario(nomeFuncionario, senha, cpfFuncionario, emailFuncionario, telefoneFuncionario, generoFuncionario, enderecoFuncionario, dataNascFuncionario, cargo, salario, dataDeAdmissao) values(? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ?)");
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(4, funcionario.getEmail());	
			stmt.setString(5, funcionario.getTelefone());
			stmt.setString(6, funcionario.getGenero());
			stmt.setString(7, funcionario.getEndereco());
			stmt.setString(8, funcionario.getDataNasc());
			stmt.setString(9, funcionario.getCargo());
			stmt.setString(10, funcionario.getSalario());
			stmt.setString(11, funcionario.getDataDeAdmissao());

			stmt.executeUpdate();
			System.out.println("Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao cadastrar Funcionario!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	// READ - ler (SELECT)

	public ArrayList<Funcionario> read(){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from Funcionario");
			rs = stmt.executeQuery();


			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getString(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setSenha(rs.getString(3));
				funcionario.setCpf(rs.getString(4));
				funcionario.setEmail(rs.getString(5));
				funcionario.setTelefone(rs.getString(6));
				funcionario.setGenero(rs.getString(7));
				funcionario.setEndereco(rs.getString(8));
				funcionario.setDataNasc(rs.getString(9));
				funcionario.setCargo(rs.getString(10));
				funcionario.setSalario(rs.getString(11));
				funcionario.setDataDeAdmissao(rs.getString(12));

				funcionarios.add(funcionario);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao ler informações!"); 
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return funcionarios;
	}
	//UPDATE - ATUALIZAR (

	public void update(Funcionario funcionario) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update funcionario set nomeFuncionario = ?, senha = ?, cpfFuncionario = ?, emailFuncionario = ?, telefoneFuncionario = ?, generoFuncionario = ?, enderecoFuncionario = ?, dataNascFuncionario = ?, cargo = ?, salario = ?, dataDeAdmissao = ? where idFuncionario = ? or cpfFuncionario = ?");
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSenha());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(4, funcionario.getEmail());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setString(6, funcionario.getGenero());
			stmt.setString(7, funcionario.getEndereco());
			stmt.setString(8, funcionario.getDataNasc());
			stmt.setString(9, funcionario.getCargo());
			stmt.setString(10, funcionario.getSalario());
			stmt.setString(11, funcionario.getDataDeAdmissao());
		    stmt.setString(12, funcionario.getId());
		    stmt.setString(13, funcionario.getCpf());

			stmt.executeUpdate();
			System.out.println("Atualizado com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao atualizar!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	//DELETE - EXCLUIR (DELETE)

	public void delete(Funcionario funcionario) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from Funcionario where idFuncionario = ? or cpfFuncionario =?");
			stmt.setString(1, funcionario.getId());
			stmt.setString(2, funcionario.getCpf());

			stmt.executeUpdate();
			System.out.println("LIL BRO EXCLUIDO");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao excluir!", e);
		}finally {
			ConnectionDatabase.closeConnection(con, stmt);
		}
	}
	//SEARCH - PESQUISAR (SELECT)

	public ArrayList<Funcionario> search(Funcionario funcionario1){
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from funcionario where cpfFuncionario like ? or nomeFuncionario like ?");
			stmt.setString(1, "%" +funcionario1.getCpf()+ "%");
			stmt.setString(2, "%" +funcionario1.getNome()+ "%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getString(1));
				funcionario.setNome(rs.getString(2));
				funcionario.setSenha(rs.getString(3));
				funcionario.setCpf(rs.getString(4));
				funcionario.setEmail(rs.getString(5));
				funcionario.setTelefone(rs.getString(6));
				funcionario.setGenero(rs.getString(7));
				funcionario.setEndereco(rs.getString(8));
				funcionario.setDataNasc(rs.getString(9));
				funcionario.setCargo(rs.getString(10));
				funcionario.setSalario(rs.getString(11));
				funcionario.setDataDeAdmissao(rs.getString(12));
				
				funcionarios.add(funcionario);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro ao pesquisar informações!"); 
		}finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
		return funcionarios;
	}
	
	
	public Funcionario autenticarUser(String cpf, String senha) {
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs =  null;
		Funcionario funcionario =  new Funcionario();
		
			try {
				stmt = con.prepareStatement("select * from Funcionario where cpfFuncionario = ? and senha = ?");
				stmt.setString(1, cpf);
				stmt.setString(2, senha);
				rs = stmt.executeQuery();
				
				while(rs.next()) {					
					funcionario.setId(rs.getString(1));
					funcionario.setNome(rs.getString(2));
					funcionario.setSenha(rs.getString(3));
					funcionario.setCpf(rs.getString(4));
					funcionario.setEmail(rs.getString(5));
					funcionario.setTelefone(rs.getString(6));
					funcionario.setGenero(rs.getString(7));
					funcionario.setEndereco(rs.getString(8));
					funcionario.setDataNasc(rs.getString(9));
					funcionario.setCargo(rs.getString(10));
					funcionario.setSalario(rs.getString(11));
					funcionario.setDataDeAdmissao(rs.getString(12));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Alerts.showAlert("Erro!", "Erro de Conexão", "Falha ao consultar informações no banco de dados", AlertType.ERROR);
				throw new RuntimeException("Erro de autenticação", e);
			}finally {
				ConnectionDatabase.closeConnection(con, stmt, rs);
			}	
			
		return funcionario;
	}
	
    public String getTotalVendido(String id) {
    	
    	Connection con = ConnectionDatabase.getConnection();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	String TotalVendido = null;
    	
    	try {
    		
			stmt = con.prepareStatement("select SUM(precoTotal) as TotalVendido from Venda where codeFuncionario = ?");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				TotalVendido = rs.getString(1);
			}
			
		} catch (SQLException e) {
			Alerts.showAlert("Erro!", "Erro de conexão", "Falha ao consultar informações no banco de dados.", AlertType.ERROR);
			throw new RuntimeException("Erro!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt, rs);
		}
    	
		return TotalVendido;
    }
	private PreparedStatement setString(int i, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}