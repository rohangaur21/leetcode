package misc;

import java.util.Date;

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