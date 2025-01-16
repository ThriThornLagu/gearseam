package com.ttl.weorcung.wiht.flan;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Fla;
import com.ttl.weorcung.wiht.Wiht;

public class TStan extends Fla {

	public TStan(GamenBord gb) {
		super(gb);
	
		nama = "Stan";
		snud = 8;
		hiegostLif = 80;
		lif = hiegostLif;
		nidh = 2;
		nyttFeo = 1;
		cwic = false;
		gietanLice();
	}

	public void gietanLice(){
		up1 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		up2 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		dune1 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre1 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre2 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		riht1 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
		riht2 = asettan("/hada/flan/stan", gb.tiglGreatnes, gb.tiglGreatnes);
	}
	
	@Override
	public boolean haefthLad(Wiht brucere) {
		boolean haefthLad = false;
		
		if(brucere.flanB >= nyttFeo) {
			haefthLad = true;
		}
		
		return haefthLad;
	}
	
	@Override
	public void lytlianLad(Wiht brucere) {
		brucere.flanB -= nyttFeo;
	}
}
