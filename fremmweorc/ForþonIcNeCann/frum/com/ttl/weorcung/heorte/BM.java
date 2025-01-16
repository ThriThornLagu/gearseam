package com.ttl.weorcung.heorte;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.ttl.weorcung.thing.TBogefodder;
import com.ttl.weorcung.thing.THeorte;
import com.ttl.weorcung.wiht.Wiht;

public class BM {

	GamenBord gb;
	Graphics2D l2;
	Font SK, SKB;
	BufferedImage heorte_full, heorte_healf, heorte_sear, bogefodder_full, bogefodder_aemettig;
	public boolean aerrendegewritOn = false;
//	public String aerrendegewrit = "";
//	int writTellend = 0;
	public String andweardSpraec = "";
	ArrayList<String> aerrendegewrit = new ArrayList<>();
	ArrayList<Integer> aerrendegewritTellend = new ArrayList<>();
	public boolean gamenDonIs = false;
	public int bebodGetael = 0;
	
	public int slitteStap = 0;
	public int slitteRaew = 0;

	public BM(GamenBord gb) {
		this.gb = gb;

		try {
			InputStream is = getClass().getResourceAsStream("/staefkund/x12y16pxMaruMonica.ttf");
			SK = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		Wiht heorte = new THeorte(gb);
		heorte_full = heorte.lice;
		heorte_healf = heorte.lice2;
		heorte_sear = heorte.lice3;
		
		Wiht bf = new TBogefodder(gb);
		bogefodder_full = bf.lice;
		bogefodder_aemettig = bf.lice2;
	}
	
	public void eacanAerrendegewrit(String gewef) {
//		aerrendegewrit = gewef;
//		aerrendegewritOn = true;
		
		aerrendegewrit.add(gewef);
		aerrendegewritTellend.add(0);
	}

	public void dragan(Graphics2D l2) {

		this.l2 = l2;

		l2.setFont(SK);
		l2.setColor(Color.white);

		if (gb.gamendom == gb.heafodscirmedom) {
			draganHeafodscirme();
		}

		if (gb.gamendom == gb.plegdom) {
			draganPlegalif();
			draganAerrendegewrit();
		}

		if (gb.gamendom == gb.healtedom) {
			draganPlegalif();
			draganHealtescirme();
		}

		if (gb.gamendom == gb.spraecdom) {
			draganPlegalif();
			draganSpraecscirme();
		}
		
		if (gb.gamendom == gb.haddom) {
			draganHadscirme();
			draganInhealdung();
		}
	}

	public void draganPlegalif() {
		
		int x = gb.tiglGreatnes / 2;
		int y = gb.tiglGreatnes / 2;
		int t = 0;
		
		while(t < gb.plega.hiegostLif / 2) {
			l2.drawImage(heorte_sear, x, y, null);
			t++;
			x += gb.tiglGreatnes + 4;
		}
		
		x = gb.tiglGreatnes / 2;
		y = gb.tiglGreatnes / 2;
		t = 0;
		
		while(t < gb.plega.lif) {
			l2.drawImage(heorte_healf, x, y, null);
			t++;
			if(t < gb.plega.lif) {
				l2.drawImage(heorte_full, x, y, null);
			}
			t++;
			x += gb.tiglGreatnes + 4;
		}
		
		x = gb.tiglGreatnes / 2;
		y = gb.tiglGreatnes * 2;
		t = 0;
		
		while(t < gb.plega.hiegostaFlan) {
			l2.drawImage(bogefodder_aemettig, x, y, null);
			t++;
			
			x += gb.tiglGreatnes;
		}
		
		x = gb.tiglGreatnes / 2;
		y = gb.tiglGreatnes * 2;
		t = 0;
		
		while(t < gb.plega.flan) {
			l2.drawImage(bogefodder_full, x, y, null);
			t++;
			x += gb.tiglGreatnes;
		}
	}
	
	public void draganAerrendegewrit() {
		
		int gewritX = gb.tiglGreatnes;
		int gewritY = gb.tiglGreatnes * 8;
		l2.setFont(l2.getFont().deriveFont(Font.PLAIN, 32F));
		
		for(int t = 0; t < aerrendegewrit.size(); t++) {
			
			if (aerrendegewrit.get(t) != null) {
				
				l2.setColor(Color.black);
				l2.drawString(aerrendegewrit.get(t), gewritX + 2, gewritY + 2);
				
				l2.setColor(Color.white);
				l2.drawString(aerrendegewrit.get(t), gewritX, gewritY);
				
				int tellend = aerrendegewritTellend.get(t) + 1;
				aerrendegewritTellend.set(t, tellend);
				gewritY += 50;
				
				if (aerrendegewritTellend.get(t) > 180) {
					aerrendegewrit.remove(t);
					aerrendegewritTellend.remove(t);
				}
			}
		}
	}
	
	public void draganHeafodscirme() {
		l2.setColor(new Color(80, 64, 90));
		l2.fillRect(0, 0, gb.scirmeWidthu, gb.scirmeHiehthu);
		
		l2.setFont(l2.getFont().deriveFont(Font.BOLD, 80F));
		String gewef = "We ne Wittaþ";
		int x = gietanGewefXforMiddel(gewef);
		int y = gb.tiglGreatnes * 4;
		
		//Ðis.
		
		l2.setColor(Color.black);
		l2.setFont(l2.getFont().deriveFont(Font.ITALIC));
		l2.drawString(gewef, x + 3, y);
		
		l2.setFont(l2.getFont().deriveFont(Font.PLAIN));
		l2.setColor(Color.white);
		l2.drawString(gewef, x, y);
		
		l2.setFont(l2.getFont().deriveFont(Font.BOLD, 40F));
		int widthu = gietanGewefWidthu(gewef);
		
		x += gb.tiglGreatnes * 2;
		gewef = "NIW GAMEN";
		y += gb.tiglGreatnes * 8;
		whscc(0, gewef, x, y, widthu);

		
		gewef = "ÞURHWUNIAN";
		y += gb.tiglGreatnes * 1.5;
		whscc(1, gewef, x, y, widthu);

		
		gewef = "COSTAS";
		y += gb.tiglGreatnes * 1.5;
		whscc(2, gewef, x, y, widthu);

		
		gewef = "LÆFAN GAMEN";
		y += gb.tiglGreatnes * 1.5;
		whscc(3, gewef, x, y, widthu);
		
		
	}
	
	//wyrcan heafocscirme costliste costas
	public void whscc(int t, String gewef, int x, int y, int widthu) {
		
		if(bebodGetael == t) {
			l2.drawRoundRect(x - 4, y - 38, widthu + 16, 44, 15, 15);
			l2.setColor(Color.black);
			l2.setFont(l2.getFont().deriveFont(Font.ITALIC));
			l2.drawString(gewef, x + 3, y);
			l2.setColor(Color.white);
			l2.setFont(l2.getFont().deriveFont(Font.PLAIN));
			l2.drawString(gewef, x, y);
		} else {
		l2.setColor(Color.white);
		l2.setFont(l2.getFont().deriveFont(Font.BOLD));
		l2.drawString(gewef, x, y);
		}
	}
	
	public void draganHealtescirme() {

		l2.setFont(l2.getFont().deriveFont(Font.PLAIN, 80F));

		String gewef = "GEHEALTOD";
		int x = gietanGewefXforMiddel(gewef);
		int y = gb.scirmeHiehthu / 2;

		l2.drawString(gewef, x, y);
	}

	public void draganSpraecscirme() {

		int x = gb.foreTigelGreatnes / 2;
		int y = gb.tiglGreatnes * 14;
		int widthu = gb.scirmeWidthu - x * 2;
		int hiehthu = gb.tiglGreatnes * 4 - gb.foreTigelGreatnes / 2;

		draganUnderEagethurl(x, y, widthu, hiehthu);

		l2.setFont(l2.getFont().deriveFont(Font.PLAIN, 32F));

		x += 16;
		y += 40;

		for (String raew : andweardSpraec.split("<br>")) {
			l2.drawString(raew, x, y);
			y += 40;
		}
	}

	public void draganHadscirme() {
		
		final int fremmX = gb.tiglGreatnes;
		final int fremmY = gb.tiglGreatnes;
		final int fremmWidthu = gb.tiglGreatnes * 7;
		final int fremmHiehthu = (int) (gb.tiglGreatnes * 10.5);
		
		draganUnderEagethurl(fremmX, fremmY, fremmWidthu, fremmHiehthu);
		
		l2.setColor(Color.white);
		l2.setFont(l2.getFont().deriveFont(32F));
		
		int gewefX = fremmX + 20;
		int gewefY = fremmY + gb.tiglGreatnes;
		final int raewHiehthu = 35;
		
		l2.drawString("Amete:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Lif:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Scotu:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Strengþu:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Arodscipe:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Nið:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Forescieldung:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Cun:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("To Niehstne Amete:", gewefX, gewefY);
		gewefY += raewHiehthu;
		l2.drawString("Gold:", gewefX, gewefY);
		gewefY += raewHiehthu + 20;
		l2.drawString("Weapon:", gewefX, gewefY);
		gewefY += raewHiehthu + 15;
		l2.drawString("Scield:", gewefX, gewefY);
		gewefY += raewHiehthu;
		
		int taeglX = (fremmX + fremmWidthu) - 30;
		gewefY = fremmY + gb.tiglGreatnes;
		String weorth;
		
		weorth = String.valueOf(gb.plega.amete);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.lif + "/" + gb.plega.hiegostLif);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.flan + "/" + gb.plega.hiegostaFlan);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.strengthu);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.arodscipe);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.nidh);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.forescieldung);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.cun);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.niehstAmeteCun);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		weorth = String.valueOf(gb.plega.gold);
		gewefX = gietanGewefXforRiht(weorth, taeglX);
		l2.drawString(weorth, gewefX, gewefY);
		gewefY += raewHiehthu;
		
		l2.drawImage(gb.plega.andweardWeapon.dune1, taeglX - gb.tiglGreatnes, gewefY - 16, null);
		gewefY += gb.tiglGreatnes;
		
		l2.drawImage(gb.plega.andweardScield.dune1, taeglX - gb.tiglGreatnes, gewefY - 12, null);
	}
	
	public void draganInhealdung() {
		
		int fremmX = gb.tiglGreatnes * 14;
		int fremmY = gb.tiglGreatnes;
		int fremmWidthu = gb.tiglGreatnes * 9;
		int fremmHiehthu = gb.tiglGreatnes * 6;
				
		draganUnderEagethurl(fremmX, fremmY, fremmWidthu, fremmHiehthu);
		
		final int slitteXAnginn = fremmX + 20;
		final int slitteYAnginn = fremmY + 20;
		int slitteX = slitteXAnginn;
		int slitteY = slitteYAnginn;
		int slitteGreatnes = gb.tiglGreatnes + 3;
		
		for (int g = 0; g < gb.plega.inhealdung.size(); g++) {
			
			if(gb.plega.inhealdung.get(g) == gb.plega.andweardWeapon || 
					gb.plega.inhealdung.get(g) == gb.plega.andweardScield) {
				l2.setColor(new Color(255, 222, 147));
				l2.fillRoundRect(slitteX, slitteY, gb.tiglGreatnes, gb.tiglGreatnes, 10, 10);
				
			}
			
			l2.drawImage(gb.plega.inhealdung.get(g).dune1, slitteX, slitteY, null);
			
			slitteX += slitteGreatnes;
			
			if (g == 7 || g == 15 || g == 23 || g == 31) {
				slitteX = slitteXAnginn;
				slitteY += slitteGreatnes;
			}
		}
		
		int taecnendX = slitteXAnginn + (slitteGreatnes * slitteStap);
		int taecnendY = slitteYAnginn + (slitteGreatnes * slitteRaew);
		int taecnendeWidthu = gb.tiglGreatnes;
		int taecnendHiehthu = gb.tiglGreatnes;
		
		l2.setColor(Color.white);
		l2.setStroke(new BasicStroke(3));
		l2.drawRoundRect(taecnendX, taecnendY, taecnendeWidthu, taecnendHiehthu, 10, 10);
		
		int rFremmX = fremmX - gb.tiglGreatnes;
		int rFremmY = fremmY + fremmHiehthu;
		int rFremmWidthu = fremmWidthu + gb.tiglGreatnes;
		int rFremmHiehthu = gb.tiglGreatnes * 4;
		
		int gewefX = rFremmX + 20;
		int gewefY = rFremmY + gb.tiglGreatnes;
		l2.setFont(l2.getFont().deriveFont(28F));
		
		int thingTacn = gietanThingTacn();
		
		if(thingTacn < gb.plega.inhealdung.size()) {
			
			draganUnderEagethurl(rFremmX, rFremmY, rFremmWidthu, rFremmHiehthu);
			
			for(String raew: gb.plega.inhealdung.get(thingTacn).reccung.split("<br>")) {
				
				l2.drawString(raew, gewefX, gewefY);
				gewefY += 32;
			}
		}
	}
	
	public int gietanThingTacn() {
		int thingTacn = slitteStap + (slitteRaew * 8);
		return thingTacn;
	}
	
	public void draganUnderEagethurl(int x, int y, int widthu, int hiehthu) {

		Color h = new Color(0, 0, 0, 255);
		l2.setColor(new Color(40, 40, 40, 200));
		l2.fillRoundRect(x, y, widthu, hiehthu, 28, 28);

		h = new Color(240, 240, 240, 255);
		l2.setColor(h);
		l2.setStroke(new BasicStroke(5));
		l2.drawRoundRect(x + 5, y + 5, widthu - 11, hiehthu - 11, 25, 25);
	}

	public int gietanGewefXforMiddel(String gewef) {
		int lengthu = gietanGewefWidthu(gewef);
		int x = gb.scirmeWidthu / 2 - lengthu / 2;
		return x;
	}
	
	public int gietanGewefXforRiht(String gewef, int tX) {
		int lengthu = gietanGewefWidthu(gewef);
		int x = tX - lengthu;
		return x;
	}
	
	public int gietanGewefWidthu(String gewef) {
		int lengthu = (int) l2.getFontMetrics().getStringBounds(gewef, l2).getWidth();
		return lengthu;
	}
}
