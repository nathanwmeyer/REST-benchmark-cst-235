package business;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;

import beans.Bible;

/**
 * Session Bean implementation class WordSearchBusinessService
 */
@Stateless
@Local
@LocalBean
public class WordSearchBusinessService implements WordSearchBusinessInterface{
	
    /**
     * Default constructor. 
     */
    public WordSearchBusinessService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String[] breakDown(String string) {//clean up the given string to make it easier to compare
		// TODO Auto-generated method stub
		String[] output = string.split(" ");
		for(int i=0; i<output.length; i++)
		{
			output[i].trim();
			output[i] = output[i].replaceAll("^[^a-zA-Z]", "");// remove all non-alphabetic
													// character from start of
													// string
			output[i] = output[i].replaceAll("[^a-zA-Z]$", "");// remove all non-alphabetic
													// character from end of string
			output[i] = output[i].toLowerCase();
		}
		return output;
	}

	@Override
	public int returnOccurences(Bible bible) {//count the number of times a given word (stored in bible.search) occurs in a given passage (stored in bible.passage)
		// TODO Auto-generated method stub
		String[] material = breakDown(bible.getPassage());
		int count = 0;
		String search = bible.getSearch().toLowerCase();
		for(int i=0; i<material.length; i++)
		{
			
			if (material[i].equals(search)) count++;
		}
		return count;
		
	}

	@Override
	public Bible getBible() {//creates a bible object based on a specific bible passage and returns it
		// TODO Auto-generated method stub
		Bible bible = new Bible(" ", "The LORD is my strength and my song; he has become my salvation. Glad songs of salvation are in the tents of the righteous: ‘The right hand of the LORD does valiantly, the right hand of the LORD exalts, the right hand of the LORD does valiantly!");
		return bible;
	}

}
