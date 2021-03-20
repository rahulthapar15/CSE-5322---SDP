/**
 * @author : Rahul Thapar
 * Date: 24/04/2020
 */
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class GuiController {

    private static String shape = "";

    public GuiController(){}

    public String getShape(){
        return shape;
    }

    public String setShape(String nshape){
        shape = nshape;
        return shape;
    }


    public void open(String dest) throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()) {
            // Windows
            Desktop.getDesktop().browse(new URI(dest));
        } else {
            // Mac or Ubuntu
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("/usr/bin/firefox -new-window " + dest);
        }
    }
}
