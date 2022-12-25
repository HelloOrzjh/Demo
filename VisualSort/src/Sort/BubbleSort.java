package Sort;

public class BubbleSort extends VisibleSort {
	
	Thread thread;
	
	BubbleSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("√∞≈›≈≈–Ú");
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
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size - i - 1; j++) {
				if(arr.get(j) > arr.get(j + 1)) {
					int temp = arr.get(j);
					arr.set(arr.get(j + 1), j);
					arr.set(temp, j + 1);
					try {
						Thread.sleep(MOVE_SPEED);
					} catch (Exception e) {
						
					}
					super.repaint();
				}
			}
		}
		
		end = System.currentTimeMillis();
		frame.setTitle("≈≈–Ú“—Ω· ¯£¨”√ ±" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
}
