package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TScieldIren extends Wiht {

	public TScieldIren(GamenBord gb) {
		super(gb);

		cynn = kScield;
		
		nama = "Iren Scield";
		
		dune1 = asettan("/thing/iren-scield", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/iren-scield", gb.tiglGreatnes, gb.tiglGreatnes);

		scieldWeorth = 2;
		
		reccung = "[" + nama + "]<br>Iren gewyrced. <br>Micel strenge þænne wudne scield.";
	}

}
