package Sort;

public class MergeSort extends VisibleSort {

	Thread thread;
	
	MergeSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("归并排序");
		while(true) {
			try {
				startSort();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void startSort() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			
		}
		
		start = System.currentTimeMillis();
		
		int l = 0, r = size - 1;
		MSort(l, r);
		
		end = System.currentTimeMillis();
		frame.setTitle("排序已结束，用时" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
	
	public void MSort(int l, int r) {
		if(l >= r) return ;
		
		int mid = (l + r) >> 1;
		MSort(l, mid);
		MSort(mid + 1, r);
		
		int k = 0, i = l, j = mid + 1;
		int[] tmp = new int[size];
		while(i <= mid && j <= r) {
			if(arr.get(i) <= arr.get(j)) {
				tmp[k++] = arr.get(i);
				i++;
			} else {
				tmp[k++] = arr.get(j);
				j++;
			}
		}
		while(i <= mid) {
			tmp[k++] = arr.get(i);
			i++;
		}
		while(j <= r) {
			tmp[k++] = arr.get(j);
			j++;
		}
		
		for(i = l, j = 0; i <= r; i++, j++) {
			arr.set(tmp[j], i);
			try {
				Thread.sleep(MOVE_SPEED);
			} catch (Exception e) {
				
			}				
			super.repaint();			
		}
		
	}
}
