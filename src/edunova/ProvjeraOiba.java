package edunova;

import javax.swing.JOptionPane;

public class ProvjeraOiba {

	public ProvjeraOiba() {
		ispis(provjeraOiba(unosOiba()));
	}

	private int[] unosOiba() {

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

	private boolean provjeraOiba(int[] oib) {

		int rezultat = 0;

		for (int j = 0; j < 10; j++) {
			// inline if
			rezultat = (j == 0) ? (oib[j] + 10) % 10 : (rezultat + oib[j]) % 10;
			if (rezultat == 0) {
				rezultat = 10;
			}
			rezultat = (rezultat * 2) % 11;

		}

		if (11 - rezultat == oib[10] || (11 - rezultat == 10 && oib[10] == 0)) {
			return true;
		}

		return false;

	}

	private void ispis(boolean b) {
		// inline if
		JOptionPane.showMessageDialog(null, (b) ? "OIB je ispravan." : "Greška. OIB je neispravan");
	}

	public static void main(String[] args) {

		new ProvjeraOiba();

	}

}
