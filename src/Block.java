

public class Block implements Comparable<Block>{
	
	private int length;
	private int width;
	private int height;
	int baseArea;
	
	
	public Block(int length, int width, int height) {
		this.setLength(length);
		this.setWidth(width);
		this.setHeight(height);
	}
	
	
	@Override
	public int compareTo(Block o) {
		return o.baseArea - this.baseArea;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}

}
