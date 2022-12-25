package Sort;

import javax.swing.*;
import java.awt.*;;

public class VisibleSort extends Visual {
	final int INF = 2147483647;
	final int MOVE_SPEED = 60;
	final int MAXSIZE = 100;
	int size = MAXSIZE;
	long start, end;
	JFrame frame;
	SortingArray arr = new SortingArray();
	
	VisibleSort(int size, SortingArray arr) {
		this.size = size;
		for(int i = 0; i < arr.size; i++) {
			this.arr.set(arr.get(i), i);
		}
		this.arr.size = arr.size;
		windowFrom();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.clearRect(0, 0, 1500, 1500);

		for(int i = 0; i < size; i++) {
			g.setColor(Color.BLACK);
			g.fillRect(i * 10 + 80, (500 - ( arr.get(i) * 4 ) ), 10, arr.get(i) * 4);
			//g.fillRect(x, y, width, height);
		}
	}
	
	public void windowFrom() {
		frame = new JFrame();
		
		frame.setSize(1200, 600);
		frame.setLocationRelativeTo(null);
		frame.add(this);
	}
	
	public void startSort() {
		
	}
	
	public void run() {
		
	}
}
