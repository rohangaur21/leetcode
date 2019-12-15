import java.util.ArrayList;
import java.util.List;

public class ListAllIPAddress {
    public List<String> listAllIPAddress(String s) {
        List<String> ips = new ArrayList<>();
        helper(ips, s, "", 0);
        return ips;
    }

    public void helper(List<String> ips, String string, String temp, int count) {
        if (count == 4) {
            if (string.length() == 0)
                ips.add(temp.substring(1));
            return;
        }
        for (int index = 1; index <= 3; index++) {
            if (string.length() < index)
                continue;
            String str = string.substring(0, index);
            int val = Integer.parseInt(str);
            if (val > 255 || str.length() != String.valueOf(val).length())
                continue;
            helper(ips, string.substring(index), temp + "." + val, count + 1);
        }
    }


    public static void main(String[] args) {
        ListAllIPAddress o = new ListAllIPAddress();
        System.out.println(o.listAllIPAddress(""));
        System.out.println(o.listAllIPAddress("0100"));
        System.out.println(o.listAllIPAddress("00000"));
        System.out.println(o.listAllIPAddress("25535511135"));
        System.out.println(o.listAllIPAddress("2552551135"));
    }
}
