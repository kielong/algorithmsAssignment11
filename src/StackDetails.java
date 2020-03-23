import java.util.ArrayList;

public class StackDetails {
	
	private int maxHeight;
	private int totBlocks;
	private int maxIndex;
	private ArrayList<ArrayList<Block>> stack = new ArrayList<ArrayList<Block>>();	
	
	public StackDetails(int maxHeight, int totBlocks, ArrayList<ArrayList<Block>> stack, int maxIndex) {
		this.setMaxHeight(maxHeight);
		this.setTotBlocks(totBlocks);
		this.setStack(stack);
		this.setMaxIndex(maxIndex);
	}
	
	public int getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	public int getTotBlocks() {
		return totBlocks;
	}
	public void setTotBlocks(int totBlocks) {
		this.totBlocks = totBlocks;
	}
	public ArrayList<ArrayList<Block>> getStack() {
		return stack;
	}
	public void setStack(ArrayList<ArrayList<Block>> stack) {
		this.stack = stack;
	}

	public int getMaxIndex() {
		return maxIndex;
	}

	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}
	
	

}
