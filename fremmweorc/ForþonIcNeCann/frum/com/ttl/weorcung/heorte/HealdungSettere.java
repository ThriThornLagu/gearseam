package com.ttl.weorcung.heorte;

import com.ttl.weorcung.thing.TAexWunu;
import com.ttl.weorcung.thing.TCaeg;
import com.ttl.weorcung.thing.THlaf;
import com.ttl.weorcung.thing.TScieldIren;
import com.ttl.weorcung.wiht.feond.FBanseten;
import com.ttl.weorcung.wiht.feond.FSwamm;
import com.ttl.weorcung.wiht.nph.NPHLibbendeHwitWulf;

public class HealdungSettere {

	GamenBord gb;
	int t;

	public HealdungSettere(GamenBord gb) {
		this.gb = gb;
	}

	public void settanThing() {
		t = 0;
		
		gb.thn[t] = new TCaeg(gb);
		gb.thn[t].worldX = gb.tiglGreatnes * 30;
		gb.thn[t].worldY = gb.tiglGreatnes * 50;
		t++;
		
		gb.thn[t] = new TCaeg(gb);
		gb.thn[t].worldX = gb.tiglGreatnes * 35;
		gb.thn[t].worldY = gb.tiglGreatnes * 56;
		t++;
		
		gb.thn[t] = new TCaeg(gb);
		gb.thn[t].worldX = gb.tiglGreatnes * 43;
		gb.thn[t].worldY = gb.tiglGreatnes * 62;
		t++;
		
		gb.thn[t] = new TAexWunu(gb);
		gb.thn[t].worldX = gb.tiglGreatnes * 14;
		gb.thn[t].worldY = gb.tiglGreatnes * 52;
		t++;
		
		gb.thn[t] = new TScieldIren(gb);
		gb.thn[t].worldX = gb.tiglGreatnes * 19;
		gb.thn[t].worldY = gb.tiglGreatnes * 52;
		t++;
		
		gb.thn[t] = new THlaf(gb);
		gb.thn[t].worldX = gb.tiglGreatnes * 30;
		gb.thn[t].worldY = gb.tiglGreatnes * 52;
		t++;
	}

	public void settanNPH() {
		t = 0;
		
		gb.nph[t] = new NPHLibbendeHwitWulf(gb);
		gb.nph[t].worldX = gb.tiglGreatnes * 19;
		gb.nph[t].worldY = gb.tiglGreatnes * 61;
		t++;
		
		gb.nph[t] = new NPHLibbendeHwitWulf(gb);
		gb.nph[t].worldX = gb.tiglGreatnes * 16;
		gb.nph[t].worldY = gb.tiglGreatnes * 62;
	}

	public void settanFeond() {
		t = 0;
		
		gb.sac[t] = new FSwamm(gb);
		gb.sac[t].worldX = gb.tiglGreatnes * 24;
		gb.sac[t].worldY = gb.tiglGreatnes * 64;
		t++;
		
		gb.sac[t] = new FSwamm(gb);
		gb.sac[t].worldX = gb.tiglGreatnes * 24;
		gb.sac[t].worldY = gb.tiglGreatnes * 65;
		t++;
		
		gb.sac[t] = new FSwamm(gb);
		gb.sac[t].worldX = gb.tiglGreatnes * 24;
		gb.sac[t].worldY = gb.tiglGreatnes * 60;
		t++;
		
		gb.sac[t] = new FBanseten(gb);
		gb.sac[t].worldX = gb.tiglGreatnes * 55;
		gb.sac[t].worldY = gb.tiglGreatnes * 60;
		t++;
		
		gb.sac[t] = new FBanseten(gb);
		gb.sac[t].worldX = gb.tiglGreatnes * 60;
		gb.sac[t].worldY = gb.tiglGreatnes * 55;
		t++;
	
		gb.sac[t] = new FBanseten(gb);
		gb.sac[t].worldX = gb.tiglGreatnes * 55;
		gb.sac[t].worldY = gb.tiglGreatnes * 65;
		t++;
	}
}
