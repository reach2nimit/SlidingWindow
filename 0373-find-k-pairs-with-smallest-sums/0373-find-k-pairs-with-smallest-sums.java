class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        for(int x : nums1)
            minHeap.offer(new int[]{x, nums2[0], 0});
        
        List<List<Integer>> result = new ArrayList();

        for(int i = 0; i<k && !minHeap.isEmpty(); i++){
            int[] curr = minHeap.poll();
            result.add(List.of(curr[0], curr[1]));

            int nums2Index = curr[2];
            if(nums2Index + 1 < nums2.length)
                minHeap.offer(new int[]{curr[0], nums2[nums2Index+1], nums2Index + 1});
        }
        return result;
        // O(k log k) 
    }
}