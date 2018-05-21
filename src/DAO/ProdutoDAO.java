
package DAO;


import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Produtos;


public class ProdutoDAO {
    
    private Conexao conexao = new Conexao();
  
    public ProdutoDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public ResultSet all(){
        //criar SQL com variáveis
        String sql = "select * from produtos;";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //restornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean inserir(Produtos produtos) throws SQLException{
        
        //criar SQL com variáveis
        String sql = "insert into produtos(nome, marca, validade, preco) values('"+produtos.getNome()+"','"+produtos.getMarca()+"','"+produtos.getValidade()+"','"+produtos.getPreco()+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizar(int id, Produtos produtos) throws SQLException{

        //criar SQL com variáveis
        String sql = "update produtos set nome = '"+produtos.getNome()+"', marca ='"+produtos.getMarca()+"'validade='"+produtos.getValidade()+"'preco='"+produtos.getPreco()+"' WHERE id = '"+id+"';";
        
        //conectar com BD
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
    
    public ResultSet get(int id){
        //criar SQL com variáveis
        String sql = "SELECT produtos.nome, produtos.marca, produtos.validade, produtos.preco FROM mercado.produtos WHERE produtos.id ="+id+";";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;        
    }
}


