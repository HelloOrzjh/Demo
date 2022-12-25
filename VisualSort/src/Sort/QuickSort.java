package Sort;

public class QuickSort extends VisibleSort {

	Thread thread;
	
	QuickSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("快速排序");
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
		QSort(l, r);
		
		end = System.currentTimeMillis();
		frame.setTitle("排序已结束，用时" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
	
	void QSort(int l, int r) {
		int mid = arr.get((l + r) >> 1);
		int i = l, j = r;
		do {
			while(arr.get(i) < mid) i++;
			while(arr.get(j) > mid) j--;
			if(i <= j) {
				int temp = arr.get(i);
				arr.set(arr.get(j), i);
				arr.set(temp, j);
				i++;
				j--;
				try {
					Thread.sleep(MOVE_SPEED);
				} catch (Exception e) {
					
				}				
				super.repaint();
			}
		} while(i <= j);
		if(j > l) QSort(l, j);
		if(i < r) QSort(i, r);
	}
	
}
