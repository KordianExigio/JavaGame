import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements ActionListener {
    JPanel panel;
    JFrame frame;
    JTextField poleNazwaUzytkownika;
    SQL sql = new SQL();
    JPasswordField poleHaslo;
    JButton submitBtn;
    JLabel labelNazwa;
    JLabel labelHaslo;
    JLabel labelKomunikat;

    public Login() {
        // Tworzenie JFrame
        frame = new JFrame("Login Panel");
        panel = new JPanel();


        panel.setLayout(null);


        poleNazwaUzytkownika = new JTextField();
        poleNazwaUzytkownika.setEditable(true);
        poleNazwaUzytkownika.setBounds(150, 20, 150, 25);

        poleHaslo = new JPasswordField ();
        poleHaslo.setEditable(true);
        poleHaslo.setBounds(150, 60, 150, 25);

        labelNazwa = new JLabel("Nazwa:");
        labelNazwa.setBounds(50, 20, 100, 25);

        labelHaslo = new JLabel("Haslo:");
        labelHaslo.setBounds(50, 60, 100, 25);


        submitBtn = new JButton("Zaloguj się");
        submitBtn.setBounds(100, 100, 150, 30);
        submitBtn.addActionListener(this);

        labelKomunikat = new JLabel("");
        labelKomunikat.setBounds(50, 180, 250, 25);


        panel.add(labelNazwa);
        panel.add(poleNazwaUzytkownika);
        panel.add(labelHaslo);
        panel.add(poleHaslo);
        panel.add(submitBtn);
        panel.add(labelKomunikat);


        frame.add(panel);
        frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitBtn){
            String nazwa = poleNazwaUzytkownika.getText();
            String haslo = poleHaslo.getText();
            String[][] rekord;


            String query = "SELECT nazwa, haslo FROM uzytkownicy WHERE nazwa = " + nazwa + " AND haslo = " + haslo;
//            try {
//                sql.QUERY(query);
//                System.out.println("Dodano do bazy");
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }


            if(nazwa.length() > 3 && haslo.length() > 3){
                try {
                    rekord = sql.SELECT(query);
                    System.out.println(rekord);


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }else{

            }

        }
    }
}