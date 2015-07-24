import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


class  Blanks_constraint
{

	public String sortString( String word )
	{
		char[] alphabets = word.toCharArray();
		Arrays.sort(alphabets);
		return new String(alphabets);
	}
	
	public boolean ifExists(String word, HashMap<String,String> dictionary){
		
		boolean wordexists = false;
		if(word.contains("*"))
		{
			return dictionary.containsKey(word);
		}
		else
		{
			return dictionary.containsKey(sortString(word));
		}
		
	}
	
	public ArrayList<String> getValidkeys(ArrayList<String> keys, HashMap<String,String> dictionary)
	{
		ArrayList<String> validkeys = null;
		
		for(String key: keys)
		{
			if(ifExists(key,dictionary))
			{
				validkeys.add(key);
			}
		}
		
		return validkeys;
	}
	
	
}
public class codeforgit {

}
