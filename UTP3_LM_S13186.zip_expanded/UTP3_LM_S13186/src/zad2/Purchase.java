/**
 *
 *  @author Lipińska Martyna S13186
 *
 */

package zad2;


public class Purchase {
	
	String id_klienta;
	String nazwisko;
	String imie;
	String nazwa_towaru;
	Double cena;
	Double zakupiona_ilosc;
	
	Purchase( String ik, String n, String i, String nt, Double c, Double zi )
	{
		this.id_klienta = ik;
		this.nazwisko = n;
		this.imie = i;
		this.nazwa_towaru = nt;
		this.cena = c;
		this.zakupiona_ilosc = zi;
	}
	public String toString() 
	{
		return id_klienta+";"+nazwisko+" "+imie+";"+nazwa_towaru+";"+cena+";"+zakupiona_ilosc;
		
	}
}
