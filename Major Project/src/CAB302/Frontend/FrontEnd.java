package CAB302.FrontEnd;

//for testing

//for GUI
import CAB302.Backend.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//for keyboard input


public class FrontEnd extends JFrame {
    private JPanel mainPanel;
    private JButton generateMazeButton;
    private JButton exportButton;
    private JButton toggleSolutionButton;
    private JButton clearButton;
    private JButton createNewButton;
    private JPanel drawingBoard;
    private Maze maze;

    public FrontEnd() {
        this.setContentPane(this.mainPanel);
        this.setTitle("Maze Tool");
        this.setSize(964, 872);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

        Graphics graphics = drawingBoard.getGraphics();
        drawingBoard.paintComponents(graphics);

        generateMazeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (maze != null) {
                    maze.generateMaze(0, 0);
                    maze.DrawMaze(graphics);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FrontEnd.this.drawingBoard.repaint();
            }
        });

        createNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreationPanel tempFrame = new CreationPanel();
                tempFrame.pack();
                tempFrame.setVisible(true);

                maze = tempFrame.showDialog();
            }
        });
    }
}



