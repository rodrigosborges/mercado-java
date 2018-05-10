package mercado;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
