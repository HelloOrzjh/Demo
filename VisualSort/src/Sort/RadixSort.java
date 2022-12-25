package Sort;

public class RadixSort extends VisibleSort {
	
	Thread thread;
	
	RadixSort(int size, SortingArray arr) {
		super(size, arr);
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		frame.setVisible(true);
		frame.setTitle("基数牌序");
		while(true) {
			try {
				startSort();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
    private int getMaxValue() {
        int maxValue = arr.get(0);
        for(int i = 1; i < arr.size; i++) {
        	maxValue = Math.max(maxValue, arr.get(i));
        }
        return maxValue;
    }
	
    private int getMaxDigit() {
    	int maxValue = getMaxValue();
    	return getNumLength(maxValue);
    }
    
    private int getNumLength(int num) {
    	if(num == 0) return 1;
    	int count = 0;
    	while(num > 0) {
    		count++;
    		num /= 10;
    	}
    	return count;
    }
    
	public void startSort() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			
		}
		
		start = System.currentTimeMillis();
		
		int maxValue = getMaxValue();
		int maxDigit = getNumLength(maxValue);
		int[] counts = new int[10];
		int[][] tmp = new int[10][arr.size];
		
		for(int i = 0, n = 1; i < maxDigit; i++, n *= 10) {
			for(int j = 0; j < arr.size; j++) {
				int mod = (arr.get(j) / n) % 10;
				tmp[mod][counts[mod]] = arr.get(j);
				counts[mod]++;
			}
			int idx = 0;
			for(int k = 0; k < 10; k++) {
				if(counts[k] > 0) {
					for(int j = 0; j < counts[k]; j++) {
						arr.set(tmp[k][j], idx);
						try {
							Thread.sleep(MOVE_SPEED);
						} catch (Exception e) {
							
						}				
						super.repaint();
						idx++;
					}
					counts[k] = 0;
				}
			}
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
