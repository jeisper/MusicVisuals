package ie.tudublin;

import d19124603.GivagoVisual;

public class Main {

	public void startUI() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new GivagoVisual());
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.startUI();
	}
}