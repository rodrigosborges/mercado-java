
package Controller.Fornecedor;

import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;
import Model.Fornecedor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RODRIGO
 */
public class Cadastro implements Initializable {
    
    @FXML private TextField nome;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        try{
            Fornecedor fornecedor = new Fornecedor(nome.getText());
            FornecedorDAO dao = new FornecedorDAO();
            if(!fornecedor.getNome().equals("") && dao.inserir(fornecedor)){
                Stage stage; 
                Parent root;
                stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
                root = FXMLLoader.load(getClass().getResource("/View/Fornecedor/Index.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();       
            }else{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Index/Error.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("ERRO");
                stage.setScene(scene);
                stage.show();                
            }
        }catch(Exception e){         
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Index/Error.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("ERRO");
            stage.setScene(scene);
            stage.show();
        }
    }   
    
    
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
