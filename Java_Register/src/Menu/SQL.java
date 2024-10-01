package Menu;

import java.sql.*;
import java.util.ArrayList;
public class SQL {
    String url = "jdbc:mysql://lead-principle.gl.at.ply.gg:29339/uzytkownicy";
    String username = "root";
    String password = "";
    Connection connection;
    private String userId;
    private String userName;
    private String userPassword;
    String[] UserData = new String[3];

    public void connect(){
        System.out.println("Connecting database ...");
        try{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    public void SELECT(String query) throws SQLException {
        if (connection == null || connection.isClosed()) {
            connect(); // Nawiąż połączenie, jeśli nie jest aktywne
        }

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) { // Sprawdzamy, czy są jakieś wyniki
            UserData[0] = resultSet.getString("id");
            UserData[1] = resultSet.getString("nazwa");
            UserData[2] = resultSet.getString("haslo");

            System.out.println("ID: " + UserData[0] + ", Name: " + UserData[1] + ", Haslo: " + UserData[2]);

        } else {
            System.out.println("Brak wyników.");
        }
    }

     //QUERY moze dodawac, usuwac i update !!   AUTOR: Maciek Kubis
    public void QUERY(String query) throws SQLException {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
    }
}
