package Sorting;
import java.util.Scanner;
public class QuickSort_Pivot_First {
    int pos;
    public void input(int arr[],int size){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter The Elements:");
        for(int i=0;i<size;i++){
            arr[i]=scan.nextInt();
        }
    }
    public void quick_Sort(int arr[],int low,int high,int size) {
        if (low < high) {
            pos=partition(arr,low,high,size);
            quick_Sort(arr,low, pos-1,size);
            quick_Sort(arr,pos+1,high,size);
        }
    }
    int partition(int arr[],int low,int high,int size){
        int pivot=arr[low];
        int flag=0;
        int i=low,j=high;
        while(i<j){
            while(arr[i]<=pivot){
                i++;
                if( i==(high+1) ){
                    flag=1;
                    i=low;
                    break;
                }
            }
            while(arr[j]>=pivot){
                j--;
                if( j==(low-1) ){
                    j=low;
                    break;
                }
            }
            if(flag==1)
                break;
            if(i<j)
                this.swap(arr,i,j);
        }
        this.swap(arr,low,j);
        return j;
    }
    void swap(int arr[],int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
    }
    public void display(int arr[],int size){
        System.out.println("The output is given in Sorting order :");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+"  ");
        }

    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter The Size of Array:");
        int size=scan.nextInt();
        int arr[]=new int[size];
        QuickSort_Pivot_First obj=new QuickSort_Pivot_First();
        obj.input(arr,size);
        int low=0;
        int high=size-1;
        obj.quick_Sort(arr,low,high,size);
        obj.display(arr,size);

    }
}
