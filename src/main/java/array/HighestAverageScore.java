package array;

public class HighestAverageScore {
    public static void main(String[] args) {
        String students[][] = {{"jerry", "65"}, {"bob", "91"}, {"jerry", "23"}, {"Eric", "83"}};
        printHighestAvgScore(students);
    }

    private static void printHighestAvgScore(String[][] students) {
        if (students == null || students.length == 0 || students[0].length == 0) {
            System.out.println("Invalid Data");
        }

        int total = 0;
        for (int i = 0; i < students.length; i++) {
            total += Integer.parseInt(students[i][1]);
        }
        int average = total / students.length;
        for (int i = 0; i < students.length; i++) {
            if (Integer.parseInt(students[i][1]) > average) {
                System.out.println("Student " + students[i][0]);
            }
        }

    }
}
