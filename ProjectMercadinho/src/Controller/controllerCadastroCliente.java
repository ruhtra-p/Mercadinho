package Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.ClienteDAO;
import Model.Cliente;
import Util.Alerts;
import Util.cpfValidator;
import Util.emailValidator;
import Util.phoneValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controllerCadastroCliente implements Initializable{

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField txtCPF;

    @FXML
    private DatePicker dpDataNasc;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private ChoiceBox<String> choiceGenero;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;

    @FXML
    void actionCadastrar(ActionEvent event) {
    	Cliente cliente = new Cliente();
    	ClienteDAO clienteDAO = new ClienteDAO();
    	
    	if(txtCPF.getText() == "") {
    		
    	}else if(txtEmail.getText() == "" || cpfValidator.validarCPF(txtCPF.getText()) == false) {
    		Alerts.showAlert("Erro!", "CPF inválido!", "Verifique o cpf e tente novamente", AlertType.ERROR);
    	}else if(txtEmail.getText() != "" && emailValidator.validarEmail(txtEmail.getText()) == false) {
    		Alerts.showAlert("Erro!", "E-mail inválido!", "Verifique o e-mail e tente novamente", AlertType.ERROR);
    	}else if(phoneValidator.validarTelefone(txtTelefone.getText()) == false) {
    		Alerts.showAlert("Erro!", "Telefone inválido!", "Verifique o telefone e tente novamente", AlertType.ERROR);
    	}else if(txtNome.getText() == "" || choiceGenero.getValue() == null 
    			|| dpDataNasc.getValue() == null || txtEndereco.getText() == "") {
    		Alerts.showAlert("Erro!", "Informações incompletas!", "Verifique se preencheu todas as informações"
    				+ " e tente novamente!", AlertType.ERROR);
    	}else {	
    		cliente.setNome(txtNome.getText());
    		cliente.setCpf(txtCPF.getText());
    		cliente.setEmal(txtEmail.getText());
    		cliente.setEndereco(txtEndereco.getText());
    		cliente.setTelefone(txtTelefone.getText());
    		cliente.setDataNasc(dpDataNasc.getValue().toString());
    		cliente.setGenero(choiceGenero.getValue());	  		
    		
    		
    		if(controllerCliente.clienteEditar == null) {
    			clienteDAO.create(cliente);
    			Alerts.showAlert("Sucesso", "Cliente cadastrado!", "O cliente foi cadastrado com sucesso!", AlertType.INFORMATION);
    	    	Stage stage = (Stage) btCancelar.getScene().getWindow();
    	    	stage.close();
    	    	
    		}else if(controllerCliente.clienteEditar != null) {
    			clienteDAO.update(cliente);
    			Alerts.showAlert("Sucesso", "Cliente editado!", "O cliente foi editado com sucesso!", AlertType.INFORMATION);
    	    	Stage stage = (Stage) btCancelar.getScene().getWindow();
    	    	stage.close(); 	
    		}
    	}
    }
    
    @FXML
    void actionCancelar(ActionEvent event) {
    	txtNome.setText("");
    	txtCPF.setText("");
    	txtEmail.setText("");
    	txtEndereco.setText("");
    	txtTelefone.setText("");
    	dpDataNasc.setValue(null);
    	choiceGenero.setValue(null);
    	
    	
    	Stage stage = (Stage) btCancelar.getScene().getWindow();
    	stage.close(); 	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		choiceGenero.getItems().add("Maculino");
		choiceGenero.getItems().add("Feminino");

		
		if(controllerCliente.clienteEditar != null) {
			btCadastrar.setText("SALVAR");
			Cliente clienteEditar = new Cliente();
			clienteEditar = controllerCliente.clienteEditar;
			txtCPF.setText(clienteEditar.getCpf());
			txtCPF.setEditable(false);
			txtNome.setText(clienteEditar.getNome());
			txtEndereco.setText(clienteEditar.getEndereco());
			txtTelefone.setText(clienteEditar.getTelefone());
			txtEmail.setText(clienteEditar.getEmal());
			choiceGenero.setValue(clienteEditar.getGenero());
			LocalDate dateNasc = LocalDate.parse(clienteEditar.getDataNasc());
			dpDataNasc.setValue(dateNasc);
		}
		
		
		}
}
