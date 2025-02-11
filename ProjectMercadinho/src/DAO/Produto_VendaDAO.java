package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Produto_Venda;

public class Produto_VendaDAO {

    // CREATE - Criar (Insert)
    public void create(Produto_Venda produtoVenda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Produto_Venda (codeProduto, codeVenda, quantidade) VALUES (?, ?, ?)");
            stmt.setString(1, produtoVenda.getCodeProduto());
            stmt.setString(2, produtoVenda.getCodeVenda());
            stmt.setString(3, produtoVenda.getQuantidade());

            stmt.executeUpdate();
            System.out.println("Produto_Venda cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Produto_Venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // READ - Ler (Select)
    public ArrayList<Produto_Venda> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Produto_Venda> produtosVenda = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Produto_Venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto_Venda pv = new Produto_Venda();
                pv.setId(rs.getString("idProdutoVenda"));
                pv.setCodeProduto(rs.getString("codeProduto"));
                pv.setCodeVenda(rs.getString("codeVenda"));
                pv.setQuantidade(rs.getString("quantidade"));

                produtosVenda.add(pv);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produto_Venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return produtosVenda;
    }

    // UPDATE - Atualizar (Update)
    public void update(Produto_Venda produtoVenda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE Produto_Venda SET codeProduto = ?, codeVenda = ?, quantidade = ? WHERE idProdutoVenda = ?");
            stmt.setString(1, produtoVenda.getCodeProduto());
            stmt.setString(2, produtoVenda.getCodeVenda());
            stmt.setString(3, produtoVenda.getQuantidade());
            stmt.setString(4, produtoVenda.getId());

            stmt.executeUpdate();
            System.out.println("Produto_Venda atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Produto_Venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // DELETE - Deletar (Delete)
    public void delete(Produto_Venda produtoVenda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Produto_Venda WHERE idProdutoVenda = ?");
            stmt.setString(1, produtoVenda.getId());

            stmt.executeUpdate();
            System.out.println("Produto_Venda deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar Produto_Venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // SEARCH - Procurar
    public ArrayList<Produto_Venda> search(Produto_Venda produtoVenda) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Produto_Venda> produtosVenda = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Produto_Venda WHERE codeProduto LIKE ? OR codeVenda LIKE ? OR quantidade LIKE ?");
            stmt.setString(1, "%" + produtoVenda.getCodeProduto() + "%");
            stmt.setString(2, "%" + produtoVenda.getCodeVenda() + "%");
            stmt.setString(3, "%" + produtoVenda.getQuantidade() + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto_Venda pv = new Produto_Venda();
                pv.setId(rs.getString("idProdutoVenda"));
                pv.setCodeProduto(rs.getString("codeProduto"));
                pv.setCodeVenda(rs.getString("codeVenda"));
                pv.setQuantidade(rs.getString("quantidade"));

                produtosVenda.add(pv);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Produto_Venda: " + e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }

        return produtosVenda;
    }
}
