
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author keyew7019
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(12, 12);

        // set a peg
        b.putPeg(Color.GREEN, 3, 5);
        b.putPeg(Color.BLUE, 3, 5);

        //remove a peg
        b.removePeg(3, 5);

        // message 
        b.displayMessage("Hello everyone");

        while (true) {
            // recieve a click from user
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            // put a peg at the click
            b.putPeg(Color.BLACK, clickRow, clickCol);
        }
    }
}
