/**
 * @author : Rahul Thapar
 * Date: 24/04/2020
 */
import java.awt.*;

public class Line implements Shape {
    private int x,y;

    public Line(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void Draw(Graphics2D g) {
        g.setColor(Color.red);
        g.drawLine(x,y,x+150,y);
    }
}
