package microsoft.databee.generator;

/**
 * @author hakuchip
 *
 */

import java.util.Map;
import java.util.Random;

import microsoft.databee.helper.DBConnection;

public class Dictionaries {
	private static Map<Integer, String> companyNameDict;
	private static Map<Integer, String> productNameDict;
	private static Map<Integer, String> nameDict;
	private static Map<Integer, String> phoneDict;
	private static Map<Integer, String> roleDict;
	private static Map<Integer, String> addressDict;

	private static Map<Integer, String> addressCityDict;
	private static Map<Integer, String> addressPostalCodeDict;
	private static Map<Integer, String> addressCountryDict;
	private static Map<Integer, String> addressPhoneDict;

	private static Random rand;

	static {
		String country = System.getProperty("country", "USA");
		String filter = " Country = '" + country + "'";
		rand = new Random();
		productNameDict = DBConnection.getDictionary("databee.Golden_dictionary_ProductName");
		companyNameDict = DBConnection.getDictionary("databee.Golden_dictionary_CompanyName");
		nameDict = DBConnection.getColDictionary("databee.Golden_dictionary_Name", filter, "Name");
		phoneDict = DBConnection.getColDictionary("databee.Golden_dictionary_Phone", filter, "PhoneNumber");
		roleDict = DBConnection.getDictionary("databee.Golden_dictionary_Role");
		addressDict = DBConnection.getColDictionary("databee.Golden_dictionary_Address", filter, "Address");

//		System.out.println("productNameDict " + productNameDict);
//		System.out.println("companyNameDict " + companyNameDict);
//		System.out.println("nameDict " + nameDict);
//		System.out.println("phoneDict " + phoneDict);
//		System.out.println("roleDict " + roleDict);
//		System.out.println("addressDict " + addressDict);
	}

	public static String getAddrDictValue(String address, String column) {
		String result = null;
		String filter = " Address = '" + address + "'";
		switch (column.toUpperCase()) {
		case "CITY":
			addressCityDict = DBConnection.getDictionary("databee.Golden_dictionary_Address", filter, column);
			result = addressCityDict.get(addressCityDict.size());
			break;
		case "POSTALCODE":
			addressPostalCodeDict = DBConnection.getDictionary("databee.Golden_dictionary_Address", filter, column);
			result = addressPostalCodeDict.get(addressPostalCodeDict.size());
			break;
		case "COUNTRY":
			addressCountryDict = DBConnection.getDictionary("databee.Golden_dictionary_Address", filter, column);
			result = addressCountryDict.get(addressCountryDict.size());
			break;
		case "PHONE":
			addressPhoneDict = DBConnection.getDictionary("databee.Golden_dictionary_Address", filter, column);
			result = addressPhoneDict.get(addressPhoneDict.size());
			break;
		}
		return result;
	}

	public static String getDictValue(String dict) {
		String result = null;
		switch (dict) {
		case "PRODUCTNAME":
			result = productNameDict.get(rand.nextInt(productNameDict.size()));
			break;
		case "COMPANYNAME":
			result = companyNameDict.get(rand.nextInt(companyNameDict.size()));
			break;
		case "NAME":
			result = nameDict.get(rand.nextInt(nameDict.size()));
			break;
		case "PHONE":
			result = phoneDict.get(rand.nextInt(phoneDict.size()));
			break;
		case "ROLE":
			result = roleDict.get(rand.nextInt(roleDict.size()));
			break;
		case "ADDRESS":
			result = addressDict.get(rand.nextInt(addressDict.size()));
			break;
		}
		return result;
	}
}
