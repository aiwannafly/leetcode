package maxpersondistance;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxWindow = 0;
        int currWindow = 0;
        int leftWindow = -1;
        for (int seat : seats) {
            if (seat == 0) {
                currWindow++;
                continue;
            }
            if (currWindow > maxWindow) {
                maxWindow = currWindow;
            }
            if (leftWindow < 0) {
                leftWindow = currWindow;
            }
            currWindow = 0;
        }
        int rightWindow = currWindow;
        int middleWindow =  (maxWindow - 1) / 2;
        return max(max(leftWindow, middleWindow), rightWindow);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
