package com.twitter.poruke;

/**
 * 
 * Klasa TwitterPoruka predstavlja twitter poruku.
 * 
 * @author Milos
 * @version 1.0.0
 */
public class TwitterPoruka {

	/**
	 * Predstavlja korisnika twitter naloga.
	 */

	private String korisnik;
	
	/**
	 * Predstavlja sadrzaj poruke.
	 */

	private String poruka;

	/**
	 * Ova metoda vraca korinika konkretnog twitter naloga.
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Ova metoda postavlja korisnika twitter naloga.
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	
	/**
	 * Ova metoda vraca sadrzaj twitter poruke.
	 * @return poruka
	 */
	public String getPoruka() {
		return this.poruka;
	}
	
	/**
	 * Ova metoda postavlja sadrzaj twitter poruke.
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.isEmpty() || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Ova metoda ispisuje korisnika twitter naloga kao i sadrzaj poruke.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
