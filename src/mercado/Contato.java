package mercado;

public class Contato {
   
    private int id;
    private String fixo;
    private String celular;
    private String email;

    public Contato(String fixo, String celular, String email) {
        this.fixo = fixo;
        this.celular = celular;
        this.email = email;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
