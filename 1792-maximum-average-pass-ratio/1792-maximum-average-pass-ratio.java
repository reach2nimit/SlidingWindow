class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        Queue<double[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Double.compare(b[0],a[0])
        );
        //Double comparator is imp because by default it returns int only

        for(int[] singleClass : classes){
            int pass = singleClass[0];
            int total = singleClass[1];
            double gain = calculateGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }
        
        while(extraStudents > 0){
            double[] current = maxHeap.poll();
            int pass = (int)current[1];
            int total = (int)current[2];

            maxHeap.offer(new double[]{
                calculateGain(pass + 1, total + 1),
                pass + 1,
                total + 1
            });

            extraStudents--;
        }

        double passRatio = 0;
        
        while(!maxHeap.isEmpty()){
            double[] current = maxHeap.poll();
            passRatio+= (current[1]/current[2]);
        }
        return passRatio/classes.length;
    }

    public double calculateGain(int pass, int total){
        return (
            (double)(pass+1)/(total+1) - (double)pass/total
        );
    }
    //be careful of typecasting here
}