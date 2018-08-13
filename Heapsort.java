
import java.util.*;
public class Heapsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner sc=new Scanner(System.in);
	
           System.out.println(">>>>>>>>>>HEAPSORT<<<<<<<<<<");
           System.out.println("ENTER HOW MANY NUMBERS YOU WANT TO SORT");
           int nele=sc.nextInt();
           System.out.println(nele);
           Hidden a=new Hidden(nele);//calling the constructor to create array of size given by user
           System.out.println("enter the numbers");
           for (int i=0;i<nele;i++)
           {
        	  a.setarray(sc.nextInt()); //entering the elements inside array
           }
           a.buildheap();
           System.out.print("AFTER SORTING THE SORTED ARRAY IS >>>");
           a.printarray();
           
	}

}
 class Hidden{
	 private int array[];
	 private int nele;
	 public Hidden(int max)//constructor by which array gets its size
	 {
		 array=new int[max];
		 nele=0;
	 }
	 public void setarray(int ele)//enter element into array
	 {
		 array[nele]=ele;
		 nele++;

	 }
	 //start build heap
	 public void buildheap()
	 {
		 int n=array.length;
		 for(int i=n/2-1;i>=0;i--)
		 {
			 heapify(array,n,i);//first time heapify is called
		 }
		 for (int i=n-1;i>=0;i--)//expression ensures that the last element after swapping is excluded from heapify step
		 {
			 int swap=array[0];
			 array[0]=array[i];
			 array[i]=swap;
			 heapify(array, i, 0);//this step calls heapify
		 }
	 }
	 //start heapify
	 public void heapify(int arr[],int n ,int i)
	 {
		 int largest=i;
		 int  l=(2*i)+1;
		 int r=(2*i) +2;
		 if (l<n && arr[l]>arr[largest])
		 {
			largest=l;
		 }
		 if (r<n &&arr[r]>arr[largest])
		 {
			 largest=r;
		 }
		 if (largest!=i)
		 {
			 int  temp=arr[i];//swap
			 arr[i]=arr[largest];
			 arr[largest]=temp;
			 heapify(arr,n,largest);
		 }
	 }
	 public void printarray()
	 {
		 for (int i=0;i<nele;i++)
		 {
			 System.out.print(array[i]+" ");
		 }
	 }
	 
	
}
