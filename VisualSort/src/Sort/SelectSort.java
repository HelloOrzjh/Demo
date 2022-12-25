package Sort;

public class SelectSort extends VisibleSort {

	Thread thread;
	
	SelectSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("ѡ������");
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
		
		for(int i = 0; i < arr.size - 1; i++) {
			int minn = i;
			for(int j = i + 1; j < arr.size; j++) {
				if(arr.get(j) < arr.get(minn)) {
					minn = j;
				}
				try {
					Thread.sleep(MOVE_SPEED);
				} catch (Exception e) {
					
				}				
				super.repaint();
			}
			
			if(i != minn) {
				int tmp = arr.get(i);
				arr.set(arr.get(minn), i);
				arr.set(tmp, minn);
				try {
					Thread.sleep(MOVE_SPEED);
				} catch (Exception e) {
					
				}				
				super.repaint();
			}
		}
		
		end = System.currentTimeMillis();
		frame.setTitle("�����ѽ�������ʱ" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
}
