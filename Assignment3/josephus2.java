import java.util.*;

class JosephusQueue {
    public static void main(String[] args) {
        int position = Integer.parseInt(args[0]);
        int count = Integer.parseInt(args[1]);

        printJosephusPositions(count, position);
    }

    public static void printJosephusPositions(int count, int position) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < count; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            // The eliminated position counted from 1.
            for (int i = 1; i <= position; i++) {
                int eliminatedPosition = queue.remove();

                if (i == position) {
                    System.out.print(eliminatedPosition + " ");
                    break;
                }

                queue.add(eliminatedPosition);
            }
        }
    }
}