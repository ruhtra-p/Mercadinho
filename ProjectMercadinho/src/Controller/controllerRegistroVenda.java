package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import Model.Cliente;
import Model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class controllerRegistroVenda implements Initializable{

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancelar;

    @FXML
    private Button btFinalizar;

    @FXML
    private ChoiceBox<String> choicePagamento;

    @FXML
    private TableColumn<Produto, String> columnIndice;

    @FXML
    private TableColumn<Produto, String> columnPrecoTotal;

    @FXML
    private TableColumn<Produto, String> columnPrecoUn;

    @FXML
    private TableColumn<Produto, String> columnProduto;

    @FXML
    private TableColumn<Produto, String> columnQuantidade;

    @FXML
    private TableView<Produto> tableProdutos;
   
    @FXML
    private TextField txtCPF;
    
    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtCliente;
    
    @FXML
    private TextField txtCodProduto;

    @FXML
    private TextField txtDesconto;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtTotalCompra;

    @FXML
    private TextField txtValorUN;

    @FXML
    private TextField txtVendedor;

    @FXML
    void actionAdicionar(ActionEvent event) {

    }

    @FXML
    void actionCancelar(ActionEvent event) {

    }

    @FXML
    void actionFinalizar(ActionEvent event) {

    }
    
    @FXML
    void actionCPFType(KeyEvent event) {
    	if(txtCliente.getText().length() > 3) {	
    	ClienteDAO clienteDAO = new ClienteDAO();
    	Cliente cliente = new Cliente();
    	cliente.setNome(txtCliente.getText());
    	ArrayList<Cliente> clientes = new ArrayList<>();
    	clientes = clienteDAO.search(cliente);
    	cliente = clientes.get(0);
    	txtCPF.setText(cliente.getCpf());
    	}	
    }
    
    @FXML
    void actionCPFclick(MouseEvent event) {
    	if(txtCliente.getText().length() > 3) {	
    	ClienteDAO clienteDAO = new ClienteDAO();
    	Cliente cliente = new Cliente();
    	cliente.setNome(txtCliente.getText());
    	ArrayList<Cliente> clientes = new ArrayList<>();
    	clientes = clienteDAO.search(cliente);
    	cliente = clientes.get(0);
    	txtCPF.setText(cliente.getCpf());
    	}else {
    		txtCPF.setText(null);
    	}
    }
    
    @FXML
    void actionProdutoClick(MouseEvent event) {
    	
    	if (txtProduto.getText().length() > 3) {
    		ProdutoDAO produtoDAO = new ProdutoDAO();
    		Produto produto = new Produto();
    		produto.setNome(txtProduto.getText());
    		ArrayList<Produto> produtos = new ArrayList<>();
    		produtos = produtoDAO.search(produto);
    		produto = produtos.get(0);
    		txtCodProduto.setText(produto.getCodBarra());	
    		
    		String precoUn;
    		precoUn = produto.getPrecoUn();
    		double valorUn = Double.parseDouble(precoUn);
    		precoUn = String.format("%.2f", valorUn);
    		txtValorUN.setText("R$ "+precoUn);
    	}
    }

    @FXML
    void actionProdutoType(KeyEvent event) {
    	if (txtProduto.getText().length() > 3) {	
    		ProdutoDAO produtoDAO = new ProdutoDAO();
    		Produto produto = new Produto();
    		produto.setNome(txtProduto.getText());
    		ArrayList<Produto> produtos = new ArrayList<>();
    		produtos = produtoDAO.search(produto);
    		produto = produtos.get(0);
    		txtCodProduto.setText(produto.getCodBarra());
    		
    		String precoUn;
    		precoUn = produto.getPrecoUn();
    		double valorUn = Double.parseDouble(precoUn);
    		precoUn = String.format("%.2f", valorUn);
    		txtValorUN.setText("R$ "+precoUn);
    	} else {
    		txtCodProduto.setText(null);
    		txtValorUN.setText(null);
    	}
    }
  
    private static Produto produtoVenda = new Produto();
    double totalVenda;
    @FXML
    void actionAdicionarProduto(ActionEvent event) {
    	produtoVenda.setNome(txtProduto.getText());
    	produtoVenda.setEstoque(txtQuantidade.getText());
    	produtoVenda.setPrecoUn(txtValorUN.getText());
    	produtoVenda.setPrecoTotal(txtTotalCompra.getText());
    	String valor = txtTotalCompra.getText();
    	valor = valor.replace(",", ".");
    	double precoTotal = Double.parseDouble(txtTotalCompra.getText());
    		
    	totalVenda = totalVenda + precoTotal;
    	txtTotalCompra.setText("R$"+totalVenda);
    	ArrayProdutos.add(produtoVenda);
    	
    	carregarTableProdutos(ArrayProdutos);
    }

    @FXML
    void actionDesconto(KeyEvent event) {
    	ProdutoDAO produtoDAO = new ProdutoDAO();
    	Produto produto = new Produto();
    	produto.setNome(txtProduto.getText());
    	ArrayList<Produto> produtos = new ArrayList<>();
    	produtos = produtoDAO.search(produto);
    	produto = produtos.get(0);
    	double quantidade = Double.parseDouble(txtQuantidade.getText());
    	double precoUN = Double.parseDouble(produto.getPrecoUn());

    	if(quantidade >= 15) {
    		double desconto = (precoUN * quantidade) * 0.05;
    		double precoTotal = precoUN * quantidade - desconto;
    		txtDesconto.setText(""+String.format("%.2f", desconto));
    		txtTotalCompra.setText(""+String.format("%.2f", precoTotal));
    	}else if(quantidade < 15) {
    		txtDesconto.setText("0,00");
    		double precoTotal = precoUN * quantidade;
    		txtTotalCompra.setText(""+String.format("%.2f", precoTotal));
    	}else {
    		txtDesconto.setText(null);
    		txtTotalCompra.setText(null);
    	}
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		choicePagamento.getItems().add("Débito");
		choicePagamento.getItems().add("Dinheiro");
		choicePagamento.getItems().add("Pix");
		txtVendedor.setText(controllerLogin.funcionario.getNome());
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayList<String> nomesProdutos = new ArrayList<String>();
		nomesProdutos = produtoDAO.readProdutoByNome();
		String[] produto = new String[nomesProdutos.size()];
		for(int i = 0; i < nomesProdutos.size(); i++) {
			produto[i] = nomesProdutos.get(i);
		}
		TextFields.bindAutoCompletion(txtProduto, produto);	
		//==========================================================
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<String> nomesClientes = new ArrayList<String>();
		nomesClientes = clienteDAO.readClienteByNome();
		String[] cliente = new String[nomesClientes.size()];
		
		for(int i = 0; i < nomesClientes.size(); i++) {
			cliente[i] = nomesClientes.get(i);
		}
		TextFields.bindAutoCompletion(txtCliente, cliente);
	}	
	
    private ObservableList<Produto> ArrayProdutos;
	public void carregarTableProdutos(ObservableList<Produto> arrayProdutos2) {
		ObservableList<Produto> produtosVendidos = FXCollections.observableArrayList(ArrayProdutos);

		columnIndice.setCellValueFactory(new PropertyValueFactory<>("id"));
		columnProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("precoUn"));
		columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
	
		tableProdutos.setItems(produtosVendidos);
	}
	
	
	
}	