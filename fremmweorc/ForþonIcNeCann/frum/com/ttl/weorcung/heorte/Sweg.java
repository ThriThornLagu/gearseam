package com.ttl.weorcung.heorte;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sweg {

	Clip efesung;
	URL fetor[] = new URL[30];

	public Sweg() {

		fetor[0] = getClass().getResource("/swegas/sangcraeft/gamung.wav");
		fetor[1] = getClass().getResource("/swegas/sangcraeft/egesiende-sang.wav");
		fetor[2] = getClass().getResource("/swegas/costliste-locian.wav");
		fetor[3] = getClass().getResource("/swegas/costliste-ceosan.wav");
		fetor[4] = getClass().getResource("/swegas/rise.wav");
		fetor[5] = getClass().getResource("/swegas/dor-opennian.wav");
		fetor[6] = getClass().getResource("/swegas/dor-unlucan.wav");
		fetor[7] = getClass().getResource("/swegas/nan-ingang-wunu.wav");
		fetor[8] = getClass().getResource("/swegas/sangcraeft/gamen-ende.wav");
		fetor[9] = getClass().getResource("/swegas/sweord-geswungen.wav");
		fetor[10] = getClass().getResource("/swegas/hearmian.wav");
		fetor[11] = getClass().getResource("/swegas/feond-deadh.wav");
		fetor[12] = getClass().getResource("/swegas/plega-deadh.wav");
		fetor[13] = getClass().getResource("/swegas/sangcraeft/betterung.wav");
		fetor[14] = getClass().getResource("/swegas/thing-uppyced.wav");
		fetor[15] = getClass().getResource("/swegas/scot-arwe.wav");
	}

	public void settanThraed(int g) {
		try {
			AudioInputStream sis = AudioSystem.getAudioInputStream(fetor[g]);
			efesung = AudioSystem.getClip();
			efesung.open(sis);

		} catch (Exception b) {
		}
	}

	public void plegan() {

		efesung.start();
	}

	public void eftgian() {
		efesung.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stoppian() {
		efesung.stop();
	}
}
