package Controller.Fornecedor;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.FornecedorDAO;
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
        root = FXMLLoader.load(getClass().getResource("/View/Fornecedor/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        
    @FXML
    private void deletar(ActionEvent event) throws IOException {
        FornecedorDAO c = new FornecedorDAO();
        c.apagar(Integer.parseInt(select.getSelectionModel().getSelectedItem().toString().split("-")[0]));        
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/View/Fornecedor/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Index/Sucesso.fxml"));
        Scene cena = new Scene(fxmlLoader.load());
        Stage estagio = new Stage();
        estagio.setTitle("SUCESSO");
        estagio.setScene(cena);
        estagio.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> selectItems = select.getItems();
        selectItems.add(0, "Selecione um fornecedor");
        select.setValue("Selecione um fornecedor");
        FornecedorDAO c = new FornecedorDAO();
        ResultSet rc = c.all();
        try {
            while(rc.next()){
                selectItems.add(rc.getInt("id")+"- "+rc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Fornecedor.Deletar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
