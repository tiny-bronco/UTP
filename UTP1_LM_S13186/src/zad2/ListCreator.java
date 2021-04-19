package zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class ListCreator<T> {
	
	List<T> list = new ArrayList<T>();
	List<T> resultList = new ArrayList<T>();
	
	ListCreator(List<T> list)
	{
		this.list = list;
	}
	public static <T> ListCreator<T> collectFrom(List<T> destinations) {
		
		ListCreator<T> list = new ListCreator<T>(destinations);
		
		return list;
	}
	public ListCreator<T> when(Predicate<T> sel) {
		
		for(int i=0; i<list.size();i++)
		{
			if(sel.test(list.get(i)))
			{
				resultList.add(list.get(i));
			}
		}
		
		return this;
	}
	public <K> List<T> mapEvery(Function<T,K> map) {
		
		List<T> temp = new ArrayList<T>();
		
		for(int i=0; i<resultList.size();i++)
		{
			temp.add( (T) map.apply(resultList.get(i)));
		}
		return temp;
	}
	
}  
