/**
 *
 *  @author Lipińska Martyna S13186
 *
 */

package zad2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class CustomersPurchaseSortFind 
{
	LinkedList<Purchase> lista_zak = new LinkedList<Purchase>();

	public void readFile( String fname )
	{
		File file = new File( fname );
		
		try 
		{
			Scanner sc = new Scanner( file );
			
			while( sc.hasNextLine() )
			{
				String[] data = sc.nextLine().split("(;)|(\\p{IsWhite_Space})");
				
				lista_zak.add( new Purchase(
						data[0], 
						data[1], 
						data[2], 
						data[3], 
						Double.parseDouble(data[4]), 
						Double.parseDouble(data[5])) );

			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showSortedBy( String string ) 
	{
		System.out.println( string );
		LinkedList<Purchase> sort_list = lista_zak;
		
		switch( string )
		{
		case "Nazwiska":
			sort_list.sort((purchase1, purchase2) -> 
			{
				int temp = purchase1.nazwisko.compareTo( purchase2.nazwisko );
				if ( temp == 0 ) 
				{
					return purchase1.id_klienta.compareTo( purchase2.id_klienta );
				}
				return temp;
			});
			for (Purchase i : sort_list) 
			{
				System.out.println( i );
			}
			break;
		case "Koszty":
			sort_list.sort((purchase1, purchase2) -> 
			{
				int temp = purchase1.cena.compareTo( purchase2.cena );
				if ( temp == 0 ) 
				{
					return purchase1.cena.compareTo( purchase2.cena );
				}
				return temp;
			});
			for ( Purchase i : sort_list ) 
			{
				System.out.println( i );
			}
			break;
		}
		
	}

	public void showPurchaseFor( String id ) 
	{
		System.out.println("Klient "+ id);
		
		for( int i = 0; i< lista_zak.size(); i++)
		{
			if( id.equals( lista_zak.get(i).id_klienta ) )
			{
				System.out.println( lista_zak.get(i) );
			}
		}
	}
}