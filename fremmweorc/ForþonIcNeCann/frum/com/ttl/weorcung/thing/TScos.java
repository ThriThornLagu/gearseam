package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TScos extends Wiht {

	public TScos(GamenBord gb) {
		super(gb);

		nama = "Scos";
		dune1 = asettan("/thing/scos", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/scos", gb.tiglGreatnes, gb.tiglGreatnes);

	}
}