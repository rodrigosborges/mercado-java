package DAO;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Endereco;

public class EnderecoDAO {
    private Conexao conexao = new Conexao();
    
    public EnderecoDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public ResultSet inserir(Endereco endereco) throws SQLException{
        
        
        //criar SQL com variáveis
        String sql = "insert into enderecos(rua, numero, bairro, cidade, uf, cep) values('"+endereco.getRua()+"','"+
                endereco.getNumero()+"','"+endereco.getBairro()+"','"+endereco.getCidade()+"','"+endereco.getUF()+"','"
                +endereco.getCep()+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.executarRetornarID(sql);
        
        b.next();
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public ResultSet atualizar(int id,Endereco endereco) throws SQLException{
        
        
        //criar SQL com variáveis
        String sql = "update enderecos set rua='"+endereco.getRua()+"',numero = '"+endereco.getNumero()+"',bairro = '"+endereco.getBairro()+
                "',cidade = '"+endereco.getCidade()+"',uf = '"+endereco.getUF()+"',cep = '"+endereco.getCep()+"' WHERE id = "+id+";";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.executarRetornarID(sql);
        
        b.next();
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean apagar(int id){
        //criar SQL com variáveis
        String sql = "delete from enderecos where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
}
