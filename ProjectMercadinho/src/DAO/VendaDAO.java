package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Funcionario;
import Model.Venda;

public class VendaDAO {

	//CREATE - criar (insert)
	
    public void create(Venda venda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Venda (codeCliente, codeFuncionario, formaDePagamento, dataVenda, desconto, precoTotal) VALUES (?, ? , ? , ? , ? , ?)");
            stmt.setString(1, venda.getCodeCliente());
            stmt.setString(2, venda.getCodeFuncionario());
            stmt.setString(3, venda.getFormaDePagamento());
            stmt.setString(4, venda.getDataVenda());
            stmt.setString(5, venda.getDesconto());
            stmt.setString(6, venda.getPrecoTotal());

            stmt.executeUpdate();
            System.out.println("Venda cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

  //READ - ler (select)
    public ArrayList<Venda> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getString("idVenda"));
                venda.setCodeCliente(rs.getString("codeCliente"));
                venda.setCodeFuncionario(rs.getString("codeFuncionario"));
                venda.setFormaDePagamento(rs.getString("formaDePagamento"));
                venda.setDataVenda(rs.getString("dataVenda"));
                venda.setDesconto(rs.getString("desconto"));
                venda.setPrecoTotal(rs.getString("precoTotal"));

                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar vendas: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return vendas;
    }

    //UPDATE - atualizar (update)
    public void update(Venda venda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Venda SET codeCliente = ?, codeFuncionario = ?, formaDePagamento = ?, dataVenda = ?, desconto = ?, precoTotal = ? WHERE idVenda = ? or CodeCliente = ?");
            stmt.setString(1, venda.getCodeCliente());
            stmt.setString(2, venda.getCodeFuncionario());
            stmt.setString(3, venda.getFormaDePagamento());
            stmt.setString(4, venda.getDataVenda());
            stmt.setString(5, venda.getDesconto());
            stmt.setString(6, venda.getPrecoTotal());
            stmt.setString(7, venda.getId());
            stmt.setString(8, venda.getCodeCliente());

            stmt.executeUpdate();
            System.out.println("Venda atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    //DELETE - deletar (delete)
    	public void delete(Venda venda) {
		
		Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		
		try {
			
			stmt = con.prepareStatement("DELETE from Venda WHERE idVenda = ?");
			stmt.setString(1, venda.getId());


			stmt.executeUpdate();
			System.out.println("Deletada com sucesso!!");
			
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao deletar!", e);
		} finally {
			ConnectionDatabase.closeConnection(con, stmt);
	}
		
	}
    
    //SEARCH - procurar
    public ArrayList<Venda> search(Venda venda1) {
        
    	Connection con = ConnectionDatabase.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Venda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Venda WHERE codeCliente LIKE ? OR codeFuncionario LIKE ? OR formaDePagamento LIKE ?");
            stmt.setString(1, "%" +venda1.getCodeCliente() + "%");
            stmt.setString(2, "%" +venda1.getCodeFuncionario() + "%");
            stmt.setString(3, "%" + venda1.getFormaDePagamento() + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getString("idVenda"));
                venda.setCodeCliente(rs.getString("codeCliente"));
                venda.setCodeFuncionario(rs.getString("codeFuncionario"));
                venda.setFormaDePagamento(rs.getString("formaDePagamento"));
                venda.setDataVenda(rs.getString("dataVenda"));
                venda.setDesconto(rs.getString("desconto"));
                venda.setPrecoTotal(rs.getString("precoTotal"));

                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return vendas;  
    }
}