package com.ttl.weorcung.wiht;

import com.ttl.weorcung.heorte.GamenBord;

public class Fla extends Wiht {

	Wiht brucere;
	
	public Fla(GamenBord gb) {
		super(gb);
	}

	public void settan(int worldX, int worldY, String weg, boolean cwic, Wiht brucere) {
		
		this.worldX = worldX;
		this.worldY = worldY;
		this.weg = weg;
		this.cwic = cwic;
		this.brucere = brucere;
		this.lif = this.hiegostLif;
	}
	
	@Override
	public void andweardian() {
		
		if(brucere == gb.plega) {
			int sacaTacn = gb.hh.stieranWiht(this, gb.sac);
			
			if(sacaTacn != 999) {
				gb.plega.hearmianFeond(sacaTacn, nidh);
				cwic = false;
			}
		} 
		
		if(brucere != gb.plega) {
			boolean hrinPlega = gb.hh.stieranPlega(this);
			
			if(!gb.plega.untamcul && hrinPlega) {
				hearmianPlega(nidh);
				cwic = false;
			}
		}
		
		switch(weg) {
		case "up": worldY -= snud; break;
		case "dune": worldY += snud; break;
		case "winstre": worldX -= snud; break;
		case "riht": worldX += snud; break;
		}
		
		lif--;
		if(lif <= 0) {
			cwic = false;
		}
		
		pucaTellend++;
		if(pucaTellend > 12) {
			if(pucaGetael == 1) {
				pucaGetael = 2;
			} else if(pucaGetael == 2) {
				pucaGetael = 1;
			}
			pucaTellend = 0;
		}
	}
	
	public boolean haefthLad(Wiht brucere) {
		boolean haefthLad = false;
		return haefthLad;
	}
	
	public void lytlianLad(Wiht brucere) {
	}
}
