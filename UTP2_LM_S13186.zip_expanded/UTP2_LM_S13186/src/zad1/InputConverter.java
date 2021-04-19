package zad1;


import java.util.function.Function;

public class InputConverter<T> {
	
	T data;
	
	public InputConverter(T data)
	{
		this.data = data;		
	}
	public <K> K convertBy(Function... args)
	{
		Object result = null;

		
		Function fun = args[0];

		for(int i=1;i<args.length;i++)
		{
			fun = fun.andThen(args[i]);
		}
		
		result = fun.apply(data);
		
		return (K) result;
	}

}
