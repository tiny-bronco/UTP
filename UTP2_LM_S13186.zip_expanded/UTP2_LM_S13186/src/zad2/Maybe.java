package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T>  {
	
	T value = null;
	
	public Maybe(T value){
		this.value = value;
	}

	public static <T> Maybe<T> of(T v) {
		return new Maybe<T>(v);
	}

	public void ifPresent(Consumer<T> cons) {
		
		if(value != null)
		{
			cons.accept(value);
		}
	}

	public <K> Maybe<K> map(Function<T,K> fun) {
		
		K val = null;
		
		if(value != null)
		{
			val = fun.apply(value);
		}
		Maybe<K> result = Maybe.of(val);
		
		return result;
	}

	public T get() {
		
		T result;
		
		if(value != null)
		{
			result = value;
		}
		else
		{
			throw new NoSuchElementException();
		}
		return result;
	}
	public boolean isPresent()
	{
		boolean result = false;
		
		if(value != null)
		{
			result = true;
		}
		return result;
	}

	public T orElse(T defValue) {
		
		T result = defValue;
		
		if(value != null)
		{
			result = value;
		}
		return result;
	}

	public Maybe<T> filter(Predicate<T> pred) {
		
		Maybe<T> result;
		
		if(!this.isPresent())
		{
			result = this;
		}
		else
		{
			if(pred.test(value))
			{
				result = this;
			}
			else
			{
				result = new Maybe(null);
			}
			
		}
		return result;
	}
	public String toString()
	{
		String result = "Maybe is empty";
		
		if(this.isPresent())
		{
			result = "Maybe has value " + value;
		}

		return result;
		
	}

}
