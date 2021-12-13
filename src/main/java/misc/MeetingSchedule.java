package misc;

import java.util.*;
//https://leetcode.com/discuss/interview-question/487773/Visa-or-OA-2020-or-Meetup-Schedule/433848
public class MeetingSchedule {
    public static void main(String[] args) {
        int[] arrival1 = { 1, 2, 3, 3, 3 }, departure1 = { 2, 2, 3, 4, 4 };
        int[] arrival2 = { 1, 1, 2 }, departure2 = { 1, 2, 2 };
        int[] arrival3 = { 1, 1 }, departure3 = { 5, 5 };
        int[] arrival4 = { 1, 1, 1, 1, 1 }, departure4 = { 2, 2, 2, 2, 6 };
        int[] arrival5 = { 1, 1, 1, 2, 2 }, departure5 = { 5, 5, 5, 3, 3 };
        int[] arrival6 = { 1, 2, 2, 2, 2 }, departure6 = { 10, 2, 2, 2, 2 };
        int[] arrival7 = { 1, 2, 1, 2, 2 }, departure7 = { 3,2,1,3,3 };

        System.out.println(getMinMeetings(arrival1, departure1));
        System.out.println(getMinMeetings(arrival2, departure2));
        System.out.println(getMinMeetings(arrival3, departure3));
        System.out.println(getMinMeetings(arrival4, departure4));
        System.out.println(getMinMeetings(arrival5, departure5));
        System.out.println(getMinMeetings(arrival6, departure6));
        System.out.println(getMinMeetings(arrival7, departure7));
        System.out.println("============");
        System.out.println(countMeetings(arrival1, departure1));
        System.out.println(countMeetings(arrival2, departure2));
        System.out.println(countMeetings(arrival3, departure3));
        System.out.println(countMeetings(arrival4, departure4));
        System.out.println(countMeetings(arrival5, departure5));
        System.out.println(countMeetings(arrival6, departure6));
        System.out.println(countMeetings(arrival7, departure7));
    }
    public static int countMeetings(int[]  firstDay,int[] lastDay)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[1]-b[1]);
        for (int i = 0; i <firstDay.length; i++)
        {
            pq.offer(new int[]{firstDay[i],lastDay[i]});
        }
        Set<Integer> days = new HashSet<Integer>();
        int count = 0;
        while(!pq.isEmpty())
        {
            int[] e = pq.poll();
            for(int i=e[0]; i<=e[1]; i++)
            {
                if(!days.contains(i))
                {
                    days.add(i);
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    private static int getMinMeetings(int[] arrival, int[] departure) {
        TreeMap<Integer, Map<Integer, Integer>> tm = new TreeMap<Integer, Map<Integer, Integer>>();
        for(int i=0;i<arrival.length;i++) {
            tm.putIfAbsent(arrival[i], new HashMap<>());
            Map<Integer, Integer> m = tm.get(arrival[i]);
            m.put(departure[i], m.getOrDefault(departure[i], 0) + 1);
        }
        List<int[]> lst = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer, Integer>> entry : tm.entrySet()) {
            for(Map.Entry<Integer, Integer> endEntry : entry.getValue().entrySet()) {
                lst.add(new int[] {entry.getKey(), endEntry.getKey(), Math.min(endEntry.getKey() - entry.getKey() + 1, endEntry.getValue())});
            }
        }
        int res = 0;
        int[] first = lst.get(0);
        for(int i=1;i<lst.size();i++) {
            int[] cur = lst.get(i);
            if(cur[0] > first[1]) {
                res += Math.min(first[1] - first[0] + 1, first[2]);
                first = cur;
            }else {
                first[1] = Math.max(first[1], cur[1]);
                if(first[2] + cur[2] > first[1] - first[0] + 1)
                    first[2] = first[1] - first[0] + 1;
                else
                    first[2] += cur[2];
            }
        }
        res += Math.min(first[1] - first[0] + 1, first[2]);
        return res;
    }
}
