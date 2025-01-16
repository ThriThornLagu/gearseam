package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TScieldWudu extends Wiht {

	public TScieldWudu(GamenBord gb) {
		super(gb);

		cynn = kScield;
		
		nama = "Wudu Scield";
		
		dune1 = asettan("/thing/wudu-scield", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/wudu-scield", gb.tiglGreatnes, gb.tiglGreatnes);

		scieldWeorth = 1;
		
		reccung = "[" + nama + "]<br>Micel gelice þone sweord, þu ealrihte <br>onwace mid him in þinum poccum.";
	}

}
