package mercado;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    
    private Conexao conexao = new Conexao();
    
    public ClienteDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public boolean inserir(Cliente cliente, Endereco endereco, Contato contato) throws SQLException{
        
        ContatoDAO daocontato = new ContatoDAO();
        EnderecoDAO daoendereco = new EnderecoDAO();
        
        ResultSet rc = daocontato.inserir(contato);
        ResultSet re = daoendereco.inserir(endereco);
        rc.next();
        
        int contato_id = rc.getInt("id");
        int endereco_id = re.getInt("id");
        
        System.out.println(endereco_id);
        
        //criar SQL com variáveis
        String sql = "insert into clientes(nome, cpf, dt_nasc, endereco_id, contato_id) values('"+cliente.getNome()+"','"+
                cliente.getCpf()+"','"+cliente.getNascimento()+"','"+endereco_id+"','"+contato_id+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizarNome(int id, String nome){
        //criar SQL com variáveis
        String sql = "update cliente set nome = '"+nome+"' where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizarCpf(int id, String cpf){
        //criar SQL com variáveis
        String sql = "update cliente set cpf = '"+cpf+"' where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean apagar(int id){
        //criar SQL com variáveis
        String sql = "delete from cliente where id = '"+id+"';";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
}
