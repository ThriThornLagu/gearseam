package com.ttl.weorcung.wiht;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ttl.weorcung.heorte.CaegHandlere;
import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.thing.TCaeg;
import com.ttl.weorcung.thing.TScieldWudu;
import com.ttl.weorcung.thing.TSweordWunu;
import com.ttl.weorcung.wiht.flan.TArwe;

public class Plega extends Wiht {

	CaegHandlere ch;

	public final int scirmeX, scirmeY;
	int standTellend = 0;
	public boolean nidhGestoppod = false;
	public ArrayList<Wiht> inhealdung = new ArrayList<>();
	public final int inhealdungGreatnes = 40;

	public Plega(GamenBord gb, CaegHandlere ch) {
		super(gb);

		this.ch = ch;

		scirmeX = gb.scirmeWidthu / 2 - (gb.tiglGreatnes / 2);
		scirmeY = gb.scirmeHiehthu / 2 - (gb.tiglGreatnes / 2);

		// hittseam = new Rectangle(8, 16, 32, 40);
		hittseam.x = 8;
		hittseam.y = 16;
		hittseam.width = 32;
		hittseam.height = 40;
		hittseamStoccX = hittseam.x;
		hittseamStoccY = hittseam.y;

//		nidhseam.width = 36;
//		nidhseam.height = 36;

		settanStoccas();
		gietanLice();
		gietanNidhLice();
		settanThing();
	}
	
	public void settanThing() {
		
		inhealdung.add(andweardWeapon);
		inhealdung.add(andweardScield);
		inhealdung.add(new TCaeg(gb));
	}

	public void settanStoccas() {
		worldX = gb.tiglGreatnes * 19;
		worldY = gb.tiglGreatnes * 55;
		snud = 4;
		weg = "dune";

		amete = 1;
		hiegostLif = 6;
		hiegostaFlan = 6;
//		flanB = 10;
		flan = hiegostaFlan;
		lif = hiegostLif;
		strengthu = 1;
		arodscipe = 1;
		cun = 0;
		niehstAmeteCun = 5;
		gold = 0;
		
		andweardWeapon = new TSweordWunu(gb);
		andweardScield = new TScieldWudu(gb);
		
		fla = new TArwe(gb);
		
		nidh = gietanNidh();
		forescieldung = gietanForescieldung();
	}
	
	public int gietanNidh() {
		nidhseam = andweardWeapon.nidhseam;
		return nidh = strengthu * andweardWeapon.nidhWeorth;
	}
	
	public int gietanForescieldung() {
		return forescieldung = arodscipe * andweardScield.scieldWeorth;
	}

	public void gietanLice() {
		up1 = asettan("/hada/plega/up_1", gb.tiglGreatnes, gb.tiglGreatnes);
		up2 = asettan("/hada/plega/up_2", gb.tiglGreatnes, gb.tiglGreatnes);
		dune1 = asettan("/hada/plega/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/hada/plega/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre1 = asettan("/hada/plega/winstre_1", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre2 = asettan("/hada/plega/winstre_2", gb.tiglGreatnes, gb.tiglGreatnes);
		riht1 = asettan("/hada/plega/riht_1", gb.tiglGreatnes, gb.tiglGreatnes);
		riht2 = asettan("/hada/plega/riht_2", gb.tiglGreatnes, gb.tiglGreatnes);
	}

	public void gietanNidhLice() {
		
		if (andweardWeapon.cynn == kSweord) {
			nidhUp1 = asettan("/hada/plega/sweord_up_1", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhUp2 = asettan("/hada/plega/sweord_up_2", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhDune1 = asettan("/hada/plega/sweord_dune_1", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhDune2 = asettan("/hada/plega/sweord_dune_2", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhWinstre1 = asettan("/hada/plega/sweord_winstre_1", gb.tiglGreatnes * 2, gb.tiglGreatnes);
			nidhWinstre2 = asettan("/hada/plega/sweord_winstre_2", gb.tiglGreatnes * 2, gb.tiglGreatnes);
			nidhRiht1 = asettan("/hada/plega/sweord_riht_1", gb.tiglGreatnes * 2, gb.tiglGreatnes);
			nidhRiht2 = asettan("/hada/plega/sweord_riht_2", gb.tiglGreatnes * 2, gb.tiglGreatnes);
		}
		
		if (andweardWeapon.cynn == kAex) {
			nidhUp1 = asettan("/hada/plega/aex_up_1", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhUp2 = asettan("/hada/plega/aex_up_2", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhDune1 = asettan("/hada/plega/aex_dune_1", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhDune2 = asettan("/hada/plega/aex_dune_2", gb.tiglGreatnes, gb.tiglGreatnes * 2);
			nidhWinstre1 = asettan("/hada/plega/aex_winstre_1", gb.tiglGreatnes * 2, gb.tiglGreatnes);
			nidhWinstre2 = asettan("/hada/plega/aex_winstre_2", gb.tiglGreatnes * 2, gb.tiglGreatnes);
			nidhRiht1 = asettan("/hada/plega/aex_riht_1", gb.tiglGreatnes * 2, gb.tiglGreatnes);
			nidhRiht2 = asettan("/hada/plega/aex_riht_2", gb.tiglGreatnes * 2, gb.tiglGreatnes);
		}
	}
	
	@Override
	public void andweardian() {

		if (raesende) {
			raesende();
		}

		else if (ch.upThrungen || ch.nitherThrungen || ch.winstreThrungen || ch.rihtThrungen || ch.hrinende) {
			if (ch.upThrungen) {
				weg = "up";
			} else if (ch.nitherThrungen) {
				weg = "dune";
			} else if (ch.winstreThrungen) {
				weg = "winstre";
			} else if (ch.rihtThrungen) {
				weg = "riht";
			}

			hrinOn = false;
			gb.hh.stieranTigel(this);

			int thingTacn = gb.hh.stieranThing(this, true);
			upPycanThing(thingTacn);

			int nphTacn = gb.hh.stieranWiht(this, gb.nph);
			hrinNPH(nphTacn);

			int sacaTacn = gb.hh.stieranWiht(this, gb.sac);
			hrinSaca(sacaTacn);

			gb.cih.stieranCirm();

			if (!hrinOn && !ch.hrinende) {
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
			
			if (ch.hrinende && !nidhGestoppod) {
				gb.pleganSF(9);
				raesende = true;
				pucaGetael = 0;
			}

			nidhGestoppod = false;
			gb.cah.hrinende = false;

			pucaTellend++;
			if (pucaTellend > 12) {
				if (pucaGetael == 1) {
					pucaGetael = 2;
				} else if (pucaGetael == 2) {
					pucaGetael = 1;
				}
				pucaTellend = 0;
			}
		} else {
			standTellend++;
			if (standTellend == 20) {
				pucaGetael = 1;
				standTellend = 0;
			}
		}
		
		if (gb.cah.scot && !fla.cwic && scotFreoTellend == 30 && fla.haefthLad(this)) {
			fla.settan(worldX, worldY, weg, true, this);
			
			gb.flanliste.add(fla);
			
			fla.lytlianLad(this);
		
			scotFreoTellend = 0;
			
			gb.pleganSF(15);
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

	public void raesende() {

		pucaTellend++;

		if (pucaTellend <= 5) {
			pucaGetael = 1;
		}
		if (pucaTellend > 5 && pucaTellend <= 25) {
			pucaGetael = 2;

			int andweardWorldX = worldX, andweardWorldY = worldY, hittseamWidthu = hittseam.width,
					hittseamHiehthu = hittseam.height;

			switch (weg) {
			case "up":
				worldY -= nidhseam.height;
				break;
			case "dune":
				worldY += nidhseam.height;
				break;
			case "winstre":
				worldX -= nidhseam.width;
				break;
			case "riht":
				worldX += nidhseam.width;
				break;
			}

			hittseam.width = nidhseam.width;
			hittseam.height = nidhseam.height;

			int sacaTacen = gb.hh.stieranWiht(this, gb.sac);
			hearmianFeond(sacaTacen, nidh);

			worldX = andweardWorldX;
			worldY = andweardWorldY;
			hittseam.width = hittseamWidthu;
			hittseam.height = hittseamHiehthu;
		}
		if (pucaTellend > 25) {
			pucaGetael = 1;
			pucaTellend = 0;
			raesende = false;
		}
	}

	public void upPycanThing(int t) {

		if (t != 999) {
			String gewef;

			if(inhealdung.size() != inhealdungGreatnes) {
				
				inhealdung.add(gb.thn[t]);
				gb.pleganSF(14);
				gewef = gb.thn[t].nama + " gegeaten!";
			}
			else {
				gewef = "Na ma ne mægst þu ne beran!";
			}
			gb.bm.eacanAerrendegewrit(gewef);
			gb.thn[t] = null;
		}
	}

	public void hrinNPH(int t) {

		if (gb.cah.hrinende) {
			if (t != 999) {
				nidhGestoppod = true;
				gb.gamendom = gb.spraecdom;
				gb.nph[t].spreccan();
			}
		}
	}

	public void hrinSaca(int t) {

		if (t != 999) {
			if (!untamcul && !gb.sac[t].cwelende) {
				gb.pleganSF(10);
				
				int hearm = gb.sac[t].nidh - forescieldung;
				if (hearm < 0) {
					hearm = 0;
				}
				
				lif -= hearm;
				untamcul = true;
			}
		}

	}

	public void hearmianFeond(int t, int nidh) {

		if (t != 999) {
			
			if (!gb.sac[t].untamcul) {
				
				gb.pleganSF(10);
				
				int hearm = nidh - gb.sac[t].forescieldung;
				if (hearm < 0) {
					hearm = 0;
				}
				
				gb.sac[t].lif -= hearm;
				gb.bm.eacanAerrendegewrit(hearm + " hearm gedæled!");
				
				gb.sac[t].untamcul = true;
				gb.sac[t].hearmEddaed();
				
				if (gb.sac[t].lif <= 0) {
					gb.sac[t].cwelende = true;
					gb.bm.eacanAerrendegewrit(gb.sac[t].nama + " hæfþ gewesen gesolgen!");
					gb.bm.eacanAerrendegewrit(gb.sac[t].cun + " cun gegan!");
					cun += gb.sac[t].cun;
					stieranBetterung();
				}
			}
		}
	}

	public void stieranBetterung() {
		
		if (cun >= niehstAmeteCun) {
			
			amete++;
			niehstAmeteCun = (int) (niehstAmeteCun * 2.75f);
			hiegostLif += 2;
			strengthu++;
			arodscipe++;
			nidh = gietanNidh();
			forescieldung = gietanForescieldung();
			
			gb.pleganSF(13);
			gb.gamendom = gb.spraecdom;
			gb.bm.andweardSpraec = "Þu eart nu amete: " + amete + "!";
		}
	}
	
	public void ceosanThing() {
		
		int thingTacn = gb.bm.gietanThingTacn();
		
		if(thingTacn < inhealdung.size()) {
			Wiht gecorenThing = inhealdung.get(thingTacn);
			
			if(gecorenThing.cynn == kSweord || gecorenThing.cynn == kAex) {
				
				andweardWeapon = gecorenThing;
				nidh = gietanNidh();
				gietanNidhLice();
			}
			
			if(gecorenThing.cynn == kScield) {
				
				andweardScield = gecorenThing;
				forescieldung = gietanForescieldung();
			}
			
			if(gecorenThing.cynn == kSwelgendlic) {
				
				gecorenThing.brucan(this);
				inhealdung.remove(thingTacn);
			}
		}
	}
	
	public void dragan(Graphics2D l2) {

		// l2.setColor(Color.black);
		// l2.fillRect(x, y, gb.tigelGreatnes, gb.tigelGreatnes);

		BufferedImage onlicnes = null;
		int laeneScirmeX = scirmeX;
		int laeneScirmeY = scirmeY;

		switch (weg) {
		case "up":
			if (!raesende) {
				if (pucaGetael == 1) {
					onlicnes = up1;
				}
				if (pucaGetael == 2) {
					onlicnes = up2;
				}
			}

			if (raesende) {
				laeneScirmeY = scirmeY - gb.tiglGreatnes;
				if (pucaGetael == 1) {
					onlicnes = nidhUp1;
				}
				if (pucaGetael == 2) {
					onlicnes = nidhUp2;
				}
			}
			break;
		case "dune":
			if (!raesende) {
				if (pucaGetael == 1) {
					onlicnes = dune1;
				}
				if (pucaGetael == 2) {
					onlicnes = dune2;
				}
			}

			if (raesende) {
				if (pucaGetael == 1) {
					onlicnes = nidhDune1;
				}
				if (pucaGetael == 2) {
					onlicnes = nidhDune2;
				}
			}
			break;
		case "winstre":
			if (!raesende) {
				if (pucaGetael == 1) {
					onlicnes = winstre1;
				}
				if (pucaGetael == 2) {
					onlicnes = winstre2;
				}
			}

			if (raesende) {
				laeneScirmeX = scirmeX - gb.tiglGreatnes;
				if (pucaGetael == 1) {
					onlicnes = nidhWinstre1;
				}
				if (pucaGetael == 2) {
					onlicnes = nidhWinstre2;
				}
			}
			break;
		case "riht":
			if (!raesende) {
				if (pucaGetael == 1) {
					onlicnes = riht1;
				}
				if (pucaGetael == 2) {
					onlicnes = riht2;
				}
			}

			if (raesende) {
				if (pucaGetael == 1) {
					onlicnes = nidhRiht1;
				}
				if (pucaGetael == 2) {
					onlicnes = nidhRiht2;
				}
			}
			break;
		}

		if (untamcul) {
			l2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3F));
		}

		l2.drawImage(onlicnes, laeneScirmeX, laeneScirmeY, null);

		l2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1F));

//		l2.setFont(new Font("Arial", Font.PLAIN, 35));
//		l2.setColor(Color.white);
//		l2.drawString("Untamcul for " + untamculTellend, 200, 400);
	}
}
