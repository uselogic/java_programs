package college;
import java.util.*;
class SimpleArray
{
	private int array[];
	private int nele;
	public  SimpleArray(int max)
	{
		array=new int[max];
		nele=0;
	}
	public void setArray(int ele)//INSERTS ELEMENTS PROVIDED BY USER
	{
		array[nele]=ele;
		nele+=1;
	}
	public int getArray(int p)//RETURNS THE ELEMENT IF USER WANTS TO KNOW WHAT ELEMENT IS PRESENT IN A SPECIFIED POSITION
	{
		return array[p];
		
	}
	public void setele(int n)
	{
		nele=n;
	
	}
	public  int getnele()
	{
		return nele;
	}
	public int  max()//SELECTS THE MAX NUMMBER IN AN ARRAY
	{
		int max=array[0];
		for(int i=0;i<array.length;i++)
		{
			if(max<array[i])
			{
				max=array[i];
			}
		}
		return max;
	}
	public boolean search(int ele)//SEARCHES THE USER REQUIRED NUMBER AND RETURNS TRUE OR FALSE 
	{
		for (int i=0;i<nele;i++)
		{
			if (array[i]==ele)
			{
				return true;
			}
		}
		return false;
	}
	public void delete(int dele)//DELETS AN ELEMENT IN AN ARRAY
	{
		int p=-1;
		for(int i=0;i<nele;i++)
		{
			if (dele==array[i])
			{
				p=i;
				break;
			}
		}
		if(p!=-1)
		{
			for(int j=p;j<nele;j++)
			{
				array[j]=array[j+1];
			}
			nele--;
		}
		System.out.print("new array is ");
		for(int i=0;i<nele;i++)
		{
			System.out.print(array[i]+" ");

		}
	}
	public void sortncopy()
	{
		for(int i=0;i<nele;i++)
		{
			for (int j=i+1;j<nele;j++)
			{
				if (array[i]>array[j])
						{
					       int temp=array[i];
					       array[i]=array[j];
					       array[j]=temp;
						}
			}
		}
		System.out.println(" ");
		System.out.print("after sorting the new array is :>>");
		for(int i=0;i<nele;i++)
		{
			System.out.print(array[i]+" ");
		}
		int dest[]=new int[nele];
		for (int i=0;i<nele;i++)
		{
			dest[i]=array[nele-i-1];
		}
		System.out.println(" ");
		System.out.print("elemnt in reverse order is :>>>");
		for (int i=0;i<dest.length;i++)
		{
			System.out.print(dest[i]+" ");
		}
	}
	public void sort(int arr[],int len)
	{
		for(int i=0;i<len;i++)
		{
			for (int j=i+1;j<len;j++)
			{
				if (arr[i]>arr[j])
						{
					       int temp=arr[i];
					       arr[i]=arr[j];
					       arr[j]=temp;
						}
			}
	     }
	}
	public void viewarray(int arr[],int len)
	{
		for(int i=0;i<len;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public void merge(int arr1[],int arr2[],int merged[],int len1,int len2,int len3)
	{
		int c=0;
		for(int i=0;i<len1;i++)
		{
			merged[i]=arr1[i];
			c++;
		}
		for (int j=0;j<len2;j++)
		{
			merged[c++]=arr2[j];
			
		}
		System.out.println(" ");
		System.out.print("after  merging new array is:>>");
		for(int i=0;i<len3;i++)
		{
			System.out.print(merged[i]+" ");
		}
	}
	
	
	
}
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleArray a= new SimpleArray(100);
		Scanner sc=new Scanner(System.in);
		System.out.println("how many numbers you want to enter?");
		int number=sc.nextInt();
		for(int i=0;i<number;i++)
		{
			a.setArray(sc.nextInt());
		}
		for(int i=0;i<a.getnele();i++)
		{
			System.out.print(a.getArray(i)+" ");
			
		}
		System.out.println(" ");
		System.out.println("type which number you want to search?");
		int snumber=sc.nextInt();
		boolean f=a.search(snumber);
			if(f)
			{
				System.out.println("ELEMENT IS PRESENT");
			}
			else
			{
				System.out.println("ELEMENT IS NOT PRESENT");
			}
		int dele=a.max();
		System.out.println(" ");
		System.out.println("MAX number is "+dele+"  will be deleted");
		a.delete(dele);
		a.sortncopy();
		System.out.println(" ");
		System.out.println("ARRAY CREATION");
		System.out.println("enter lengths of both arrays");
		int len1=sc.nextInt();
		int newarray1[]=new int [len1];
		int len2=sc.nextInt();
		int newarray2[]=new int [len1];
		int merge[]=new int [len1+len2];
		System.out.println("enter elements of ist array upto"+len1);
		for(int i=0;i<len1;i++)
		{
			newarray1[i]=sc.nextInt();
		}
		System.out.println("enter elements of 2nd array upto"+len2);
		for(int i=0;i<len1;i++)
		{
			newarray2[i]=sc.nextInt();
		}
		a.sort(newarray1,len1);
		a.sort(newarray2,len2);
		int len3=len1+len2;
		a.merge(newarray1, newarray2, merge, len1, len2,len3 );
		System.out.println(" ");
		System.out.print("after sorting merge array :>>");
		a.sort(merge, len3);
		a.viewarray(merge, len3);
		
	}

}
