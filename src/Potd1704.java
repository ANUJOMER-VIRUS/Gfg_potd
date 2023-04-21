import java.util.Arrays;

public class Potd1704{

    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a, b) -> a.profit == b.profit ? b.deadline-a.deadline : b.profit-a.profit);

        int maxDeadline = 0;

        for(int i=0; i<n; i++){
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        boolean[] hash = new boolean[maxDeadline+1];
        int profitCount = 0, jobCount = 0;

        for(int i=0; i<n; i++){
            Job curr = arr[i];
            int currDL = curr.deadline;

            while(currDL > 0 && hash[currDL]){
                currDL--;
            }

            if(currDL > 0){
                hash[currDL]=true;
                profitCount+=curr.profit;
                jobCount++;
            }
        }

        return new int[]{jobCount, profitCount};
    }

}
class Job
{
     int id;
    int deadline;
    int profit;

    Job(int id, int dead, int profit) {
        this.id = id;
        this.deadline = dead;
        profit = profit;
    }

}