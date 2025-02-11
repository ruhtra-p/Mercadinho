package application;
	
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
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	System.out.println("Conexão fechada!");
	}
	
	public static void main(String[]  args) {
		Connection con = ConnectionDatabase.getConnection();
		ConnectionDatabase.closeConnection(con);
		

		//Produto_VENDA
		Produto_Venda produtoVenda = new Produto_Venda();
		Produto_VendaDAO pVendaDAO = new Produto_VendaDAO();
		ArrayList<Produto_Venda> produtos_Vendas = new ArrayList<>();
		
		//----TESTES DE CREATE
        /*produtoVenda.setCodeProduto("17");
        produtoVenda.setCodeVenda("67");
        produtoVenda.setQuantidade("7");
        produtoVenda.setId("129");*/
		//pVendaDAO.create(produtoVenda);
		
		
		//----TESTE DE READ
		//produtos_Vendas.addAll(pVendaDAO.read());
		
		
		//----TESTES DE UPDATE
		//pVendaDAO.update(produtoVenda);
		
		
		//----TESTES DE DELETE
		/*produtoVenda.setId("129");
		pVendaDAO.delete(produtoVenda);*/
		
		
		//----TEST DE SEARCH
		/*produtoVenda.setQuantidade("6");
		produtos_Vendas.addAll(pVendaDAO.search(produtoVenda));*/
		
		
	/*	for(int i = 0; i < produtos_Vendas.size(); i++) {
			produtoVenda = produtos_Vendas.get(i);
    System.out.println("");
    System.out.print(produtoVenda.getId() + " | ");
    System.out.print(produtoVenda.getCodeProduto() + " | ");
    System.out.print(produtoVenda.getCodeVenda() + " | ");
    System.out.print(produtoVenda.getQuantidade() + " | ");
		}*/
   
		launch(args);
	}
}