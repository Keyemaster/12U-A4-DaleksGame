
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    private Board board = new Board(12, 12);
    private Dalek Bruce;
    private Dalek RogerRoger;
    private Dalek Sauron;
    private Doctor Doc;

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        Bruce = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        RogerRoger = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        Sauron = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));// put pegs of the daleks and the doctor on the board

         board.putPeg(Color.BLACK, Bruce.getRow(), Bruce.getCol());
            board.putPeg(Color.BLACK, RogerRoger.getRow(), RogerRoger.getCol());
            board.putPeg(Color.BLACK, Sauron.getRow(), Sauron.getCol());
            board.putPeg(Color.GREEN, Doc.getRow(), Doc.getCol());
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {

        while (true) {

            // create variables to store positions
            int DocRow = Doc.getRow();
            int DocCol = Doc.getCol();
            int BruceRow = Bruce.getRow();
            int BruceCol = Bruce.getCol();
            int RogerRogerRow = RogerRoger.getRow();
            int RogerRogerCol = RogerRoger.getCol();
            int SauronRow = Sauron.getRow();
            int SauronCol = Sauron.getCol();

            board.putPeg(Color.GREEN, Doc.getRow(), Doc.getCol());
            // check if Doctor was caught
            if (BruceRow == DocRow && BruceCol == DocCol) {
                board.removePeg(DocRow, DocCol);
                board.putPeg(Color.yellow, DocRow, DocCol);
                board.displayMessage("The Daleks win");
                break;
            } else if (RogerRogerRow == DocRow && RogerRogerCol == DocCol) {
                board.removePeg(DocRow, DocCol);
                board.putPeg(Color.yellow, DocRow, DocCol);
                board.displayMessage("The Daleks win");
                break;
            } else if (SauronRow == DocRow && SauronCol == DocCol) {
                board.removePeg(DocRow, DocCol);
                board.putPeg(Color.yellow, DocRow, DocCol);
                board.displayMessage("The Daleks win");
                break;
            }
            // if the Bruce haven't crashed, keep moving 
            // move Daleks towards the doctor
            // check if Daleks have crashed
            if (BruceCol == RogerRogerCol && BruceRow == RogerRogerRow) {
                // set dalek to a crashed state 
                Bruce.crash();
                RogerRoger.crash();
            }
            // check if Daleks have crashed
            if (RogerRogerCol == SauronCol && RogerRogerRow == SauronRow) {
                // set dalek to a crashed state 
                RogerRoger.crash();
                Sauron.crash();
            }
            // check if Daleks have crashed
            if (SauronCol == BruceCol && SauronRow == BruceRow) {
                // set dalek to a crashed state
                Sauron.crash();
                Bruce.crash();
            }
            // if Bruce have crashed, stop moving and change colour to red
            if (Bruce.hasCrashed() == true) {
                board.putPeg(Color.RED, BruceRow, BruceCol);
            }
            // if RogerRoger have crashed, stop moving and change colour to red
            if (RogerRoger.hasCrashed() == true) {
                board.putPeg(Color.RED, RogerRogerRow, RogerRogerCol);
            }
            // if Sauron have crashed, stop moving and change colour to red
            if (Sauron.hasCrashed() == true) {
                board.putPeg(Color.RED, SauronRow, SauronCol);
            }
            // recieve a click from user for Doctor's movement
            Coordinate click = board.getClick();
            board.removePeg(DocRow, DocCol);
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            DocRow = clickRow;
            DocCol = clickCol;

            // move the doctor
            Doc.move(DocRow, DocCol);


            board.removePeg(BruceRow, BruceCol);
            board.removePeg(RogerRogerRow, RogerRogerCol);
            board.removePeg(SauronRow, SauronCol);
            // if the Bruce haven't crashed, keep moving 
            // move Daleks towards the doctor
            // check if Daleks have crashed
            if (BruceCol == RogerRogerCol && BruceRow == RogerRogerRow) {
                // set dalek to a crashed state 
                Bruce.crash();
                RogerRoger.crash();
            }
            // check if Daleks have crashed
            if (RogerRogerCol == SauronCol && RogerRogerRow == SauronRow) {
                // set dalek to a crashed state 
                RogerRoger.crash();
                Sauron.crash();
            }
            // check if Daleks have crashed
            if (SauronCol == BruceCol && SauronRow == BruceRow) {
                // set dalek to a crashed state
                Sauron.crash();
                Bruce.crash();
            }
            // if Bruce have crashed, stop moving and change colour to red
            if (Bruce.hasCrashed() == true) {
                board.putPeg(Color.RED, BruceRow, BruceCol);
            }
            // if RogerRoger have crashed, stop moving and change colour to red
            if (RogerRoger.hasCrashed() == true) {
                board.putPeg(Color.RED, RogerRogerRow, RogerRogerCol);
            }
            // if Sauron have crashed, stop moving and change colour to red
            if (Sauron.hasCrashed() == true) {
                board.putPeg(Color.RED, SauronRow, SauronCol);
            }
            // if Bruce haven't crashed, keep moving
            if (Bruce.hasCrashed() == false) {
                Bruce.advanceTowards(Doc);
                board.putPeg(Color.BLACK, Bruce.getRow(), Bruce.getCol());
            }else{
                board.putPeg(Color.RED, BruceRow, BruceCol);
            }
            // if the RogerRoger haven't crashed, keep moving
            if (RogerRoger.hasCrashed() == false) {
                RogerRoger.advanceTowards(Doc);
                board.putPeg(Color.BLACK, RogerRoger.getRow(), RogerRoger.getCol());
            }else{
                board.putPeg(Color.RED, RogerRogerRow, RogerRogerCol);
            }
            // if the Sauron haven't crashed, keep moving
            if (Sauron.hasCrashed() == false) {
                Sauron.advanceTowards(Doc);
                board.putPeg(Color.BLACK, Sauron.getRow(), Sauron.getCol());
            }else{
              board.putPeg(Color.RED, Sauron.getRow(), Sauron.getCol());  
            }

            if (Bruce.hasCrashed() == true && RogerRoger.hasCrashed() == true && Sauron.hasCrashed() == true) {
                break;
            }
        }
        // if all daleks have crashed, the doctor wins
        if (Bruce.hasCrashed() == true && RogerRoger.hasCrashed() == true && Sauron.hasCrashed() == true) {
            board.displayMessage("The Doctor wins");
        }

    }
}
