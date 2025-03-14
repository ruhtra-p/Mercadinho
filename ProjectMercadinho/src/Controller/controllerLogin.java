package Controller;

import java.io.IOException;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import Util.Alerts;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class controllerLogin {
    @FXML
    private Button btLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtUser;
     
    public static Funcionario funcionario =  new Funcionario();

    @FXML
    void actionLogin(ActionEvent event)	throws  IOException {
    	FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); 
    	funcionario =  funcionarioDAO.autenticarUser(txtUser.getText(), txtSenha.getText());
    		
    	if(funcionario.getCpf() == null) {
    		Alerts.showAlert("Erro!", "Erro de Login", "Verifique se as informações estão corretas!", AlertType.ERROR);    	
    	}
    	else if(txtUser.getText() == "" || txtSenha.getText() == "") {
    		Alerts.showAlert("Erro!", "Erro de Login", "Preencha as informações de login e senha para acessar!", AlertType.ERROR);
    	}
    	else if(funcionario.getCpf().equals(txtUser.getText()) && funcionario.getSenha().equals(txtSenha.getText())) {
    		Alerts.showAlert("Login bem sucedido", "Seja Bem-Vindo "+ funcionario.getNome(), "Agora que acessou, vá trabalhar!", AlertType.INFORMATION);
    		txtUser.setText("");
    		txtSenha.setText("");
    		Main.TelaHome();		
    	}  	
    }
}