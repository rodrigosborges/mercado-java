/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Fornecedor;

import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;
import Model.Fornecedor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RODRIGO
 */
public class Cadastro implements Initializable {
    
    @FXML private TextField nome;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        Fornecedor fornecedor = new Fornecedor(nome.getText());
        FornecedorDAO dao = new FornecedorDAO();
        if(dao.inserir(fornecedor)){
            Stage stage; 
            Parent root;
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
            root = FXMLLoader.load(getClass().getResource("/View/Fornecedor/Index.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();       
        }else{
            
        }
    }   
    
    
    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/View/Fornecedor/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
