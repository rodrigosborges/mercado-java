package Controller;

import Model.Contato;
import Model.Endereco;
import Model.Cliente;
import DAO.ClienteDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ClienteController implements Initializable {
    
    //dados pessoais
    @FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private TextField nascimento;
    
    //endereco
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;    
    @FXML private TextField cep;
    @FXML private TextField cidade;
    @FXML private TextField UF;
    
    //contato
    @FXML private TextField fixo;
    @FXML private TextField celular;
    @FXML private TextField email;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException{
        Cliente cliente = new Cliente(nome.getText(), cpf.getText(), nascimento.getText());
        Endereco endereco = new Endereco(rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(), cidade.getText(), UF.getText(), cep.getText());
        Contato contato = new Contato(fixo.getText(), celular.getText(), email.getText());
        ClienteDAO dao = new ClienteDAO();
        
        if(dao.inserir(cliente, endereco, contato)){
        
        }else{
            
        }
    }   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
