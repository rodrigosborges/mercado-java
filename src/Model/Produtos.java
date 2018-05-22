
package Model;

public class Produtos {
    
    private int id;
    private String nome;
    private String marca;
    private String preco;
    private int fornecedores;
    private int categorias;
    
    
    public Produtos(String nome, String marca, String preco, int fornecedores, int categorias){
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.fornecedores = fornecedores;
        this.categorias = categorias;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(int fornecedores) {
        this.fornecedores = fornecedores;
    }

    public int getCategorias() {
        return categorias;
    }

    public void setCategorias(int categorias) {
        this.categorias = categorias;
    }
    
}
