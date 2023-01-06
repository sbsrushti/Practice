package practice2021.ctci.recursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StackBoxes {

    public static void main(String[] args) {

        List<Box> boxes = new ArrayList<>();
        Box b1 = new Box(1, 10, 10, 10);
        Box b2 = new Box(2, 15, 5, 10);
        Box b3 = new Box(3, 12, 10, 10);
        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);

        boxes.sort(new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return b1.h - b2.h;
            }
        });

        List<Box> temp = new ArrayList<>();
        List<Box> res = new ArrayList<>();
        findAllCombs(boxes, temp, res, 0);
        for (Box b: res) {
            System.out.print(b.id + ", ");
        }
    }

    private static void findAllCombs(List<Box> boxes, List<Box> temp, List<Box> res, int start) {
        for (int i = start; i < boxes.size(); i++) {
            Box child = boxes.get(i);
            if (temp.size() >= 1) {
                Box parent = temp.get(temp.size()-1);
                if (child.d >= parent.d && child.w >= parent.w) {
                    List<Box> temp_new = new ArrayList<>(temp);
                    temp_new.add(boxes.get(i));
                    findAllCombs(boxes, temp_new, res, i+1);
                }
            } else {
                List<Box> temp_new = new ArrayList<>(temp);
                temp_new.add(boxes.get(i));
                findAllCombs(boxes, temp_new, res, i+1);
            }
        }
        if (temp.size() > res.size()) {
            res.clear();
            res.addAll(temp);
        }
    }
}