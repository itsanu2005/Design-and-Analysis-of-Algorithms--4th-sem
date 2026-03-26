import java.util.*;
public class Quick {
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quicksort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }         //last element pivot
         int pindex= partition(arr,si,ei); //  gives index of pivot
         quicksort(arr, si, pindex-1);  // for left subarray
         quicksort(arr, pindex+1, ei); // for right subarray
    }
     public static int partition(int arr[],int si,int ei){
        int pivot= arr[ei];
        int i=si-1;// at -1 posi which make place for elem smaller then pivot
        for(int j=si;j<ei;j++ ){
            if(arr[j]<=pivot){
                i++;//value of index i is incremented
                // swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++; // for swapping the pivot
         int temp=pivot;
         arr[ei]=arr[i];  // dont use pivot in plase or arr[ei] because we dont want to change in pivot variable we want it in array.
         arr[i]=temp ;    
         return i;   
        }
    public static void main(String[] args){
        Scanner sc=new Scanner (System.in);
        System.out.println("enter the size of array");
        int n=sc.nextInt();
        int arr[]= new int[n];
        System.out.println("enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        } 
        quicksort(arr, 0, arr.length-1);
        printarr(arr);
        sc.close();
    }
 }
/*
==================== QUICK SORT ANALYSIS ====================

Recurrence Relation:

Best / Average Case:
T(n) = 2T(n/2) + O(n)

Worst Case:
T(n) = T(n-1) + O(n)

Explanation:
- Partition takes O(n)
- Then recursive calls depend on pivot position

------------------------------------------------------------

USING MASTER THEOREM (BEST / AVERAGE CASE):

T(n) = 2T(n/2) + O(n)

a = 2
b = 2
d = 1

log_b(a) = log2(2) = 1

Since:
d = log_b(a)

=> Time Complexity = O(n log n)

------------------------------------------------------------

TIME COMPLEXITY:

Best Case    : O(n log n)
(A balanced partition: pivot divides array into equal halves)

Average Case : O(n log n)

Worst Case   : O(n^2)
(When pivot is smallest or largest every time)

------------------------------------------------------------

RECURSION TREE ANALYSIS:

BEST / AVERAGE CASE:

Level 0:
- Size = n
- Work = n

Level 1:
- 2 subarrays of size n/2
- Work = n

Level 2:
- 4 subarrays of size n/4
- Work = n

...

Number of levels = log n

Total work = n * log n = O(n log n)

------------------------------------------------------------

WORST CASE RECURSION TREE:

Level 0:
- Size = n
- Work = n

Level 1:
- Size = n-1
- Work = n-1

Level 2:
- Size = n-2
- Work = n-2

...

Last level:
- Size = 1

Total work:
= n + (n-1) + (n-2) + ... + 1
= n(n+1)/2
= O(n^2)

------------------------------------------------------------

SPACE COMPLEXITY:

Best / Average Case : O(log n)  (recursion stack)
Worst Case          : O(n)

------------------------------------------------------------

FINAL SUMMARY:

- Best / Avg Time  : O(n log n)
- Worst Time       : O(n^2)
- Space            : O(log n) (in-place sort)
- Not Stable    : Yes (not stable)

============================================================
*/