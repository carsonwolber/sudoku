//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Carson's Sudoku Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Board board = new Board();

        int size = 50;
        int padding = 5;
        JTextField[][] grid = new JTextField[9][9];

        for (int i = 0; i < 9; i++) {
            Row r = new Row(i);
            Column c = new Column(i);
            board.addRow(r);
            board.addColumn(c);
            for (int j = 0; j < 9; j++) {
                Tile tile = new Tile(i, j);
                r.addTile(tile);
                c.addTile(tile);
                grid[i][j] = new JTextField();
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                int x = i * (size + padding) + 10;
                int y = j * (size + padding) + 10;

                grid[i][j].setBounds(x, y, size, size);
                frame.add(grid[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            Box b = new Box(i);
            board.addBox(b);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Tile tile = board.getTile(i, j);
                int index = tile.findBoxIndex();
                Box b = board.findBox(index);
                b.addTile(tile);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        Tile tile = board.getTile(i, j);
                        String gridTxt = grid[i][j].getText();
                        if (gridTxt.equals("")) {
                            tile.setValue(0);
                        }
                        else {
                            tile.setValue(Integer.parseInt(gridTxt));
                        }
                    }
                }

                if (board.validBoard()){
                    board.solveBoard();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }

            }
        });

        solveButton.setBounds(550, 250, 100, 25);
        frame.add(solveButton);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}