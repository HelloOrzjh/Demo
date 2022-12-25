package Sort;

import java.util.List;
import java.util.ArrayList;

public class SortingArray {
	final int MAXSIZE = 100;
	int size = MAXSIZE;
	int[] arr;
	
	SortingArray() {
		arr = new int[size];
	}
	
	SortingArray(int size) {
		arr = new int[size];
		this.size = size;
	}
	
	public void initalArray(List<Integer> list) {
		size = list.size();
		for(int i = 0; i < size; i++) {
			arr[i] = list.get(i);
		}
	}
	
	public void randArray() {
		for(int i = 0; i < size; i++) {
			arr[i] = (int)(Math.random() * size) + 1;
		}
	}
	
	public int get(int i) {
		if(i >= size || i < 0) {
			System.out.println("index illegal! " + i);
		}
		else return arr[i];
		return 0;
	}
	
	public void set(int k, int i) {
		if(i >= size || i < 0) {
			System.out.println("index illegal! " + i);
		}
		else arr[i] = k;
		return ;
	}
	
	public String toString() {
		String res = "";
		for(int i = 0; i < size; i++) {
			res = res + Integer.toString(arr[i]) + ", ";
		}
		return res;
	}
}
