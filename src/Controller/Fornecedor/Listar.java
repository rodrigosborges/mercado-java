
package Controller.Fornecedor;

import DAO.CategoriaDAO;
import DAO.FornecedorDAO;
import DAO.ProdutoDAO;
import Model.Produtos;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Listar implements Initializable {
     
    @FXML private Label nome;
    @FXML private ChoiceBox select;  
    @FXML private AnchorPane container;
    
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
    
    @FXML
    private void editar(ActionEvent event) throws IOException, SQLException {
        if(select.getSelectionModel().getSelectedIndex() > 0){
            FornecedorDAO c = new FornecedorDAO();
            ResultSet rc = c.get(Integer.parseInt(select.getSelectionModel().getSelectedItem().toString().split("-")[0]));
            rc.next();
            nome.setText(rc.getString("nome"));
            container.setVisible(true);
        }else{
            container.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        ObservableList<String> selectItems = select.getItems();
        selectItems.add("Selecione um fornecedor");
        select.setValue("Selecione um fornecedor");
        FornecedorDAO p = new FornecedorDAO();
        ResultSet pc = p.all();
        try {
            while(pc.next()){
                selectItems.add(pc.getInt("id")+"- "+pc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Produto.Editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
