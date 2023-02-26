package Core;

public class FindCI {

	public float find(String worda, String wordb) {
		float ans = 0;
		float count = 0;
		int n = Math.min(worda.length(), wordb.length());
		for (int i = 0; i < n; i++) {
			if (worda.charAt(i) == wordb.charAt(i))
				count++;
		}
		if (n == 0 || count == 0) {
			ans = 0.0f;
		} else {
			ans = count / n;
		}
		return ans;
	}
}
