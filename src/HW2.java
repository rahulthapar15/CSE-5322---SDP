/**
 * @author : Rahul Thapar
 * Date: 24/04/2020
 */
public class HW2 {

    public static void main(String[] args) {

        //----------------------CONTROLLER PATTERN-----------------//
        GuiController guiController = new GuiController();
        Gui gui = new Gui(guiController);
    }
}
