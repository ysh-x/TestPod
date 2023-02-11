package Core;

import java.util.ArrayList;
import java.util.List;
import org.glassfish.grizzly.utils.Pair;

public class FindSI {

	@SuppressWarnings("null")
	public ReportBean find(List<Pair<String, String>> faculty, List<Pair<String, String>> student,
			Pair<Integer, Integer> sCount, Pair<Integer, Integer> facultyAnsBounds,
			List<Pair<Integer, Integer>> facultySentenceCount) {

		List<Float> SIS = new ArrayList<>();
		List<Float> CI = new ArrayList<>();
		
		ReportBean RB = new ReportBean();
		
		FindCI FC = new FindCI();
		float FTcount = 0;
		int STcount = 0;
		
		for (int i = facultyAnsBounds.getFirst(); i < facultyAnsBounds.getSecond(); i++) {
			Pair<Integer, Integer> inbound = facultySentenceCount.get(i);
			if (inbound.getFirst() == -1)
				continue;

			FTcount = inbound.getSecond() - inbound.getFirst();
			STcount = 0;
			
			for (int j = inbound.getFirst(); j < inbound.getSecond(); j++) {
				Pair<String, String> fT = faculty.get(j);

				for (int k = sCount.getFirst(); k < sCount.getSecond(); k++) {
					Pair<String, String> sT = student.get(k);
						
					if (fT.getFirst().equals(sT.getFirst())) {
						if (fT.getSecond().equals(sT.getSecond()) && (FC.find(fT.getSecond(), sT.getSecond()) > 0.7)) {
							CI.add(FC.find(fT.getSecond(), sT.getSecond()));
							STcount++;
							break;
						}
					}
				}
			}
			SIS.add((float) (STcount / FTcount));
		}
		RB.setCorrectiveIndex(CI);
		RB.setSimilarityIndex(SIS);
		return RB;
	}
}
