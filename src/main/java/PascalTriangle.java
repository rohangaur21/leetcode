import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        List<Integer> list = null;
        List<Integer> temp = null;
        for (int idx = 1; idx <= rowIndex; idx++) {
            list = new ArrayList<>(Arrays.asList(1));
            temp = ans.get(idx - 1);
            for (int j = 0; j < temp.size() - 1; j++) {
                list.add(temp.get(j) + temp.get(j + 1));
            }
            list.add(1);
            ans.add(list);
        }

        for (List<Integer> l : ans) {
            System.out.println(l.toString());
        }

        return ans.get(rowIndex);
    }

    public static void main(String[] args) {
        new PascalTriangle().getRow(5);
    }
}
