package ds;

// DONE
// https://www.hackerrank.com/challenges/java-1d-array/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1DArray {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static int[] readInts(String delimiter) throws IOException {
        String[] str = reader.readLine().split(delimiter);
        int[] numbers = new int[str.length];
        int i = 0;
        while (i < str.length) {
            numbers[i] = Integer.parseInt(str[i]);
            i++;
        }
        return numbers;
    }

    private static boolean naiveSolution(int leap, int[] game) {
        int i = 0;
        int limit = game.length;
        int [] stack = new int[game.length + 1];
        int counter = 0;
        boolean [] flag = new boolean[game.length];
        while (i < limit) {
            if (i == limit - 1)
                return true;
            int jump = i + leap;
            if (jump >= limit) {
                break;
            } else if (jump > 0 && game[jump] == 0  && !flag[jump])  {
                i = jump;
                counter++;
                stack[counter] = i;

            } else if (i+1 < limit && game[i+1] == 0 && !flag[i+1]) {
                i += 1;
                counter++;
                stack[counter] = i;
            } else if (i-1 >= 0 && game[i-1] == 0 && !flag[i-1]) {
                i -= 1;
                counter++;
                stack[counter] = i;
            }
            else {
                if (counter-1 < 0)
                    return false;
                counter--;
                i = stack[counter];
            }
            flag[i] = true;
        }
        return counter != game.length;
    }

    private static boolean canWin(int leap, int[] game) {
        return naiveSolution(leap, game);
    }

    private static void solver() throws IOException {
        int queries = readInt();
        StringBuilder sb = new StringBuilder();
        while (queries > 0) {
            int[] pair = readInts(" ");
            int[] numbers = readInts(" ");
            sb.append(String.format("%s\n", canWin(pair[1], numbers) ? "YES" : "NO"));
            queries--;
        }
        System.out.println(sb.toString());
        /*
        IO.writeOutput(String.format("raw/%s"
                , Problem1DArray.class.getSimpleName().toLowerCase()), sb.toString());
                */
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
