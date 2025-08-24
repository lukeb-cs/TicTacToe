import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends JPanel implements MouseListener {

    public final int SCREEN_X = 650;
    public final int SCREEN_Y = 650;

    private int screenNum;
    private final int TITLE_SCREEN = 0;
    private final int GAME_SCREEN = 1;
    private final int ROUND_WIN_SCREEN = 2;
    private final int TIE_SCREEN = 3;

    private int mouseX;
    private int mouseY;

    private Tile[][] tiles;

    private boolean xTurn;
    private boolean xWon;

    private int pickTile;

    public Game() {

        this.setPreferredSize(new Dimension(SCREEN_X, SCREEN_Y));
        this.setFocusable(true);
        this.addMouseListener(this);

        screenNum = 0;

        tiles = new Tile[3][3];
        makeTiles();
    }

    public void makeTiles() {
        for (int a = 0; a < tiles.length; a++) {
            for (int b = 0; b < tiles[0].length; b++) {
                tiles[a][b] = new Tile(" ", false);
            }
        }
        xTurn = true;
    }

    public void resetTiles() {
        for (int a = 0; a < tiles.length; a++) {
            for (int b = 0; b < tiles[0].length; b++) {
                tiles[a][b].reset();
            }
        }
        xTurn = true;
    }

    public void play() {
        switch (pickTile) {
            case 1:
                if (tiles[0][0].getUsed() != true) {
                    if (xTurn) {
                        tiles[0][0].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[0][0].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[0][0].turnOn();
                }
                break;
            case 2:
                if (tiles[0][1].getUsed() != true) {
                    if (xTurn) {
                        tiles[0][1].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[0][1].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[0][1].turnOn();
                }
                break;
            case 3:
                if (tiles[0][2].getUsed() != true) {
                    if (xTurn) {
                        tiles[0][2].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[0][2].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[0][2].turnOn();
                }
                break;
            case 4:
                if (tiles[1][0].getUsed() != true) {
                    if (xTurn) {
                        tiles[1][0].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[1][0].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[1][0].turnOn();
                }
                break;
            case 5:
                if (tiles[1][1].getUsed() != true) {
                    if (xTurn) {
                        tiles[1][1].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[1][1].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[1][1].turnOn();
                }
                break;
            case 6:
                if (tiles[1][2].getUsed() != true) {
                    if (xTurn) {
                        tiles[1][2].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[1][2].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[1][2].turnOn();
                }
                break;
            case 7:
                if (tiles[2][0].getUsed() != true) {
                    if (xTurn) {
                        tiles[2][0].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[2][0].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[2][0].turnOn();
                }
                break;
            case 8:
                if (tiles[2][1].getUsed() != true) {
                    if (xTurn) {
                        tiles[2][1].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[2][1].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[2][1].turnOn();
                }
                break;
            case 9:
                if (tiles[2][2].getUsed() != true) {
                    if (xTurn) {
                        tiles[2][2].setSybmol("X");
                        xTurn = false;
                    } else {
                        tiles[2][2].setSybmol("O");
                        xTurn = true;
                    }
                    tiles[2][2].turnOn();
                }
                break;
        }
        pickTile = 0;

        if (tiles[0][0].getSymbol().equals(tiles[0][1].getSymbol())
                && tiles[0][1].getSymbol().equals(tiles[0][2].getSymbol()) && !tiles[0][0].getSymbol().equals(" ")) {
            xWon = tiles[0][0].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[1][0].getSymbol().equals(tiles[1][1].getSymbol())
                && tiles[1][1].getSymbol().equals(tiles[1][2].getSymbol()) && !tiles[1][0].getSymbol().equals(" ")) {
            xWon = tiles[1][0].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[2][0].getSymbol().equals(tiles[2][1].getSymbol())
                && tiles[2][1].getSymbol().equals(tiles[2][2].getSymbol()) && !tiles[2][0].getSymbol().equals(" ")) {
            xWon = tiles[2][0].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[0][0].getSymbol().equals(tiles[1][0].getSymbol())
                && tiles[1][0].getSymbol().equals(tiles[2][0].getSymbol()) && !tiles[0][0].getSymbol().equals(" ")) {
            xWon = tiles[0][0].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[0][1].getSymbol().equals(tiles[1][1].getSymbol())
                && tiles[1][1].getSymbol().equals(tiles[2][1].getSymbol()) && !tiles[0][1].getSymbol().equals(" ")) {
            xWon = tiles[0][1].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[0][2].getSymbol().equals(tiles[1][2].getSymbol())
                && tiles[1][2].getSymbol().equals(tiles[2][2].getSymbol()) && !tiles[0][2].getSymbol().equals(" ")) {
            xWon = tiles[0][2].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[0][0].getSymbol().equals(tiles[1][1].getSymbol())
                && tiles[1][1].getSymbol().equals(tiles[2][2].getSymbol()) && !tiles[0][0].getSymbol().equals(" ")) {
            xWon = tiles[0][0].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }
        if (tiles[0][2].getSymbol().equals(tiles[1][1].getSymbol())
                && tiles[1][1].getSymbol().equals(tiles[2][0].getSymbol()) && !tiles[0][2].getSymbol().equals(" ")) {
            xWon = tiles[0][2].getSymbol().equals("X");
            screenNum = ROUND_WIN_SCREEN;
            resetTiles();
        }

        int totalSpots = 0;
        for (int a = 0; a < tiles.length; a++) {
            for (int b = 0; b < tiles[0].length; b++) {
                if (tiles[a][b].getUsed()){
                    totalSpots++;
                }
            }
        }
        if (totalSpots == 9) {
            screenNum = TIE_SCREEN;
        }
    }

    public void checkInputs() {
        if ((mouseX > 30 && mouseX < 200 && mouseY > 30 && mouseY < 200)) {
            pickTile = 1;
        }
        if ((mouseX > 30 && mouseX < 200 && mouseY > 225 && mouseY < 425)) {
            pickTile = 4;
        }
        if ((mouseX > 30 && mouseX < 200 && mouseY > 450 && mouseY < 625)) {
            pickTile = 7;
        }
        if ((mouseX > 225 && mouseX < 425 && mouseY > 30 && mouseY < 200)) {
            pickTile = 2;
        }
        if ((mouseX > 225 && mouseX < 425 && mouseY > 225 && mouseY < 425)) {
            pickTile = 5;
        }
        if ((mouseX > 225 && mouseX < 425 && mouseY > 450 && mouseY < 625)) {
            pickTile = 8;
        }
        if ((mouseX > 450 && mouseX < 625 && mouseY > 30 && mouseY < 200)) {
            pickTile = 3;
        }
        if ((mouseX > 450 && mouseX < 625 && mouseY > 225 && mouseY < 425)) {
            pickTile = 6;
        }
        if ((mouseX > 450 && mouseX < 625 && mouseY > 450 && mouseY < 625)) {
            pickTile = 9;
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (screenNum) {
            case TITLE_SCREEN:
                this.setBackground(Color.WHITE);
                g2.setColor(Color.BLACK);
                g2.fillRect(95, 95, 460, 460);
                g2.setColor(Color.YELLOW);
                g2.fillRect(100, 100, 450, 450);

                g2.setFont(new Font("SansSerif", Font.BOLD, 150));
                g2.setColor(Color.BLUE);
                g2.drawString("TIC", 200, 255);
                g2.setColor(Color.RED);
                g2.drawString("TAC", 175, 380);
                g2.setColor(Color.BLUE);
                g2.drawString("TOE", 175, 505);

                g2.setFont(new Font("SansSerif", Font.PLAIN, 12));
                g2.setColor(Color.BLACK);
                g2.drawString("by: Luke B.", 295, 575);
                break;
            case GAME_SCREEN:
                g2.setColor(Color.BLACK);
                g2.fillRect(198, 23, 29, 604);
                g2.fillRect(423, 23, 29, 604);
                g2.fillRect(23, 198, 604, 29);
                g2.fillRect(23, 423, 604, 29);
                Color brown = new Color(102, 51, 0);
                g2.setColor(brown);
                g2.fillRect(200, 25, 25, 600);
                g2.fillRect(425, 25, 25, 600);
                g2.fillRect(25, 200, 600, 25);
                g2.fillRect(25, 425, 600, 25);
                Color lightBrown = new Color(153, 102, 0);
                g2.setColor(lightBrown);
                g2.fillRect(200, 25, 20, 595);
                g2.fillRect(425, 25, 20, 595);
                g2.fillRect(25, 200, 595, 20);
                g2.fillRect(25, 425, 595, 20);

                g2.setFont(new Font("SansSerif", Font.BOLD, 150));
                
                g2.drawImage(tiles[0][0].getImage(), 50, 60, 125, 125, null);
                g2.drawImage(tiles[1][0].getImage(), 50, 265, 125, 125, null);
                g2.drawImage(tiles[2][0].getImage(), 50, 485, 125, 125, null);
                g2.drawImage(tiles[0][1].getImage(), 265, 60, 125, 125, null);
                g2.drawImage(tiles[1][1].getImage(), 265, 265, 125, 125, null);
                g2.drawImage(tiles[2][1].getImage(), 265, 485, 125, 125, null);
                g2.drawImage(tiles[0][2].getImage(), 485, 60, 125, 125, null);
                g2.drawImage(tiles[1][2].getImage(), 485, 265, 125, 125, null);
                g2.drawImage(tiles[2][2].getImage(), 485, 485, 125, 125, null);

                checkInputs();
                play();
                break;
            case ROUND_WIN_SCREEN:
                if (xWon) {
                    this.setBackground(Color.WHITE);
                    g2.setFont(new Font("SansSerif", Font.BOLD, 150));
                    g2.setColor(Color.RED);
                    g2.drawString("X", 275, 315);
                    g2.drawString("WINS!", 105, 445);
                } else {
                    this.setBackground(Color.WHITE);
                    g2.setFont(new Font("SansSerif", Font.BOLD, 150));
                    g2.setColor(Color.BLUE);
                    g2.drawString("O", 275, 315);
                    g2.drawString("WINS!", 105, 445);
                }
                break;
            case TIE_SCREEN:
                this.setBackground(Color.WHITE);
                g2.setFont(new Font("SansSerif", Font.BOLD, 75));
                g2.setColor(Color.BLACK);
                g2.drawString("TIE GAME!", 130, 325);
                break;
        }
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (screenNum) {
            case TITLE_SCREEN:
                screenNum = GAME_SCREEN;
                break;
            case GAME_SCREEN:
                this.mouseX = e.getX();
                this.mouseY = e.getY();
                break;
            case ROUND_WIN_SCREEN:
                System.exit(0);
                break;
            case TIE_SCREEN:
                System.exit(0);
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // method not used
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // method not used
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // method not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // method not used
    }
}