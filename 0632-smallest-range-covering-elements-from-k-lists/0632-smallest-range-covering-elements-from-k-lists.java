class Solution {
    // 4-26 0-20 5-30
    // 20-26 5-30 
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for(int i = 0; i < nums.size(); i++){
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }

        //check how this contidition if fromed
        while(minHeap.size() == nums.size()){
            int[] data  = minHeap.poll();
            int minVal = data[0];

            if(maxVal - minVal < rangeEnd - rangeStart){
                rangeStart = minVal;
                rangeEnd = maxVal;
            }
            int numsIndex = data[1], listIndex = data[2];
            if(listIndex + 1 < nums.get(numsIndex).size()){
                minHeap.offer(new int[]{nums.get(numsIndex).get(listIndex+1), numsIndex, listIndex + 1});
                maxVal = Math.max(maxVal, nums.get(numsIndex).get(listIndex+1));
            }
        }

        return new int[]{rangeStart, rangeEnd};
        // NlogK where K is number of lists
    }
}