import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Register implements ActionListener {
    JPanel panel;
    JFrame frame = new JFrame("Register Panel");
    JTextField poleNazwaUzytkownika;
    SQL sql = new SQL();
    JPasswordField poleHaslo;
    JPasswordField  polePowtorzHaslo;
    JButton submitBtn;
    JLabel labelNazwa;
    JLabel labelHaslo;
    JLabel labelPowtorzHaslo;
    JLabel labelKomunikat;

    public Register() {
        // Tworzenie JFrame
        frame = new JFrame("Register Panel");
        panel = new JPanel();


        panel.setLayout(null);


        poleNazwaUzytkownika = new JTextField();
        poleNazwaUzytkownika.setEditable(true);
        poleNazwaUzytkownika.setBounds(150, 20, 150, 25);

        poleHaslo = new JPasswordField ();
        poleHaslo.setEditable(true);
        poleHaslo.setBounds(150, 60, 150, 25);

        polePowtorzHaslo = new JPasswordField ();
        polePowtorzHaslo.setEditable(true);
        polePowtorzHaslo.setBounds(150, 100, 150, 25);

        labelNazwa = new JLabel("Nazwa:");
        labelNazwa.setBounds(50, 20, 100, 25);

        labelHaslo = new JLabel("Haslo:");
        labelHaslo.setBounds(50, 60, 100, 25);

        labelPowtorzHaslo = new JLabel("Powtorz haslo:");
        labelPowtorzHaslo.setBounds(50, 100, 100, 25);

        submitBtn = new JButton("Utworz konto");
        submitBtn.setBounds(100, 140, 150, 30);
        submitBtn.addActionListener(this);

        labelKomunikat = new JLabel("");
        labelKomunikat.setBounds(50, 180, 250, 25);


        panel.add(labelNazwa);
        panel.add(poleNazwaUzytkownika);
        panel.add(labelHaslo);
        panel.add(poleHaslo);
        panel.add(labelPowtorzHaslo);
        panel.add(polePowtorzHaslo);
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
            String haslo2 = polePowtorzHaslo.getText();

            String query = "INSERT INTO `uzytkownicy`(`nazwa`, `haslo`) VALUES ('" + nazwa +"','" + haslo +"')";
            try {
                sql.QUERY(query);
                System.out.println("Dodano do bazy");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            if(nazwa.length() > 3 && haslo.length() > 3 && haslo2.equals(haslo)){
                System.out.println("Nazwa: " + nazwa + " Hasło: " + haslo);
                System.out.println("Poprawnie utworzono konto");
                poleNazwaUzytkownika.setText("");
                poleHaslo.setText("");
                polePowtorzHaslo.setText("");
                labelKomunikat.setText("Poprawnie utworzono konto");
                labelKomunikat.setForeground(Color.GREEN);
            }else{
                poleNazwaUzytkownika.setText("");
                poleHaslo.setText("");

                System.out.print("Nie udało się utowrzyc konta, niepoprawnie wprowadzono dane");
                labelKomunikat.setText("Nie udało się utowrzyc konta, niepoprawnie wprowadzono dane");
                labelKomunikat.setForeground(Color.RED);
            }

        }
    }
}
