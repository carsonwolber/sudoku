import java.util.ArrayList;
import java.util.List;

public class Column {

    private List<Tile> tiles;
    private final int index;

    public Column(int index) {
        tiles = new ArrayList<>();
        this.index = index;
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isValid() {
        boolean[] seen = new boolean[10];
        for(Tile tile : tiles) {
            int value = tile.getValue();
            if(seen[value] && value != 0){
                return false;
            }
            else {
                seen[value] = true;
            }
        }
        return true;
    }

}
