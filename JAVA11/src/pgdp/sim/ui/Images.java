package pgdp.sim.ui;

import pgdp.sim.CellSymbol;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Images {
    static final CellSymbol[] symbols =
            new CellSymbol[]{CellSymbol.PLANT, CellSymbol.HAMSTER, CellSymbol.PINGU, CellSymbol.WOLF};
    static Image[] images;

    static {
        for (int i = 0; i < 4; i++)
            if (symbols[i].id() != i) throw new RuntimeException("Expected " + symbols[i] + " to have id " + i);
        try {
            images = load(Path.of(
                            Objects.requireNonNull(Images.class.getClassLoader().getResource("pgdp/sim/PINGU.png")).toURI())
                    .getParent());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static Image[] load(Path base) throws IOException {
        images = new Image[4];
        for (int i = 0; i < 4; i++) {
            images[i] = ImageIO.read(Files.newInputStream(base.resolve(symbols[i].toString() + ".png")))
                    .getScaledInstance(32, 32, Image.SCALE_DEFAULT);
        }
        return images;
    }

    static Image getImage(CellSymbol symbol) {
        return images[symbol.id()];
    }

}
