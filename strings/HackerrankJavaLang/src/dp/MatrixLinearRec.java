package dp;

import java.math.BigInteger;


/**
 * https://medium.com/@hhccvvmm/dynamic-programming-vs-transformation-matrix-in-linear-recurrence-problems-f2067fd58230
 *
 * Podemos expressar a recorrencia Linear f(n) = f(n-1) + f(n-2) na tramsfoprmacao matricial abaixo
 *
 * f(n) = T ^ (n-1) * F
 *
 * _
 */
public class MatrixLinearRec {

    private static BigInteger fibonacci(long nth) {
        if (nth == 1) {
            return BigInteger.ZERO;
        }
        else if(nth < 2) {
            return BigInteger.ONE;
        }

        BigInteger[][] t = new BigInteger[][] {{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};
        BigInteger[][] base = new BigInteger[][] {{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};
        BigInteger[][] f = new BigInteger[][] {{BigInteger.ONE}, {BigInteger.ONE}};;
        exp(t, base,nth-1);
        // t * f
        multiply2x1(t, f);
        // f[0] = fibonacci(n); f[1] = fibonacci(n+1)
        return f[0][0];
    }

    // T ^ (n-1)
    private static void exp(BigInteger [][] target, BigInteger [][] base, long e) {
        if(e == 1)
            return;
        exp(target, base, e >> 1);
        multiply2x2(target, target);
        if ((e & 1) != 0L) {
            multiply2x2(target, base);
        }
    }

    private static void multiply2x2(BigInteger [][] p, BigInteger [][] q) {
        BigInteger a = add(multiply(p[0][0], (q[0][0])), multiply(p[0][1], (q[1][0])));
        BigInteger b = add(multiply(p[0][0], (q[0][1])), multiply(p[0][1], (q[1][1])));
        BigInteger c = add(multiply(p[1][0], (q[0][0])), multiply(p[1][1], (q[1][0])));
        BigInteger d = add(multiply(p[1][0], (q[0][1])), multiply(p[1][1], (q[1][1])));
        p[0][0] = a;
        p[0][1] = b;
        p[1][0] = c;
        p[1][1] = d;
    }

    private static void multiply2x1(BigInteger [][] p, BigInteger [][] q) {
        BigInteger a = add(multiply(p[0][0], (q[0][0])), multiply(p[0][1], (q[1][0])));
        BigInteger b = add(multiply(p[1][0], (q[0][0])), multiply(p[1][1], (q[1][0])));
        q[0][0] = a;
        q[1][0] = b;
    }

    private static BigInteger multiply(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    private static BigInteger add(BigInteger p, BigInteger q) {
        return p.add(q);
    }

    public static void main(String[] args) {
        for (long i = 3; i < 400; i++) {
            System.out.printf("%d %s\n", i, fibonacci(i).toString());
        }
    }

}
