package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Board extends JPanel {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    private final Model model;
    private int turnIndex = 0;

    public Board() {
        setLayout(new GridLayout(ROWS, COLUMNS));
        BoardCell[] cells = new BoardCell[ROWS * COLUMNS];
        for (int j = ROWS; j >= 1; j--) {
            for (int i = 65; i < 65 + COLUMNS; i++) {
                var boardCellName = String.valueOf((char) i) + j;
                var boardCell = new BoardCell(boardCellName);
                boardCell.addActionListener(this::cellSelected);
                add(boardCell);
                cells[Model.modelCoordinates(boardCellName, COLUMNS)] = boardCell;
            }
        }
        this.model = new Model(ROWS, COLUMNS, cells);
    }

    public void reset() {
        this.turnIndex = 0;
        this.model.reset();
    }

    private void cellSelected(ActionEvent actionEvent) {
        var boardCell = (BoardCell) actionEvent.getSource();
        if (this.model.set(boardCell.getName(), Symbol.values()[this.turnIndex])) {
            this.turnIndex = (this.turnIndex + 1) % 2;
        }
        this.model.checkWinner();
    }
}
