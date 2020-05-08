package ds;

class Printer<T> {
    //Write your code here
    public void printArray(T [] array) {
        for(T data : array) {
            System.out.println(data);
        }
    }
}