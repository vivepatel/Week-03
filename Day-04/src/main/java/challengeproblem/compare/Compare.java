package challengeproblem.compare;

public class Compare {
    public static void main(String[] args) {
        long startTime, endTime;

        // Measure time for StringBuffer
        StringBuffer buffer = new StringBuffer();
        startTime = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            buffer.append("hello");
        }
        endTime = System.nanoTime();
        long bufferTime = endTime - startTime;

        // Measure time for StringBuilder
        StringBuilder builder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            builder.append("hello");
        }
        endTime = System.nanoTime();
        long builderTime = endTime - startTime;

        // Output the results
        System.out.println("StringBuffer " + bufferTime + " ns");
        System.out.println("StringBuilder " + builderTime + " ns");
    }
}
