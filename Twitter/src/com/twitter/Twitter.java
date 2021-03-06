package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter predstavlja bazu svih prosledjenih poruka.
 * @author Milos
 * @version 1.0
 *
 */

public class Twitter {

	/**
	 * Lista sa svim porukama.
	 */

	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Ova metoda vraca sve poruke koje su trenutno u listi poruke.
	 * @return {@link LinkedList} poruke
	 */

	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	

	/**
	 * Metoda pravi novu poruku i puni je svim potrebnim podacima.
	 * @param korisnik Korisnik
	 * @param poruka Poruka
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Vraca sve poruke koje sadrze odredjeni tag u vidu novog niza.
	 * @param maxBroj Maksimalni broj poruka.
	 * @param tag Tag na osnovu koga se vrsti pretraga.
	 * @return rezultat[]
	 * @throws java.lang.RuntimeException Ako je uneti tag :
	 * <ul>
	 * <li>null</li>
	 * <li>prazan string</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().contains(tag))
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
