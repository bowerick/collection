package collection.algorithms;

public class QuickSort
{
	public static void main(String[] args)
	{
		QuickSort qs = new QuickSort();
		int[] array = new int[]{10000,-1,400,19,0,0,1,-400};
		qs.quicksort(array,0,array.length-1);
		System.out.println();
	}
	
	public void quicksort(int[] array,int low,int high)
	{
		int pivot=array[low+(high-low)/2];
		int i = low;
		int j = high;
		while(i <= j)
		{
			while(array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			
			if(i <= j)
			{
				int temp=array[i];
				array[i]=array[j];
				array[j]=temp;
				i++;
				j--;
			}
			
			if(low < j)
				quicksort(array,low,j);
			if(i < high)
				quicksort(array,i,high);
		}
		System.out.println();
	}
}
