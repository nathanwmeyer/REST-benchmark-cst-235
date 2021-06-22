package business;

import javax.ejb.Local;

import beans.Bible;

@Local
public interface WordSearchBusinessInterface {

	public String[] breakDown(String string); //clean up the given string to make it easier to compare
	
	public int returnOccurences(Bible bible);//count the number of times a given word (stored in bible.search) occurs in a given passage (stored in bible.passage)

	public Bible getBible();//creates a bible object based on a specific bible passage and returns it
}
