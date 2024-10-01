package Game;
import javax.swing.*;
import java.awt.*;

public class gameMain {

    public gameMain(String[] UserData){
        JFrame window = new JFrame("SpaceInvaders");
        window.setSize(800,600);
        window.setBackground(Color.BLACK);
        window.setResizable(false);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        System.out.println("<---------------->");
        System.out.println("Utworzono okienko");
        System.out.println("User ID: " + Integer.parseInt(UserData[0]));
        System.out.println("User name: " + UserData[1]);
        System.out.println("<---------------->");
    }

}
