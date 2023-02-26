package Core;

import java.util.ArrayList;
import java.util.List;

public class ReportBean {
	List<Float> SimilarityIndex = new ArrayList<Float>();
	List<Float> CorrectiveIndex = new ArrayList<Float>();
	List<List<Float>> SimilarityMatrix = new ArrayList<List<Float>>();
	List<String> Remarks = new ArrayList<String>();
	
	
	public List<String> getRemarks() {
		return Remarks;
	}
	public void setRemarks(List<String> remarks) {
		Remarks = remarks;
	}
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
	@Override
	public String toString() {
		return "ReportBean [SimilarityIndex=" + SimilarityIndex + ", CorrectiveIndex=" + CorrectiveIndex
				+ ", SimilarityMatrix=" + SimilarityMatrix + ", getSimilarityIndex()=" + getSimilarityIndex()
				+ ", getCorrectiveIndex()=" + getCorrectiveIndex() + ", getSimilarityMatrix()=" + getSimilarityMatrix()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
