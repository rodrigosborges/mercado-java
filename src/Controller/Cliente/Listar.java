
package Controller.Cliente;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
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
     
    @FXML private Label id;
    @FXML private Label nome;
    @FXML private Label cpf;
    @FXML private Label dt_nasc;
    @FXML private Label email;
    @FXML private Label telefone;
    @FXML private Label endereco;
    @FXML private ChoiceBox select;
    @FXML private AnchorPane container;
    
    @FXML
    private void voltar(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
        root = FXMLLoader.load(getClass().getResource("/View/Cliente/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void editar(ActionEvent event) throws IOException, SQLException {
        if(select.getSelectionModel().getSelectedIndex() > 0){
            ClienteDAO c = new ClienteDAO();
            ResultSet rc = c.get(Integer.parseInt(select.getSelectionModel().getSelectedItem().toString().split("-")[0]));
            rc.next();
            nome.setText(rc.getString("nome"));
            cpf.setText(rc.getString("cpf"));
            dt_nasc.setText(rc.getString("dt_nasc"));
            email.setText(rc.getString("email"));
            telefone.setText(rc.getString("fixo")+" "+rc.getString("celular"));
            endereco.setText(rc.getString("rua")+", nº "+rc.getString("numero")+", "+rc.getString("bairro")+", "+rc.getString("cidade")+", "+rc.getString("uf")+" "+rc.getString("cep"));
            container.setVisible(true);
        }else{
            container.setVisible(false);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        ObservableList<String> selectItems = select.getItems();
        selectItems.add(0, "Selecione um cliente");
        select.setValue("Selecione um cliente");
        ClienteDAO p = new ClienteDAO();
        ResultSet pc = p.all();
        try {
            while(pc.next()){
                selectItems.add(pc.getInt("id")+"- "+pc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Cliente.Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
