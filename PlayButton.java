import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayButton extends JButton implements ActionListener, MouseListener {

    private JButton quitHandle;
    private PlayBoard board;
    private final BackgroundPanel backgroundPanelHandle;
    private BoardArea boardArea;
    private final int boardWidth = 600;
    private final int boardHeight = 600;

    public void setDefaultBounds(){
        this.setBounds(75, 50, 150, 50);
    }

    public void setPointerBounds(){
        this.setBounds(70, 45, 160, 60);
    }

    public void setDefaultFont(){
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
    }

    public void setPointerFont(){
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 23));
    }

    public PlayButton(BackgroundPanel backgroundPanel){
        this.backgroundPanelHandle = backgroundPanel;

        this.setFocusable(false);
        this.addActionListener(this);

        this.setText("Graj");
        this.setDefaultFont();
        this.setForeground(Color.BLACK);
        this.setDefaultBounds();

        this.setIcon(new ImageIcon("przycisk.png"));
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalTextPosition(JButton.CENTER);

        this.setBorderPainted(false);
        this.setContentAreaFilled(false);

        this.addMouseListener(this);

    }

    public void setQuitHandle(JButton quitHandle) {
        this.quitHandle = quitHandle;
    }

    private void drawNewGameBoard(){
        final int width = this.board.getWidth();
        final int height = this.board.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.board.getBoard().get(i).get(j).setBounds((this.board.getBoard().get(i).get(j).getXIndex() * 75),
                        (this.board.getBoard().get(i).get(j).getYIndex() * 75), 75, 75);
                this.boardArea.add(this.board.getBoard().get(i).get(j));
            }
        }
        this.boardArea.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        this.quitHandle.setVisible(false);
        this.board = new PlayBoard(backgroundPanelHandle);
        this.boardArea = new BoardArea(boardWidth, boardHeight, backgroundPanelHandle);
        this.backgroundPanelHandle.playerTurnInitializer();
        this.drawNewGameBoard();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setPointerBounds();
        this.setIcon(new ImageIcon("przycisk2.png"));
        this.setPointerFont();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.setDefaultBounds();
        this.setIcon(new ImageIcon("przycisk.png"));
        this.setDefaultFont();
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
}
