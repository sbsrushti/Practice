package practice2021.ctci.recursionAndDynamicProgramming.refresher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StackBoxes {

    public static void main(String[] args) {

        Box box1 = new Box(15, 20, 8);
        Box box2 = new Box(12, 10, 10);
        Box box3 = new Box(10, 10, 9);

        List<Box> boxes = new ArrayList<>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);

        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return box2.h - box1.h;
            }
        });

        int[] res = new int[boxes.size()];
        res[0] = boxes.get(0).h;
        int globalMax = res[0];

        for (int i = 1; i < res.length; i++) {

            Box current = boxes.get(i);
            int max = 0;

            for (int j = 0; j < i; j++) {
                Box temp = boxes.get(j);
                if (temp.d >= current.d && temp.w >= current.w) {
                    if (max < res[j]) {
                        max = res[j];
                    }
                }
            }
            res[i] = max + current.h;

            if (globalMax < res[i])
                globalMax = res[i];
        }

        System.out.println(globalMax);
    }
}
