package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TBogefodder extends Wiht {

	public TBogefodder(GamenBord gb) {
		super(gb);

		nama = "Bogefodder";
		lice = asettan("/thing/bogefodder-full", gb.tiglGreatnes, gb.tiglGreatnes);
		lice2 = asettan("/thing/bogefodder-aemettig", gb.tiglGreatnes, gb.tiglGreatnes);
	}

}
