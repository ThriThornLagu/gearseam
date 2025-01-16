package com.ttl.weorcung.tigel;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.ttl.weorcung.heorte.GamenBord;
import com.ttl.weorcung.heorte.Tolseam;

public class TiglHandlere {

	GamenBord gb;
	public Tigel[] tigel;
	public int landTiglRim[][];

	public TiglHandlere(GamenBord gb) {
		this.gb = gb;

		// For marum tiglum: eacan to þissum getæle
		tigel = new Tigel[10];
		landTiglRim = new int[gb.hiehstWorldStap][gb.hiehstWorldRaew];

		gietanTigllice();
		hladanLandsceat("/landsceatas/world01.txt");
	}

	public void gietanTigllice() {
			upSettan(0, "waetere", true);
			upSettan(1, "weall", true);
			upSettan(2, "graes", false);
			upSettan(3, "sand", false);
			upSettan(4, "treow", true);
			upSettan(5, "utofrimum", true);
			upSettan(6, "wudubord", false);
	}

	public void upSettan(int t, String nama, boolean hrin) {
	
		Tolseam tol = new Tolseam();
		
		try {
			tigel[t] = new Tigel();
			tigel[t].onlicnes = ImageIO.read(getClass().getResourceAsStream("/tigla/" + nama + ".png"));
			tigel[t].onlicnes = tol.rihtianLice(tigel[t].onlicnes, gb.tiglGreatnes, gb.tiglGreatnes);
			tigel[t].hrin = hrin;
		} catch(IOException b) {
			
		}
	}
	
	public void hladanLandsceat(String threadPaedh) {
		try {
			InputStream is = getClass().getResourceAsStream(threadPaedh);
			BufferedReader lr = new BufferedReader(new InputStreamReader(is));

			int stap = 0, raew = 0;

			while (stap < gb.hiehstWorldStap && raew < gb.hiehstWorldRaew) {
				String line = lr.readLine();

				while (stap < gb.hiehstWorldStap) {
					String getalu[] = line.split(" ");

					int rim = Integer.parseInt(getalu[stap]);

					landTiglRim[stap][raew] = rim;
					stap++;
				}
				if (stap == gb.hiehstWorldStap) {
					stap = 0;
					raew++;
				}
			}
			lr.close();

		} catch (Exception b) {
			b.printStackTrace();
		}
	}

	public void dragan(Graphics2D l2) {

		int worldStap = 0, worldRaew = 0;

		while (worldStap < gb.hiehstWorldStap && worldRaew < gb.hiehstWorldRaew) {
			int tiglRim = landTiglRim[worldStap][worldRaew];

			int worldX = worldStap * gb.tiglGreatnes;
			int worldY = worldRaew * gb.tiglGreatnes;
			int scirmeX = worldX - gb.plega.worldX + gb.plega.scirmeX;
			int scirmeY = worldY - gb.plega.worldY + gb.plega.scirmeY;

			if (worldX + gb.tiglGreatnes > gb.plega.worldX - gb.plega.scirmeX
				&& worldX - gb.tiglGreatnes < gb.plega.worldX + gb.plega.scirmeX
				&& worldY + gb.tiglGreatnes > gb.plega.worldY - gb.plega.scirmeY
				&& worldY - gb.tiglGreatnes < gb.plega.worldY + gb.plega.scirmeY) {

				l2.drawImage(tigel[tiglRim].onlicnes, scirmeX, scirmeY, null);
			}
			worldStap++;

			if (worldStap == gb.hiehstWorldStap) {
				worldStap = 0;
				worldRaew++;
			}
		}
	}
}
