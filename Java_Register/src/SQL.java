import java.sql.*;
import java.util.ArrayList;
public class SQL {
    String url = "jdbc:mysql://lead-principle.gl.at.ply.gg:29339/uzytkownicy";
    String username = "root";
    String password = "";
    Connection connection;

    SQL(){
        System.out.println("Connecting database ...");
        try{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public String[][] SELECT(String query) throws SQLException {
            String[][] rekordy = new String[20][20];
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            for (int i = 0; resultSet.next(); i++) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("nazwa");
                String haslo = resultSet.getString("haslo");

                //System.out.println("ID: " + id + ", Name: " + name + " Haslo: " + haslo);
                rekordy[i][0] = id;
                rekordy[i][1] = name;
                rekordy[i][2] = haslo;
            }

            return rekordy;
    }

     //QUERY moze dodawac, usuwac i update !!   AUTOR: Maciek Kubis
    public void QUERY(String query) throws SQLException {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
    }
}
