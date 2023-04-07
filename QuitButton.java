import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuitButton extends JButton implements ActionListener, MouseListener {


    public void setDefaultBounds(){
        this.setBounds(75, 200, 150, 50);
    }

    public void setPointerBounds(){
        this.setBounds(70, 195, 160, 60);
    }

    public QuitButton(){
        this.setFocusable(false);
        this.addActionListener(this);

        this.setText("Wyjdź z gry");
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        this.setDefaultBounds();

        this.setIcon(new ImageIcon("przycisk.png"));
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);

        this.setBorderPainted(false);
        this.setContentAreaFilled(false);

        this.addMouseListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPointerBounds();
        this.setIcon(new ImageIcon("przycisk2.png"));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.setDefaultBounds();
        this.setIcon(new ImageIcon("przycisk.png"));
    }
}
