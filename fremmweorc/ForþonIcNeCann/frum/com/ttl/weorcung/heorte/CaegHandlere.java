package com.ttl.weorcung.heorte;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CaegHandlere implements KeyListener {

	GamenBord gb;
	public boolean upThrungen, nitherThrungen, winstreThrungen, rihtThrungen, hrinende, iernan, scot;
	
	public boolean unpiegung;

	public CaegHandlere(GamenBord gb) {
		this.gb = gb;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent b) {

		int diern = b.getKeyCode();

		if (gb.gamendom == gb.heafodscirmedom) {
			heafodscirmedom(diern);
		}

		else if (gb.gamendom == gb.plegdom) {
			plegdom(diern);
		}

		else if (gb.gamendom == gb.healtedom) {
			healtedom(diern);
		}

		else if (gb.gamendom == gb.spraecdom) {
			spraecdom(diern);
		}

		else if (gb.gamendom == gb.haddom) {
			haddom(diern);
		}
	}

	public void heafodscirmedom(int diern) {
		if (diern == KeyEvent.VK_W || diern == KeyEvent.VK_UP) {
			gb.bm.bebodGetael--;
			gb.pleganSF(2);
			if (gb.bm.bebodGetael < 0) {
				gb.bm.bebodGetael = 3;
			}
		}
		if (diern == KeyEvent.VK_S || diern == KeyEvent.VK_DOWN) {
			gb.bm.bebodGetael++;
			gb.pleganSF(2);
			if (gb.bm.bebodGetael > 3) {
				gb.bm.bebodGetael = 0;
			}
		}

		if (diern == KeyEvent.VK_SHIFT) {
			iernan = true;
		}

		if (diern == KeyEvent.VK_SPACE || diern == KeyEvent.VK_ENTER) {
			gb.pleganSF(3);

			if (gb.bm.bebodGetael == 0) {
				gb.gamendom = gb.plegdom;
				gb.pleganSangcraeft(0);
			}
			if (gb.bm.bebodGetael == 1) {

			}
			if (gb.bm.bebodGetael == 2) {

			}
			if (gb.bm.bebodGetael == 3) {
				System.exit(0);
			}
		}
	}

	public void plegdom(int diern) {
		if (diern == KeyEvent.VK_ESCAPE) {
			if (gb.gamendom == gb.plegdom) {
				gb.gamendom = gb.healtedom;
				gb.stoppianSangcraeft();
			}
		}

		if(diern == KeyEvent.VK_F5) {
			if(!unpiegung) {
				unpiegung = true;
			} 
			else if (unpiegung) {
				unpiegung = false;
			}
		}
		
		if (diern == KeyEvent.VK_F4) {
			gb.th.hladanLandsceat("/landsceatas/world01.txt");
		}
		
		if (diern == KeyEvent.VK_F11) {
			gb.gamendom = gb.heafodscirmedom;
			gb.stoppianSangcraeft();
		}

		if (diern == KeyEvent.VK_TAB || diern == KeyEvent.VK_C) {
			gb.gamendom = gb.haddom;
		}
		
		if (diern == KeyEvent.VK_F) {
			scot = true;
		}

		if (diern == KeyEvent.VK_SPACE || diern == KeyEvent.VK_ENTER) {
			hrinende = true;
		}

		if (diern == KeyEvent.VK_W || diern == KeyEvent.VK_UP) {
			upThrungen = true;
		}
		if (diern == KeyEvent.VK_S || diern == KeyEvent.VK_DOWN) {
			nitherThrungen = true;
		}
		if (diern == KeyEvent.VK_A || diern == KeyEvent.VK_LEFT) {
			winstreThrungen = true;
		}
		if (diern == KeyEvent.VK_D || diern == KeyEvent.VK_RIGHT) {
			rihtThrungen = true;
		}
	}

	public void healtedom(int diern) {
		if (diern == KeyEvent.VK_ESCAPE) {
			if (gb.gamendom == gb.healtedom) {
				gb.gamendom = gb.plegdom;
				gb.pleganSangcraeft(0);
			}
		}
	}

	public void spraecdom(int diern) {
		if (diern == KeyEvent.VK_SPACE || diern == KeyEvent.VK_ENTER) {
			gb.gamendom = gb.plegdom;
		}
	}

	public void haddom(int diern) {
		if (diern == KeyEvent.VK_X || diern == KeyEvent.VK_ESCAPE) {
			gb.gamendom = gb.plegdom;
		}
		if (diern == KeyEvent.VK_W || diern == KeyEvent.VK_UP) {
			if (gb.bm.slitteRaew != 0) {
				gb.bm.slitteRaew--;
				gb.pleganSF(2);
			}
		}
		if (diern == KeyEvent.VK_A || diern == KeyEvent.VK_LEFT) {
			if (gb.bm.slitteStap != 0) {
				gb.bm.slitteStap--;
				gb.pleganSF(2);
			}
		}
		if (diern == KeyEvent.VK_S || diern == KeyEvent.VK_DOWN) {
			if (gb.bm.slitteRaew != 4) {
				gb.bm.slitteRaew++;
				gb.pleganSF(2);
			}
		}
		if (diern == KeyEvent.VK_D || diern == KeyEvent.VK_RIGHT) {
			if (gb.bm.slitteStap != 7) {
				gb.bm.slitteStap++;
				gb.pleganSF(2);
			}
		}
		
		if (diern == KeyEvent.VK_SPACE || diern == KeyEvent.VK_C || diern == KeyEvent.VK_ENTER) {
			gb.plega.ceosanThing();
			gb.pleganSF(3);
		}
	}

	@Override
	public void keyReleased(KeyEvent b) {

		int diern = b.getKeyCode();

		if (diern == KeyEvent.VK_SHIFT) {
			iernan = false;
		}
		if (diern == KeyEvent.VK_W || diern == KeyEvent.VK_UP) {
			upThrungen = false;
		}
		if (diern == KeyEvent.VK_S || diern == KeyEvent.VK_DOWN) {
			nitherThrungen = false;
		}
		if (diern == KeyEvent.VK_A || diern == KeyEvent.VK_LEFT) {
			winstreThrungen = false;
		}
		if (diern == KeyEvent.VK_D || diern == KeyEvent.VK_RIGHT) {
			rihtThrungen = false;
		}
		if (diern == KeyEvent.VK_F) {
			scot = false;
		}
	}

}
