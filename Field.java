import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JButton implements ActionListener {
    private String name;
    private final int xIndex;
    private final int yIndex;
    private SelectedFlag selectedFlag;
    private final PlayBoard playBoardHandle;

    public Field(String name, int xIndex, int yIndex, String icon, PlayBoard playBoardHandle){
        this.name = name;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.setIcon(new ImageIcon(icon));
        this.playBoardHandle = playBoardHandle;
        this.selectedFlag = new SelectedFlag();
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
        if (this.selectedFlag.getLogicSelectedValue()){
            this.playBoardHandle.swapFields(this.selectedFlag.getIndexXSelectingButton(),
                    this.selectedFlag.getIndexYSelectingButton(), this.xIndex, this.yIndex);
            this.selectedFlag.setSelectedFlag(false, 0, 0);
            if (this.playBoardHandle.getPlayerTurn() == 1){
                this.playBoardHandle.setPlayerTurn((byte) 2);
            } else {
                this.playBoardHandle.setPlayerTurn((byte) 1);
            }
        }else if (this.selectedCorrectPlayer()){
            this.playBoardHandle.clearAllFlags();
            this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            this.playBoardHandle.selectStandardMoveFields(xIndex, yIndex);

        }

    }

    public SelectedFlag getSelectedFlag() {
        return selectedFlag;
    }


}
