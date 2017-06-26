package edunova;

import javax.swing.JOptionPane;

public class ProvjeraOIBa {

	public ProvjeraOIBa() {
		ispis(provjeraOIBa(unosOIBa()));
	}

	private int[] unosOIBa() {

		int[] oib = new int[11];
		String unos = JOptionPane.showInputDialog("Unesite OIB:");

		while (unos.length() != 11) {
			unos = JOptionPane.showInputDialog("Nije OIB, unesite 11-znamenkasti broj.");
		}

		for (int i = 0; i < unos.length(); i++) {
			oib[i] = Integer.parseInt(String.valueOf(unos.charAt(i)));
		}

		return oib;

	}

	private boolean provjeraOIBa(int[] oib) {

		int rezultat = 0;

		for (int i = 0; i < 10; i++) {

			rezultat = (i == 0) ? (oib[i] + 10) % 10 : (rezultat + oib[i]) % 10;

			if (rezultat == 0) {
				rezultat = 10;
			}
			
			rezultat = (rezultat * 2) % 11;

		}

		return 11 - rezultat == oib[10] || (11 - rezultat == 10 && oib[10] == 0) ? true : false;

	}

	private void ispis(boolean b) {

		JOptionPane.showMessageDialog(null, (b) ? "OIB je ispravan." : "Greška. OIB je neispravan");
	}

	public static void main(String[] args) {

		new ProvjeraOIBa();

	}

}
