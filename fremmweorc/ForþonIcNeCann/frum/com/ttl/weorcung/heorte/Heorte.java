package com.ttl.weorcung.heorte;

import javax.swing.JFrame;

public class Heorte {

	public static void main(String[] feoht) {

		JFrame eagethurl = new JFrame();

		eagethurl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eagethurl.setResizable(false);
		eagethurl.setTitle("We Ne Wittaþ");

		GamenBord gb = new GamenBord();
		eagethurl.add(gb);

		eagethurl.pack();

		eagethurl.setLocationRelativeTo(null);
		eagethurl.setVisible(true);
		
		gb.asettan();
		gb.onginnanGamenThraed();
	}
}
