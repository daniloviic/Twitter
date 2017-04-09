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
	 * @return {@link String} korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Ova metoda postavlja korisnika twitter naloga.
	 * @param korisnik Korisnik
	 * @throws java.lang.RuntimeException Ako je uneto ime:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	
	/**
	 * Ova metoda vraca sadrzaj twitter poruke.
	 * @return {@link String} poruka
	 */
	public String getPoruka() {
		return this.poruka;
	}
	
	/**
	 * Ova metoda postavlja sadrzaj twitter poruke.
	 * @param poruka Sadrzaj poruke.
	 * @throws java.lang.RuntimeException Ako je uneta poruka : 
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * <li>duza od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.isEmpty() || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Ova metoda ispisuje korisnika twitter naloga kao i sadrzaj poruke.
	 * @return {@link String} Podaci o korisniku.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
