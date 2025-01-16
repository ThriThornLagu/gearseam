package com.ttl.weorcung.wiht.feond;

import java.util.Random;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.wiht.Wiht;
import com.ttl.weorcung.wiht.flan.TArwe;

public class FBanseten extends Wiht {

	public FBanseten(GamenBord gb) {
		super(gb);

		cynn = kFeond;
		nama = "Banseten";
		snud = 3;
		hiegostLif = 8;
		lif = hiegostLif;
		nidh = 3;
		forescieldung = 0;
		cun = 4;
		fla = new TArwe(gb);

		hittseam.x = 8;
		hittseam.y = 20;
		hittseam.width = 32;
		hittseam.height = 40;
		hittseamStoccX = hittseam.x;
		hittseamStoccY = hittseam.y;

		gietanLice();
	}

	public void gietanLice() {
		up1 = asettan("/hada/fiend/banseten/up_1", gb.tiglGreatnes, gb.tiglGreatnes);
		up2 = asettan("/hada/fiend/banseten/up_2", gb.tiglGreatnes, gb.tiglGreatnes);
		dune1 = asettan("/hada/fiend/banseten/dune_1", gb.tiglGreatnes, gb.tiglGreatnes);
		dune2 = asettan("/hada/fiend/banseten/dune_2", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre1 = asettan("/hada/fiend/banseten/winstre_1", gb.tiglGreatnes, gb.tiglGreatnes);
		winstre2 = asettan("/hada/fiend/banseten/winstre_2", gb.tiglGreatnes, gb.tiglGreatnes);
		riht1 = asettan("/hada/fiend/banseten/riht_1", gb.tiglGreatnes, gb.tiglGreatnes);
		riht2 = asettan("/hada/fiend/banseten/riht_2", gb.tiglGreatnes, gb.tiglGreatnes);
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
		
		int t = new Random().nextInt(100) + 1;

		if (t > 99 && !fla.cwic && scotFreoTellend == 30) {
			fla.settan(worldX, worldY, weg, true, this);
			
			gb.flanliste.add(fla);
			scotFreoTellend = 0;
		}
	}
	
	@Override
	public void hearmEddaed() {
		daedLoca = 0;
		weg = gb.plega.weg;
	}
}
