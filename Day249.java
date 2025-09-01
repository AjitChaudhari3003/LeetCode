// 1792. Maximum Average Pass Ratio
// There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.
// You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.
// The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.
// Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.
// Example 1:
// Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
// Output: 0.78333
// Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.


class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[0] < b[0]) return 1;
                if (a[0] > b[0]) return -1;
                return 0;
            }
        });

        for (int i = 0; i < classes.length; i++) {
            double pass = classes[i][0];
            double total = classes[i][1];
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
        }

        while (extraStudents > 0) {
            double[] top = pq.poll();
            double pass = top[1] + 1;
            double total = top[2] + 1;
            double inc = (pass + 1.0) / (total + 1.0) - pass / total;
            pq.offer(new double[]{inc, pass, total});
            extraStudents--;
        }

        double sum = 0.0;
        Object[] arr = pq.toArray();
        for (int i = 0; i < arr.length; i++) {
            double[] c = (double[]) arr[i];
            sum += c[1] / c[2];
        }

        return sum / classes.length;
    }
}
