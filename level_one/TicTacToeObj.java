/**
* Created by Anton Avraamov on 17.10.2016.
*/
import java.util.*;

class TicTacToeObj{

    Field field = new Field();
    Player player = new Player();
    AI ai = new AI();

    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args){
        new TicTacToeObj().go();
    }

    void go(){
        field.printField();
        while(true){
            player.turnPlayer();
            field.printField();
            if (field.checkWin(player.getDot())){
                System.out.println("You won!");
                break;
            }
            if (field.isFieldFull()){
                System.out.println("Draw...");
                break;
            }
            ai.turnAI();
            field.printField();
            if (field.checkWin(ai.getDot())){
                System.out.println("AI won!");
                break;
            }
            if (field.isFieldFull()){
                System.out.println("Draw...");
                break;
            }
        }
    }
    /**
    * class for playing field
    */
    class Field{
        final int FIELD_SIZE = 3;
        final char DOT_EMPTY = '.';
        char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    /**
     * Initializing the playing field
     */
        Field(){
            for (int x = 0; x < FIELD_SIZE; x++){
                for (int y = 0; y < FIELD_SIZE; y++){
                    field[x][y] = DOT_EMPTY;
                }
            }
        }

    /**
    * Getters for the field size and the DOT
    */
        int getSize(){
            return FIELD_SIZE;
        }

        char getDot(){
            return DOT_EMPTY;
        }
    /**
    *   Setter for the Dot
    */
        void setDot(int x, int y, char sym){
            field[x][y] = sym;
        }

    /**
    * Displaying the playing field
    */
        void printField(){
            for (int x = 0; x < FIELD_SIZE; x++) {
                for (int y = 0; y < FIELD_SIZE; y++)
                    System.out.print(field[x][y]);
                    System.out.println();
                }
            }
    /**
    * Is the cell empty?
    */
        boolean isCellEmpty(int x, int y, char sym){
            return x < 0 || y < 0 || x > (FIELD_SIZE - 1) || y > (FIELD_SIZE - 1) ? false : field[x][y] == sym;
        }
    /**
    * Checking for a drow
    */
        boolean isFieldFull(){
            for (int x = 0; x < FIELD_SIZE; x++){
                for (int y = 0; y < FIELD_SIZE; y++){
                    if(field[x][y] == DOT_EMPTY)
                        return false;
                }
            }
            return true;
        }

    /**
     * Checking for a victory
     */
        boolean checkWin(char sym){
            // horizontals / verticals
            for (int i = 0; i < FIELD_SIZE; i++) {
                if (field[i][0] == sym && field[i][1] == sym && field[i][2] == sym) return true;
                if (field[0][i] == sym && field[1][i] == sym && field[2][i] == sym) return true;
            }
            // diagonals
            if(field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) return true;
            if(field[2][0] == sym && field[1][1] == sym && field[0][2] == sym) return true;
            return false;
        }
    }

    /**
    * Class Player
    */
    class Player{
        final char DOT_PLAYER = 'x';
        /**
        * Getter
        */
        char getDot(){
            return DOT_PLAYER;
        }

        void turnPlayer(){
        int x, y;
        do {
            System.out.println("Player: ");
            System.out.println("Enter coordinates Y and X (1-" + field.getSize() + "):");
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;

        } while (!field.isCellEmpty(x, y, field.getDot()));
            field.setDot(x, y, DOT_PLAYER);
        }
    }

    /**
    * Class AI
    */
    class AI{
        final char DOT_AI = 'o';

        /**
        * Getter
        */
        char getDot(){
            return DOT_AI;
        }

        void turnAI(){
            boolean flag = false;
            // Trying to capture the center cell
            if (field.isCellEmpty(1, 1, field.getDot())){
                field.setDot(1, 1, DOT_AI);
                System.out.println("<<Center point captured>>");
                flag = true;
            }
            int x, y;
            // Random turn
            if (!flag) { System.out.println("<<Random turn>>");
                do {
                    x = rand.nextInt(field.getSize());
                    y = rand.nextInt(field.getSize());
                } while (!field.isCellEmpty(x, y, field.getDot()));
                field.setDot(x, y, DOT_AI);
            }
        }
    }
}