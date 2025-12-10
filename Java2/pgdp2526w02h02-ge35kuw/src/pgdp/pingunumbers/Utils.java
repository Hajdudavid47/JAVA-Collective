package pgdp.pingunumbers;

//This class contains a helper method to reduce the PinguNumbers.
//You don't need to change anything.

public class Utils {
    public static void reduce(MixedPinguNumber mixedPinguNumber) {
        int ggt = ggt(Math.abs(mixedPinguNumber.numerator), Math.abs(mixedPinguNumber.denominator));

        mixedPinguNumber.numerator /= ggt;
        mixedPinguNumber.denominator /= ggt;

        // Denominator is always positive.
        if (mixedPinguNumber.denominator < 0) {
            mixedPinguNumber.numerator = -mixedPinguNumber.numerator;
            mixedPinguNumber.denominator = -mixedPinguNumber.denominator;
        }
    }

    private static int ggt(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}