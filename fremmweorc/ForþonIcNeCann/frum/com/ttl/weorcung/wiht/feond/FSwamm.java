package com.ttl.weorcung.wiht.feond;

import java.util.Random;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;

public class FSwamm extends Wiht {

	public FSwamm(GamenBord gb) {
		super(gb);

		cynn = kFeond;
		nama = "Swamm";
		snud = 2;
		hiegostLif = 4;
		lif = hiegostLif;
		nidh = 3;
		forescieldung = 0;
		cun = 2;

		hittseam.x = 8;
		hittseam.y = 20;
		hittseam.width = 32;
		hittseam.height = 40;
		hittseamStoccX = hittseam.x;
		hittseamStoccY = hittseam.y;

		gietanLice();
	}

	public void gietanLice() {
		up1 = asettan("/hada/fiend/swamm/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		up2 = asettan("/hada/fiend/swamm/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		dune1 = asettan("/hada/fiend/swamm/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/hada/fiend/swamm/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre1 = asettan("/hada/fiend/swamm/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre2 = asettan("/hada/fiend/swamm/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		riht1 = asettan("/hada/fiend/swamm/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		riht2 = asettan("/hada/fiend/swamm/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
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
	
	@Override
	public void hearmEddaed() {
		daedLoca = 0;
		weg = gb.plega.weg;
	}
}
