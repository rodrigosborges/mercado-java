
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
        String sql = "insert into produtos(nome, marca, preco, fornecedor_id, categoria_id) values('"+produtos.getNome()+"','"+produtos.getMarca()+"','"+produtos.getPreco()+"','"+produtos.getFornecedores()+"','"+produtos.getCategorias()+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizar(int id, Produtos produtos) throws SQLException{

        //criar SQL com variáveis
        String sql = "update produtos set nome = '"+produtos.getNome()+"', marca ='"+produtos.getMarca()+"',preco='"+produtos.getPreco()+"',fornecedor_id='"+produtos.getFornecedores()+"',categoria_id='"+produtos.getCategorias()+"' WHERE id = '"+id+"';";
        
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
        String sql = "SELECT produtos.*, fornecedores.nome AS f_nome, categorias.nome as c_nome FROM mercado.produtos JOIN "
                + "categorias ON categorias.id = produtos.categoria_id JOIN fornecedores ON fornecedores.id = produtos.fornecedor_id WHERE produtos.id ="+id+";";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;        
    }
}


