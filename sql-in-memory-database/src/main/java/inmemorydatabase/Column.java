package inmemorydatabase;

public class Column {

	private String columnName;
	private DataType dataType;
	//private Object value;
	private DBConstraint constraint;

	private Column(ColumnBuilder builder) {
		this.columnName = builder.columnName;
		this.dataType = builder.dataType;
		this.constraint = builder.constraint;
	}

	public String getColumnName() {
		return columnName;
	}

	public DataType getDataType() {
		return dataType;
	}

	public DBConstraint getConstraint() {
		return constraint;
	}

	public static class ColumnBuilder {
		private String columnName;
		private DataType dataType;
		private DBConstraint constraint;

		public ColumnBuilder(String columnName, DataType dataType) {
			super();
			this.columnName = columnName;
			this.dataType = dataType;
		}

		public ColumnBuilder setConstraint(DBConstraint constraint) {
			this.constraint = constraint;
			return this;
		}

		public Column build() {
			Column column = new Column(this);
			return column;
		}

	}
}
