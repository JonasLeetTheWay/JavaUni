public class Average {

    private double avg;

    public Average(int ... args){
        int[] nums = args;
        this.calcAvg(nums);
    }

    private double calcAvg(int[] nums){

        if (nums.length==0) return 0;

        double sum=0;
        int count = 0;
        for (int num : nums){
            count++;
            sum += num;
        }
        this.avg = sum/count;

        return avg;
    }

    public double getAverage(){
        return avg;
    }

}
