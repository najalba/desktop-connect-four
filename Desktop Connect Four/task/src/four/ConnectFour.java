package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    public ConnectFour() {
        setTitle("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        var board = new Board();
        add(board, BorderLayout.CENTER);

        var restButton = new JButton("Reset");
        restButton.setName("ButtonReset");
        restButton.addActionListener(actionEvent -> board.reset());

        var southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(restButton);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
