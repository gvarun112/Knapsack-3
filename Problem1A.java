package grandfinale;
import java.io.*;
import java.util.Arrays;
public class Problem1A {
    private static int[] N = {10,20,30,40,50};
    private static boolean output = false;
    public static void main(String[] args) throws IOException {
        Arrays.sort(N);
        Boolean x = knap(5,10); //calling knap function with number of elements and knap size
        System.out.println("\nX="+x);
    }
    private static Boolean knap(int X, int L1) {
        if(L1==0) { output=true; return output; }
        if(X==0) { return false; }
        if(L1<0) { return false; }
        if(output==false) {
            return (knap(X-1,L1-N[X-1])||knap(X-1,L1)); //recursive call to accept the number into knapsack or to discard it depending on knapsack size
        }
        else 
            return output;
    }
}  