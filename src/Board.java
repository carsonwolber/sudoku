import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Column> columns;
    private List<Row> rows;

    public Board() {
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void addRow(Row newRow){
        rows.add(newRow);
    }

    public void addColumn(Column newColumn){
        columns.add(newColumn);
    }

}
