package com.ttl.weorcung.heorte;

import com.ttl.weorcung.wiht.Wiht;

public class HrinHandlere {

	GamenBord gb;

	public HrinHandlere(GamenBord gb) {
		this.gb = gb;
	}

	public void stieranTigel(Wiht wiht) {

		int wihtWinstreWorldX = wiht.worldX + wiht.hittseam.x;
		int wihtRihtWorldX = wiht.worldX + wiht.hittseam.x + wiht.hittseam.width;
		int wihtToppWorldY = wiht.worldY + wiht.hittseam.y;
		int wihtBotmWorldY = wiht.worldY + wiht.hittseam.y + wiht.hittseam.height;

		int wihtWinstreStap = wihtWinstreWorldX / gb.tiglGreatnes;
		int wihtRihtStap = wihtRihtWorldX / gb.tiglGreatnes;
		int wihtToppRaew = wihtToppWorldY / gb.tiglGreatnes;
		int wihtBotmRaew = wihtBotmWorldY / gb.tiglGreatnes;

		int tiglRim1, tiglRim2;

		switch (wiht.weg) {
		case "up":
			wihtToppRaew = (wihtToppWorldY - wiht.snud) / gb.tiglGreatnes;
			tiglRim1 = gb.th.landTiglRim[wihtWinstreStap][wihtToppRaew];
			tiglRim2 = gb.th.landTiglRim[wihtRihtStap][wihtToppRaew];
			if (gb.th.tigel[tiglRim1].hrin == true || gb.th.tigel[tiglRim2].hrin == true) {
				wiht.hrinOn = true;
			}
			break;
		case "dune":
			wihtBotmRaew = (wihtBotmWorldY - wiht.snud) / gb.tiglGreatnes;
			tiglRim1 = gb.th.landTiglRim[wihtWinstreStap][wihtBotmRaew];
			tiglRim2 = gb.th.landTiglRim[wihtRihtStap][wihtBotmRaew];
			if (gb.th.tigel[tiglRim1].hrin == true || gb.th.tigel[tiglRim2].hrin == true) {
				wiht.hrinOn = true;
			}
			break;
		case "winstre":
			wihtWinstreStap = (wihtWinstreWorldX - wiht.snud) / gb.tiglGreatnes;
			tiglRim1 = gb.th.landTiglRim[wihtWinstreStap][wihtToppRaew];
			tiglRim2 = gb.th.landTiglRim[wihtWinstreStap][wihtBotmRaew];
			if (gb.th.tigel[tiglRim1].hrin == true || gb.th.tigel[tiglRim2].hrin == true) {
				wiht.hrinOn = true;
			}
			break;
		case "riht":
			wihtRihtStap = (wihtRihtWorldX + wiht.snud) / gb.tiglGreatnes;
			tiglRim1 = gb.th.landTiglRim[wihtRihtStap][wihtToppRaew];
			tiglRim2 = gb.th.landTiglRim[wihtRihtStap][wihtBotmRaew];
			if (gb.th.tigel[tiglRim1].hrin == true || gb.th.tigel[tiglRim2].hrin == true) {
				wiht.hrinOn = true;
			}
			break;
		}
	}

	public int stieranThing(Wiht wiht, boolean plega) {

		int tacen = 999;

		for (int e = 0; e < gb.thn.length; e++) {
			if (gb.thn[e] != null) {
				wiht.hittseam.x = wiht.worldX + wiht.hittseam.x;
				wiht.hittseam.y = wiht.worldY + wiht.hittseam.y;

				gb.thn[e].hittseam.x = gb.thn[e].worldX + gb.thn[e].hittseam.x;
				gb.thn[e].hittseam.y = gb.thn[e].worldY + gb.thn[e].hittseam.y;

				switch (wiht.weg) {
				case "up":
					wiht.hittseam.y -= wiht.snud;
					break;
				case "dune":
					wiht.hittseam.y += wiht.snud;
					break;
				case "winstre":
					wiht.hittseam.x -= wiht.snud;
					break;
				case "riht":
					wiht.hittseam.x += wiht.snud;
					break;
				}

				if (wiht.hittseam.intersects(gb.thn[e].hittseam)) {
					if (gb.thn[e].hrin == true) {
						wiht.hrinOn = true;
					}
					if (plega == true) {
						tacen = e;
					}
				}

				wiht.hittseam.x = wiht.hittseamStoccX;
				wiht.hittseam.y = wiht.hittseamStoccY;
				gb.thn[e].hittseam.x = wiht.hittseamStoccX;
				gb.thn[e].hittseam.y = wiht.hittseamStoccY;
			}
		}

		return tacen;
	}

	public int stieranWiht(Wiht wiht, Wiht[] mearc) {

		int tacen = 999;

		for (int e = 0; e < mearc.length; e++) {
			if (mearc[e] != null) {
				wiht.hittseam.x = wiht.worldX + wiht.hittseam.x;
				wiht.hittseam.y = wiht.worldY + wiht.hittseam.y;

				mearc[e].hittseam.x = mearc[e].worldX + mearc[e].hittseam.x;
				mearc[e].hittseam.y = mearc[e].worldY + mearc[e].hittseam.y;

				switch (wiht.weg) {
				case "up":
					wiht.hittseam.y -= wiht.snud;
					break;
				case "dune":
					wiht.hittseam.y += wiht.snud;
					break;
				case "winstre":
					wiht.hittseam.x -= wiht.snud;
					break;
				case "riht":
					wiht.hittseam.x += wiht.snud;
					break;
				}

				if (wiht.hittseam.intersects(mearc[e].hittseam)) {
					if (mearc[e] != wiht) {
						wiht.hrinOn = true;
						tacen = e;
					}
				}

				wiht.hittseam.x = wiht.hittseamStoccX;
				wiht.hittseam.y = wiht.hittseamStoccY;
				mearc[e].hittseam.x = wiht.hittseamStoccX;
				mearc[e].hittseam.y = wiht.hittseamStoccY;
			}
		}

		return tacen;
	}

	public boolean stieranPlega(Wiht wiht) {
		boolean hrinanPlega = false;
		
		wiht.hittseam.x = wiht.worldX + wiht.hittseam.x;
		wiht.hittseam.y = wiht.worldY + wiht.hittseam.y;

		gb.plega.hittseam.x = gb.plega.worldX + gb.plega.hittseam.x;
		gb.plega.hittseam.y = gb.plega.worldY + gb.plega.hittseam.y;

		switch (wiht.weg) {
		case "up":
			wiht.hittseam.y -= wiht.snud;
			break;
		case "dune":
			wiht.hittseam.y += wiht.snud;
			break;
		case "winstre":
			wiht.hittseam.x -= wiht.snud;
			break;
		case "riht":
			wiht.hittseam.x += wiht.snud;
			break;
		}
		
		if (wiht.hittseam.intersects(gb.plega.hittseam)) {
			wiht.hrinOn = true;
			hrinanPlega = true;
		}
		
		wiht.hittseam.x = wiht.hittseamStoccX;
		wiht.hittseam.y = wiht.hittseamStoccY;
		gb.plega.hittseam.x = wiht.hittseamStoccX;
		gb.plega.hittseam.y = wiht.hittseamStoccY;
		
		return hrinanPlega;
	}
}
