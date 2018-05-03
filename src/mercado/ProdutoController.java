
package mercado;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class ProdutoController implements Initializable {
  
    
    @FXML private TextField nome;
    @FXML private TextField marca;
    @FXML private TextField preco;
    @FXML private ListView<String> categorias;
    @FXML private ListView<String> fornecedores;
    
   
    private void handleButtonAction(ActionEvent event){
       Produtos produto = new Produtos();
        
        produto.setNome(nome.getText());
        produto.setMarca(marca.getText());
        produto.setPreco(Double.parseDouble(preco.getText()));
//        produto.setCategoria_id(Integer.parseInt(categorias.getText()));
//        produto.setFornecedor_id(Integer.parseInt(fornecedor_id.getText()));
        ProdutoDAO dao = new ProdutoDAO();
   
        boolean b = dao.inserir(produto.getNome(), produto.getMarca(), 1, produto.getPreco(), 1);
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ObservableList<String> categoriaItems = categorias.getItems();
        //categoriaItems.add(0, "Selecione uma opção: ");
        
        
        //ObservableList<String> fornecedorItems = fornecedores.getItems();
        //fornecedorItems.add(0, "Selecione uma opção: ");
    }    
    
}
