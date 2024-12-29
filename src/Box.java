import java.util.ArrayList;
import java.util.List;

public class Box {

    private List<Tile> tiles;
    private int index;

    public Box(int index){
        this.index = index;
        tiles = new ArrayList<>();
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
            if(value < 0 || value > 9) {
                return false;
            }
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
