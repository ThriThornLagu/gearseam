package com.ttl.weorcung.heorte;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JPanel;

import com.ttl.weorcung.tigel.TiglHandlere;
import com.ttl.weorcung.wiht.Plega;
import com.ttl.weorcung.wiht.Wiht;

public class GamenBord extends JPanel implements Runnable {

	private static final long serialVersionUID = -1625796457926563313L;

	final int foreTigelGreatnes = 16;
	final int greatnes = 3;

	public final int tiglGreatnes = foreTigelGreatnes * greatnes;
	public final int hiehstScirmeStap = 24;
	public final int hiehstScirmedRaew = 18;
	public final int scirmeWidthu = tiglGreatnes * hiehstScirmeStap;
	public final int scirmeHiehthu = tiglGreatnes * hiehstScirmedRaew;

	public final int hiehstWorldStap = 96;
	public final int hiehstWorldRaew = 72;

	int t;
	int FTB = 60;

	TiglHandlere th = new TiglHandlere(this);
	public CaegHandlere cah = new CaegHandlere(this);
	Sweg sang = new Sweg();
	Sweg sweg = new Sweg();
	public HrinHandlere hh = new HrinHandlere(this);
	public HealdungSettere hs = new HealdungSettere(this);
	public BM bm = new BM(this);
	public CirmHandlere cih = new CirmHandlere(this);
	Thread gamenThraed;
	public Plega plega = new Plega(this, cah);
	public Wiht thn[] = new Wiht[10];
	public Wiht nph[] = new Wiht[10];
	public Wiht sac[] = new Wiht[10];
	public ArrayList<Wiht> flanliste = new ArrayList<>();
	ArrayList<Wiht> wihtliste = new ArrayList<>();

	public int gamendom;
	public final int heafodscirmedom = 0;
	public final int plegdom = 1;
	public final int fuldonnes = 2;
	public final int healtedom = 3;
//	public final int slogendom = 4;
	public final int spraecdom = 5;
//	public final int stoppedom = 6;
	public final int haddom = 7;

	public GamenBord() {
		this.setPreferredSize(new Dimension(scirmeWidthu, scirmeHiehthu));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(cah);
		this.setFocusable(true);
	}

	public void asettan() {
		hs.settanThing();
		hs.settanNPH();
		hs.settanFeond();
		gamendom = heafodscirmedom;
	}

	public void onginnanGamenThraed() {
		gamenThraed = new Thread(this);
		gamenThraed.start();
	}

	@Override
	@SuppressWarnings("unused")
	public void run() {

		double dragFaec = 1000000000 / FTB;
		double delta = 0;
		long aerTima = System.nanoTime();
		long andweardTima;
		long timere = 0;
		int dragGetaelu = 0;

		while (gamenThraed != null) {

			andweardTima = System.nanoTime();
			delta += (andweardTima - aerTima) / dragFaec;
			timere += (andweardTima - aerTima);
			aerTima = andweardTima;

			if (delta >= 1) {
				// System.out.println("Eald Englisc, gelice hu us licaþ hit!");
				andweardian();
				repaint();
				delta--;
				dragGetaelu++;
			}

			if (timere >= 1000000000) {
				// System.out.println("Fremmas þurh bearhtm: " + dragGetaelu);
				dragGetaelu = 0;
				timere = 0;
			}
		}
	}

	public void andweardian() {

		if (gamendom == plegdom) {
			plega.andweardian();

			for (t = 0; t < nph.length; t++) {
				if (nph[t] != null) {
					nph[t].andweardian();
				}
			}
			for (t = 0; t < sac.length; t++) {
				if (sac[t] != null) {
					if (sac[t].cwic && !sac[t].cwelende) {
						sac[t].andweardian();
					}
					if (!sac[t].cwic) {
						sac[t] = null;
					}
				}
			}
			for (t = 0; t < flanliste.size(); t++) {
				if (flanliste.get(t) != null) {
					if (flanliste.get(t).cwic) {
						flanliste.get(t).andweardian();
					}
					if (!flanliste.get(t).cwic) {
						flanliste.remove(t);
					}
				}
			}
		}

		if (gamendom == healtedom) {

		}
	}

	public void paintComponent(Graphics l) {
		super.paintComponent(l);
		Graphics2D l2 = (Graphics2D) l;

		if (gamendom == heafodscirmedom) {

			bm.dragan(l2);
		} else {

			th.dragan(l2);

			wihtliste.add(plega);

			for (t = 0; t < nph.length; t++) {
				if (nph[t] != null) {
					wihtliste.add(nph[t]);
				}
			}

			for (t = 0; t < thn.length; t++) {
				if (thn[t] != null) {
					wihtliste.add(thn[t]);
				}
			}

			for (t = 0; t < sac.length; t++) {
				if (sac[t] != null) {
					wihtliste.add(sac[t]);
				}
			}
			
			for (t = 0; t < flanliste.size(); t++) {
				if (flanliste.get(t) != null) {
					wihtliste.add(flanliste.get(t));
				}
			}
		}

		wihtliste.sort(Comparator.comparingInt(thn -> thn.worldY));

		for (t = 0; t < wihtliste.size(); t++) {
			wihtliste.get(t).dragan(l2);
		}

		wihtliste.clear();

		bm.dragan(l2);
		
		if(cah.unpiegung) {
			l2.setFont(l2.getFont().deriveFont(20F));
			l2.setColor(Color.white);
			
			int x = 10;
			int y = 100;
			int raewHiehthu = 20;
			
			l2.drawString("WorldX: " + plega.worldX, x, y); y += raewHiehthu;
			l2.drawString("WorldY: " + plega.worldY, x, y); y += raewHiehthu;
			l2.drawString("Stap: " + (plega.worldX + plega.hittseam.x) / tiglGreatnes, x, y); y += raewHiehthu;
			l2.drawString("Ræw: " + (plega.worldY + plega.hittseam.y) / tiglGreatnes, x, y);
		}
		
		l2.dispose();
	}

	public void pleganSangcraeft(int g) {
		sang.settanThraed(g);
		sang.plegan();
		sang.eftgian();
	}

	public void stoppianSangcraeft() {
		sang.stoppian();
	}

	public void pleganSF(int g) {
		sweg.settanThraed(g);
		sweg.plegan();
	}
}
