import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayBoard implements Runnable {
    private final int width = 8;
    private final int height = 8;
    private ArrayList<ArrayList<Field>> board;
    private final BackgroundPanel backgroundPanelHandle;
    //1 means white player 2 means black player
    private byte playerTurn;

    public boolean isBlackPlayerArea(int i){
        return i < 3;
    }

    public boolean isWhitePlayerArea(int i){
        return i > 4;
    }

    public boolean isBlackColorOnBoard(int i, int j){
        if (i % 2 == 0){
            return j % 2 != 0;
        } else {
            return j % 2 == 0;
        }
    }

    public ArrayList<ArrayList<Field>> getBoard(){
        return this.board;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    private static void namesOfFieldsInitializer(HashMap <String, String> toInitialize){
        toInitialize.put("whiteFieldNoPlayer", "w");
        toInitialize.put("blackFieldNoPlayer", "b");
        toInitialize.put("blackFieldPlayerWhite", "bw");
        toInitialize.put("blackFieldPlayerBlack", "bb");
    }

    public void boardInitializer(HashMap <String, String> namesOfFields){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                if (isBlackColorOnBoard(i, j)){
                    if (isBlackPlayerArea(i)){
                        this.board.get(i).add(new Field(namesOfFields.get("blackFieldPlayerBlack"), j, i, "bb.png", this, backgroundPanelHandle));
                        continue;
                    } else if (isWhitePlayerArea(i)){
                        this.board.get(i).add(new Field(namesOfFields.get("blackFieldPlayerWhite"), j, i, "bw.png", this, backgroundPanelHandle));
                        continue;
                    }
                    this.board.get(i).add(new Field(namesOfFields.get("blackFieldNoPlayer"), j, i, "b.png", this, backgroundPanelHandle));
                } else {
                    this.board.get(i).add(new Field(namesOfFields.get("whiteFieldNoPlayer"), j, i, "w.png", this, backgroundPanelHandle));
                }
            }
        }
    }



    public void clearAllSelections(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Field currentField = this.board.get(i).get(j);
                currentField.setDefaultBorder();

            }
        }
    }

    public void clearAllFlags(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.board.get(i).get(j).getSelectedFlag().setSelectedFlag(false, 0, 0);
            }
        }
    }

    public static void checkFieldAndSetBorderToValidToMove(Field field, int buttonXIndex, int buttonYIndex){
        if (field.getName().equals("b")){
            field.getSelectedFlag().setSelectedFlag(true, buttonXIndex, buttonYIndex);
            field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        }
    }

    public void selectStandardMoveFields(int buttonXIndex, int buttonYIndex){
        if (playerTurn == 1){
            if (buttonYIndex - 1 >= 0){
                if (buttonXIndex - 1 >= 0){
                    Field tmpField = board.get(buttonYIndex - 1).get(buttonXIndex - 1);
                    checkFieldAndSetBorderToValidToMove(tmpField, buttonXIndex, buttonYIndex);
                }
                if (buttonXIndex + 1 < width){
                    Field tmpField = board.get(buttonYIndex - 1).get(buttonXIndex + 1);
                    checkFieldAndSetBorderToValidToMove(tmpField, buttonXIndex, buttonYIndex);
                }
            }
        } else if (playerTurn == 2){
            if (buttonYIndex + 1 < height){
                if (buttonXIndex - 1 >= 0){
                    Field tmpField = board.get(buttonYIndex + 1).get(buttonXIndex - 1);
                    checkFieldAndSetBorderToValidToMove(tmpField, buttonXIndex, buttonYIndex);
                }
                if (buttonXIndex + 1 < width){
                    Field tmpField = board.get(buttonYIndex + 1).get(buttonXIndex + 1);
                    checkFieldAndSetBorderToValidToMove(tmpField, buttonXIndex, buttonYIndex);
                }
            }
        }
    }

    public PlayBoard(BackgroundPanel backgroundPanelHandle){
        // w -> white field without player, b -> black field without player
        // bw -> black field with white player, bb -> black field with black player
        HashMap <String, String> namesOfFields = new HashMap<>();
        namesOfFieldsInitializer(namesOfFields);

        board = new ArrayList<>();
        for (int i = 0; i < height; i++){
            board.add(new ArrayList<>());
        }
        this.playerTurn = 1;
        this.backgroundPanelHandle = backgroundPanelHandle;
        this.backgroundPanelHandle.playerTimeInitializer();
        Thread timeCounter = new Thread(this);
        timeCounter.start();
        boardInitializer(namesOfFields);
    }

    public byte getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(byte playerTurn) {
        this.playerTurn = playerTurn;
    }

    public static void changeIconsOfTwoFields(Field firstField, Field secondField){
        firstField.setIcon(new ImageIcon(firstField.getName() + ".png"));
        secondField.setIcon(new ImageIcon(secondField.getName() + ".png"));
        firstField.repaint();
        secondField.repaint();
    }

    public void swapFields(int indexXSelectingButton, int indexYSelectingButton, int xIndex, int yIndex) {
        String tmpName = board.get(indexYSelectingButton).get(indexXSelectingButton).getName();
        board.get(indexYSelectingButton).get(indexXSelectingButton).setName(board.get(yIndex).get(xIndex).getName());
        board.get(yIndex).get(xIndex).setName(tmpName);
        changeIconsOfTwoFields(board.get(indexYSelectingButton).get(indexXSelectingButton), board.get(yIndex).get(xIndex));
    }

    public void deletePawn(int x, int y){
        this.board.get(y).get(x).setName("b");
        this.board.get(y).get(x).setIcon(new ImageIcon("b.png"));
    }

    @Override
    public void run() {
        while (true){
            if (this.backgroundPanelHandle.getWhitePlayer().getActiveFlag() == 0){
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (this.backgroundPanelHandle.getWhitePlayer().getActiveFlag() == 0){
                return;
            }
            this.backgroundPanelHandle.getWhitePlayer().increaseTime();
            this.backgroundPanelHandle.getWhitePlayer().setText(this.backgroundPanelHandle.getWhitePlayer().returnFullLabel());
            this.backgroundPanelHandle.getWhitePlayer().repaint();
            this.backgroundPanelHandle.repaint();
        }
    }
}
