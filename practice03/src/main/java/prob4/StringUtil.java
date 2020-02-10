package prob4;

public class StringUtil {
	
	public static String concatenate(String[] str)
	{
		String answer = "";
		
		for(String temp : str)
		{
			answer += temp;
		}
		return answer;
	}
}
