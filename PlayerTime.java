import javax.swing.*;
import java.awt.*;

public class PlayerTime extends JLabel{
    private int minutes;
    private int seconds;
    private final String playerTag;
    private int activeFlag;

    public PlayerTime(int x, int y, int width, int height, String playerTag){
        this.minutes = 0;
        this.seconds = 0;
        this.playerTag = playerTag;
        this.activeFlag = 0;
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setText(this.playerTag + getTime());
        this.setForeground(Color.white);
        this.setBackground(Color.black);
        this.setOpaque(true);
        this.setFont(new Font("Arial", Font.BOLD, 15));
        this.repaint();
    }


    public String getTime(){
        if (this.minutes < 10){
            if (this.seconds < 10){
                return "0" + Integer.toString(minutes) + ":" + "0" + Integer.toString(seconds);
            } else {
                return "0" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
            }
        }
        if (this.seconds < 10){
            return Integer.toString(minutes) + ":" + "0" + Integer.toString(seconds);
        }
        return Integer.toString(minutes) + ":" + Integer.toString(seconds);
    }

    public String returnFullLabel(){
        return this.playerTag + this.getTime();
    }

    public void increaseTime(){
        if (this.seconds < 59){
            this.seconds++;

        } else {
            this.seconds = 0;
            this.minutes++;
        }
    }

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }
}
