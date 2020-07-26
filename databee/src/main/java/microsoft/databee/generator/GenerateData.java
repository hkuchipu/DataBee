package microsoft.databee.generator;

import java.util.Map;
import java.util.Random;

import com.mifmif.common.regex.Generex;

/**
 * @author hakuchip
 *
 */

import microsoft.databee.helper.InputHelper;
import microsoft.databee.request.Column;
import microsoft.databee.request.Table;

public class GenerateData {
	public static Random random = new Random();
	public static String addressVal = null;

	public static void main(String[] args) {

		for (int i = 0; i < InputHelper.tables.getTables().size(); i++) {
			for (int j = 0; j < InputHelper.ds.getRecordsCount(); j++) {
				Table table = InputHelper.tables.getTables().get(i);
				String tableName = table.getTableName(); // Table Name
				StringBuffer clomnsStringBfr = new StringBuffer();
				StringBuffer valuesStringBfr = new StringBuffer();
				Map<String, Column> columns = table.getColumns();
				for (String col : columns.keySet()) {
					String columnName = col; // Column Name
					clomnsStringBfr.append(columnName).append(",");
					Object columnValue = null; // Column Value
					Column colmnProps = columns.get(col);

					columnValue = computeColumnValue(colmnProps, columnName);
					// Apply additional criteria
					if (null != colmnProps.getCriteria()) {

					}
					if(null == colmnProps.getDataType() ) {
						System.out.println("ColName "+ columnName +" datatype "+ colmnProps.getDataType());
					}
					valuesStringBfr.append(convertType(columnValue, colmnProps.getDataType())).append(",");
				}

				String colmns = clomnsStringBfr.toString();
				String vals = valuesStringBfr.toString();
				if (colmns.length() > 1 && vals.length() > 1) {
					String insertQuery = "insert into " + tableName + "(" + colmns.substring(0, colmns.length() - 1)
							+ ") values (" + vals.substring(0, vals.length() - 1) + ")";
					System.out.println("insertQuery " + insertQuery);
				}

//			String insertQuery = "insert into " + tableName + "("
//					+ clomnsStringBfr.toString().substring(0, clomnsStringBfr.length() - 1) + ") va;lues ("
//					+ valuesStringBfr.toString().substring(0, clomnsStringBfr.length() - 1) + ")";
//			

				// System.out.println(insertQuery);
			}
		}

//		System.out.println("Tables " + InputHelper.tables.getTables().size());
//		System.out.println("Tables " + InputHelper.tables.getTables().get(0).getColumns().size());
//		System.out.println(Dictionaries.getDictValue("ProductName"));

	}

	/**
	 * @param columnValue
	 * @param dataType
	 * @return
	 */
	private static String convertType(Object columnValue, String dataType) {
		StringBuffer sb = new StringBuffer();
		switch (dataType.toUpperCase()) {
		case "VARCHAR":
			sb.append("'").append(columnValue).append("'");
			break;
		default:
			sb.append(columnValue);
			break;
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param colmnProps
	 * @param seq
	 * @param min
	 * @param max
	 * @return
	 */
	private static Object computeColumnValue(Column colmnProps, String columnName) {
		Object value = null;
		Generex genEx;
		// get dependent column
		if (null != colmnProps.getDependentColumn()) {
			value = " ";
		}

		if (null != colmnProps.getStrategy()) {
			switch (colmnProps.getStrategy().toUpperCase()) {
			case "SEQUENCE":
				genEx = new Generex(colmnProps.getPattern());
				value = genEx.random();
				break;
			case "RANDOM":
				// value = getRandom(min, max);
				break;
			case "DICTIONARY":
				if (null != colmnProps.getDictionarySource()) {

					if (colmnProps.getDependentColumn().equalsIgnoreCase("Address")
							&& colmnProps.getDictionarySource().equalsIgnoreCase("Address")) {
						value = Dictionaries.getAddrDictValue(addressVal, columnName);
					} else if (colmnProps.getDictionarySource().equalsIgnoreCase("Address")
							&& !colmnProps.getDependentColumn().equalsIgnoreCase("Address")) {
						value = Dictionaries.getDictValue(colmnProps.getDictionarySource().toUpperCase());
						addressVal = (String) value;
					} else {
						value = Dictionaries.getDictValue(colmnProps.getDictionarySource().toUpperCase());
					}

				} else {
					System.out.println(" Dictionary source not found ");
				}
				break;
			case "BOOLEAN":
				value = random.nextBoolean();
				break;
			default:
				value = getRandom(1, 100);
				break;
			}
		}

		return value;
	}

	/**
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	private static int getRandom(int lowerBound, int upperBound) {
		int randomNumber = random.nextInt(upperBound - lowerBound) + lowerBound;
		return randomNumber;
	}

	/**
	 * 
	 * @param seq
	 * @return
	 */
	private static int getSequence(int seq) {
		return seq + 1;
	}

}
