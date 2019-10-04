package sort;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    int iterationCount = 0;

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        System.out.println(is.getSortedList(Arrays.asList(3, 5, 2, 8, 5, 1, 0)));

    }

    private List<Integer> getSortedList(List<Integer> integerList) {
        int temp = 0;
        int size = integerList.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (integerList.get(j - 1) > integerList.get(j)) {
                    swap(integerList, j - 1, j);
                    iterationCount++;
                }
            }
        }
        return integerList;
    }

    private void swap(List<Integer> list, int pos1, int pos2) {
        int temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
        iterationCount++;
    }
}