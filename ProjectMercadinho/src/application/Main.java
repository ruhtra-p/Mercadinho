package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import DAO.Produto_VendaDAO;
import DAO.VendaDAO;
import Model.Cliente;
import Model.Fornecedor;
import Model.Funcionario;
import Model.Produto;
import Model.Produto_Venda;
import Model.Venda;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;
	private static Scene Login;
	private static Scene main;
	private static Scene cliente;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			primaryStage.setTitle("Mercadinho - Login");
			
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/View/ViewLogin.fxml"));
			Login = new Scene(fxmlLogin);
			
//			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/View/ViewMain.fxml"));
//			main = new Scene(fxmlMain);
			
			primaryStage.setScene(Login);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScreen(String tela) {
		if(tela.equals("main")) {
			stage.setScene(main);
			stage.centerOnScreen();
			stage.setTitle("Menu principal");
		}
	}
	
    public static void TelaHome() throws IOException {
    	
    	FXMLLoader fxmlHome = new FXMLLoader();
    	fxmlHome.setLocation(Main.class.getResource("/View/ViewMain.fxml"));
    	Parent TelaHome = fxmlHome.load();
    	main = new Scene(TelaHome);
    	stage.setTitle("Mercadinho - Menu principal");
    	stage.setScene(main);
    	stage.setResizable(false);
    	stage.centerOnScreen();
    	stage.show(); 
    }
    
    public static void TelaCliente() throws IOException {
    	
    	FXMLLoader fxmlCliente = new FXMLLoader();
    	fxmlCliente.setLocation(Main.class.getResource("/View/ViewCliente.fxml"));
    	Parent TelaCliente = fxmlCliente.load();
    	cliente = new Scene(TelaCliente);
    	stage.setTitle("Mercadinho - Relatorio Cliente");
    	stage.setScene(cliente);
    	stage.setResizable(false);
    	stage.centerOnScreen();
    	stage.show();
    } 
    
    private static Stage cadCliente;
    public static void TelaCadastroCliente() throws IOException {
    	FXMLLoader fxmlCadastroCliente = new FXMLLoader();
    	fxmlCadastroCliente.setLocation(Main.class.getResource("/View/ViewCadastroCliente.fxml"));
    	Parent cadastroCliente = fxmlCadastroCliente.load();
    	Scene scene2 = new Scene(cadastroCliente);
    	
    	cadCliente = new Stage();
    	cadCliente.setTitle("Cadastro/Edição de Cliente - Mercadinho do João");
    	cadCliente.initModality(Modality.WINDOW_MODAL);
    	cadCliente.setScene(scene2);
    	cadCliente.centerOnScreen();
    	cadCliente.showAndWait();   	
    }
    
    private static Stage venda;
    public static void TelaRegistroVenda() throws IOException {
    	FXMLLoader fxmlRegistroVenda = new FXMLLoader();
    	fxmlRegistroVenda.setLocation(Main.class.getResource("/View/ViewRegistroVenda.fxml"));
    	Parent registroVenda = fxmlRegistroVenda.load();
    	Scene scene2 = new Scene(registroVenda);
    	
    	venda = new Stage();
    	venda.setTitle("Registro de Vendas - Mercadinho do João");
    	venda.initModality(Modality.WINDOW_MODAL);
    	venda.setScene(scene2);
    	venda.centerOnScreen();
    	venda.showAndWait();   	
    }
    	
    	
	public static void main(String[]  args) {	
		launch(args);
	}
}