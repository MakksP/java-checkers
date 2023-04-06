import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButton extends JButton implements ActionListener {
    private JButton play;
    private Image backgroundImage;

    public PlayButton(){
        this.setFocusable(false);
        this.addActionListener(this);

        this.setText("Graj");
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.setBounds(75, 50, 150, 50);

        this.setIcon(new ImageIcon("przycisk.png"));
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        PlayBoard board = new PlayBoard();
    }
}
