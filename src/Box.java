/**
 * @author : Rahul Thapar
 * Date: 24/04/2020
 */

import java.awt.*;

public class Box implements Shape
{
    private int x, y;
    public Box(int x, int y)
    {
        this.x = x-(75/2);
        this.y = y-(75/2);
    }
    public void Draw(Graphics2D g)
    {
        g.setColor(Color.blue);
        g.drawRect(x, y, 75, 75);
    }
}
