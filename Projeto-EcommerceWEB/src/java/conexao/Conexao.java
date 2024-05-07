    package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/javaweb_project?useSSL=false";
    private static final String user = "root";
    private static final String senha = "";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public static Connection conectar(){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
