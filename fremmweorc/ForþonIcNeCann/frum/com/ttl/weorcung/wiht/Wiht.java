package com.ttl.weorcung.wiht;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.heorte.Tolseam;

public class Wiht {

	public GamenBord gb;
	public int worldX, worldY, snud;
	public BufferedImage up1, up2, dune1, dune2, winstre1, winstre2, riht1, riht2;
	public BufferedImage nidhUp1, nidhUp2, nidhDune1, nidhDune2, nidhWinstre1, nidhWinstre2, nidhRiht1, nidhRiht2;
	public String weg = "dune";
	public boolean hrin = false;
	public BufferedImage lice, lice2, lice3;
	public Rectangle nidhseam = new Rectangle(0, 0, 0, 0);

	public int daedLoca = 0;
	public boolean untamcul = false;
	public boolean raesende = false;
	public boolean cwic = true;
	public boolean cwelende = false;
	public boolean hoRodOn = false;

	public int pucaTellend = 0;
	public int pucaGetael = 1;
	public int scotFreoTellend = 0;
	public int untamculTellend = 0;
	public int cwelendeTellend = 0;
	public int hoRodTellend = 0;

	public String spraeca[] = new String[20];
	public int spraecT = 0;

	public int hiegostLif, lif;
	public int hiegostaFlan, flan, flanB;
	public String nama;
	public Rectangle hittseam = new Rectangle(0, 0, 48, 48);
	public int hittseamStoccX, hittseamStoccY;
	public boolean hrinOn = false;
	
	public int amete;
	public int strengthu;
	public int arodscipe;
	public int nidh;
	public int forescieldung;
	public int cun;
	public int niehstAmeteCun;
	public int gold;
	public Wiht andweardWeapon;
	public Wiht andweardScield;
	public Fla fla;
	
	public int nidhWeorth;
	public int scieldWeorth;
	public String reccung = "";
	public int nyttFeo;
	
	public int cynn; // 0 = plega, 1 = nph, 2 = feond
	public final int kPlega = 0;
	public final int kNPH = 1;
	public final int kFeond = 2;
	public final int kWendfeond = 3;
	public final int kSweord = 4;
	public final int kAex = 5;
	public final int kScield = 6;
	public final int kSwelgendlic = 7;

	public Wiht(GamenBord gb) {
		this.gb = gb;
	}
	
	public void settanDaed() {
	}
	
	public void hearmEddaed() {
	}

	public void spreccan() {

		if (spraeca[spraecT] == null) {
			spraecT = 0;
		}

		gb.bm.andweardSpraec = spraeca[spraecT];
		spraecT++;

		switch (gb.plega.weg) {
		case "up":
			weg = "dune";
			break;
		case "dune":
			weg = "up";
			break;
		case "winstre":
			weg = "riht";
			break;
		case "riht":
			weg = "winstre";
			break;
		}
	}

	public void brucan(Wiht wiht) {}
	
	public void andweardian() {
		settanDaed();

		hrinOn = false;
		gb.hh.stieranTigel(this);
		gb.hh.stieranThing(this, false);
		gb.hh.stieranWiht(this, gb.nph);
		gb.hh.stieranWiht(this, gb.sac);
		boolean hrinendePlega = gb.hh.stieranPlega(this);

		if (this.cynn == kFeond && hrinendePlega) {
			hearmianPlega(nidh);
		}

		if (!hrinOn) {
			switch (weg) {
			case "up":
				worldY -= snud;
				break;
			case "dune":
				worldY += snud;
				break;
			case "winstre":
				worldX -= snud;
				break;
			case "riht":
				worldX += snud;
				break;
			}
		}

		if (untamcul) {
			untamculTellend++;
			if (untamculTellend > 45) {
				untamcul = false;
				untamculTellend = 0;
			}
		}
		
		if(scotFreoTellend < 30) {
			scotFreoTellend++;
		}
	}

	public void hearmianPlega(int nidh) {
		if (!gb.plega.untamcul) {
			gb.pleganSF(10);
			int hearm = nidh - gb.plega.forescieldung;
			if (hearm < 0) {
				hearm = 0;
			}
			
			gb.plega.lif -= hearm;
			gb.plega.untamcul = true;
		}
	}
	
	public void dragan(Graphics2D l2) {

		int scirmeX = worldX - gb.plega.worldX + gb.plega.scirmeX;
		int scirmeY = worldY - gb.plega.worldY + gb.plega.scirmeY;

		if (worldX + gb.tiglGreatnes > gb.plega.worldX - gb.plega.scirmeX
				&& worldX - gb.tiglGreatnes < gb.plega.worldX + gb.plega.scirmeX
				&& worldY + gb.tiglGreatnes > gb.plega.worldY - gb.plega.scirmeY
				&& worldY - gb.tiglGreatnes < gb.plega.worldY + gb.plega.scirmeY) {

			BufferedImage onlicnes = null;

			switch (weg) {
			case "up":
				if (pucaGetael == 1) {
					onlicnes = up1;
				}
				if (pucaGetael == 2) {
					onlicnes = up2;
				}
				break;
			case "dune":
				if (pucaGetael == 1) {
					onlicnes = dune1;
				}
				if (pucaGetael == 2) {
					onlicnes = dune2;
				}
				break;
			case "winstre":
				if (pucaGetael == 1) {
					onlicnes = winstre1;
				}
				if (pucaGetael == 2) {
					onlicnes = winstre2;
				}
				break;
			case "riht":
				if (pucaGetael == 1) {
					onlicnes = riht1;
				}
				if (pucaGetael == 2) {
					onlicnes = riht2;
				}
				break;
			}

			if (cynn == 2 && hoRodOn) {

				double anGreatnes = (double) gb.tiglGreatnes / hiegostLif;
				double hoRodWeorth = anGreatnes * lif;

				l2.setColor(new Color(35, 35, 35));
				l2.fillRect(scirmeX - 2, scirmeY - 20, gb.tiglGreatnes + 4, 13);

				l2.setColor(new Color(255, 48, 86));
				l2.fillRect(scirmeX, scirmeY - 18, (int) hoRodWeorth, 10);
				
				hoRodTellend++;
				
				if (hoRodTellend > 600) {
					hoRodTellend = 0;
					hoRodOn = false;
				}
			}

			pucaTellend++;
			if (pucaTellend > 12) {
				if (pucaGetael == 1) {
					pucaGetael = 2;
				} else if (pucaGetael == 2) {
					pucaGetael = 1;
				}
				pucaTellend = 0;
			}

			if (untamcul) {
				hoRodOn = true;
				hoRodTellend = 0;
				hweorfanAlfa(l2, 0.5F);
			}

			if (cwelende) {
				cwelungLifung(l2);
			}

			l2.drawImage(onlicnes, scirmeX, scirmeY, null);

			hweorfanAlfa(l2, 1F);
		}
	}

	public void cwelungLifung(Graphics2D l2) {

		int g = 5;

		cwelendeTellend++;
		if (cwelendeTellend <= g) {
			hweorfanAlfa(l2, 0f);
		}
		if (cwelendeTellend > g && cwelendeTellend <= g * 2) {
			hweorfanAlfa(l2, 1f);
		}
		if (cwelendeTellend > g * 2 && cwelendeTellend <= g * 3) {
			hweorfanAlfa(l2, 0f);
		}
		if (cwelendeTellend > g * 3 && cwelendeTellend <= g * 4) {
			hweorfanAlfa(l2, 1f);
		}
		if (cwelendeTellend > g * 4 && cwelendeTellend <= g * 5) {
			hweorfanAlfa(l2, 0f);
		}
		if (cwelendeTellend > g * 5 && cwelendeTellend <= g * 6) {
			hweorfanAlfa(l2, 1f);
		}
		if (cwelendeTellend > g * 6 && cwelendeTellend <= g * 7) {
			hweorfanAlfa(l2, 0f);
		}
		if (cwelendeTellend > g * 7 && cwelendeTellend <= g * 8) {
		}

		if (cwelendeTellend > g * 8) {
			cwic = false;
		}
	}

	public void hweorfanAlfa(Graphics2D l2, float a) {
		l2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, a));
	}

	public BufferedImage asettan(String licepaedh, int widthu, int hiehthu) {

		Tolseam tol = new Tolseam();
		BufferedImage lice = null;

		try {
			lice = ImageIO.read(getClass().getResourceAsStream(licepaedh + ".png"));
			lice = tol.rihtianLice(lice, widthu, hiehthu);
		} catch (IOException b) {
			b.printStackTrace();
		}
		return lice;
	}

	public void torhtianSpraeca() {

		for (int t = 0; t < spraeca.length; t++) {
			spraeca[t] = null;
		}
	}
}
