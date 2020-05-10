package advanced;

public abstract class TemplatePerformanceAlgorithm {

    public abstract void operation();

    public long evaluation() {
        long start = System.currentTimeMillis();
        operation();
        return System.currentTimeMillis() - start;
    }
}
