package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TCaeg extends Wiht {

	public TCaeg(GamenBord gb) {
		super(gb);

		nama = "Cæg";
		dune1 = asettan("/thing/caeg", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/caeg", gb.tiglGreatnes, gb.tiglGreatnes);
		reccung = "[" + nama + "]<br>Cæg gebryced opennian hwæthwene.<br>Ic wundrie hwær to hit gæþ?";
	}
}
