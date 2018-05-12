package Model;

public class Cliente {
    
    private int id;
    private String nome;
    private String cpf;
    private String nascimento;
    private int contato_id;
    private int endereco_id;

    public Cliente(String nome, String cpf, String nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }    

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public int getContato_id() {
        return contato_id;
    }

    public void setContato_id(int contato_id) {
        this.contato_id = contato_id;
    }

    public int getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }
}
