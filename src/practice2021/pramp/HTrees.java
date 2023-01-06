package practice2021.pramp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HTrees {

    public static void main(String[] args) {

        drawHTree(2, 10, 5, 5);
    }

    private static void drawHTree(int depth, double length, int x, int y) {

        int d = 0;

        Deque<double[]> queue = new ArrayDeque<>();
        double[] point = new double[2];
        point[0] = x;
        point[1] = y;
        queue.add(point);

        while (d < depth) {

            int size = queue.size();
            System.out.println("Depth - " + d);

            while (size != 0) {
                double[] removed = queue.remove();
                printAllCoordinates(removed, length, queue);

                size--;
            }

            d++;
            length = (double) length/2;
        }
    }

    private static void printAllCoordinates(double[] center, double length, Deque<double[]> queue) {

        double l1_x1 = center[0];
        double l1_y1 = center[1] - length/2;

        double l1_x2 = center[0];
        double l1_y2 = center[1] + length/2;

        System.out.println("Horizontal line - (" + l1_x1 + ", " + l1_y1 + "), (" + l1_x2 + ", " + l1_y2 + ")");

        double l2_x1 = l1_x1 + length/2;
        double l2_y1 = l1_y1;
        double[] line2_1 = new double[2];
        line2_1[0] = l2_x1;
        line2_1[1] = l2_y1;
        queue.add(line2_1);

        double l2_x2 = l1_x1 - length/2;
        double l2_y2 = l1_y1;
        double[] line2_2 = new double[2];
        line2_2[0] = l2_x2;
        line2_2[1] = l2_y2;
        queue.add(line2_2);

        System.out.println("Vertical line 1 - (" + l2_x1 + ", " + l2_y1 + "), (" + l2_x2 + ", " + l2_y2 + ")");

        double l3_x1 = l1_x2 + length/2;
        double l3_y1 = l1_y2;
        double[] line3_1 = new double[2];
        line3_1[0] = l3_x1;
        line3_1[1] = l3_y1;
        queue.add(line3_1);

        double l3_x2 = l1_x2 - length/2;
        double l3_y2 = l1_y2;
        double[] line3_2 = new double[2];
        line3_2[0] = l3_x2;
        line3_2[1] = l3_y2;
        queue.add(line3_2);

        System.out.println("Vertical line 2 - (" + l3_x1 + ", " + l3_y1 + "), (" + l3_x2 + ", " + l3_y2 + ")");
    }
}

// -4, -4 : -4, -124, 8 : 12, 84, 12 : 4, 412, 12 : 12, 44, -8 : 12, -84, -4 : 4, -1212, -4 : 12, -12
