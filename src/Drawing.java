/**
 * @author : Rahul Thapar
 * Date: 24/04/2020
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Drawing extends JPanel implements Command {
    public ArrayList<Shape> points;

    public ArrayList<Shape> pointsRedraw = new ArrayList<Shape>();
    public GuiController controller = new GuiController();

    public Drawing()
    {
        points = new ArrayList<Shape>();

        //----------------------ADAPTER PATTERN-----------------//
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {


                String shape = controller.getShape();  //----------------------EXPERT PATTERN-----------------
                switch (shape){
                    case "circle":
                        //System.out.println("Making circle...");
                        Circle circle = new Circle(e.getX(), e.getY());
                        points.add(circle);
                        System.out.println("Points: " + points);
                        break;

                    case "box" :
                        //System.out.println("Making box...");
                        Box box = new Box(e.getX(), e.getY());
                        points.add(box);
                        System.out.println("Points: " + points);
                        break;

                    case "line":
                        //System.out.println("Making a line...");
                        Line line = new Line(e.getX(), e.getY());
                        points.add(line);
                        System.out.println("Points :" + points);
                        break;

                    default: break;
                }
                repaint();
            }
        });
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Shape pt;

        //----------------------ITERATOR PATTERN-----------------//
        Iterator i = points.iterator();
        while(i.hasNext()){
            pt = (Shape) i.next();
           pt.Draw(g2);
        }
    }

    public ArrayList<Shape> getPoints(){ return this.points; }
    public void setPoints(ArrayList newPoints){
        this.points = newPoints;
        System.out.println("new points: " + points);
        repaint();
    }


    //----------------------COMMAND PATTERN-----------------//
    @Override
    public void undo() {
        if(points.size() > 0){
            System.out.println("undo");
            pointsRedraw.add(points.get(points.size()-1));
            points.remove(points.size() - 1);
            repaint();
        }else{
            JOptionPane.showMessageDialog(null, "There is nothing to undo!");
        }
    }

    @Override
    public void redo() {
        if (pointsRedraw.size() > 0){
            System.out.println("redo");
            Shape toRedraw = pointsRedraw.get(pointsRedraw.size()-1);
            points.add(toRedraw);
            pointsRedraw.remove(toRedraw);
            repaint();
        }else{
            JOptionPane.showMessageDialog(null, "There is nothing to redraw!");
        }
    }

    //----------------------End of COMMAND PATTERN-----------------//
}
