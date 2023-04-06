import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButton extends JButton implements ActionListener {
    private JButton play;

    public PlayButton(){
        this.setFocusable(false);
        this.addActionListener(this);

        this.setText("Graj");
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.setBounds(75, 50, 150, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
