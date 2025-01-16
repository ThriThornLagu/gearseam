package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class THordcist extends Wiht {

	public THordcist(GamenBord gb) {
		super(gb);

		nama = "Hordcist";
		dune1 = asettan("/thing/hordcist", gb.tiglGreatnes, gb.tiglGreatnes);		
		dune2 = asettan("/thing/hordcist", gb.tiglGreatnes, gb.tiglGreatnes);

	}
}
