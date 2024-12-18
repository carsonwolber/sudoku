public class Tile {

    private int value;
    private boolean fixed;
    private final int rowIndex;
    private final int colIndex;

    public Tile(int rowIndex, int colIndex) {
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.value = 0;
        this.fixed = false;

    }

    public int getValue() {
        return this.value;
    }
    public void setValue(int newValue){
        if(!fixed && newValue > 0 && newValue < 10){
            this.value = newValue;
        }
    }

    public int findBoxIndex(int rowIndex, int colIndex) {
        return (rowIndex /3) + (colIndex /3) *3;
    }



}
