package four;

import javax.swing.*;
import java.awt.*;

public class BoardCell extends JButton {
    public BoardCell(String text) {
        super(Symbol.EMPTY.getCode());
        setFocusPainted(false);
        setName("Button" + text);
        setBackground(Color.DARK_GRAY);
        setOpaque(true);
    }
}
