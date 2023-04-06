import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitButton extends JButton implements ActionListener {
    private JButton quit;
    private Image backgroundImage;

    public QuitButton(){
        this.setFocusable(false);
        this.addActionListener(this);

        this.setText("Wyjdź z gry");
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.setBounds(75, 200, 150, 50);

        this.setIcon(new ImageIcon("przycisk.png"));
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
