package sort;

public class InsertionSort {
}

    private List<Integer> getSortedList(List<Integer> integerList) {
        int temp = 0;
        int size = integerList.size();
        for (int i = 0; i < size -1; i++) {
            for (int j = i + 1; j >0; j--) {
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
