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
        if(!this.fixed){
            this.value = newValue;
        }
    }

    public int findBoxIndex() {
        return (rowIndex /3) + (colIndex /3) *3;
    }

    public int getRowIndex() {
        return this.rowIndex;
    }

    public void setInitValue(int newValue) {
        this.value = newValue;
        this.fixed = true;
    }

    public int getColIndex() {
        return this.colIndex;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    public void printTile(){
        System.out.print(this.value);
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
