package Sort;

public class HeapSort extends VisibleSort {

	Thread thread;
	
	HeapSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("堆排序");
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
		
		for(int i = (arr.size - 1) / 2; i >= 0; i--) {
			adjustHeap(i, arr.size);
		}
		
		for(int i = arr.size - 1; i > 0; i--) {
			int tmp = arr.get(i);
			arr.set(arr.get(0), i);
			arr.set(tmp, 0);
			try {
				Thread.sleep(MOVE_SPEED);
			} catch (Exception e) {
				
			}				
			super.repaint();
			adjustHeap(0, i);
		}
 		
		end = System.currentTimeMillis();
		frame.setTitle("排序已结束，用时" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
	
	void adjustHeap(int root, int size) {
		int tmp = arr.get(root);
		int lChild = root * 2 + 1;
		
		while(lChild < size) {
			int rChild = lChild + 1;
			if(rChild < size && arr.get(lChild) < arr.get(rChild)) {
				lChild++;
			}
			if(tmp >= arr.get(lChild)) {
				break;
			}
			
			arr.set(arr.get(lChild), root);
			try {
				Thread.sleep(MOVE_SPEED);
			} catch (Exception e) {
				
			}				
			super.repaint();
			
			root = lChild;
			lChild = lChild * 2 + 1;
		}
		
		arr.set(tmp, root);
		try {
			Thread.sleep(MOVE_SPEED);
		} catch (Exception e) {
			
		}				
		super.repaint();
	}
}
