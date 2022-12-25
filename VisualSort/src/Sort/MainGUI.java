package Sort;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

import java.util.List;
import java.util.ArrayList;

public class MainGUI extends JFrame {
	final int MAXSIZE = 100;
	int size = MAXSIZE;
	SortingArray arr = new SortingArray(size);
	
	JPanel panel = new JPanel(new BorderLayout());
	JPanel topPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel buttonPanel = new JPanel(new FlowLayout());
	
	JButton bubbleSortButton = new JButton("ð������");
	JButton insertSortButton = new JButton("��������");
	JButton quickSortButton = new JButton("��������");
	JButton mergeSortButton = new JButton("�鲢����");
	JButton shellSortButton = new JButton("ϣ������");
	JButton selectSortButton = new JButton("ѡ������");
	JButton radixSortButton = new JButton("��������");
	JButton heapSortButton = new JButton("������");
	
	JTextArea inputTextArea = new JTextArea(10, 10);
	JButton submitButton = new JButton("ȷ��");
	JButton randButton = new JButton("����һ���������");
	
	JLabel tip = new JLabel();
	
	MainGUI() {
		super("������ӻ� --By Orzjh");
		
		try {
			Image img = Toolkit.getDefaultToolkit().createImage("./img/Diana.jpg");
			this.setIconImage(img);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		setBackground();
		setTopPanel();
		setInputData();
		setPanelButtons();
		this.setContentPane(panel);
		this.setLocationRelativeTo(null);
	}
	
	void setBackground() {
		
	}
	
	void setTopPanel() {
		String text = "<html><body>"
					  + "������1-100֮������������Է������ַ��ָ�" + "<br>"
					  + "����100����Ч����(1-100֮���������)��������" + "<br>"
					  + "���������(100����Ч�����Ժ�)����Ч���ݽ�������" + "<br>"
					  + "�������ݺ�����ȷ�ϲſɽ�������" + "<body></html>";
		//System.out.println(text);
		tip.setText(text);
		tip.setFont(new Font(null, Font.PLAIN, 25));
		tip.setHorizontalTextPosition(SwingConstants.CENTER);
		
		topPanel.add(tip);
		panel.add(topPanel, BorderLayout.NORTH);
	}
	
	void setInputData() {
		inputTextArea.setPreferredSize(new Dimension(600, 100));
		submitButton.setPreferredSize(new Dimension(80, 60));
		randButton.setPreferredSize(new Dimension(200, 60));
		
		inputTextArea.setLineWrap(true);
		inputTextArea.setFont(new Font(null, Font.PLAIN, 20));
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getData(inputTextArea.getText());
				//System.out.println(inputTextArea.getText());
			}
		});
		
		randButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				arr.size = MAXSIZE;
				arr.randArray();
				String text = "";
				for(int i = 0; i < arr.size; i++) {
					text = text + arr.get(i) + " ";
					if(i != arr.size - 1) text = text + ", ";
				}
				inputTextArea.setText(text);
				getData(text);
			}
		});
		
		inputPanel.add(inputTextArea);
		inputPanel.add(submitButton);
		inputPanel.add(randButton);
		
		panel.add(inputPanel, BorderLayout.CENTER);
	}
	
	void getData(String str) {
		List<Integer> list = new ArrayList<Integer>();
		String curval = "";
		
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(cur >= '0' && cur <= '9') {
				curval = curval + str.substring(i, i + 1);
			} else {
				try {
					if(Integer.parseInt(curval) != 0 && Integer.parseInt(curval) <= 100 && list.size() < MAXSIZE) {
						list.add(Integer.parseInt(curval));
					}
				} catch (Exception e) {

				}
				curval = "";
			}
		}
		try {
			if(Integer.parseInt(curval) <= 100 && list.size() < MAXSIZE) {
				list.add(Integer.parseInt(curval));
			}
		} catch (Exception e) {
			
		}
		
		size = list.size();
		arr.initalArray(list);
		
		//System.out.println(list);
	}
	
	void setPanelButtons() {
		bubbleSortButton.setPreferredSize(new Dimension(120, 60));
		insertSortButton.setPreferredSize(new Dimension(120, 60));
		quickSortButton.setPreferredSize(new Dimension(120, 60));
		mergeSortButton.setPreferredSize(new Dimension(120, 60));
		shellSortButton.setPreferredSize(new Dimension(120, 60));
		selectSortButton.setPreferredSize(new Dimension(120, 60));
		radixSortButton.setPreferredSize(new Dimension(120, 60));
		heapSortButton.setPreferredSize(new Dimension(120, 60));

		bubbleSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BubbleSort(size, arr);
			}
		});
		insertSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertSort(size, arr);
			}
		});
		quickSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new QuickSort(size, arr);
			}
		});
		mergeSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MergeSort(size, arr);
			}
		});
		shellSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ShellSort(size, arr);
			}
		});
		selectSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectSort(size, arr);
			}
		});
		radixSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RadixSort(size, arr);
			}
		});		
		heapSortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HeapSort(size, arr);
			}
		});
		
		buttonPanel.add(bubbleSortButton);
		buttonPanel.add(insertSortButton);
		buttonPanel.add(quickSortButton);
		buttonPanel.add(mergeSortButton);
		buttonPanel.add(shellSortButton);
		buttonPanel.add(selectSortButton);
		buttonPanel.add(radixSortButton);
		buttonPanel.add(heapSortButton);
		
		panel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new MainGUI().setVisible(true);
	}
}
