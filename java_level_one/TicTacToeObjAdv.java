/**
* Created by Anton Avraamov on 19.10.2016.
*/
import java.util.*;

class TicTacToeObjAdv{

    Field field = new Field();
    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args){
        new TicTacToeObjAdv().go();
    }

    void go(){
        boolean go = true;
        Players[] arrPlayers = new Players[2];
        arrPlayers[0] = new Human();
        arrPlayers[1] = new AI();

        field.printField();
        while(go){
            for(int i = 0; i < arrPlayers.length; i++){
                arrPlayers[i].turn();
                field.printField();
                if (field.checkWin(arrPlayers[i].getDot())){
                    arrPlayers[i].win();
                    go = false;
                    break;
                }
                if (field.isFieldFull()){
                    field.draw();
                    go = false;
                    break;
                }
            }
        }
    }
    /**
    * Abstract class Players
    */
    abstract class Players{
        protected char DOT;

        public char getDot(){
            return DOT;
        }
        public void turn(){}
        public void win(){}

    }
    /**
    * Class Human
    */
    class Human extends Players{
        public Human(){
            this.DOT = 'x';
        }

        public char getDot(){
            return DOT;
        }

        @Override
        public void turn(){
        int x, y;
        do {
            System.out.println("Player: ");
            System.out.println("Enter coordinates Y and X (1-" + field.getSize() + "):");
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;

            } while (!field.isCellEmpty(x, y, field.getDot()));
                field.setDot(x, y, DOT);
            }
        @Override
        public void win(){
            System.out.println("Player won!");
        }
    }

    /**
    * Class AI
    */
    class AI extends Players{
        public AI(){
            this.DOT = 'o';
        }

        public char getDot(){
            return DOT;
        }

        @Override
        public void turn(){
            boolean flag = false;
            // Trying to capture the center cell
            if (field.isCellEmpty(1, 1, field.getDot())){
                field.setDot(1, 1, DOT);
                System.out.println("<<Center point captured>>");
                flag = true;
            }
            int x, y;
            // Random turn
            if (!flag) { 
                System.out.println("<<Random turn>>");
                do {
                    x = rand.nextInt(field.getSize());
                    y = rand.nextInt(field.getSize());
                } while (!field.isCellEmpty(x, y, field.getDot()));
                field.setDot(x, y, DOT);
                }
            }

        @Override
        public void win(){
            System.out.println("AI won!");
        }
    }
}
    /**
    * class for the playing field
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
        public int getSize(){
            return FIELD_SIZE;
        }

        public char getDot(){
            return DOT_EMPTY;
        }
    /**
    *   Setter for the Dot
    */
        public void setDot(int x, int y, char sym){
            field[x][y] = sym;
        }

    /**
    * Displaying the playing field
    */
        public void printField(){
            for (int x = 0; x < FIELD_SIZE; x++) {
                for (int y = 0; y < FIELD_SIZE; y++)
                    System.out.print(field[x][y]);
                    System.out.println();
                }
            }
    /**
    * Is the cell empty?
    */
        public boolean isCellEmpty(int x, int y, char sym){
            return x < 0 || y < 0 || x > (FIELD_SIZE - 1) || y > (FIELD_SIZE - 1) ? false : field[x][y] == sym;
        }
    /**
    * Checking for a drow
    */
        public boolean isFieldFull(){
            for (int x = 0; x < FIELD_SIZE; x++){
                for (int y = 0; y < FIELD_SIZE; y++){
                    if(field[x][y] == DOT_EMPTY)
                        return false;
                }
            }
            return true;
        }

        public void draw(){
            System.out.println("Draw...");
        }

    /**
     * Checking for a victory
     */
        public boolean checkWin(char sym){
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

