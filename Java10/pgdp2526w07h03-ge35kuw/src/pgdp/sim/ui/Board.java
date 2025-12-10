package pgdp.sim.ui;

import pgdp.sim.RandomGenerator;
import pgdp.sim.SimConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Board extends JComponent {
    private static final long serialVersionUID = -6683080396973648829L;
    private final Object simulation;
    private final int width;
    private final int height;

    public Board() throws Throwable {
        this.width = SimConfig.width;
        this.height = SimConfig.height;
        var cellArray = Proxy.newCellArray(width * height);
        for (int i = 0; i < SimConfig.numInitialPlant; i++)
            Proxy.addPlant(cellArray, RandomGenerator.nextInt(width * height));
        for (int i = 0; i < SimConfig.numInitialHamster; i++)
            Proxy.addHamster(cellArray, RandomGenerator.nextInt(width * height));
        for (int i = 0; i < SimConfig.numInitialPingu; i++)
            Proxy.addPingu(cellArray, RandomGenerator.nextInt(width * height));
        for (int i = 0; i < SimConfig.numInitialWolf; i++)
            Proxy.addWolf(cellArray, RandomGenerator.nextInt(width * height));
        simulation = Proxy.newSimulation(cellArray, width, height);
    }

    public void tick() throws Throwable {
        Proxy.tick(simulation);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, width * 32, height * 32);
        g.setColor(getForeground());
        g.drawRect(0, 0, width * 32, height * 32);
        try {
            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++) {
                    var cells = Proxy.getCells(simulation);
                    var cell = cells[y * width + x];
                    if (cell != null) {
                        g.drawImage(Images.getImage(Proxy.getSymbol(cell)), x * 32,
                                y * 32,
                                (i, flags, xa, ya, w, h) -> (flags & ImageObserver.ALLBITS) != ImageObserver.ALLBITS
                        );
                    }
                }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
