import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Column> columns;
    private List<Row> rows;
    private List<Box> boxes;


    public Board() {
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.boxes = new ArrayList<>();
    }

    public void addRow(Row newRow){
        rows.add(newRow);
    }


    public void addColumn(Column newColumn){
        columns.add(newColumn);
    }

    public void addBox(Box newBox){
        boxes.add(newBox);
    }


    public List<Column> getColumns() {
        return columns;
    }


    public List<Row> getRows() {
        return rows;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public Box findBox(int index) {
        for (Box box : boxes) {
            if(box.getIndex() == index){
                return box;
            }
        }
        return null;
    }


    public Tile getTile(int rowIndex, int columnIndex) {
        for (Row rowN : rows) {
            for(Tile tileN : rowN.getTiles()){
                if(tileN.getColIndex() == columnIndex && tileN.getRowIndex() == rowIndex){
                    return tileN;
                }
            }
        }
        return null;
    }


    public void printBoard(){
        for(Row row : rows){
            row.printRow();
        }
    }


    public boolean validBoard(){
        for(Row row : rows){
            if (!(row.isValid())){
                return false;
            }
        }
        for(Column col : columns){
            if (!(col.isValid())){
                return false;
            }
        }

        for(Box box : boxes){
            if (!(box.isValid())){
                return false;
            }
        }
        return true;

    }

    private boolean filledBoard(){
        for(Row row : rows){
            for(Tile tile : row.getTiles()){
                if (tile.getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private Tile backtrack_tile(int i, int j){
        // if we can, go back across rows, otherwise do so by column,
        if (j > 0){
            return getTile(i, j-1);
        }
        return getTile(i-1, j);
    }

    private Tile advance_tile(int i, int j){
        if (j < 9){
            return getTile(i, j+1);
        }
        return getTile(i+1, j);
    }

    public void solveBoard() {
        int i = 0;
        int j = 0;
        while(!filledBoard() && !validBoard()){
            Tile tile = getTile(i, j);
            if(!tile.isFixed()){
                if(tile.getValue() < 9){
                    tile.setValue(tile.getValue() +1);
                    if(!validBoard()){
                        /*
                         if incrementing by 1 breaks the boards validity, increment until we
                         a. find a valid input
                         b. exhaust our options and backtrack
                         */
                        while(tile.getValue() < 9 && !validBoard()){
                            tile.setValue(tile.getValue() +1);
                        }
                        if(!validBoard()){
                            tile = backtrack_tile(i,j);
                        }
                        else {
                            tile = advance_tile(i,j);
                        }
                    }
                }
            }
        }
    }
}
