/**
 *
 *  @author Lipińska Martyna S13186
 *
 */

package zad1;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1,7,8,11,12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector<Boolean>()
    		{
    			@Override
    			public boolean select( Object t)
    			{
    				boolean result = false;
    				
    				if( (Integer) t < 10 )
    				{
    					result = true;
    				}
    				return result;
    			}
    		};
    Mapper map =  new Mapper<Integer, Integer>()
    		{

				@Override
				public Integer map(Integer k) {
					return k+10;
				}
    	
    		};
    		
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
    Selector sel = new Selector<Boolean>()
	{
		@Override
		public boolean select( Object t)
		{
			boolean result = false;
			
			if( t.toString().length() > 3)
			{
				result = true;
			}
			return result;
		}
	}; 
    Mapper map =  new Mapper<Integer, String>()
	{

		@Override
		public Integer map(String k) {
			return k.toString().length()+10;
		}

	};
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
