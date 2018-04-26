package mercado;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;

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

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        
        cliente.setNome("Gabriel");
        cliente.setCpf("1234");
        
        ClienteDAO dao = new ClienteDAO();
        
        boolean b = dao.inserir(cliente.getNome(), cliente.getCpf());
        
        if(b){
            System.out.println("Inserido com sucesso!");
        }
    }
    
}
