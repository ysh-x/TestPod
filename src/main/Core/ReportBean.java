package Core;

import java.util.ArrayList;
import java.util.List;

public class ReportBean {
	List<Float> SimilarityIndex = new ArrayList<>();
	List<Float> CorrectiveIndex = new ArrayList<>();
	List<List<Float>> SimilarityMatrix = new ArrayList<>();
	public List<Float> getSimilarityIndex() {
		return SimilarityIndex;
	}
	public void setSimilarityIndex(List<Float> similarityIndex) {
		SimilarityIndex = similarityIndex;
	}
	public List<Float> getCorrectiveIndex() {
		return CorrectiveIndex;
	}
	public void setCorrectiveIndex(List<Float> correctiveIndex) {
		CorrectiveIndex = correctiveIndex;
	}
	public List<List<Float>> getSimilarityMatrix() {
		return SimilarityMatrix;
	}
	public void setSimilarityMatrix(List<List<Float>> similarityMatrix) {
		SimilarityMatrix = similarityMatrix;
	}
	
	
}
