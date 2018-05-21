
package DAO;

import Model.Fornecedor;
import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorDAO {
    
    private Conexao conexao = new Conexao();
  
    public FornecedorDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public boolean inserir(Fornecedor fornecedor) throws SQLException{
        
        //criar SQL com variáveis
        String sql = "insert into fornecedores(nome) values('"+fornecedor.getNome()+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public ResultSet atualizar(Fornecedor fornecedor, int id) throws SQLException{
        
        //criar SQL com variáveis
        String sql = "update fornecedores set nome= '"+fornecedor.getNome()+"' where id = "+id+";";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.executarRetornarID(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean apagar(int id){
        //criar SQL com variáveis
        String sql = "delete from fornecedores where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public ResultSet all(){
        //criar SQL com variáveis
        String sql = "select * from fornecedores;";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public ResultSet get(int id){
        //criar SQL com variáveis
        String sql = "select * from fornecedores where id ="+id;
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;        
    }
}
