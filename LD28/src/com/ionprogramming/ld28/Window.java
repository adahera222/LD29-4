package com.ionprogramming.ld28;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	 static final long serialVersionUID = 1L;
	 
		private JPanel contentPane;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Window frame = new Window();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public Window() {
			setTitle("LD28 - Warmup");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, Game.width + 6, Game.height + 32);
			contentPane = new JPanel();
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			Game game = new Game();
			contentPane.add(game);
			game.setVisible(true);
			game.init();
			game.start();
		}
}
