package Sort;

public class InsertSort extends VisibleSort {

	Thread thread;
	
	InsertSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("插入排序");
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
		
		for(int i = 1; i < size; i++) {
			int temp = super.arr.get(i);
			int j = i - 1;
			while(j >= 0 && temp < arr.get(j)) {
				arr.set(arr.get(j), j + 1);
				j--;
				try {
					Thread.sleep(MOVE_SPEED);
				} catch (Exception e) {
					
				}
				super.repaint();
			}
			arr.set(temp, j + 1);
		}
		
		end = System.currentTimeMillis();
		frame.setTitle("排序已结束，用时" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
}
