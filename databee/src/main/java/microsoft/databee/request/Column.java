package microsoft.databee.request;

/**
 * @author hakuchip
 *
 */

public class Column {

	private String dependentColumn;
	private String strategy;
	private String pattern;
	private String criteria;
	private String dictionarySource;
	private String dataType;

	public String getDependentColumn() {
		return dependentColumn;
	}

	public void setDependentColumn(String dependentColumn) {
		this.dependentColumn = dependentColumn;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getDictionarySource() {
		return dictionarySource;
	}

	public void setDictionarySource(String dictionarySource) {
		this.dictionarySource = dictionarySource;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
