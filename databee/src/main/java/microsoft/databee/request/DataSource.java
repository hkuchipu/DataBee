package microsoft.databee.request;

/**
 * @author hakuchip
 *
 */

public class DataSource {

	private String database;
	private String connectionString;
	private int recordsCount;
	private String language;
	private boolean bigdata;
	private boolean useDictionary;

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public int getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(int recordsCount) {
		this.recordsCount = recordsCount;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isBigdata() {
		return bigdata;
	}

	public void setBigdata(boolean bigdata) {
		this.bigdata = bigdata;
	}

	public boolean isUseDictionary() {
		return useDictionary;
	}

	public void setUseDictionary(boolean useDictionary) {
		this.useDictionary = useDictionary;
	}

}
