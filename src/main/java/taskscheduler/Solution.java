package taskscheduler;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastTaskMap = new HashMap<>();
        long day = 0;
        for (int task : tasks) {
            day++;
            Long lastTaskDay = lastTaskMap.get(task);
            if (lastTaskDay != null) {
                long passed = day - lastTaskDay - 1;
                long waitTime = space > passed ? space - passed : 0;
                day += waitTime;
            }
            lastTaskMap.put(task, day);
        }
        return day;
    }

    public static void main(String[] args) {
        int[] tasks = {1,2,1,2,3,1};
        int space = 3;
        System.out.println(new Solution().taskSchedulerII(tasks, space));
    }
}
