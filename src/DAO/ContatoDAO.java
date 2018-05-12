package DAO;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Contato;

public class ContatoDAO {
    private Conexao conexao = new Conexao();
    
    public ContatoDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public ResultSet inserir(Contato contato) throws SQLException{
        
        
        //criar SQL com variáveis
        String sql = "insert into contatos(fixo, celular, email) values('"+contato.getFixo()+"','"+
                contato.getCelular()+"','"+contato.getEmail()+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.executarRetornarID(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
}
