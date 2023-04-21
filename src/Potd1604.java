import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Potd1604 {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        long ans=0;
        List<Integer>[] Aevenodd=new List[2];
        Aevenodd=getevenodd(A);
        List<Integer>[] Bevenodd=new List[2];
        Bevenodd=getevenodd(B);
           if(checksum(A,B)){
               return -1;
           }
           else if(Aevenodd[0].size()!=Bevenodd[0].size()){
               return -1;
           }
           else {
               for (int i = 0; i < 2; ++i) {
                   for (int j = 0; j <Aevenodd[i].size() ; ++j) {
                            ans+=Math.abs(Aevenodd[i].get(j)-Bevenodd[i].get(j))/2;
                   }
               }
                return  ans/2;

           }


    }

    private static List<Integer>[] getevenodd(int[] b) {
        List<Integer>[] lists=new List[2];
        List<Integer>even=new ArrayList<>();
        List<Integer>odd=new ArrayList<>();
        for(int i:b){
            if(i%2==0){
                even.add(i);
            }
            else {
                odd.add(i);
            }
        }
        Collections.sort(even);

        Collections.sort(odd);
        lists[0]=even;
        lists[1]=odd;
        return  lists;

    }


    private static    boolean  checksum(int []A,int []B){
        int sum=0;
        for (int i=0;i<A.length;i++
             ) {
            sum=sum+A[i]-B[i];


        }
        if(sum==0)
            return false;
      else
          return true;
    }


    public static void main(String[] args) {
        int n= 4;
        int A[]={1,1,3,5};
        int B[]={2,2,2,4};
        System.out.println(solve(n,A,B));
    }
    }


