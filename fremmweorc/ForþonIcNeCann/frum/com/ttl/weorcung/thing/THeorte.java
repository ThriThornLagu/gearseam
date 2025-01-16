package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class THeorte extends Wiht {

	public THeorte(GamenBord gb) {

		super(gb);

		nama = "Heorte";
		lice = asettan("/thing/heorte_full", gb.tiglGreatnes, gb.tiglGreatnes);
		lice2 = asettan("/thing/heorte_healf", gb.tiglGreatnes, gb.tiglGreatnes);
		lice3 = asettan("/thing/heorte_sear", gb.tiglGreatnes, gb.tiglGreatnes);
	}
}