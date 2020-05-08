package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * DONE
 * */

public class JavaComparatorProblem {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    static class Checker<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            Player p = (Player) o1;
            Player q = (Player) o2;
            return p.score == q.score ? p.name.compareTo(q.name) : q.score - p.score;
        }
    }


    private static final Comparator<Player> checker = (p, q) ->
            p.score == q.score ? p.name.compareTo(q.name) : q.score - p.score;


    private static void solver() throws IOException {
        int cases = Integer.parseInt(reader.readLine());
        Player[] players = new Player[cases];
        for (int i=0; i<cases; i++) {
            String [] line = reader.readLine().split(" ");
            players[i] = new Player(line[0], Integer.parseInt(line[1]));
        }
        Arrays.sort(players, new Checker());
        for (Player value : players) {
            System.out.printf("%s %s\n", value.name, value.score);
        }
    }

    public static void main(String[] args) throws IOException {
        solver();
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
