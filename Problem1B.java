package grandfinale;
import java.io.*;
import java.util.Arrays;
public class Problem1B {
    private static int[] N = {2,5,1,5,8};
    private static int[] temp = new int[5];
    private static int i=0;
    private static boolean output = false;
    public static void main(String[] args) throws IOException {
        Arrays.sort(N);
        Boolean x = knap(5,10); //calling knap function with number of elements and knap size
        System.out.println("X="+x);
        if(x){
            for(int i=0 ; i<temp.length ; i++)
                if(temp[i] != 0)
                    System.out.print(temp[i]+" "); //print the elements that are accepted into the knap
        }
        System.out.println();
    }
    private static Boolean knap(int X, int L1) {
        if(L1==0) { output=true; return output; }
        if(X==0) { return false; }
        if(L1<0) { return false; }
        if(output==false) {
            if (L1-N[X-1] >= 0) { //check if knapsack size is greater or equal to zero after inserting the element selected
                temp[i] = N[X-1]; //store the elements that are accepted into an array
                i++;
                return (knap(X-1,L1-N[X-1])); //reduce knap size with the element and do a recursive call
            }
            else
                return (knap(X-1,L1)); //discard the element and recall the function with same knap size
        }
        else 
            return output;
    }
}  