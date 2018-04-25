package quiosque;

import conexao.Conexao;

public class ClienteDAO {
    
    private Conexao conexao = new Conexao();
    
    public ClienteDAO(){
        conexao = new Conexao();
        conexao.configurar();
    }
    
    public boolean inserir(String nome, String cpf){
        //criar SQL com variáveis
        String sql = "insert into cliente(nome, cpf) values('"+nome+"','"+cpf+"');";
        
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
