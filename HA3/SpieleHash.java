package HA3;

/**
 * Eine Klasse, die eine Liste von Spielnamen in einer Hashtabelle speichert.
 * 
 * @author Intan
 *
 */
public class SpieleHash {

	private String[] tab = new String[53];
	private int counter = 0;

	/**
	 * Berechnet h0.
	 * 
	 * @param spiel
	 * @return
	 */
	private int hashIndex(String spiel) {
		return Math.abs(spiel.hashCode()) % 100;
	}

	/**
	 * Berechnet Inkrement
	 * 
	 * @param spiel
	 * @return
	 */
	private int hashIncrement(String spiel) {
		return Math.abs(spiel.hashCode() / 1000) % 100 + 1;
	}

	/**
	 * Fuegt Spiel zu Liste hinzu.
	 * 
	 * @param spiel
	 *            Das hinzuzufuegende Spiel.
	 * @throws ArrayStoreException
	 *             wenn die Tabelle voll ist.
	 */
	public void add(String spiel) {
		int a = hashIndex(spiel);
		int b = hashIncrement(spiel);
		int n = 0;
		int index;
		if (counter >= tab.length) {
			throw new ArrayStoreException("Die Tabelle ist voll!");
		}
		while (true) {
			index = (a + (n * b)) % tab.length;
			if (tab[index] == null)
				break;
			n++;
		}
		tab[index] = spiel;
		counter++;
	}

	/**
	 * Prueft, ob Spiel in der Liste ist.
	 * 
	 * @param spiel
	 *            Das zu ueberpruefende Spiel.
	 * @return true, wenn spiel in der Liste ist.
	 */
	public boolean contains(String spiel) {
		int a = hashIndex(spiel);
		int b = hashIncrement(spiel);

		for (int i = 0; i < tab.length; i++) {
			int index = (a + i * b) % tab.length;
			if (tab[index] != null && tab[index].equals(spiel)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return Die Stringdarstellung der Hashtabelle.
	 */
	public String toString() {
		String ret = "";
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == null) {
				ret += "[" + i + "]  " + "--" + "\n";
			} else {
				ret += "[" + i + "]  " + tab[i] + "\n";
			}
		}
		return ret;
	}
}
