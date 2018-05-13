package Controller.Produto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RODRIGO
 */
public class Index implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    
    @FXML
    private void clientes(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        if(event.getSource() == btn1){      
            root = FXMLLoader.load(getClass().getResource("/View/Produto/Cadastro.fxml"));
        }else if(event.getSource() == btn2){
            root = FXMLLoader.load(getClass().getResource("/View/Produto/Editar.fxml"));
        }else{            
            root = FXMLLoader.load(getClass().getResource("/View/Produto/Deletar.fxml"));            
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/Index/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
