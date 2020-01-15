package array;

public class RobotGraphicalPosition {
    public static void main(String[] args) {
        String move = "UDDLLRUUUDUURUDDUULLDRRRR";
        finalPosition(move);
    }

    static void finalPosition(String direction) {
        int countUp = 0, countDown = 0;
        int countLeft = 0, countRight = 0;

        for (int i = 0; i < direction.length(); i++) {
            if (direction.charAt(i) == 'U')
                countUp++;

            else if (direction.charAt(i) == 'D')
                countDown++;

            else if (direction.charAt(i) == 'L')
                countLeft++;

            else if (direction.charAt(i) == 'R')
                countRight++;
        }

        // required final position of robot
        System.out.println("Final Position: ("
                + (countRight - countLeft) + ", "
                + (countUp - countDown) + ")");
    }
}
