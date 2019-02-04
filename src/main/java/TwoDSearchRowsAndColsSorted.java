public class TwoDSearchRowsAndColsSorted {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;

        // Iterate from top right in zigzag fashion
        while (col >= 0 && row <= matrix.length - 1) {
            System.out.println(row+"___"+col+"_@_"+matrix[row][col]);
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
