
package Controller.Produto;

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

public class Editar implements Initializable {
     
    @FXML private TextField nome;
    @FXML private TextField marca;
    @FXML private TextField preco;
    @FXML private ChoiceBox select;
    @FXML private ChoiceBox fornecedores;
    @FXML private ChoiceBox categorias;    
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
    
    @FXML
    private void editar(ActionEvent event) throws IOException, SQLException {
        if(select.getSelectionModel().getSelectedIndex() > 0){
            ProdutoDAO c = new ProdutoDAO();
            ResultSet rc = c.get(Integer.parseInt(select.getSelectionModel().getSelectedItem().toString().split("-")[0]));
            rc.next();
            nome.setText(rc.getString("nome"));
            marca.setText(rc.getString("marca"));
            preco.setText(rc.getString("preco"));
            fornecedores.getSelectionModel().select(rc.getInt("fornecedor_id"));
            categorias.getSelectionModel().select(rc.getInt("categoria_id"));
            container.setVisible(true);
        }else{
            container.setVisible(false);
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        Produtos produto = new Produtos(nome.getText(), marca.getText(), preco.getText(), fornecedores.getSelectionModel().getSelectedIndex(), categorias.getSelectionModel().getSelectedIndex());
     
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
                
        ObservableList<String> categoriaItems = categorias.getItems();
        categoriaItems.add(0, "Selecione uma opção");
        categorias.setValue("Selecione uma opção");
        CategoriaDAO c = new CategoriaDAO();
        ResultSet rc = c.all();
        try {
            while(rc.next()){
                categoriaItems.add(rc.getInt("id")+"- "+rc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ObservableList<String> fornecedorItems = fornecedores.getItems();
        fornecedorItems.add(0, "Selecione uma opção");
        fornecedores.setValue("Selecione uma opção");
        FornecedorDAO f = new FornecedorDAO();
        ResultSet rf = f.all();
        try {
            while(rf.next()){
                fornecedorItems.add(rf.getInt("id")+"- "+rf.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        ObservableList<String> selectItems = select.getItems();
        selectItems.add(0, "Selecione um produto");
        select.setValue("Selecione um produto");
        ProdutoDAO p = new ProdutoDAO();
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
