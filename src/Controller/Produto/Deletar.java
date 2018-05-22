package Controller.Produto;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.ProdutoDAO;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RODRIGO
 */
public class Deletar implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private ChoiceBox select;
    
    
    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/View/Produto/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        
    @FXML
    private void deletar(ActionEvent event) throws IOException {
        ProdutoDAO c = new ProdutoDAO();
        c.apagar(Integer.parseInt(select.getSelectionModel().getSelectedItem().toString().split("-")[0]));        
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/View/Produto/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> selectItems = select.getItems();
        selectItems.add(0, "Selecione um produto");
        select.setValue("Selecione um produto");
        ProdutoDAO c = new ProdutoDAO();
        ResultSet rc = c.all();
        try {
            while(rc.next()){
                selectItems.add(rc.getInt("id")+"- "+rc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Cliente.Deletar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
