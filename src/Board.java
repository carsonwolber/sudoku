import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Column> columns;
    private List<Row> rows;
    private List<Box> boxes;
    private Tile[][] tiles;


    public Board() {
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
        this.boxes = new ArrayList<>();
        tiles = new Tile[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }

        for (int i = 0; i < 9; i++) {
            Row r = new Row(i);
            Column c = new Column(i);

            rows.add(r);
            columns.add(c);

            for (int j = 0; j < 9; j++) {
                r.addTile(tiles[i][j]);
                c.addTile(tiles[j][i]);
            }
        }

        for (int boxIndex = 0; boxIndex < 9; boxIndex++) {
            Box b = new Box(boxIndex);
            boxes.add(b);

            int startRow = (boxIndex / 3) * 3;
            int startCol = (boxIndex % 3) * 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    b.addTile(tiles[startRow + i][startCol + j]);
                }
            }
        }

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
        return tiles[rowIndex][columnIndex];
    }

    public void clearBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tiles[i][j].setFixed(false);
                tiles[i][j].setValue(0);
            }
        }
    }


    public void printBoard(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(tiles[j][i].getValue() + " ");
            }
            System.out.println();
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

    public void solveBoard() {
        int i = 0;
        int j = 0;

        while(!filledBoard()){
            Tile tile = getTile(i, j);
            if(!tile.isFixed()){
                if(tile.getValue() < 9){
                    tile.setValue(tile.getValue() + 1);
                    if(!validBoard()){
                        while(!validBoard() && tile.getValue() < 9){
                            tile.setValue(tile.getValue() + 1);
                        }
                        if(!validBoard()){
                            tile.setValue(0);
                            if(j > 0){
                                j--;
                            }
                            else{
                                j = 8;
                                i--;
                            }
                        }
                        else{
                            if(j < 8){
                                j++;
                            }
                            else {
                                i++;
                                j=0;
                            }
                        }
                    }
                    else {
                      if(j < 8){
                          j++;
                      }
                      else{
                          i++;
                          j=0;
                      }
                    }
                }
                else {
                    tile.setValue(0);
                    if(j > 0){
                        j--;
                    }
                    else{
                        j = 8;
                        i--;
                    }
                }
            }
            else {
                if(j < 8){
                    j++;
                }
                else {
                    i++;
                    j=0;
                }
            }
        }
    }
}
