package practice2021.thread.demo1;

import java.util.HashMap;
import java.util.Map;

public class Practice {

    // students: A, B, C
    // A [98, 65]
    // B [67, 99]
    // C [17, 45]

    // 2 subjects: S1, S2

    // S1: (A, 98), S2: (B, 99)

    public static void main(String[] args) {

        char[] studentNames = {'A', 'B', 'C'};
        String[] subjects = {"S1", "S2"};
        int[][] studentsMarksMapping = {{98, 65},
                {67, 99},
                {17, 45}};

        Map<String, Score> result = new HashMap<>();

        for (int j = 0; j < subjects.length; j++) {
            int max = -1;
            char studentName = '\0';
            for (int i = 0; i < studentNames.length; i++) {
                if (studentsMarksMapping[i][j] > max) {
                    max = studentsMarksMapping[i][j];
                    studentName = studentNames[i];
                }
            }
            result.put(subjects[j], new Score(studentName, max));
        }

        for (Map.Entry<String, Score> score: result.entrySet()) {
            System.out.println(score.getKey() + ": " + score.getValue().studentName + ", " + score.getValue().score);
        }
    }
}

// j = 0, i = 0, max = 98,A
// j = 0, i = 0, max = 98,A

class Score {
    char studentName;
    int score;

    Score (char studentName, int score) {
        this.studentName = studentName;
        this.score = score;
    }
}
