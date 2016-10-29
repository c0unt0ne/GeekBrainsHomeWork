/**
* JAVA 1. Homework 07
* @Autor Anton Avraamov
* dated October 26, 2016
*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TicTacToeUI extends JFrame{
    final String TITLE_OF_PROGRAM = "TicTacToe";
    final int WINDOW_SIZE = 300;
    final int NUMBER_OF_CELLS = 3;
    final int CELL_SIZE = WINDOW_SIZE / NUMBER_OF_CELLS;

    Canvas canvas;
    Game game = new Game();

    public static void main(String[] args) {
        new TicTacToeUI();
    }

    TicTacToeUI(){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 350);
        setResizable(false);

        canvas = new Canvas();
        canvas.setBackground(Color.white);
        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + ":" + y);
            }
        });

        JPanel bp = new JPanel();
        bp.setLayout(new GridLayout());

        JButton newGame = new JButton("New game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.repaint();
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bp.add(newGame);
        bp.add(exit);
        add(BorderLayout.CENTER, canvas);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
    }
    class Game{

        void paint(Graphics g) {
            for (int i = 0; i < NUMBER_OF_CELLS - 1; i++) {
                g.drawLine(0, (i + 1)*CELL_SIZE, WINDOW_SIZE, (i + 1)*CELL_SIZE);
                g.drawLine((i + 1)*CELL_SIZE, 0, (i + 1)*CELL_SIZE, WINDOW_SIZE);
            }
        }
    }

    class Canvas extends JPanel{
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            game.paint(g);
        }
    }
}