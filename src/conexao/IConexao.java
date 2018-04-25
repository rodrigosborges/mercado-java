package conexao;

public interface IConexao {
    public String MYSQL = "mysql";
    public String CLASSNAME_MYSQL = "com.mysql.jdbc.Driver";
    public String PORT_MYSQL = "3306";
    public void configurar();
}
