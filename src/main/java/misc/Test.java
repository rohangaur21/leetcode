package misc;

import java.util.*;

public class Test {

    public boolean getValue(Demo d) {
        d.setName("rohan");
        return true;
    }

//    public static void main(String[] args) {
//        Demo d = new Demo();
//        Test t = new Test();
//        System.out.println(t.getValue(d));
//        System.out.println(d.getName());
//    }

    public static void main(String[] args) {

        Date date1 = new Date();
        Date date2 = new Date();

        System.out.println("date1 : " + date1.getTime());
        System.out.println("date2 : " + date2.getTime());

        if (date1.after(date2)) {
            System.out.println("Date1 is after Date2");
        }

        if (date1.before(date2)) {
            System.out.println("Date1 is before Date2");
        }

        if (date1.equals(date2)) {
            System.out.println("Date1 is equal Date2");
        }


        System.out.println("-------------------------");
        int i = 010;
        int j = 07;
        System.out.println(i+""+j);

        System.out.println("-------------------------");
        int x=0;
        int y=0;
        for(int z = 0; z<5; z++){
            if((++x > 2) && (++y > 2))
                x++;
        }
        System.out.println(x+""+y);

        System.out.println("-------------------------");
        int l = 5;
                int m=6;
                String s1="7";
        System.out.println(l+m+s1);


        String [] c = {"Bangalore", "Pune","San Fr", "New Y"};
        Arrays.sort(c, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.binarySearch(c, "New Y"));

        int mm = 0x000F;
        int vv = 0x2222;
        /* System.out.printl /* n(vv&mm); *** */
        System.out.println();

//        new HashMap<>().get
     }


}

class Demo {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}