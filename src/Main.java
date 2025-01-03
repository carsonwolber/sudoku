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
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new JTextField();
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                int x = i * (size + padding) + 10;
                int y = j * (size + padding) + 10;
                grid[i][j].setBounds(x, y, size, size);
                frame.add(grid[i][j]);
            }
        }

        JButton solveButton = new JButton("Solve");
        JButton clearButton = new JButton("Clear");

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        grid[i][j].setText("");
                    }
                }
                board.clearBoard();
            }
        });

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
                            tile.setInitValue(Integer.parseInt(gridTxt));
                        }
                    }
                }

                if (board.validBoard()){
                    board.solveBoard();
                    for(int i = 0; i < 9; i++){
                        for(int j = 0; j < 9; j++){
                            grid[i][j].setText(String.valueOf(board.getTile(i, j).getValue()));
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                    board.clearBoard();
                }

            }
        });

        solveButton.setBounds(550, 250, 100, 25);
        clearButton.setBounds(550, 300, 100, 25);
        frame.add(solveButton);
        frame.add(clearButton);

        frame.setMinimumSize(new Dimension(700, 600));
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