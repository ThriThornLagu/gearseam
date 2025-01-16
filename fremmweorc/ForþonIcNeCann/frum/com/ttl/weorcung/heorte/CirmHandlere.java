package com.ttl.weorcung.heorte;

public class CirmHandlere {

	GamenBord gb;
	CirmFeowerecge cFE[][];
	
	int aerCX, aerCY;
	boolean maegCirmHrinan = true;

	public CirmHandlere(GamenBord gb) {
		this.gb = gb;

		cFE = new CirmFeowerecge[gb.hiehstWorldStap][gb.hiehstWorldRaew];
		
		int stap = 0;
		int raew = 0;
		while(stap < gb.hiehstScirmeStap && raew < gb.hiehstWorldRaew) {
			cFE[stap][raew] = new CirmFeowerecge();
			cFE[stap][raew].x = 23;
			cFE[stap][raew].y = 23;
			cFE[stap][raew].width = 2;
			cFE[stap][raew].height = 2;
			cFE[stap][raew].feStoccX = cFE[stap][raew].x;
			cFE[stap][raew].feStoccY = cFE[stap][raew].y;
			
			stap++;
			if(stap == gb.hiehstScirmeStap) {
				stap = 0;
				raew++;
			}
		}
	}
	
	public void stieranCirm() {
		
		int xFeornres = Math.abs(gb.plega.worldX - aerCX);
		int yFeornres = Math.abs(gb.plega.worldY - aerCY);
		int feorrnes = Math.max(xFeornres, yFeornres);
		if(feorrnes > gb.tiglGreatnes) {
			maegCirmHrinan = true;
		}

		//Settan þing her gelice ðis: if(hittan(x, y, "weg")) {cirm(healfmetras);}
		if(maegCirmHrinan) {
			//if(hittan(19, 48, "any")) {worldEdcennung(gb.spraecdom, "þu wær gehalod");}
		}
	}

	public boolean hittan(int stap, int raew, String tWeg) {

		boolean hittan = false;

		gb.plega.hittseam.x = gb.plega.worldX + gb.plega.hittseam.x;
		gb.plega.hittseam.y = gb.plega.worldY + gb.plega.hittseam.y;
		cFE[stap][raew].x = stap * gb.tiglGreatnes + cFE[stap][raew].x;
		cFE[stap][raew].y = raew * gb.tiglGreatnes + cFE[stap][raew].y;

		if (gb.plega.hittseam.intersects(cFE[stap][raew]) && !cFE[stap][raew].cirmDon) {
			if (gb.plega.weg.contentEquals(tWeg) || tWeg.contentEquals("any")) {
				hittan = true;
				
				aerCX = gb.plega.worldX;
				aerCY = gb.plega.worldY;
			}
		}

		gb.plega.hittseam.x = gb.plega.hittseamStoccX;
		gb.plega.hittseam.y = gb.plega.hittseamStoccY;
		cFE[stap][raew].x = cFE[stap][raew].feStoccX;
		cFE[stap][raew].y = cFE[stap][raew].feStoccY;

		return hittan;
	}
	
	//"maegCirmHrinan" is geeaced to cirme wyrcan hit healtian oþ ðæt plega gæþ onweg of him huru anum tigle.

	public void hearmtreppe(int gamendom, String gewef) {
		gb.gamendom = gamendom;
		gb.bm.andweardSpraec = gewef;
		gb.plega.lif -= 1;
		maegCirmHrinan = true;
	}

	public void worldEdcennung(int gamendom, String gewef) {
		if (gb.cah.hrinende) {
			
			gb.gamendom = gamendom;
			gb.plega.nidhGestoppod = true;
			gb.bm.andweardSpraec = gewef;
			gb.plega.lif = gb.plega.hiegostLif;
		}
	}
	
	public void feorrferan(int gamendom, int stap, int raew) {
		gb.gamendom = gamendom;
		//gb.bm.andweardspraec = "";
		gb.plega.worldX = gb.tiglGreatnes * stap;
		gb.plega.worldY = gb.tiglGreatnes * raew;
	}
	
	public void scendan(int gamendom, int t) {
		gb.gamendom = gamendom;
		
		gb.plega.up1 = gb.nph[t].up1;
		gb.plega.up2 = gb.nph[t].up2;
		gb.plega.dune1 = gb.nph[t].dune1;
		gb.plega.dune2 = gb.nph[t].dune2;
		gb.plega.winstre1 = gb.nph[t].winstre1;
		gb.plega.winstre2 = gb.nph[t].winstre2;
		gb.plega.riht1 = gb.nph[t].riht1;
		gb.plega.riht2 = gb.nph[t].riht2;
		
		maegCirmHrinan = true;
	}
}
