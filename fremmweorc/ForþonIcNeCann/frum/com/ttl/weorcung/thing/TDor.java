package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TDor extends Wiht {

	public TDor(GamenBord gb) {
		super(gb);

		nama = "Dor";
		dune1 = asettan("/thing/dor", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/dor", gb.tiglGreatnes, gb.tiglGreatnes);
		hrin = true;
		
		hittseam.x = 0;
		hittseam.y = 16;
		hittseam.width = 48;
		hittseam.height = 30;
		hittseamStoccX = hittseam.x = 0;;
		hittseamStoccY = hittseam.y = 16;
	}
}
