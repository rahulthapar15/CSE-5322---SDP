/**
 * @author : Rahul Thapar
 * Date: 24/04/2020
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class Gui extends JFrame {

    private GuiController guiController = new GuiController();
    public Drawing drawingBoard = new Drawing();

    public Gui(GuiController guiController){

        JFrame frame = new JFrame("Rahul Thapar: HW2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        //Form control section
        JPanel controls = new JPanel();
        controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));
        controls.setBackground(Color.LIGHT_GRAY);

        //Init Buttons
        JButton btnCircle = new JButton("Circle");
        JButton btnBox = new JButton("Box");
        JButton btnLine = new JButton("Line");
        JButton btnUndo = new JButton("Undo");
        JButton btnRedo = new JButton("Redo");

        //Add buttons to the controls section
        controls.add(btnCircle,BorderLayout.WEST);
        controls.add(btnBox, BorderLayout.WEST);
        controls.add(btnLine, BorderLayout.WEST);
        controls.add(btnUndo, BorderLayout.WEST);
        controls.add(btnRedo, BorderLayout.WEST);

        //Menu bar for code and explanation
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem docs = new JMenuItem("Related Documents");


        menu.add(docs);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);


        //Setting the canvas for shapes
        drawingBoard.setBackground(Color.white);


        //----------------------OBSERVER PATTERN-----------------//
        //Drawing board actions
        btnCircle.addActionListener((ActionEvent e) -> {
            guiController.setShape("circle");
        });

        btnBox.addActionListener((ActionEvent e) -> {
            guiController.setShape("box");
        });

        btnLine.addActionListener((ActionEvent e) -> {
            guiController.setShape("line");
        });



        btnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingBoard.undo();
            }
        });

        btnRedo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingBoard.redo();
            }
        });



        //----------------------------------------------------------------------------//
        //      Extra code for Code and docs : Handled using Controller Pattern      //
        //---------------------------------------------------------------------------//
        docs.addActionListener((ActionEvent e)->{
            try {
                guiController.open("https://rahulthapar15.github.io/SDP_HW2/");
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        // Add everything to the frame
        frame.add(controls,BorderLayout.WEST);
        frame.add(drawingBoard);
        frame.setVisible(true);
    }
}
