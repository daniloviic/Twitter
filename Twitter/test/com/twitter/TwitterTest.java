/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Milos
 *
 */
public class TwitterTest {

	Twitter twitter;
	 LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	 TwitterPoruka tPoruka;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
		poruke = new LinkedList<TwitterPoruka>();
		tPoruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitter = null;
		poruke = null;
		tPoruka = null;
	}

	

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		tPoruka.setKorisnik("Milos");
		tPoruka.setPoruka("Bohemian Rhapsody");
		twitter.unesi("Milos", "Bohemian Rhapsody");
		
		assertEquals(tPoruka.toString(), twitter.vratiSvePoruke().get(0).toString());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka prva = new TwitterPoruka();
		prva.setKorisnik("Milos");
		prva.setPoruka("P2");
		
		TwitterPoruka druga = new TwitterPoruka();
		druga.setKorisnik("Paulo Dybala");
		druga.setPoruka("Juventus");
		twitter.unesi("Milos", "P2");
		twitter.unesi("Paulo Dybala", "Juventus");
		
		poruke = twitter.vratiSvePoruke();
		
		assertEquals(2, poruke.size());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		twitter.vratiPoruke(10, null);
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmptyString() {
		twitter.vratiPoruke(10, "");
		
	}
	
	@Test
	public void testVratiPorukeNegativanMaxBroj(){
		assertEquals(100, twitter.vratiPoruke(-5, "a").length);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		twitter.unesi("Milos", "Lopta");
		twitter.unesi("Fred", "Bempersonski");
		twitter.unesi("Dzon", "bbbb");
		twitter.unesi("Sigala", "Daljinski");
		TwitterPoruka[] test = twitter.vratiPoruke(1, "Bem");
		TwitterPoruka p1 = new TwitterPoruka();
		p1.setKorisnik("Fred");
		p1.setPoruka("Bempersonski");
		
		String testS = test[0].toString();
		
		assertEquals(p1.toString(), testS);
		
		
	}


}
