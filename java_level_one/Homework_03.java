/**
 * Created by Anton Avraamov on 12.10.2016.
 */
import java.util.*;

class Homework03{
    static final int FIELD_SIZE = 3;
    static final char DOT_PLAYER = 'x';
    static final char DOT_AI = 'o';
    static final char DOT_EMPTY = '.';
    static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String args[]) {
        initField();
        printField();
        while (true){
            turnPlayer();
            printField();
            if (isFieldFull()){
                System.out.println("Draw...");
                break;
            }
            if (checkWin(DOT_PLAYER)){
                System.out.println("You won!");
                break;
            }
            System.out.println("AI: ");
            turnAI();
            printField();
            if (isFieldFull()){
                System.out.println("Draw...");
                break;
            }
            if (checkWin(DOT_AI)){
                System.out.println("AI won!");
                break;
            }
        }
    }

    /**
     * Initializing the playing field
     */
    static void initField(){
        for (int x = 0; x < FIELD_SIZE; x++){
            for (int y = 0; y < FIELD_SIZE; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Displaying the playing field
     */
    static void printField(){
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++)
                System.out.print(field[x][y]);
                System.out.println();
        }
    }

    /**
     * Is the cell empty?
     */
    static boolean isCellEmpty(int x, int y, char sym){
        return x < 0 || y < 0 || x > (FIELD_SIZE - 1) || y > (FIELD_SIZE - 1) ? false : field[x][y] == sym;
    }

    /**
     * Player's turn
     */
    static boolean turnPlayer(){
        int x, y;
        do {
            System.out.println("Player: ");
            System.out.println("Enter coordinates Y and X (1-" + FIELD_SIZE + "):");

            x = in.nextInt();
            y = in.nextInt();
            if (x < 0 || y < 0) {
                return false;
            }
        } while (!isCellEmpty(x-1, y-1, DOT_EMPTY));
            field[x-1][y-1] = DOT_PLAYER;
            return true;
    }
    /**
     * AI's turn
     */
    static void turnAI(){
        boolean flag = false;
        // Trying to capture the center cell
        if (isCellEmpty(1, 1, DOT_EMPTY)){
            field[1][1] = DOT_AI;
            System.out.println("<<Center point captured>>");
            flag = true;
        }
        /** 
        * Blocking the center of a line. 
        * Only horizontals. 
        * Otherwise you will never win :))
        */
        if (field[0][0] == DOT_PLAYER && field[0][2] == DOT_PLAYER) {
            if (isCellEmpty(0, 1, DOT_EMPTY)){
                field[0][1] = DOT_AI;
                System.out.println("<<Blocking center>>");
                flag = true;
            }
        }
        if (field[2][0] == DOT_PLAYER && field[2][2] == DOT_PLAYER) {
            if (isCellEmpty(2, 1, DOT_EMPTY)){
                field[2][1] = DOT_AI;
                System.out.println("<<Blocking center>>");
                flag = true;
            }
        }
        // Blocking the lines (beginning cell/end cell) 
        for (int x = 0; x < FIELD_SIZE; x++){
            for (int y = 0; y < FIELD_SIZE; y++){
                if (isCellEmpty(x, y, DOT_PLAYER)){
                    for (int xx = x - 1; xx < x + FIELD_SIZE; xx++){
                        for (int yy = y - 1; yy < y + FIELD_SIZE; yy++){
                            if(!((y == yy) && (x == xx))){
                                if(isCellEmpty(xx, yy, DOT_PLAYER)){

                                    if (isCellEmpty(x * 2 - xx, y * 2 - yy, DOT_EMPTY)){
                                        field[x * 2 - xx][y * 2 - yy] = DOT_AI;
                                        System.out.println("<<Blocking the beginning cell>>");
                                        flag = true;
                                    }

                                    if (isCellEmpty(xx * 2 - x, yy * 2 - y, DOT_EMPTY)){
                                        field[xx * 2 - x][yy * 2 - y] = DOT_AI;
                                        System.out.println("<<Blocking the end cell>>");
                                        flag = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int x, y;
        // Random turn
        if (!flag) { System.out.println("<<Random turn>>");
            do {
                x = rand.nextInt(FIELD_SIZE);
                y = rand.nextInt(FIELD_SIZE);
            } while (!isCellEmpty(x, y, DOT_EMPTY));
            field[x][y] = DOT_AI;
        }
    }

    /**
     * Checking for a draw
     */
    static boolean isFieldFull(){
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
    static boolean checkWin(char sym){
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
