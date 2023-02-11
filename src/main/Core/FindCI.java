package Core;

public class FindCI {
	
	public float find(String worda, String wordb) {
		float ans;
		float count = 0;
		int n = Math.min(worda.length(),wordb.length());
		for(int i = 0; i < n;i++) {
			if(worda.charAt(i) == wordb.charAt(i))
				count++;
		}
		ans = count / n;
		return ans;
	}
}
