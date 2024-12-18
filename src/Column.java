public class Column {

    private final Tile[] tiles;
    private final int index;

    public Column(Tile[] tiles, int index) {
        this.tiles = tiles;
        this.index = index;
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
