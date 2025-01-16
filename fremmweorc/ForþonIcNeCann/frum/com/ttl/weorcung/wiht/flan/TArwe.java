package com.ttl.weorcung.wiht.flan;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Fla;
import com.ttl.weorcung.wiht.Wiht;

public class TArwe extends Fla {

	public TArwe(GamenBord gb) {
		super(gb);
	
		nama = "Arwe";
		snud = 5;
		hiegostLif = 80;
		lif = hiegostLif;
		nidh = 3;
		nyttFeo = 1;
		cwic = false;
		gietanLice();
	}

	public void gietanLice(){
		up1 = asettan("/hada/flan/arwe/up_1", gb.tiglGreatnes, gb.tiglGreatnes);
		up2 = asettan("/hada/flan/arwe/up_2", gb.tiglGreatnes, gb.tiglGreatnes);
		dune1 = asettan("/hada/flan/arwe/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/hada/flan/arwe/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre1 = asettan("/hada/flan/arwe/winstre_1", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre2 = asettan("/hada/flan/arwe/winstre_2", gb.tiglGreatnes, gb.tiglGreatnes);
		riht1 = asettan("/hada/flan/arwe/riht_1", gb.tiglGreatnes, gb.tiglGreatnes);
		riht2 = asettan("/hada/flan/arwe/riht_2", gb.tiglGreatnes, gb.tiglGreatnes);
	}
	
	@Override
	public boolean haefthLad(Wiht brucere) {
		boolean haefthLad = false;
		
		if(brucere.flan >= nyttFeo) {
			haefthLad = true;
		}
		
		return haefthLad;
	}
	
	@Override
	public void lytlianLad(Wiht brucere) {
		brucere.flan -= nyttFeo;
	}
}
