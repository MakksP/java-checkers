import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JButton implements ActionListener {
    private String name;
    private final int xIndex;
    private final int yIndex;
    private final PlayBoard playBoardHandle;

    public Field(String name, int xIndex, int yIndex, String icon, PlayBoard playBoardHandle){
        this.name = name;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.setIcon(new ImageIcon(icon));
        this.playBoardHandle = playBoardHandle;
        this.addActionListener(this);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getYIndex() {
        return yIndex;
    }

    public int getXIndex() {
        return xIndex;
    }

    public boolean selectedCorrectPlayer(){
        if (this.playBoardHandle.getPlayerTurn() == 1 && this.name.equals("bw")){
            return true;
        } else return this.playBoardHandle.getPlayerTurn() == 2 && this.name.equals("bb");
    }

    public void setDefaultBorder(){
        this.setBorder(new JButton().getBorder());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.playBoardHandle.clearAllSelections();
        if (this.selectedCorrectPlayer()){
            this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            this.playBoardHandle.selectStandardMoveFields(xIndex, yIndex);
        }
    }
}
