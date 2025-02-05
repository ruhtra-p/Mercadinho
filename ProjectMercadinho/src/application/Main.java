package application;
	
import java.sql.Connection;
import java.util.ArrayList;

import ConnectionFactory.ConnectionDatabase;
import DAO.ClienteDAO;
import Model.Cliente;
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
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		cliente.setNome("camila");
		clientes.addAll(clienteDAO.search(cliente));
		
		for(int i = 0; i < clientes.size(); i++) {
			cliente = clientes.get(i);
			System.out.println("");
			System.out.print(cliente.getId()+ " | ");
			System.out.print(cliente.getNome()+ " | ");
			System.out.print(cliente.getEmal()+ " | ");
			System.out.print(cliente.getGenero()+ " | ");
			System.out.print(cliente.getTelefone()+ " | ");
		}
		
		
		launch(args);
	}
}