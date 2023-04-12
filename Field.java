import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JButton implements ActionListener {
    private String name;
    private int attackFlag;
    private final int xIndex;
    private final int yIndex;
    private SelectedFlag selectedFlag;
    private final PlayBoard playBoardHandle;
    private final BackgroundPanel backgroundPanelHandle;
    private static AttackLock attackLockWhite = new AttackLock();
    private static AttackLock attackLockBlack = new AttackLock();

    public Field(String name, int xIndex, int yIndex, String icon, PlayBoard playBoardHandle, BackgroundPanel backgroundPanelHandle){
        this.name = name;
        this.attackFlag = 0;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
        this.setIcon(new ImageIcon(icon));
        this.playBoardHandle = playBoardHandle;
        this.backgroundPanelHandle = backgroundPanelHandle;
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

    public void playerMove(){
        this.playBoardHandle.swapFields(this.selectedFlag.getIndexXSelectingButton(),
                this.selectedFlag.getIndexYSelectingButton(), this.xIndex, this.yIndex);
        this.selectedFlag.setSelectedFlag(false, 0, 0);
        if (this.playBoardHandle.getPlayerTurn() == 1){
            this.playBoardHandle.setPlayerTurn((byte) 2);
            this.backgroundPanelHandle.setPlayerTurn("Teraz kolej gracza czarnego");
        } else {
            this.playBoardHandle.setPlayerTurn((byte) 1);
            this.backgroundPanelHandle.setPlayerTurn("Teraz kolej gracza białego");
        }
        this.playBoardHandle.clearAllFlags();
    }

    public void choosePlayer(){
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3)); //wybranie gracza
        this.playBoardHandle.selectStandardMoveFields(xIndex, yIndex);
    }

    //todo 1. sprawdzic ture 2. sprawdzac czy pole to gracz w zaleznosci od tury 3. sprawdzac przekatne

    public static void attackFieldsInitializer(Field attackedField, Field currentField, int currentFieldX, int currentFieldY){
        attackedField.setAttackFlag(2);
        currentField.setAttackFlag(1);
        attackedField.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        currentField.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        attackLockWhite.setAttackLock(1);
        attackLockWhite.setPlayerX(currentFieldX);
        attackLockWhite.setPlayerY(currentFieldY);
        attackedField.repaint();
        currentField.repaint();
    }

    //attackFlag = 1, oznacza ze z tego pola wyprowadzany jest atak
    //attackFlag = 2, oznacza ze na to pole skacze sie po ataku
    public boolean checkTopLeftAttack(int currentFieldX, int currentFieldY){
        Field currentField = this.playBoardHandle.getBoard().get(currentFieldY).get(currentFieldX);
        if (this.playBoardHandle.getPlayerTurn() == 1){ //biały
            if (currentField.name.equals("bw")){
                int XToCheck = currentField.getXIndex() - 1;
                int YToCheck = currentField.getYIndex() - 1;
                if (XToCheck > 0 && YToCheck > 0){
                    if (this.playBoardHandle.getBoard().get(YToCheck).get(XToCheck).getName().equals("bb")){ //jesli w lewym gornym narozniku jest czarny przeciwnik
                        Field attackedField = this.playBoardHandle.getBoard().get(YToCheck - 1).get(XToCheck - 1);
                        if (attackedField.getName().equals("b")){
                            attackFieldsInitializer(attackedField, currentField, currentFieldX, currentFieldY);
                        }
                    }
                }
            }
        } else if (this.playBoardHandle.getPlayerTurn() == 2){
            if (currentField.name.equals("bb")){
                int XToCheck = currentField.getXIndex() - 1;
                int YToCheck = currentField.getYIndex() - 1;
                if (XToCheck > 0 && YToCheck > 0){
                    if (this.playBoardHandle.getBoard().get(YToCheck).get(XToCheck).getName().equals("bw")){ //jesli w lewym gornym narozniku jest biały przeciwnik
                        Field attackedField = this.playBoardHandle.getBoard().get(YToCheck - 1).get(XToCheck - 1);
                        if (attackedField.getName().equals("b")){
                            attackFieldsInitializer(attackedField, currentField, currentFieldX, currentFieldY);
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean checkTopRightAttack(int currentFieldX, int currentFieldY){
        return false;
    }

    public boolean checkBottomLeftAttack(int currentFieldX, int currentFieldY){
        return false;
    }

    public boolean checkBottomRightAttack(int currentFieldX, int currentFieldY){
        return false;
    }

    public void checkPossibleAttacks(){
        //todo rozpatrzec 4 mozliwosci bycia bitym (kazdy z naroznikow)
        for (int i = 0; i < this.playBoardHandle.getHeight(); i++){
            for (int j = 0; j < this.playBoardHandle.getWidth(); j++) {
                if(checkTopLeftAttack(j, i)){
                    return;
                }
                if(checkTopRightAttack(j, i)){
                    return;
                }
                if(checkBottomLeftAttack(j, i)){
                    return;
                }
                if(checkBottomRightAttack(j, i)){
                    return;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.playBoardHandle.clearAllSelections();
        if (attackLockWhite.getAttackLock() == 1 && this.playBoardHandle.getPlayerTurn() == 1){
            if (this.getXIndex() == attackLockWhite.getPlayerX() && this.getYIndex() == attackLockWhite.getPlayerY()){
                this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
            } else if (this.getXIndex() == attackLockWhite.getAttackedFieldX() && this.getYIndex() == attackLockWhite.getAttackedFieldY()){
                //todo pole gdzie gracz sie teleportuje po biciu, obsluzyc co sie dzieje jak zbije
            }else {
                this.playBoardHandle.getBoard().get(attackLockWhite.getPlayerY()).get(attackLockWhite.getPlayerX()).
                        setBorder(BorderFactory.createLineBorder(Color.yellow, 3)); //jeśli się kliknie gdzieś indziej to żeby zostało żółte zaznaczenie
            }

        }else if (this.selectedFlag.getLogicSelectedValue()){
            this.playerMove();
            this.checkPossibleAttacks();
        }else if (this.selectedCorrectPlayer()){
            this.choosePlayer();
        } else{
            this.playBoardHandle.clearAllFlags();
        }

    }

    public SelectedFlag getSelectedFlag() {
        return selectedFlag;
    }


    public int getAttackFlag() {
        return attackFlag;
    }

    public void setAttackFlag(int attackFlag) {
        this.attackFlag = attackFlag;
    }
}
