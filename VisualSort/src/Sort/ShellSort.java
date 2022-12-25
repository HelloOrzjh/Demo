package Sort;

public class ShellSort extends VisibleSort {

	Thread thread;
	
	ShellSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("Ï£¶ûÅÅÐò");
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
		
		for(int gap = arr.size / 2; gap > 0; gap /= 2) {
			for(int i = gap; i < arr.size; i++) {
				int j = i;
				int temp = arr.get(j);
				if(arr.get(j) < arr.get(j - gap)) {
					while(j - gap >= 0 && temp < arr.get(j - gap)) {
						arr.set(arr.get(j - gap), j);
						j -= gap;
						try {
							Thread.sleep(MOVE_SPEED);
						} catch (Exception e) {
							
						}
						super.repaint();
					}
					arr.set(temp, j);
					try {
						Thread.sleep(MOVE_SPEED);
					} catch (Exception e) {
						
					}	
					super.repaint();
				}
			}
		}
		
		end = System.currentTimeMillis();
		frame.setTitle("ÅÅÐòÒÑ½áÊø£¬ÓÃÊ±" + (end - start) + "ms");
		try {
			Thread.sleep(INF);
		} catch (Exception e) {
			
		}
		frame.setVisible(false);
	}
}
