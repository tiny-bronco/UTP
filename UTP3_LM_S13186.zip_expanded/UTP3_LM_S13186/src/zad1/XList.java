package zad1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T>
{
	/*
	 * CONSTRUCTORS/
	 */
	public XList( T... args)
	{
		for( int i= 0; i < args.length ;i++ )
		{
			this.add( args[i]);
		}
	}
	public XList( Collection<T> coll)
	{
		this.addAll(coll);
	}
	/*
	 * STATIC METHODS
	 */
	public static <T> XList<T> of(T... args) {

		return new XList<T>(args);
	}
	public static <T> XList<T> of( Collection<T> coll)
	{
		return new XList<T>(coll);
	}
	public static XList<String> charsOf(String string) {
		XList<String> list = new XList<String>();
		
		for(char c :string.toCharArray())
		{
			list.add(String.valueOf(c));
		}
 
		return list;
	}

	public static XList<String> tokensOf(String... strings ) 
	{
		XList<String> result;
		
		String separator = "\s";
		
		if(strings.length > 1)
		{
			separator = strings[1];
		}
		String[] list = strings[0].split(separator);
		result = new XList<String>(list);
		
 
		return result;
	}
	/*
	 * METHODS
	 */
	public XList<T> union(Collection<T> coll) {
		XList<T> result = new XList<T>(this);
		result.addAll(coll);
		
		return result;
	}
	public XList<T> union(T[] array) {
		XList<T> result = new XList<T>(this);
		for( int i= 0; i < array.length ;i++ )
		{
			result.add( array[i]);
		}
		return result;
	}

	public XList<T> diff(Collection<T> coll) {
		XList<T> result = new XList<T>(this);
		result.removeAll(coll);
		return result;
	}

	public XList<T> unique() {
		
		XList<T> result = new XList<T> ( this.stream().distinct().collect(Collectors.toList()));
		return result;
	}
	public XList<XList<T>> combine() {
		XList<XList<T>> result = null;
		
		return result;
	}
	public XList collect(Function function) {
		XList result = new XList();
		for( int i= 0; i < result.size(); i++ )
		{
			function.apply(result.get(i));

		}
		return result;
	}
	public String[] join(T... separator) {
		String result[] = {""};
		StringBuilder strb = new StringBuilder();
		
		if(separator.length >0)
		{
			
		}
		while(this.iterator().hasNext())
		{
			
			strb.append(this.iterator().next());
		}
		//result = strb.toString();
		
		return result;
	}
	
	public void forEachWithIndex(Object object) {
		// TODO Auto-generated method stub
		
	}



}
