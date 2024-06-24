// ConnectionDAO.java
package DAO;

import java.sql.*;

public class ConnectionDAO {
    protected Connection con;
    protected PreparedStatement pst;
    protected Statement st;
    protected ResultSet rs;

    String database = "mago_jogo";
    String url = "jdbc:mysql://localhost:3306/" + database;
    String user = "root";
    String password = "DG[Z.FEd1";

    public void connectToDB() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão deu certo!");
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            con = null;
        }
    }
}
