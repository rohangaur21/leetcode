package misc;

import java.util.Arrays;


//https://stackoverflow.com/questions/43950000/hackerrank-buying-show-tickets-optimization


//        Here is my idea to solve this problem, first take a look at the line. We divide people in 2 groups:
//        1/ Those stands before pth person.
//        2/ Those stands behind pth perosn.
//        Let's call times - the number of move that pth person has to take to buy sufficent tickets.
//
//        Now considering the first group [tickets0, tickets1, ..., ticketsP-1], if there is a person i who needs to buy the number of tickets smaller than the pth person, then just simply add <ticket i> to times ( the duration that pth person has to wait for the person i until he gets out of the line ). Otherwise, in case the amount of buying tickets of person i is bigger than person pth, add <ticket p> to times.
//
//        Secondly, the same idea to those who stand behind the pth person [ticketsP+1, ticketsP+2, ..., ticketsN]. Considering person t (t > p), we add <ticket t> to times if ticketT < ticketP. Unless person t buys tickets less then person p, skip the last round so that just add <ticket p - 1 > to times
//
//
//        While iterating the lines, dont forget to add ticket p to times whenever meet the person p.


public class PurchaseTickets {
    public static void main(String[] args) {
        PurchaseTickets t = new PurchaseTickets();
        System.out.println(t.times(new int[]{2, 6, 3, 4, 5}, 2));
    }

    public static long times(int[] tickets, int p) {
        long times = 0;
        int[] temp = Arrays.copyOf(tickets, tickets.length); //creating this array to check whether the *person i* buy tickets less than *person p*
        for (int i : temp) {
            System.out.print(i);
        }
        System.out.println("\n");
        for (int i = 0; i < tickets.length; i++) {
            temp[i] = tickets[i] - tickets[p];
        }
        for (int i : temp) {
            System.out.print(i);
        }
        System.out.println("\n");
        for (int i = 0; i < tickets.length; i++) {
            if (temp[i] < 0)
                times += tickets[i];
            else {
                if (i <= p)
                    times += tickets[p];
                else
                    times += tickets[p] - 1;
            }
        }
        return times;
    }
}


//        All the test cases on HackerRank are passed. The simplest solution to this is -
//
//        def waitingTime(tickets, p):
//        total_steps = tickets[p]
//        first_half = tickets[:p]
//        second_half = tickets[p+1:]
//
//        for num in first_half:
//        if num < tickets[p]:
//        total_steps += num
//        else:
//        total_steps += tickets[p]
//
//        for num in second_half:
//        if num < tickets[p]:
//        total_steps += num
//        else:
//        total_steps += tickets[p] - 1
//
//        return total_steps
//        Explanation -
//        Divide list into two halves. People standing ahead of Jesse and persons standing behind Jesse.
//        Check with each person in both the halves - how many tickets that person wants to buy.
//        Lets consider first half
//        If the person wants to buy less number of tickets than that of Jesse - the person will visit the ticket window till he buy the tickets before Jesse. So add his number of tickets to the total unit time
//        If the person wants to buy more or the equal tickets than Jesse then he will visit ticket window before Jesse exactly the same number of times that Jesse visits the ticket window. So add Jesse's tickets count to the total unit time - which is equal to the person's ticket count which he buys before Jesse
//        Now consider second half -
//        If the person standing behind Jesse wants to buy more or equal tickets than Jesse, he will visit ticket window one less time than Jesse. So add (Jesse's ticket count - 1) to the total unit time
//        If the person standing behind Jesse wants to buy less tickets than Jesse, then the person will visit ticket window until he buys all his tickets. So add persons total ticket count to the total unit time.
//        Finally, add Jesse's ticket count to the total unit time too, because Jesse will also visit the ticket window until he buys all the tickets that he wants
//        e.g. Five persons are standing in a queue. Their ticket count is given in the list below. Jesse is standing at 3rd position (list index = 2)
//
//        [2,6,3,4,5]
//
//        first half = [2,6] second half = [4,5]
//
//        now consider first half -
//
//        Person#1 wants to buy 2 tickets. Jesse's count (3) is greater than 2. So this person will definitely visit ticket window twice before Jesse. Hence total_unit_time = 2
//
//        Person#2 wants to buy 6 tickets. Jesse's count (3) is less than 6. So this person will visit ticket window 3 times before Jesse. So total_unit_time = 2+3
//
//        now consider second half - 1. Person#1 wants to buy 4 tickets. Jesse's count (3) is less than 4. Now, Jesse will buy his first ticket then the person will get a chance to buy his first ticket. But then Jesse will have to wait for 2 more turns to buy remaining 2 tickets after this person. So total_unit_time = 2+3+(3-1)
//
//        Person#2 wants to buy 5 tickets. Again Jesse will buy his first ticket and will wait for his remaining two turns until this guy buys two tickets. So total_unit_time = 2+3+2+(3-1)


