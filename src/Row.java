import java.util.ArrayList;
import java.util.List;

public class Row {

    private final int index;
    private List<Tile> tiles;

    public Row(int index) {
        tiles = new ArrayList<>();
        this.index = index;
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public List<Tile> getTiles() {
        return tiles;
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

    public void printRow() {
        for(Tile tile : tiles) {
            tile.printTile();
        }
        System.out.println();
    }
}
