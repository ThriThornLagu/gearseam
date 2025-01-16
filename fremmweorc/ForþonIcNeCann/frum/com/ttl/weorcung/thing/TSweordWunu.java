package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TSweordWunu extends Wiht {

	public TSweordWunu(GamenBord gb) {
		super(gb);
		
		cynn = kSweord;

		nama = "Wunu Sweord";
		
		dune1 = asettan("/thing/sweord", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/sweord", gb.tiglGreatnes, gb.tiglGreatnes);
		
		nidhWeorth = 1;
		
		nidhseam.width = 36;
		nidhseam.height = 36;
		
		reccung = "[" + nama + "]<br>Ðu ealrihte onwace mid him, <br>þu ne cnæwst hwær ðu geate hit from.";
	}

}
