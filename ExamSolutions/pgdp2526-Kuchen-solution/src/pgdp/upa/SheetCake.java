package pgdp.upa;

public class SheetCake {

    private final int[][] tastiness;

    public SheetCake(int[][] tastiness) {
        this.tastiness = tastiness;
    }

    // TODO Aufgabe 6 - 2pt
    public double averageTastiness() {
        int totalTaste = 0;
        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < height(); y++) {
                totalTaste += tastiness[x][y];
            }
        }
        return (double) totalTaste / (width() * height());
    }

    // TODO Aufgabe 7 - 3pt - 2pt for base logic - 1pt for out of bounds logic
    public int tastinessAround(int x, int y, int size) {
        int halfSize = size / 2;

        int start_x = max(0, x - halfSize);
        int end_x = min(x + halfSize + 1, width());

        int start_y = max(0, y - halfSize);
        int end_y = min(y + halfSize + 1, height());

        int taste = 0;

        for (int xi = start_x; xi < end_x; xi++) {
            for (int yi = start_y; yi < end_y; yi++) {
                taste += tastiness[xi][yi];
            }
        }
        return taste;
    }

    private int width() {
        return tastiness.length;
    }

    private int height() {
        return tastiness[0].length;
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private int min(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
}
