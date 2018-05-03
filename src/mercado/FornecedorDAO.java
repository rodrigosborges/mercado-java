
package mercado;

import conexao.Conexao;
import java.sql.ResultSet;

public class FornecedorDAO {
    
    private Conexao conexao = new Conexao();
  
    public FornecedorDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public ResultSet selecionarFornecedores(int id){
        //criar SQL com variáveis
        String sql = "select from fornecedores where id = '"+id+"';";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
}
