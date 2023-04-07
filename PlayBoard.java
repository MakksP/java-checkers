import java.util.ArrayList;
import java.util.HashMap;

public class PlayBoard {
    private final int width = 8;
    private final int height = 8;
    private ArrayList<ArrayList<Field>> board;

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
                        this.board.get(i).add(new Field(namesOfFields.get("blackFieldPlayerBlack"), j, i, "bb.png"));
                        continue;
                    } else if (isWhitePlayerArea(i)){
                        this.board.get(i).add(new Field(namesOfFields.get("blackFieldPlayerWhite"), j, i, "bw.png"));
                        continue;
                    }
                    this.board.get(i).add(new Field(namesOfFields.get("blackFieldNoPlayer"), j, i, "b.png"));
                } else {
                    this.board.get(i).add(new Field(namesOfFields.get("whiteFieldNoPlayer"), j, i, "w.png"));
                }
            }
        }
    }

    public PlayBoard(){
        // w -> white field without player, b -> black field without player
        // bw -> black field with white player, bb -> black field with black player
        HashMap <String, String> namesOfFields = new HashMap<>();
        namesOfFieldsInitializer(namesOfFields);

        board = new ArrayList<>();
        for (int i = 0; i < height; i++){
            board.add(new ArrayList<>());
        }

        boardInitializer(namesOfFields);

    }
}
