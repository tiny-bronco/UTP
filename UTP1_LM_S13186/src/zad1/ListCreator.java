/**
 *
 *  @author Lipińska Martyna S13186
 *
 */

package zad1;

import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {
	
	List<T> list = new ArrayList<T>();
	List<T> resultList = new ArrayList<T>();
	
	ListCreator(List<T> list)
	{
		this.list = list;
	}
	public static <T> ListCreator<T> collectFrom(List<T> src) {
		
		ListCreator<T> list = new ListCreator<T>(src);
		
		return list;
	}
	public ListCreator<T> when(Selector<T> sel) {
		
		for(int i=0; i<list.size();i++)
		{
			if(sel.select(list.get(i)))
			{
				resultList.add(list.get(i));
			}
		}
		return this;
	}
	public List<T> mapEvery(Mapper map) {
		
		List<T> temp = new ArrayList<T>();
		
		for(int i=0; i<resultList.size();i++)
		{
			temp.add( (T) map.map(resultList.get(i)));
		}
		return temp;
	}
	
}  
