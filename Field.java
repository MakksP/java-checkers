import javax.swing.*;

public class Field extends JButton {
    private String name;
    private final int xIndex;
    private final int yIndex;

    public Field(String name, int xIndex, int yIndex, String icon){
        this.name = name;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.setIcon(new ImageIcon(icon));
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
}
