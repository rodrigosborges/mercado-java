package DAO;

import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;

public class ClienteDAO {
    
    private Conexao conexao = new Conexao();
    
    public ClienteDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public ResultSet all(){
        //criar SQL com variáveis
        String sql = "select * from clientes;";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean inserir(Cliente cliente, Endereco endereco, Contato contato) throws SQLException{
        
        ContatoDAO daocontato = new ContatoDAO();
        EnderecoDAO daoendereco = new EnderecoDAO();
        
        ResultSet rc = daocontato.inserir(contato);
        ResultSet re = daoendereco.inserir(endereco);
        rc.next();
        
        int contato_id = rc.getInt("id");
        int endereco_id = re.getInt("id");
        
        
        //criar SQL com variáveis
        String sql = "insert into clientes(nome, cpf, dt_nasc, endereco_id, contato_id) values('"+cliente.getNome()+"','"+
                cliente.getCpf()+"','"+cliente.getNascimento().toString()+"','"+endereco_id+"','"+contato_id+"');";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        if(!b){
            daocontato.apagar(contato_id);
            daoendereco.apagar(endereco_id);
        }
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public boolean atualizar(int id, Cliente cliente, Endereco endereco, Contato contato) throws SQLException{
        
        ContatoDAO daocontato = new ContatoDAO();
        EnderecoDAO daoendereco = new EnderecoDAO();
        
        ResultSet rc = daocontato.atualizar(cliente.getContato_id(),contato);
        ResultSet re = daoendereco.atualizar(cliente.getEndereco_id(),endereco);
        
        //criar SQL com variáveis
        String sql = "update clientes set nome = '"+cliente.getNome()+"',cpf = '"+cliente.getCpf()+"',dt_nasc = '"+cliente.getNascimento().toString()+
                "' WHERE id = "+id+";";
        
        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
    public ResultSet get(int id){
        //criar SQL com variáveis
        String sql = "SELECT clientes.cpf, clientes.nome, clientes.dt_nasc,clientes.contato_id, clientes.endereco_id, contatos.fixo, contatos.celular, contatos.email, enderecos.rua, "
                + "enderecos.bairro, enderecos.numero, enderecos.cep, enderecos.cidade, enderecos.uf FROM mercado.clientes "
                + "JOIN contatos ON clientes.contato_id = contatos.id JOIN enderecos ON clientes.endereco_id = enderecos.id WHERE clientes.id ="+id+";";
        
        //conectar com o BD
        conexao.conectar();
        
        //enviar SQL para o BD
        ResultSet b = conexao.pegarResultadoSQL(sql);
        
        //retornar mensagem de erro ou sucesso
        return b;        
    }
    
    public boolean apagar(int id) throws SQLException{
        //criar SQL com variáveis
        String sql = "delete from clientes where id = '"+id+"';";
        
        ResultSet rs = this.get(id);
        rs.next();
        ContatoDAO ct = new ContatoDAO();
        EnderecoDAO ed = new EnderecoDAO();
        

        //conectar com BD
        conexao.conectar();
        
        //enviar SQL para o BD
        boolean b = conexao.executarComandosSQL(sql);
        
        ct.apagar(rs.getInt("contato_id"));
        ed.apagar(rs.getInt("endereco_id"));
        
        //retornar mensagem de erro ou sucesso
        return b;
    }
    
}
