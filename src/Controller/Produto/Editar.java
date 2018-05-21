
package Controller.Produto;

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

public class Editar implements Initializable {
     
    @FXML private TextField nome;
    @FXML private TextField marca;
    @FXML private TextField validade;
    @FXML private TextField preco;
    @FXML private ChoiceBox select;
    @FXML private AnchorPane container;
    
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
    
    private void editar(ActionEvent event) throws IOException, SQLException {
        if(select.getSelectionModel().getSelectedIndex() > 0){
            ProdutoDAO c = new ProdutoDAO();
            ResultSet rc = c.get(select.getSelectionModel().getSelectedIndex());
            rc.next();
            nome.setText(rc.getString("nome"));
            marca.setText(rc.getString("marca"));
            validade.setText(rc.getString("validade"));
            preco.setText(rc.getString("preco"));
            
            container.setVisible(true);
        }else{
            container.setVisible(false);
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        Produtos produto = new Produtos(nome.getText(), marca.getText(), validade.getText(), preco.getText());
     
        ProdutoDAO dao = new ProdutoDAO();
        
        if(dao.atualizar(select.getSelectionModel().getSelectedIndex(),produto)){
            Stage stage; 
            Parent root;
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
            root = FXMLLoader.load(getClass().getResource("/View/Produto/Index.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();       
        }else{
            
        }
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
                selectItems.add(rc.getInt("id"),rc.getString("nome")+" - "+rc.getString("cpf"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Produto.Editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
