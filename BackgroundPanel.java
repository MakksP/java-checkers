import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    private JLabel playerWhiteTime;
    private JLabel playerBlackTime;
    private JLabel playerTurn;

    public BackgroundPanel(String image){
        this.backgroundImage = new ImageIcon(image).getImage();
    }

    public void paintComponent(Graphics graphics){
        graphics.drawImage(backgroundImage, 0, 0, null);
    }


    public JLabel getPlayerWhiteTime() {
        return playerWhiteTime;
    }

    public void setPlayerWhiteTime(JLabel playerWhiteTime) {
        this.playerWhiteTime = playerWhiteTime;
    }

    public JLabel getPlayerBlackTime() {
        return playerBlackTime;
    }

    public void setPlayerBlackTime(JLabel playerBlackTime) {
        this.playerBlackTime = playerBlackTime;
    }

    public JLabel getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(String text) {
        this.playerTurn.setText(text);
        if (text.equals("Teraz kolej gracza białego")){
            this.playerTurn.setForeground(Color.white);
            this.playerTurn.setBackground(Color.black);
        } else if (text.equals("Teraz kolej gracza czarnego")){
            this.playerTurn.setForeground(Color.black);
            this.playerTurn.setBackground(Color.white);
        }

    }

    public void playerTurnInitializer(){
        this.playerTurn = new JLabel();
        this.playerTurn.setLayout(null);
        this.playerTurn.setText("Teraz kolej gracza białego");
        this.playerTurn.setFont(new Font ("Arial", Font.BOLD, 20));
        this.playerTurn.setBounds(515, 200, 265, 30);
        this.playerTurn.setForeground(Color.white);
        this.playerTurn.setBackground(Color.black);
        this.playerTurn.setOpaque(true);
        this.add(this.playerTurn);
        this.repaint();
    }
}
