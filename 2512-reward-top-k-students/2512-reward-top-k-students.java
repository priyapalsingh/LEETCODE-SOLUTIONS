import java.util.*;

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // Fast lookup ke liye HashSets banao (O(1) search)
        Set<String> posSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negSet = new HashSet<>(Arrays.asList(negative_feedback));

        int n = report.length;
        // int[2] array store karega: [student_id, score]
        int[][] students = new int[n][2];

        for (int i = 0; i < n; i++) {
            int score = 0;
            String[] words = report[i].split(" ");
            
            for (String word : words) {
                if (posSet.contains(word)) {
                    score += 3;
                } else if (negSet.contains(word)) {
                    score -= 1;
                }
            }
            
            students[i][0] = student_id[i];
            students[i][1] = score;
        }

        // Custom Sorting Logic:
        // 1. Score ke basis par descending (bada score pehle)
        // 2. Agar score same hai, toh Student ID ke basis par ascending (chhota ID pehle)
        Arrays.sort(students, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1]; // Higher score first
            }
            return a[0] - b[0];     // Lower ID first
        });

        // Top K students ke IDs collect karo
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(students[i][0]);
        }

        return result;
    }
}