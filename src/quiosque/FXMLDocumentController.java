/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiosque;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author a1700782
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private TextField nome;
    @FXML private TextField cpf;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        Cliente cliente = new Cliente();
        
        cliente.setNome(nome.getText());
        cliente.setCpf(cpf.getText());
        
        ClienteDAO dao = new ClienteDAO();
        
        boolean b = dao.inserir(cliente.getNome(), cliente.getCpf());
    }   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
