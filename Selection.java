// In selection sort we treverse through the array select the minimum element and swap it with the first element of the array
import java.util.*;
public class Selection {
    public static void Select(int arr[],int n){
       for(int i=0;i<n;i++){
        int minpos=i;  //minimum position is at i
        for(int j=i+1;j<n;j++){
            if(arr[minpos]>arr[j]){ // finding the minimum position
                minpos=j;
            }
        }
        int temp=arr[minpos];
        arr[minpos]=arr[i]; //swapping minimum
        arr[i]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Select(arr,n);  
        sc.close();
    }
}
// time complexity = O(n^2) 