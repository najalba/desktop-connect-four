package four;

import java.awt.*;

public class Model {
    private final int rows;
    private final int columns;
    private final BoardCell[] model;

    private boolean withWinner = false;

    public Model(int rows, int columns, BoardCell[] model) {
        this.rows = rows;
        this.columns = columns;
        this.model = model;
    }

    public boolean set(String cellName, Symbol symbol) {
        if (this.withWinner) {
            return false;
        } else {
            var selectedCellCoordinates = modelCoordinates(cellName, this.columns);
            int selectedColumnCoordinates = selectedCellCoordinates % this.columns;
            while (selectedColumnCoordinates < this.model.length && !Symbol.EMPTY.getCode().equals(this.model[selectedColumnCoordinates].getText())) {
                selectedColumnCoordinates += this.columns;
            }
            if (selectedColumnCoordinates < this.model.length) {
                this.model[selectedColumnCoordinates].setText(symbol.getCode());
                return true;
            } else {
                return false;
            }
        }
    }

    public void reset() {
        this.withWinner = false;
        for (BoardCell cell : this.model) {
            cell.setText(Symbol.EMPTY.getCode());
            cell.setBackground(Color.DARK_GRAY);
        }
    }

    public void checkWinner() {
        if (!this.withWinner) {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns - 3; j++) {
                    var index = i * this.columns + j;
                    var symbol = this.model[index].getText();
                    if (!Symbol.EMPTY.getCode().equals(symbol) && symbol.equals(this.model[index + 1].getText()) && symbol.equals(this.model[index + 2].getText()) && symbol.equals(this.model[index + 3].getText())) {
                        this.model[index].setBackground(Color.GREEN);
                        this.model[index + 1].setBackground(Color.GREEN);
                        this.model[index + 2].setBackground(Color.GREEN);
                        this.model[index + 3].setBackground(Color.GREEN);
                        this.withWinner = true;
                    }
                }
            }
            for (int i = 0; i < this.columns; i++) {
                for (int j = 0; j < this.rows - 3; j++) {
                    var index = j * this.columns + i;
                    var symbol = this.model[index].getText();
                    if (!Symbol.EMPTY.getCode().equals(symbol) && symbol.equals(this.model[index + this.columns].getText()) && symbol.equals(this.model[index + 2 * this.columns].getText()) && symbol.equals(this.model[index + 3 * this.columns].getText())) {
                        this.model[index].setBackground(Color.GREEN);
                        this.model[index + this.columns].setBackground(Color.GREEN);
                        this.model[index + 2 * this.columns].setBackground(Color.GREEN);
                        this.model[index + 3 * this.columns].setBackground(Color.GREEN);
                        this.withWinner = true;
                    }
                }
            }
            for (int i = 0; i < this.rows - 3; i++) {
                for (int j = 0; j < this.columns - 3; j++) {
                    var index = i * this.columns + j;
                    var symbol = this.model[index].getText();
                    if (!Symbol.EMPTY.getCode().equals(symbol) && symbol.equals(this.model[index + this.columns + 1].getText()) && symbol.equals(this.model[index + 2 * this.columns + 2].getText()) && symbol.equals(this.model[index + 3 * this.columns + 3].getText())) {
                        this.model[index].setBackground(Color.GREEN);
                        this.model[index + this.columns + 1].setBackground(Color.GREEN);
                        this.model[index + 2 * this.columns + 2].setBackground(Color.GREEN);
                        this.model[index + 3 * this.columns + 3].setBackground(Color.GREEN);
                        this.withWinner = true;
                    }
                }
            }
            for (int i = 3; i < this.columns; i++) {
                for (int j = 0; j < this.rows; j++) {
                    var index = j * this.columns + i;
                    var symbol = this.model[index].getText();
                    if (!Symbol.EMPTY.getCode().equals(symbol) && symbol.equals(this.model[index + this.columns - 1].getText()) && symbol.equals(this.model[index + 2 * this.columns - 2].getText()) && symbol.equals(this.model[index + 3 * this.columns - 3].getText())) {
                        this.model[index].setBackground(Color.GREEN);
                        this.model[index + this.columns - 1].setBackground(Color.GREEN);
                        this.model[index + 2 * this.columns - 2].setBackground(Color.GREEN);
                        this.model[index + 3 * this.columns - 3].setBackground(Color.GREEN);
                        this.withWinner = true;
                    }
                }
            }
        }
    }

    public static int modelCoordinates(String cellName, int columns) {
        var column = (int) cellName.charAt(cellName.length() - 2) - 65;
        var row = (int) cellName.charAt(cellName.length() - 1) - 49;
        return row * columns + column;
    }
}
