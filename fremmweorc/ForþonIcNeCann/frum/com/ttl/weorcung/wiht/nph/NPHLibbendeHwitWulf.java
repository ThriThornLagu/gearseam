package com.ttl.weorcung.wiht.nph;

import java.util.Random;

//import java.util.Random;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class NPHLibbendeHwitWulf extends Wiht {

	public NPHLibbendeHwitWulf(GamenBord gb) {
		super(gb);

		nama = "Hwit Wulf";
		snud = 2;

		hittseam.x = 8;
		hittseam.y = 20;
		hittseam.width = 32;
		hittseam.height = 40;
		hittseamStoccX = hittseam.x;
		hittseamStoccY = hittseam.y;

		gietanLice();
		settanSpraec();
	}

	public void gietanLice() {
		up1 = asettan("/hada/nph/wulfas/lhw/up_1", gb.tiglGreatnes, gb.tiglGreatnes);
		up2 = asettan("/hada/nph/wulfas/lhw/up_2", gb.tiglGreatnes, gb.tiglGreatnes);
		dune1 = asettan("/hada/nph/wulfas/lhw/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/hada/nph/wulfas/lhw/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre1 = asettan("/hada/nph/wulfas/lhw/winstre_1", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre2 = asettan("/hada/nph/wulfas/lhw/winstre_2", gb.tiglGreatnes, gb.tiglGreatnes);
		riht1 = asettan("/hada/nph/wulfas/lhw/riht_1", gb.tiglGreatnes, gb.tiglGreatnes);
		riht2 = asettan("/hada/nph/wulfas/lhw/riht_2", gb.tiglGreatnes, gb.tiglGreatnes);
	}

	public void settanSpraec() {

			spraeca[0] = "Wilcume to þære worlde, uncnawnne man!";
			spraeca[1] = "Ic ne wite hwæt ðu mægst her don, ac eom sicor se wyrhta wyrce hwæthwene!";

			// Fandiende gewef
			spraeca[2] = "Þes streng is gemæned wesan swa lang þe se ne mæg eall on anum line ne <br>þæslæcan.";
			
			spraeca[3] = "Hwi eart ðu giet her? Ga fanda hwæthwene!";
	}

	@Override
	public void settanDaed() {

		daedLoca++;

		if (daedLoca == 90) {
			Random sithsum = new Random();
			int g = sithsum.nextInt(100) + 1;
			
			if (g <= 25) {
				weg = "up";
			}
			if (g > 25 && g <= 50) {
				weg = "dune";
			}
			if (g > 50 && g <= 75) {
				weg = "winstre";
			}
			if (g > 75 && g <= 100) {
				weg = "riht";
			}

			daedLoca = 0;
		}
	}

	public void spreccan() {

		super.spreccan();
	}
}
