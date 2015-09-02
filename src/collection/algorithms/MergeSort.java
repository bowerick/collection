package collection.algorithms;

import java.util.Arrays;

public class MergeSort
{
	public static void main(String[] args)
	{
		MergeSort m = new MergeSort();
		int[] array = new int[] { 4, 1, 0, -4000, 555, 10000, 556, 100, -1, -1 };
		// int[] array = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		// int[] left = new int[] { -4000, 0, 1, 10000 };
		// int[] right = new int[] { -1, -1, 100, 555, 556 };
		// m.merge(array, left, right);
		m.mergeSort(array);
	}

	public void mergeSort(int[] array)
	{
		if (array.length > 1)
		{
			int low = 0;
			int high = array.length;
			int mid = low + (high - low) / 2;
			int[] left = new int[mid];
			int[] right = new int[array.length - mid];
			System.arraycopy(array, 0, left, 0, left.length);
			System.arraycopy(array, mid, right, 0, right.length);
			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
			System.out.println(Arrays.toString(array));
		}
	}

	public void merge(int[] array, int[] left, int[] right)
	{
		if (left[left.length - 1] < right[0])
		{
			System.arraycopy(left, 0, array, 0, left.length);
			System.arraycopy(right, 0, array, left.length, right.length);
		}
		else if (right[right.length - 1] < left[0])
		{
			System.arraycopy(right, 0, array, 0, right.length);
			System.arraycopy(left, 0, array, right.length, left.length);
		}
		else
		{
			int i = 0;
			int j = 0;
			int k = 0;

			while (i < left.length && j < right.length)
			{
				if (left[i] <= right[j])
				{
					array[k] = left[i];
					i++;
				}
				else
				{
					array[k] = right[j];
					j++;
				}
				k++;
			}
			while (j < right.length)
			{
				array[k] = right[j];
				j++;
				k++;
			}
			while (i < left.length)
			{
				array[k] = left[i];
				i++;
				k++;
			}
		}
	}
}
