package dp;

import advanced.TemplatePerformanceAlgorithm;

import java.math.BigInteger;


/**
 * http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibtable.html
 * https://medium.com/@hhccvvmm/dynamic-programming-vs-transformation-matrix-in-linear-recurrence-problems-f2067fd58230
 * https://www.dcode.fr/fibonacci-numbers
 * <p>
 * Podemos expressar a recorrencia Linear f(n) = f(n-1) + f(n-2) na tramsfoprmacao matricial abaixo
 * <p>
 * f(n) = T ^ (n-1) * F
 * <p>
 * Onde T eh uma matriz kxk e F um matrix kx1
 * <p>
 * K eh a quantidade de termos necessarios para obter f(n).
 * observado a recorrencia vemos que k = 2 -> f(n-1) + f(n-2)
 * <p>
 * Os valores da matriz F sao: {f(1) ... f(k)}
 * <p>
 * A matriz T eh preenchida da seguinte forma
 * Ela eh quase toda preenchida de zeros, exceto na (i+1)-esima coluna da respectiva linha
 * onde adicionamos 1, e a ultima linha eh preenchida com os coeficientes dos termos de recorrencia
 * <p>
 * a reccorencia de exemplo eh f(n) = f(n-1) + f(n-2) ou 1f(n-1)+1f(n-2)
 * <p>
 * 0, 1, 0 ... 0
 * 0, 0, 1 ... 0
 * <p>
 * ck, k, k-1 ... 1
 * <p>
 * No caso da funcao de fibonacci, a matriz de transformacao 'T' ficara [ [0, 1], [1, 1]] e F [1, 1]
 * <p>
 * Agora temos como calcular T (n^1) * F, com os algoritmos recursivo e iterativo abaixo, usando
 * exponentiation by squaring para acelerar o process
 */
public class MatrixTransformationFibonacci {

    private static final long LIMIT = 50000L;

    private static BigInteger fibonacci(long nth) {
        if (nth == 0) {
            return BigInteger.ZERO;
        } else if (nth < 3) {
            return BigInteger.ONE;
        }

        BigInteger[][] t = new BigInteger[][]{{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};
        BigInteger[][] base = new BigInteger[][]{{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};
        BigInteger[][] f = new BigInteger[][]{{BigInteger.ONE}, {BigInteger.ONE}};
        ;
        exp(t, base, nth - 1);
        // t * f
        multiply2x1(t, f);
        // {f[0]:fibonacci(n), f[1]:fibonacci(n+1)}
        return f[0][0];
    }

    // T ^ (n-1)
    private static void exp(BigInteger[][] target, BigInteger[][] base, long e) {
        if (e == 1)
            return;
        exp(target, base, e >> 1);
        multiply2x2(target, target);
        if ((e & 1) != 0L) {
            multiply2x2(target, base);
        }
    }

    private static BigInteger itFibonacci(long nth) {
        if (nth == 0) {
            return BigInteger.ZERO;
        } else if (nth < 3) {
            return BigInteger.ONE;
        }

        BigInteger[][] t = new BigInteger[][]{{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        // AGORA ENTENDI PORRA abaixo temos a matriz IDENTIDADE:
        // fonte de desricao de um algoritmo iterativo que utiliza a matriz identidade nxn
        // https://www.hackerearth.com/practice/notes/matrix-exponentiation-1/
        ;
        ;
        BigInteger[][] base = new BigInteger[][]
                {{BigInteger.ONE, BigInteger.ZERO}
                        , {BigInteger.ZERO, BigInteger.ONE}
                };
        BigInteger[] f = new BigInteger[]{BigInteger.ONE, BigInteger.ONE};

        // P = T ^ (n-1)
        nth -= 1;
        while (nth > 0) {
            if ((nth & 1) != 0)
                multiply2x2(base, t);
            multiply2x2(t, t);
            nth >>= 1;
        }
        // P * f
        BigInteger a = add(multiply(base[0][0], f[0]), multiply(base[0][1], f[1]));
        BigInteger b = add(multiply(base[1][0], f[0]), multiply(base[1][1], f[1]));
        f[0] = a;
        f[1] = b;
        return f[1];
    }

    private static void multiply2x2(BigInteger[][] p, BigInteger[][] q) {
        BigInteger a = add(multiply(p[0][0], (q[0][0])), multiply(p[0][1], (q[1][0])));
        BigInteger b = add(multiply(p[0][0], (q[0][1])), multiply(p[0][1], (q[1][1])));
        BigInteger c = add(multiply(p[1][0], (q[0][0])), multiply(p[1][1], (q[1][0])));
        BigInteger d = add(multiply(p[1][0], (q[0][1])), multiply(p[1][1], (q[1][1])));
        p[0][0] = a;
        p[0][1] = b;
        p[1][0] = c;
        p[1][1] = d;
    }

    private static void multiply2x1(BigInteger[][] p, BigInteger[][] q) {
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

    private static void log(long i, BigInteger r) {
        String value = r.toString();
        int length = value.length();
        System.out.printf("%d: digitos - %d - %s\n", i, length, value);
    }

    private static void log(long i, long time, BigInteger r) {
        String value = r.toString();
        int length = value.length();
        System.out.printf("%d: digitos - %d - %s\n", i, length, value);
    }

    private static void test() {
        long end = new TemplatePerformanceAlgorithm() {
            @Override
            public void operation() {
                for (long i = LIMIT - 10; i < LIMIT; i++) {
                    BigInteger r = fibonacci(i);
                    log(i, r);
                }
            }
        }.evaluation();
        System.out.printf("%.3f\n", end / 1000.0d);
        System.out.println("...................................................");
        end = new TemplatePerformanceAlgorithm() {
            @Override
            public void operation() {
                for (long i = LIMIT - 10; i < LIMIT; i++) {
                    BigInteger r = itFibonacci(i);
                    log(i, r);
                }
            }
        }.evaluation();
        System.out.printf("%.3f\n", end / 1000.0d);
    }

    private static void compareEachComputation() {
        for (long i = 0; i < LIMIT; i++) {
            final long ith = i;
            long end = new TemplatePerformanceAlgorithm() {
                @Override
                public void operation() {
                    itFibonacci(ith);
                }
            }.evaluation();

            System.out.printf("Algoritmo Iterativo: %d - %d / %.5f", i, end, end / 1000.0d);

            end = new TemplatePerformanceAlgorithm() {
                @Override
                public void operation() {
                    fibonacci(ith);
                }
            }.evaluation();
            System.out.print(" ");
            System.out.printf("Algoritmo Recursivo: %d - %d / %.5f", i, end, end / 1000.0d);
            System.out.println("\n");
        }
    }


    private static boolean compare() {
        for (long i = 0; i < LIMIT; i++) {
            if (itFibonacci(i).compareTo(fibonacci(i)) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        compareEachComputation();
    }

}
