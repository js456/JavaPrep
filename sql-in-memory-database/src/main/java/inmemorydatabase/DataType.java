package inmemorydatabase;

public enum DataType {
	INTEGER(-1024, 1024), STRING(1, 100);

	int startRange;
	int endRange;

	DataType(int startRange, int endRange) {
		this.startRange = startRange;
		this.endRange = endRange;
	}

	public int getStartRange() {
		return startRange;
	}

	public int getEndRange() {
		return endRange;
	}

}
