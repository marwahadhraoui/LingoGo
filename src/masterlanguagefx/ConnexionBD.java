/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package masterlanguagefx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */

public class ConnexionBD {

    private final String Host = "localhost";
    private final String port = "5432";
    private final String DB = "postgres";
    private final String User = "postgres";
    private final String Password = "123";

    public Connection getConnexion() {
        Connection connexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + Host + ":" + port + "/" + DB;
            connexion = DriverManager.getConnection(url, User, Password);
            //JOptionPane.showMessageDialog(null, "connexion reussite");
            PreparedStatement stmt = connexion.prepareStatement("select * from public.user");
            ResultSet rs = stmt.executeQuery();
         
            while (rs.next()) {
                // Example: Fetching columns from the result set
                int id = rs.getInt("id"); // Assuming there's an 'id' column
                String name = rs.getString("name"); // Assuming there's a 'name' column

                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return connexion;
    }
}
