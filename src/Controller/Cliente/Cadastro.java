package Controller.Cliente;

import Model.Contato;
import Model.Endereco;
import Model.Cliente;
import DAO.ClienteDAO;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Cadastro implements Initializable {
    
    //dados pessoais
    @FXML private TextField nome;
    @FXML private TextField cpf;
    @FXML private DatePicker nascimento;
    
    //endereco
    @FXML private TextField rua;
    @FXML private TextField numero;
    @FXML private TextField bairro;    
    @FXML private TextField cep;
    @FXML private TextField cidade;
    @FXML private TextField UF;
    
    //contato
    @FXML private TextField fixo;
    @FXML private TextField celular;
    @FXML private TextField email;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        try{
            Cliente cliente = new Cliente(nome.getText(), cpf.getText(), java.sql.Date.valueOf(nascimento.getValue()));
            Endereco endereco = new Endereco(rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(), cidade.getText(), UF.getText(), cep.getText());
            Contato contato = new Contato(fixo.getText(), celular.getText(), email.getText());
            ClienteDAO dao = new ClienteDAO();

            if(dao.inserir(cliente, endereco, contato)){
                Stage stage; 
                Parent root;
                stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
                root = FXMLLoader.load(getClass().getResource("/View/Cliente/Index.fxml"));
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
        root = FXMLLoader.load(getClass().getResource("/View/Cliente/Index.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
