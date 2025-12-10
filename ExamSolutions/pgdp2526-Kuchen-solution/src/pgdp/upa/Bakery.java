package pgdp.upa;

public class Bakery {

    private Cake[] cakes;

    public Bakery(Cake[] cakes) {
        this.cakes = cakes;
    }

    public Cake[] getCakes() {
        return cakes;
    }

    public void setCakes(Cake[] cakes) {
        this.cakes = cakes;
    }

    // TODO Aufgabe 3 - 2pt
    public Cake findMostPracticalCake() {
        Cake mostPracticalCake = null;
        int highestPracticality = -1;
        for (Cake c : cakes) {
            int practicality = c.practicality();
            if (practicality > highestPracticality) {
                highestPracticality = practicality;
                mostPracticalCake = c;
            }
        }
        return mostPracticalCake;
    }

    // TODO Aufgabe 4 - 3pt - 2pt for base case - 1pt for waste1 = waste2
    public Cake findBetterCake(Cake option1, Cake option2, int numberOfEaters) {
        int waste1 = option1.waste(numberOfEaters);
        int waste2 = option2.waste(numberOfEaters);

        if (waste1 == waste2) {
            if (option1.getNumberOfPieces() < option2.getNumberOfPieces()) {
                return option1;
            } else {
                return option2;
            }
        } else if (waste1 < waste2) {
            return option1;
        } else {
            return option2;
        }
    }

    // TODO Aufgabe 5 - 2pt
    public Cake findCakeFor(int numberOfEaters) {
        if (cakes.length == 0) {
            return null;
        }
        Cake bestCake = cakes[0];
        for (Cake c : cakes) {
            bestCake = findBetterCake(bestCake, c, numberOfEaters);
        }
        return bestCake;
    }
}
