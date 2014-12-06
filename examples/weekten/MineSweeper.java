package examples.weekten;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineSweeper implements ActionListener {
	JFrame frame;
	int height;
	int width;
	int minecount;

	public MineSweeper() {
		this(10, 10);
	}

	public MineSweeper(int i, int j) {
		height = i;
		width = i;
		minecount = j;
	}

	public static void main(String[] args) {
		MineSweeper adder = new MineSweeper();
		adder.show();
	}

	public Component addTopJFrame() {
		JPanel menuPanel = new JPanel();
		JLabel minesLeftLabel = new JLabel("" + minecount);
		JLabel timerLabel = new JLabel("TimeLeft");
		JButton startButton = new JButton("Start");

		menuPanel.setLayout(new BorderLayout(height, width));
		menuPanel.add(minesLeftLabel, BorderLayout.WEST);
		menuPanel.add(timerLabel, BorderLayout.EAST);
		menuPanel.add(startButton, BorderLayout.CENTER);
		return menuPanel;
	}

	public Component addLowerJFrame() {
		JPanel cellPanel = new JPanel();
		cellPanel.setLayout(new GridLayout(height, width));

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				JPanel minePanel = new JPanel();
				minePanel.setLayout(new CardLayout());
				JButton cell = new JButton();
				cell.addActionListener(this);
				JLabel cellinfo = new JLabel();
				//minePanel.add(cell);
				minePanel.add(placeMine(cellinfo));
				cellPanel.add(minePanel);
			}
		}

		return mineCount(cellPanel);
	}

	private Component mineCount(JPanel cellPanel) {
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < height; y++) {
				if (cellPanel.contains(x, y)) {
					cellPanel.getComponentAt(x, y);
				}
			}
		}

		return cellPanel;
	}

	private Component placeMine(JLabel cellinfo) {
		Random rand = new Random();
		if (rand.nextInt((height * width) / height) % 2 == 0) {
			cellinfo.setText("M");
		}
		return cellinfo;
	}

	public void show() {
		JFrame minesweeper = new JFrame();
		minesweeper.setLayout(new BorderLayout());
		minesweeper.add(addTopJFrame(), BorderLayout.NORTH);
		minesweeper.add(addLowerJFrame(), BorderLayout.SOUTH);
		minesweeper.setTitle("MineSweeper");
		minesweeper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		minesweeper.pack();
		minesweeper.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object src = arg0.getSource();
		((JButton) src).setEnabled(false);
		System.out.println("Made it here");
	}

}
