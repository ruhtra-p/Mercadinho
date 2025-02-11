package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import Model.Produto;

public class ProdutoDAO {

    // CREATE - criar (INSERT)
    public void create(Produto produto) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into Produto(codeFornecedor, nomeProduto, codBarra, lote, dataFabricacao, dataValidade, marca, categoria, unidadeDeMedida, precoUnitario, estoque) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getCodeFornecedor());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getCodBarra());
            stmt.setString(4, produto.getLote());
            stmt.setString(5, produto.getDataFab());
            stmt.setString(6, produto.getDataVal());
            stmt.setString(7, produto.getMarca());
            stmt.setString(8, produto.getCategoria());
            stmt.setString(9, produto.getUnidadeDeMed());
            stmt.setString(10, produto.getPrecoUn());
            stmt.setString(11, produto.getEstoque());
            stmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar  LIL Produto :C", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // READ - ler (SELECT)
    public ArrayList<Produto> read() {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getString(1));
                produto.setCodeFornecedor(rs.getString(2));
                produto.setNome(rs.getString(3));
                produto.setCodBarra(rs.getString(4));
                produto.setLote(rs.getString(5));
                produto.setDataFab(rs.getString(6));
                produto.setDataVal(rs.getString(7));
                produto.setMarca(rs.getString(8));
                produto.setCategoria(rs.getString(9));
                produto.setUnidadeDeMed(rs.getString(10));
                produto.setPrecoUn(rs.getString(11));
                produto.setEstoque(rs.getString(12));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler informações de Produto!");
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return produtos;
    }

    // UPDATE - atualizar (UPDATE)
    public void update(Produto produto) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("update Produto set codeFornecedor = ?, nomeProduto = ?, codBarra = ?, lote = ?, dataFabricacao = ?, dataValidade = ?, marca = ?, categoria = ?, unidadeDeMedida = ?, precoUnitario = ?, estoque = ? where idProduto = ? or codBarra = ?");
            stmt.setString(1, produto.getCodeFornecedor());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getCodBarra());
            stmt.setString(4, produto.getLote());
            stmt.setString(5, produto.getDataFab());
            stmt.setString(6, produto.getDataVal());
            stmt.setString(7, produto.getMarca());
            stmt.setString(8, produto.getCategoria());
            stmt.setString(9, produto.getUnidadeDeMed());
            stmt.setString(10, produto.getPrecoUn());
            stmt.setString(11, produto.getEstoque());
            stmt.setString(12, produto.getId());
            stmt.setString(13, produto.getCodBarra());
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso👌");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar Produto!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // DELETE - excluir (DELETE)
    public void delete(Produto produto) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from Produto where idProduto = ? or codBarra = ?");
            stmt.setString(1, produto.getId());
            stmt.setString(2, produto.getCodBarra());
            stmt.executeUpdate();
            System.out.println("Produto excluído com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir Produto!", e);
        } finally {
            ConnectionDatabase.closeConnection(con, stmt);
        }
    }

    // SEARCH - pesquisar (SELECT)
    public ArrayList<Produto> search(Produto produto1) {
        Connection con = ConnectionDatabase.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from Produto where nomeProduto like ? or codBarra like ?");
            stmt.setString(1, "%" + produto1.getNome() + "%");
            stmt.setString(2, "%" + produto1.getCodBarra() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getString(1));
                produto.setCodeFornecedor(rs.getString(2));
                produto.setNome(rs.getString(3));
                produto.setCodBarra(rs.getString(4));
                produto.setLote(rs.getString(5));
                produto.setDataFab(rs.getString(6));
                produto.setDataVal(rs.getString(7));
                produto.setMarca(rs.getString(8));
                produto.setCategoria(rs.getString(9));
                produto.setUnidadeDeMed(rs.getString(10));
                produto.setPrecoUn(rs.getString(11));
                produto.setEstoque(rs.getString(12));
                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao pesquisar Produto!");
        } finally {
            ConnectionDatabase.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
}