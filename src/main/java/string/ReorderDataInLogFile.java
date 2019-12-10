package string;

import java.util.*;

public class ReorderDataInLogFile {
    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;

        List<String> letterLS = new ArrayList<>();
        List<String> digitLS = new ArrayList<>();
        String[] results = new String[len];
        for (String log : logs) {
            boolean isDigit = Character.isDigit(log.charAt(log.indexOf(" ") + 1));
            if (isDigit) {
                digitLS.add(log);
            } else {
                letterLS.add(log);
            }
        }
        Collections.sort(letterLS, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String ss1 = s1.substring(s1.indexOf(" ") + 1);
                String ss2 = s2.substring(s2.indexOf(" ") + 1);
                int compare = ss1.compareTo(ss2);
                if(compare == 0){
                     ss1 = s1.substring(2, s1.indexOf(" "));
                    ss2 = s2.substring(2, s2.indexOf(" ") );
                    return Integer.valueOf(ss1) - Integer.valueOf(ss2);
                }
                return ss1.compareTo(ss2);
            }
        });

        letterLS.addAll(digitLS);
        return letterLS.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReorderDataInLogFile().reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }
}
