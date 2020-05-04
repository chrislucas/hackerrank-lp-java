package strings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class IO {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    private static String readLine() throws IOException {
        return reader.readLine();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static int[] readInts(String delimiter) throws IOException {
        StringTokenizer tk = new StringTokenizer(reader.readLine(), delimiter);
        int [] numbers = new int[tk.countTokens()];
        for (int i = 0; tk.hasMoreElements() && i <tk.countTokens() ; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }
        return numbers;
    }

    private static int[] readInts2(String delimiter) throws IOException {
        String [] str = reader.readLine().split(delimiter);
        int [] numbers = new int[str.length];
        int i = 0;
        while (i < str.length) {
            numbers[i] = Integer.parseInt(str[i]);
            i++;
        }
        return numbers;
    }

    public static void writeOutput(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename, false);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(data);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
