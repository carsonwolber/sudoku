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

    public void solveBoard() {

    }

}
