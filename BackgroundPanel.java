import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String image){
        this.backgroundImage = new ImageIcon(image).getImage();
    }

    public void paintComponent(Graphics graphics){
        graphics.drawImage(backgroundImage, 0, 0, null);
    }

}
