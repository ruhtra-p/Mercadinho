package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import ConnectionFactory.ConnectionDatabase;
import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import Model.Cliente;
import Model.Funcionario;
import Model.Produto;
import Util.Alerts;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class controllerMain implements Initializable{

    @FXML
    private Button btClientes;

    @FXML
    private Button btMenuPrincipal;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRegistroVenda;

    @FXML
    private Button btRelatorioVenda;

    @FXML
    private Button btSair;

    @FXML
    private Button btfornecedores;

    @FXML
    private Button btfuncionarios;

    @FXML
    private TableView<Produto> tableProdutos;

    @FXML
    private Text txtTotalVendido;

    @FXML
    private Text txtUser;
    
    @FXML
    private TableColumn<Produto, String> columnCodBarra;

    @FXML
    private TableColumn<Produto, String> columnDataFab;

    @FXML
    private TableColumn<Produto, String> columnDataVal;

    @FXML
    private TableColumn<Produto, String> columnEstoque;

    @FXML
    private TableColumn<Produto, String> columnIndice;

    @FXML
    private TableColumn<Produto, String> columnProduto;
    
    @FXML
    private ObservableList<Produto> ArrayProdutos;
    
    @FXML
    void logOut(ActionEvent event) {
    	Main.changeScreen("login");
    }

    @FXML
    void telaClientes(ActionEvent event) throws IOException {
    	Main.TelaCliente();
    }
    
    @FXML
    void telaFornecedores(ActionEvent event) {

    }

    @FXML
    void telaFuncionarios(ActionEvent event) {

    }

    @FXML
    void telaMenuPrincipal(ActionEvent event) {

    }

    @FXML
    void telaProdutos(ActionEvent event) {

    }

    @FXML
    void telaRegistroVenda(ActionEvent event) throws IOException {
    	Main.TelaRegistroVenda();
    }

    @FXML
    void telaRelatorioVenda(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		String totalVendido;
		totalVendido = funcionarioDAO.getTotalVendido(controllerLogin.funcionario.getId());
		
		double valorTotal = Double.parseDouble(totalVendido);
		totalVendido = String.format("%.2f", valorTotal);
		
		txtTotalVendido.setText("R$ " + totalVendido);
		txtUser.setText("" + controllerLogin.funcionario.getNome());
		
		carregarTableProdutos();
	}

	public void carregarTableProdutos() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayProdutos = FXCollections.observableArrayList(produtoDAO.getByEstoque());

		columnIndice.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnCodBarra.setCellValueFactory(new PropertyValueFactory<>("codBarra"));
		columnDataVal.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataFab.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnEstoque.setCellValueFactory(new PropertyValueFactory<>("estoque"));
	
		tableProdutos.setItems(ArrayProdutos);
	}
}