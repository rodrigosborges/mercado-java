
package Controller.Produto;

import Model.Produtos;
import DAO.ProdutoDAO;
import DAO.FornecedorDAO;
import DAO.CategoriaDAO;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Cadastro implements Initializable {
  
    @FXML private TextField nome;
    @FXML private TextField marca;
    @FXML private TextField validade;
    @FXML private TextField preco;

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        
        Produtos produto = new Produtos(nome.getText(), marca.getText(), validade.getText(), preco.getText());
        
        ProdutoDAO dao = new ProdutoDAO();
        
        if(dao.inserir(produto)){
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        
//        ObservableList<String> categoriaItems = categorias.getItems();
//        categoriaItems.add(0, "Selecione uma opção");
//        categorias.setValue("Selecione uma opção");
//        CategoriaDAO c = new CategoriaDAO();
//        ResultSet rc = c.all();
//        try {
//            while(rc.next()){
//                categoriaItems.add(rc.getString("nome"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        ObservableList<String> fornecedorItems = fornecedores.getItems();
//        fornecedorItems.add(0, "Selecione uma opção");
//        fornecedores.setValue("Selecione uma opção");
//        FornecedorDAO f = new FornecedorDAO();
//        ResultSet rf = f.all();
//        try {
//            while(rf.next()){
//                fornecedorItems.add(rf.getString("nome"));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    
}
