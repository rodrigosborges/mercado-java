package conexao;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class ConexaoAbstract implements IConexao{
    protected String pwd= "";
    protected String usr= "";
    protected String ip= "";
    protected String base= "";
    protected String dbms= "";
    protected String className= "";
    protected String port= "";    
    protected Connection con= null;
    protected boolean status= false;
    
    
 //-------------------- SET PARAMETROS -----------------------------------------    
    public void setConexao (String banco, String base, String ip){
        this.dbms= banco;
        this.base= base;
        this.ip= ip;
    }
    
    public void setLogin(String usuario, String senha){
        this.usr= usuario;
        this.pwd = senha;
    }

    
//---------------- GERENCIAR CONEXAO -------------------------------------------
    public void desconectar() {
        try {
            con.close();
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
        this.status = false;
    }


    public void conectar() {
        String conexao = "";
        if (con != null) {            
            this.status = true;
            return;
        }
        try {
            Class.forName(className).newInstance();
        } catch (ClassNotFoundException 
                      | InstantiationException 
                      | IllegalAccessException e) {
            this.status = false;
            out.println(e.getMessage());            
        }
        try {
            //String url      = "jdbc:postgresql://localhost:5432/jaime";
            conexao = "jdbc:%s://%s:%s/%s?user=%s&password=%s";
            conexao = String.format(conexao, dbms,  ip, port, base, usr, pwd);
            con = DriverManager.getConnection(conexao, usr, pwd);
            con.setAutoCommit(true);
        } catch (SQLException e) {
            this.status = false;
            out.println(e.getMessage());
        }
        this.status = true;
    }


    public boolean getStatus() {
        return status;
    }

//---------------------- COMANDOS SQL ------------------------------------------
    public boolean executarComandosSQL(String sql) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            out.println(e.getMessage());
            return false;
        }
    }
    
    public ResultSet executarRetornarID(String sql) throws SQLException {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID() AS id;");
            return rs;
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return rs;
    }    

    public ResultSet pegarResultadoSQL(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return rs;
    }
    

    
}