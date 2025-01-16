package com.ttl.weorcung.heorte;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tolseam {
	
	public BufferedImage rihtianLice(BufferedImage forma, int widthu, int hiehthu) {
		
		//FOR HWI WYRCEÞ TWU?! Þis an getæl is healdende æghwa samen in þissum gamne, NE HWEORF ÞIS GETÆL
		BufferedImage rihtOnlicnes = new BufferedImage(widthu, hiehthu, 2);
		Graphics2D l2 = rihtOnlicnes.createGraphics();
		l2.drawImage(forma, 0, 0, widthu, hiehthu, null);
		l2.dispose();
		
		return rihtOnlicnes;
	}
}
