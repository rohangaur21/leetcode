import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(Arrays.asList(1));

        List<Integer> list = null;
        for (int i = 1; i <= rowIndex; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < ans.get(i - 1).size() - 1; j++) {
                list.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1));
            }
            list.add(1);
            ans.add(list);
        }
        return ans.get(rowIndex);
    }
}
