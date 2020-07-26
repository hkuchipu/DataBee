package microsoft.databee.helper;

/**
 * @author hakuchip
 *
 */

import microsoft.databee.request.DataSource;
import microsoft.databee.request.Tables;

public class InputHelper {
	public static DataSource ds = ParseInputHelper.parseJson(new DataSource(), "request/datasource.json");
	public static Tables tables = ParseInputHelper.parseJson(new Tables(), "request/tables.json");

}
