// In insertion sort we traverse through the array and we take the current element and find out the correct position of the element in the sorted part of the array and repeat it till we complete for all elements.
import java.util.*;
public class Insertion {
    public static void insert(int arr[],int n){
        for(int i=1;i<n;i++){
            int curr=i;
            int prev=i-1;
            while(prev>=0&&arr[prev]>arr[curr]){ //finding correct position to insert the current element
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=arr[curr];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        insert(arr,n);  
        sc.close();
    }
}
// time complexity = O(n^2) 
