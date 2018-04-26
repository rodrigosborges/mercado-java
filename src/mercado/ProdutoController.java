
package mercado;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ProdutoController implements Initializable {
  
    
    @FXML private TextField nome;
    @FXML private TextField marca;
    @FXML private TextField preco;
    
    private void handleButtonAction(ActionEvent event){
       Produtos produto = new Produtos();
        
        produto.setNome(nome.getText());
        produto.setMarca(marca.getText());
        produto.setPreco(preco.getText());
        
        ClienteDAO dao = new ClienteDAO();
   
        boolean b = dao.inserir(cliente.getNome(), cliente.getCpf());
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
