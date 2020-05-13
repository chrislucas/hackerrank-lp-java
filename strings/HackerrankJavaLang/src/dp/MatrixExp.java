package dp;

/**
 * https://www.hackerearth.com/practice/notes/matrix-exponentiation-1/
 */

public class MatrixExp {

    // (value >> (nth - 1) & 1) > 0 shift right
    private static boolean nthBitSet(int value, int nth) {
        return (value & (1 << (nth - 1))) > 0;
    }

    private static void testNthBitSet() {
        int nth = 3;
        for (int i = 0; i < (1 << 8); i++) {
            boolean isSet = nthBitSet(i, nth);
            System.out.printf("%d: %d-nth bit %s\n", i, nth, isSet ? "is set" : "is not set");
        }
    }

    public static void main(String[] args) {
        testNthBitSet();
    }
}
