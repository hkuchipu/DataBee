package microsoft.databee.helper;

/**
 * @author hakuchip
 *
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class ParseInputHelper {

	@SuppressWarnings("unchecked")
	public static <T> T parseJson(T t, String jsonFilePath) {
		try {
			Gson gson = new Gson();
			String json = getResourceFileAsString(jsonFilePath);
			t = (T) gson.fromJson(json, t.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public static String getResourceFileAsString(String fileName) {
		System.out.println("Reading json from " + fileName);
		InputStream is = getResourceFileAsInputStream(fileName);
		if (is != null) {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			return (String) reader.lines().collect(Collectors.joining(System.lineSeparator()));
		} else {
			throw new RuntimeException("resource not found " + fileName);
		}
	}

	public static InputStream getResourceFileAsInputStream(String fileName) {
		ClassLoader classLoader = ParseInputHelper.class.getClassLoader();
		return classLoader.getResourceAsStream(fileName);
	}

}
