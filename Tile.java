import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
    
    private String symbol;
    private boolean used;
    private BufferedImage image;
    public BufferedImage x;
    public BufferedImage o;

    public Tile(String symbol, boolean used) {
        this.symbol = symbol;
        this.used = used;
        loadImages();
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean getUsed() {
        return used;
    }

    public void setSybmol(String symbol) {
        this.symbol = symbol;
        if (symbol.equals("X")) {
            this.image = x;
        }
        if (symbol.equals("O")) {
            this.image = o;
        }
    }

    public void turnOn() {
        this.used = true;
    }

    public void reset() {
        this.used = false;
        this.symbol = " ";
    }

    public void loadImages() {
        this.x = null;
        try {
            x = ImageIO.read(new File("res/x.png"));
        } catch (IOException e) {
            System.out.println("Can't locate x.png");
            e.getStackTrace();
        }
        this.o = null;
        try {
            o = ImageIO.read(new File("res/o.png"));
        } catch (IOException e) {
            System.out.println("Can't locate o.png");
            e.getStackTrace();
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }
}
