package Week7_priorityQueue_binatyHeap.BaiTap;
import java.io.*;
import java.util.*;
public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int j = A.length() - 1;
        int i = 0;
        while(i <= j){
            if(A.charAt(i) == A.charAt(j)){
                i++;
                j--;
            }
            else {
                System.out.print("No");
                break;
            }
        }

        if(i > j) System.out.print("Yes");
    }
}


