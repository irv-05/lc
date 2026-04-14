class Solution {
    private class Job implements Comparable<Job> {
        public int start;
        public int end;
        public int val;
        public int overlap;
        public Job(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Job o) {
            return Integer.compare(start, o.start);
        }

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];
        for(int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs);

        int[] memo = new int[startTime.length];
        memo[startTime.length-1] = jobs[startTime.length-1].val;
        for(int i = startTime.length-2; i >= 0; i--) {    
            int overlap = i + 1;
            while(overlap < startTime.length && jobs[i].end > jobs[overlap].start) {
                overlap++;
            }

            int curProfit;
            if(overlap < startTime.length) {
                curProfit = Math.max(jobs[i].val + memo[overlap], memo[i+1]);
            } else {
                curProfit = Math.max(jobs[i].val,  memo[i+1]);
            }
            memo[i] = curProfit;
            
        }

        return memo[0];
    }
}