import java.util.ArrayList;
import java.util.HashMap;

public class PlayBoard {
    private final int width = 8;
    private final int height = 8;
    private ArrayList<ArrayList<String>> board;

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

    private static void namesOfFieldsInitializer(HashMap <String, String> toInitialize){
        toInitialize.put("whiteFieldNoPlayer", "w");
        toInitialize.put("blackFieldNoPlayer", "b");
        toInitialize.put("blackFieldPlayerWhite", "bw");
        toInitialize.put("blackFieldPlayerBlack", "bb");
    }

    public void boardInitializer(HashMap <String, String> namesOfFields){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++) {
                if (isBlackColorOnBoard(i, j)){
                    if (isBlackPlayerArea(i)){
                        this.board.get(i).add(namesOfFields.get("blackFieldPlayerBlack"));
                        continue;
                    } else if (isWhitePlayerArea(i)){
                        this.board.get(i).add(namesOfFields.get("blackFieldPlayerWhite"));
                        continue;
                    }
                    this.board.get(i).add(namesOfFields.get("blackFieldNoPlayer"));
                } else {
                    this.board.get(i).add(namesOfFields.get("whiteFieldNoPlayer"));
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
