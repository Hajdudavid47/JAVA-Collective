package pgdp.upa;

public class Cake {

    private String flavor;
    private int numberOfPieces;

    public Cake(String flavor, int numberOfPieces) {
        this.flavor = flavor;
        this.numberOfPieces = numberOfPieces;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    // TODO Aufgabe 1 - 2pt
    public int practicality() {
        int result = 0;
        for (int i = 1; i < numberOfPieces + 1; i++) {
            if (numberOfPieces % i == 0) {
                result++;
            }
        }
        return result;
    }

    // TODO Aufgabe 2 - 1pt
    public int waste(int numberEaters) {
        int remainingPieces = numberOfPieces % numberEaters;
        return (int) (100.0 * remainingPieces / (double) numberOfPieces);
    }

    @Override
    public String toString() {
        return "Cake[" + "flavor=" + this.flavor + ", " + "pieces=" + this.numberOfPieces + "]";
    }
}
