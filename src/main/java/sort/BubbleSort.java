package sort;

public class BubbleSort {
}

    private List<Integer> getSortedList(List<Integer> integerList) {
        int temp = 0;
        int size = integerList.size();
        boolean isSwapped = false;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (integerList.get(j - 1) > integerList.get(j)) {
                    swap(integerList, j - 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
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
