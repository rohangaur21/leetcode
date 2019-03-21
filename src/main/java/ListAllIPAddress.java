import java.util.ArrayList;
import java.util.List;

public class ListAllIPAddress {
    public List<String> listAllIPAddress(String s) {
        List<String> ips = new ArrayList<>();
        helper(ips, s, "", 0);
        return ips;
    }

    public void helper(List<String> ips, String s, String temp, int count) {
        if (count == 4) {
            if (s.length() == 0)
                ips.add(temp.substring(1));
            return;
        }
        for (int index = 1; index <= 3; index++) {
            if (s.length() < index)
                continue;
            int val = Integer.valueOf(s.substring(0, index));
            if (val > 255 || s.substring(0, index).length() != String.valueOf(val).length())
                continue;
            helper(ips, s.substring(index), temp + "." + val, count + 1);
        }
    }


    public static void main(String[] args) {
        ListAllIPAddress o = new ListAllIPAddress();
        System.out.println(o.listAllIPAddress("0000"));
        System.out.println(o.listAllIPAddress("00000"));
        System.out.println(o.listAllIPAddress("25525511135"));
    }
}
