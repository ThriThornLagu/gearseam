package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class THlaf extends Wiht {

	int weorth = 4;
	
	public THlaf(GamenBord gb) {
		super(gb);

		cynn = kSwelgendlic;
		nama = "Hlaf";
		
		dune1 = asettan("/thing/hlaf", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/hlaf", gb.tiglGreatnes, gb.tiglGreatnes);
		reccung = "[" + nama + "]<br>Fersc(?) hlaf. <br>Hæleþ þe on þigne.";
	}
	
	@Override
	public void brucan(Wiht wiht) {
		gb.gamendom = gb.spraecdom;
		gb.bm.andweardSpraec = "Þu æte " + nama + ".<br>Þin lif hæfþ gewesen gemagod.";
		wiht.lif += weorth;
		if(gb.plega.lif > gb.plega.hiegostLif) {gb.plega.lif = gb.plega.hiegostLif;}
		gb.pleganSF(4);
	}
}
