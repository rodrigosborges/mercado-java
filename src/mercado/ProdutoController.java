
package mercado;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;


public class ProdutoController implements Initializable {
  
    @FXML private TextField nome;
    @FXML private TextField marca;
    @FXML private TextField preco;
    @FXML private ChoiceBox categorias;
    @FXML private ChoiceBox fornecedores;
    
    private void handleButtonAction(ActionEvent event){
       Produtos produto = new Produtos();
        
        produto.setNome(nome.getText());
        produto.setMarca(marca.getText());
        produto.setPreco(Double.parseDouble(preco.getText()));
        ProdutoDAO dao = new ProdutoDAO();
   
        boolean b = dao.inserir(produto.getNome(), produto.getMarca(), 1, produto.getPreco(), 1);
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> categoriaItems = categorias.getItems();
        categoriaItems.add(0, "Selecione uma opção");
        categorias.setValue("Selecione uma opção");
        CategoriaDAO c = new CategoriaDAO();
        ResultSet rc = c.all();
        try {
            while(rc.next()){
                categoriaItems.add(rc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<String> fornecedorItems = fornecedores.getItems();
        fornecedorItems.add(0, "Selecione uma opção");
        fornecedores.setValue("Selecione uma opção");
        FornecedorDAO f = new FornecedorDAO();
        ResultSet rf = f.all();
        try {
            while(rf.next()){
                fornecedorItems.add(rf.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
