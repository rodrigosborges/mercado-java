package mercado;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ClienteController implements Initializable {
    
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
