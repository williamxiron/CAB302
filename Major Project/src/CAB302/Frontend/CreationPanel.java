package CAB302.FrontEnd;

import CAB302.Backend.Maze;
import CAB302.Backend.OpenEndedMaze;

import javax.swing.*;
import java.awt.event.*;

public class CreationPanel extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField mazeName;
    private JTextField authorName;
    private JTextField logo;
    private JButton browseButton;
    private JTextField cellHeight;
    private JTextField cellWidth;
    private Maze maze;

    public CreationPanel() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCreate();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCreate() {
        // add your code here
        int width  = Integer.parseInt(cellWidth.getText());
        int height = Integer.parseInt(cellHeight.getText());

        String name     = mazeName.getText();
        String author   = authorName.getText();
        String dateTime = "just then";

        maze = new OpenEndedMaze(width, height, name, author, dateTime);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public Maze showDialog() {
        return maze;
    }
}
