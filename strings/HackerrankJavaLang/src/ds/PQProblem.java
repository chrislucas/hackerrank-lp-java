package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * DONE
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 * */
public class PQProblem {

    private static class Student implements Comparable<Student> {
        int id;
        String name;
        double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        private static final double EPS =10E-6;
        private boolean almostEquals(double p, double q) {
            return Math.abs(p - q) < EPS;
        }

        @Override
        public int compareTo(Student b) {
            int compareCgpa = Double.compare(b.cgpa, this.cgpa);
            if (compareCgpa == 0) {
                if (this.name.equals(b.name))
                    return this.id - b.id;
                else
                    return this.name.compareTo(b.name);
            }
            return compareCgpa;
        }

        public String getName() {
            return name;
        }
    }

    static class Priorities {
        public List<Student> getStudents(List<String> events) {
            List<Student> students = new ArrayList<>();
            PriorityQueue<Student> pq = new PriorityQueue<>();
            for (String event : events) {
                String [] data = event.split(" ");
                if (data.length > 1) {
                    pq.add(new Student(Integer.parseInt(data[3]), data[1], Double.parseDouble(data[2])));
                }
                else {
                    pq.poll();
                }
            }

            while (!pq.isEmpty()) {
                students.add(pq.poll());
            }
            return students;
        }
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private final static Priorities priorities = new Priorities();

    private static void solver() throws IOException {
        int lines = Integer.parseInt(reader.readLine());
        List<String> events = new ArrayList<>();
        while (lines>0) {
            events.add(reader.readLine());
            lines--;
        }
        priorities.getStudents(events);
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
