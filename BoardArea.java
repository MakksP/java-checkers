import javax.swing.*;

public class BoardArea extends JPanel {
    private final int x = 640;
    private final int y = 480;


    public BoardArea(int width, int height, BackgroundPanel backgroundPanel){
        this.setBounds(x/2, y/2, width * 2, height * 2);
        this.setOpaque(false);
        this.setLayout(null);
        backgroundPanel.add(this);
    }

}
