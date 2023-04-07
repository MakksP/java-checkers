import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {

    public static final int width = 1280;
    public static final int height = 960;
    private ButtonsArea buttonsArea;
    private BackgroundPanel backgroundPanel;

    StartFrame(){
        //nadanie tła oraz ustawienie podstawowych parametrów
        this.setTitle("Warcaby - java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width,height);
        this.setLayout(null);
        this.backgroundPanel = new BackgroundPanel("podkladka.jpg");
        this.backgroundPanel.setBounds(0,0, width, height);
        this.backgroundPanel.setLayout(null);
        this.add(this.backgroundPanel);
        this.setGreetings();
        this.setMenuPanel();
        this.setVisible(true);
        this.setResizable(false);
    }

    public void setGreetings(){
        //ustawienie i wystylowanie napisu powitalnego
        JLabel greetings = new JLabel();
        greetings.setText("Gra w warcaby - wersja 1.0");
        greetings.setForeground(new Color(0xFFFFFF));
        greetings.setBounds(450, 0, 400, 100);
        greetings.setFont(new Font ("Arial", Font.BOLD, 20));
        greetings.setHorizontalAlignment(JLabel.CENTER);
        greetings.setVerticalAlignment(JLabel.TOP);
        this.backgroundPanel.add(greetings);
    }

    public void setMenuPanel(){
        //stworzenie pola dla przycisków i umieszczenie ich w nim
        this.buttonsArea = new ButtonsArea(300, 300, backgroundPanel);
        this.buttonsArea.setBounds(500, 300, this.buttonsArea.getWidth(), this.buttonsArea.getHeight());
        this.buttonsArea.setOpaque(false);
        this.backgroundPanel.add(buttonsArea);
        this.buttonsArea.add(this.buttonsArea.getPlay(), backgroundPanel);
        this.buttonsArea.add(this.buttonsArea.getQuit());
    }

    public void showMenu(){
        //setMenuPanel(this);
    }

}
