package Menu;
import Game.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;



public class Menu implements ActionListener{

    JFrame frame;
    JPanel panel;
    JLabel label;
    JLabel nazwa;
    String[][] rekord;
    JButton buttonPlayGame;
    JButton signOut;

    public SQL sql = new SQL();

    public Menu(Integer userID) throws SQLException {
        sql.connect();
        frame = new JFrame("Menu");
        panel = new JPanel();
        panel.setLayout(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setResizable(false);
        frame.setVisible(true);

        int screenWidth = frame.getWidth();
        int screenHeight = frame.getHeight();

        sql.SELECT("SELECT id,nazwa, haslo FROM uzytkownicy WHERE id = " + userID);

        System.out.print(screenWidth);


        label = new JLabel();

        label.setText("User ID " + sql.UserData[0]);
        label.setHorizontalAlignment(SwingConstants.CENTER); // Wyśrodkowanie tekstu
        label.setBounds(0, 10, screenWidth, 50); // Ustaw szerokość na szerokość okna
        label.setHorizontalAlignment(JLabel.CENTER);

        nazwa = new JLabel();
        nazwa.setText("Zalogowano się jako " + sql.UserData[1]);
        nazwa.setHorizontalAlignment(SwingConstants.CENTER); // Wyśrodkowanie tekstu
        nazwa.setBounds(0, 40, screenWidth, 50); // Ustaw szerokość na szerokość okna
        nazwa.setHorizontalAlignment(JLabel.CENTER);

        buttonPlayGame = new JButton("Play");
        int PLayGameWidth = 100;
        buttonPlayGame.setBounds((screenWidth / 2) - (PLayGameWidth)/ 2, 100, PLayGameWidth, 30);
        buttonPlayGame.addActionListener(this);

        signOut = new JButton("Sign out");
        int signOutWidth = 100;
        signOut.setBounds((screenWidth /2 ) - (signOutWidth)/ 2, screenHeight - 100, signOutWidth, 30);
        signOut.addActionListener(this);

        panel.add(label);
        panel.add(nazwa);
        panel.add(buttonPlayGame);
        panel.add(signOut);
        frame.add(panel);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonPlayGame){
            new gameMain(sql.UserData);
            frame.dispose();
        }

        if(e.getSource() == signOut){
            System.out.println("Wyloguj gre");

            for(int i = 0; i < 3; i++){
                if(sql.UserData[i] != null){
                    sql.UserData[i] = null;
                }
            }

            System.out.println("Usunieto dane uzytkownika");
            System.out.println("ID " + sql.UserData[0] + " NAme " + sql.UserData[1] + " haslo " + sql.UserData[2]);

            new Register();
            frame.dispose();

        }
    }
}
