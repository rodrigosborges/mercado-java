
package mercado;

import java.sql.ResultSet;
import conexao.Conexao;

public class CategoriaDAO {
    
    private Conexao conexao = new Conexao();
  
    public CategoriaDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
     public ResultSet all(){
        //criar SQL com variáveis
        String sql = "select * from categorias;";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
}
