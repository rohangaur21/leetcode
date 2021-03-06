package sort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort {
    int iterationCount = 0;

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        System.out.println(ss.getSortedList(Arrays.asList(3, 5, 2, 8, 5, 1, 0)));

    }

    private List<Integer> getSortedList(List<Integer> integerList) {
        int temp = 0;
        for (int i = 0; i < integerList.size(); i++) {
            for (int j = i + 1; j < integerList.size(); j++) {
                if (integerList.get(i) > integerList.get(j)) {
                    swap(integerList, i, j);
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