package HA3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Eine klasse Klasse zum Testen der SpieleHash-Klasse.
 */

public class SpieleHashTest {

	public static void main(String[] args) {
		String[] tests = { "FIFA 16", "Star Wars: Battlefront", "WOW" };

		SpieleHash sh = new SpieleHash();

		File f = new File("games50.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("Datei " + f + " nicht vorhanden");
			System.exit(1);
		}
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split("\t");
			sh.add(s[1].trim());
		}
		sc.close();

		System.out.println(sh.toString());

		for (int i = 0; i < tests.length; i++) {
			System.out.println(tests[i] + ": " + sh.contains(tests[i]));
		}
	}

}
