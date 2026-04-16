class Solution {
    public int[] getOrder(int[][] tasks) {
        Queue<int[]> heap = new PriorityQueue<>(
            (a,b) -> (a[1]!=b[1]) ? a[1]-b[1] : a[2]-b[2]
        );

        int[][] sortedTasks = new int[tasks.length][3];
        for(int i=0; i<tasks.length; i++){
            sortedTasks[i][0]=tasks[i][0];
            sortedTasks[i][1]=tasks[i][1];
            sortedTasks[i][2]=i;
        }

        Arrays.sort(sortedTasks, (a,b) -> a[0]-b[0]);

        int[] result = new int[tasks.length];
        int time = 0;
        int taskIdx = 0;
        int resultIdx = 0;

        while(taskIdx < tasks.length || !heap.isEmpty()){

            if(heap.isEmpty() && time < sortedTasks[taskIdx][0])
                time = sortedTasks[taskIdx][0];
            
            while(taskIdx < tasks.length && time >= sortedTasks[taskIdx][0]){
                heap.offer(sortedTasks[taskIdx]);
                taskIdx++;
            }

            int processTime = heap.peek()[1];
            int index = heap.peek()[2];
            heap.poll();
            time+=processTime;
            result[resultIdx] = index;
            resultIdx++;
        }

        return result; 
        //NLogN
    }
}