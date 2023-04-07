import javax.swing.*;

public class ButtonsArea extends JPanel {
    private final int width;
    private final int height;
    private final PlayButton play;
    private final QuitButton quit;


    public ButtonsArea(int width, int height, BackgroundPanel backgroundPanel){
        this.width = width;
        this.height = height;
        this.play = new PlayButton(backgroundPanel);
        this.quit = new QuitButton();
        this.play.setQuitHandle(this.quit);
        this.setLayout(null);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public JButton getPlay() {
        return play;
    }

    public JButton getQuit() {
        return quit;
    }
}
