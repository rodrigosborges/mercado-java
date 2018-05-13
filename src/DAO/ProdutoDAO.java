
package DAO;

import conexao.Conexao;
import java.sql.ResultSet;

public class ProdutoDAO {
    
    private Conexao conexao = new Conexao();
  
    public ProdutoDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public boolean inserir(String nome, String marca, int categoria_id, double preco, int fornecedor_id){
        //criar SQL com variáveis
        String sql = "insert into produtos(nome, marca, categoria, preco) values('"+nome+"','"+marca+"', '"+categoria_id+"','"+preco+"','"+fornecedor_id+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizarNome(int id, String nome){
        //criar SQL com variáveis
        String sql = "update produtos set nome = '"+nome+"' where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizarMarca(int id, String marca){
        //criar SQL com variáveis
        String sql = "update produtos set marca = '"+marca+"' where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizarCategoria(int id, int categoria_id){
        //criar SQL com variáveis
        String sql = "update produtos set categoria_id'"+categoria_id+"'where id = '"+id+"';";
        
        //Conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
        
    }
    
    public boolean atualizarPreco(int id, double preco){
     //criar SQL com variáveis
     String sql = "update produtos set preco'"+preco+"' where id = '"+id+"';";
     
     //Conectar com o BD
     conexao.conectar();
     
     //enviar SQL para o BD
     boolean b = conexao.executarComandosSQL(sql);
     
     //retornar mensagem de erro ou sucesso
     return b;
        
    }
    
    public boolean apagar(int id){
        //criar SQL com variáveis
        String sql = "delete from produtos where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public ResultSet all(){
        //criar SQL com variáveis
        String sql = "select * from produtos;";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
   
    
    
    
}


