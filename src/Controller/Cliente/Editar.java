package Controller.Cliente;

import DAO.ClienteDAO;
import DAO.FornecedorDAO;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
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
    
    @FXML private ChoiceBox select;
    @FXML private AnchorPane container;
    
    private int contato_id;
    private int endereco_id;
    
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
            this.contato_id = rc.getInt("contato_id");
            this.endereco_id = rc.getInt("endereco_id");
            nome.setText(rc.getString("nome"));
            cpf.setText(rc.getString("cpf"));
            nascimento.setValue(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rc.getDate("dt_nasc"))));
            rua.setText(rc.getString("rua"));
            numero.setText(rc.getString("numero"));
            bairro.setText(rc.getString("bairro"));
            cep.setText(rc.getString("cep"));
            cidade.setText(rc.getString("cidade"));
            UF.setText(rc.getString("UF"));
            fixo.setText(rc.getString("fixo"));
            celular.setText(rc.getString("celular"));
            email.setText(rc.getString("email"));
            
            container.setVisible(true);
        }else{
            container.setVisible(false);
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, IOException{
        try{
            Cliente cliente = new Cliente(nome.getText(), cpf.getText(), java.sql.Date.valueOf(nascimento.getValue()));
            cliente.setContato_id(this.contato_id);
            cliente.setEndereco_id(this.endereco_id);
            Endereco endereco = new Endereco(rua.getText(), Integer.parseInt(numero.getText()), bairro.getText(), cidade.getText(), UF.getText(), cep.getText());
            Contato contato = new Contato(fixo.getText(), celular.getText(), email.getText());
            ClienteDAO dao = new ClienteDAO();

            if(dao.atualizar(select.getSelectionModel().getSelectedIndex(),cliente, endereco, contato)){
                Stage stage; 
                Parent root;
                stage=(Stage) ((Node)event.getSource()).getScene().getWindow();   
                root = FXMLLoader.load(getClass().getResource("/View/Cliente/Index.fxml"));
                Scene scene = new Scene(root);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> selectItems = select.getItems();
        selectItems.add(0, "Selecione um cliente");
        select.setValue("Selecione um cliente");
        ClienteDAO c = new ClienteDAO();
        ResultSet rc = c.all();
        try {
            while(rc.next()){
                selectItems.add(rc.getInt("id")+"- "+rc.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.Cliente.Editar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }      
    
}
