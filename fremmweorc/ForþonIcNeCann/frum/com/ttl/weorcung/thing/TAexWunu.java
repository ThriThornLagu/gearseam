package com.ttl.weorcung.thing;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class TAexWunu extends Wiht {

	public TAexWunu(GamenBord gb) {
		super(gb);

		cynn = kAex;
		
		nama = "Wunu Æx";
		
		dune1 = asettan("/thing/aex", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/thing/aex", gb.tiglGreatnes, gb.tiglGreatnes);
		
		nidhWeorth = 2;
		
		nidhseam.width = 30;
		nidhseam.height = 30;
		
		reccung = "[" + nama + "]<br>Æx. Strenge þænne þone sweord.";
	}

}
