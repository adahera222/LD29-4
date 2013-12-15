package com.ionprogramming.ld28;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	 static final long serialVersionUID = 1L;
	 
		private JPanel contentPane;
		public static Window frame;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new Window();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public Window() {
			setTitle("LD28");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, Game.width + 6, Game.height + 32);
			setMinimumSize(new Dimension(780 + 6, 520 + 32));
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
