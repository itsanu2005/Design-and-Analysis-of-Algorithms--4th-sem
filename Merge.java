 import java .util.*;
 public class Merge {
    public static void mergesort(int arr[],int si,int ei){
         if(si>=ei){ // base case-nothing to do
            return;
        }
        //kaam
        int mid=si+(ei-si)/2;
        mergesort(arr, si, mid); //left subarray
        mergesort(arr, mid+1, ei); //right subarray
        mergearr(arr,si,mid,ei);// func to merge the array
    }
    public static void mergearr(int arr[],int si,int mid,int ei){
       int temp[]=new int[ei-si+1];//+1 bcs array is 0 based index
        int i=si; //for left part
        int j=mid+1;// for right part
        int k=0;//for temp array
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){ // i smaller put in temp array
                temp[k]=arr[i];
                i++; k++;
            }
            else{
                temp[k]=arr[j]; // j smaller put in temp array;
                j++;  k++;
            }
        }
            //for leftover element if 1 array is over
        while(i<=mid){ // left
                temp[k++]= arr[i++];
            }
        while(j<=ei){
                temp[k++]= arr[j++]; 
            }
            //copy temp to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
        
      
    }
    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

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
        mergesort(arr, 0, arr.length-1); 
        printarr(arr);
        sc.close();
    }
 }
/*
==================== MERGE SORT ANALYSIS ====================

Recurrence Relation:
T(n) = 2T(n/2) + O(n)

Explanation:
- 2T(n/2)  → Two recursive calls (left + right half)
- O(n)     → Time to merge two sorted halves

------------------------------------------------------------

USING MASTER THEOREM:

General form:
T(n) = aT(n/b) + O(n^d)

Here:
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
Average Case : O(n log n)
Worst Case   : O(n log n)

(Note: Same in all cases because array is always divided)

------------------------------------------------------------

RECURSION TREE ANALYSIS:

Level 0:
- Problem size = n
- Work done = n

Level 1:
- 2 subproblems of size n/2
- Total work = n

Level 2:
- 4 subproblems of size n/4
- Total work = n

...

Last Level:
- n subproblems of size 1
- Total work = n

------------------------------------------------------------

NUMBER OF LEVELS:

At each step, size becomes half:
n → n/2 → n/4 → ... → 1

Number of levels = log2(n)

------------------------------------------------------------

TOTAL WORK:

Work per level = n
Number of levels = log n

Total Time = n × log n = O(n log n)

------------------------------------------------------------

SPACE COMPLEXITY:

O(n) → Extra array used for merging

------------------------------------------------------------

FINAL SUMMARY:

- Recurrence: T(n) = 2T(n/2) + n
- Levels: log n
- Work per level: n
- Total: O(n log n)

============================================================
*/
