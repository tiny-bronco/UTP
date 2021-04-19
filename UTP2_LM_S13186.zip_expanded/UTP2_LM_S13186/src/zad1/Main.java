/**
 *
 *  @author Lipińska Martyna S13186
 *
 */

package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

/*<--
 *  niezbędne importy
 */
public class Main {
  public static void main(String[] args) {
    
     Function<String,List<String>> flines = s -> {
    	 
    	 List<String> list = new ArrayList<String>();
    	 Scanner sc;
		 try {
			sc = new Scanner(new File(s));
			while(sc.hasNextLine())
	    	 {
	    		 list.add(sc.nextLine());
	    	 }
	    	 sc.close();
		 } catch (FileNotFoundException e) {
			e.printStackTrace();
		 }
    	 
		 return list;
     };
     Function<List<String>,String> join = l -> {
    	 String s = String.join("", l);
    	 
    	 return s;
     };
     Function<String, List<Integer>> collectInts= s -> {
    	 List<Integer> list = new ArrayList<Integer>();
    	 Scanner sc = new Scanner(s).useDelimiter("[^0-9]+");
    	 
		 while(sc.hasNextInt())
		 {
			 list.add(sc.nextInt());
    		 
    	 }
    	 sc.close();
    	 return list;
     };
     Function<List<Integer>,Integer> sum = l -> {
    	 int sumint = 0;
    	 for(Integer i : l)
    	 {
    		 sumint += i;
    	 }
    	 return sumint;
     };
     

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
