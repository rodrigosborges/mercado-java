package Controller.Fornecedor;

import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import Model.Fornecedor;
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

/**
 * FXML Controller class
 *
 * @author RODRIGO
 */
public class Editar implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private AnchorPane container;    
    @FXML private ChoiceBox select;
    @FXML private TextField nome;
      
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
    private void editar(ActionEvent event) throws SQLException{
        if(select.getSelectionModel().getSelectedIndex() > 0){
            FornecedorDAO c = new FornecedorDAO();
            ResultSet rc = c.get(select.getSelectionModel().getSelectedIndex());
            rc.next();
            nome.setText(rc.getString("nome"));
            container.setVisible(true);
        }else{
            container.setVisible(false);
        }
    }
    
    @FXML
    public void salvar(ActionEvent event) throws SQLException, IOException{
        Fornecedor f = new Fornecedor(nome.getText());
        FornecedorDAO c = new FornecedorDAO();
        c.atualizar(f, select.getSelectionModel().getSelectedIndex());
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/View/Fornecedor/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        container.setVisible(false);
        ObservableList<String> selectItems = select.getItems();
        selectItems.add(0, "Selecione um fornecedor");
        select.setValue("Selecione um fornecedor");
        FornecedorDAO c = new FornecedorDAO();
        ResultSet rc = c.all();
        try {
            while(rc.next()){
                selectItems.add(rc.getInt("id"),rc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Fornecedor.Editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }      
    
}
