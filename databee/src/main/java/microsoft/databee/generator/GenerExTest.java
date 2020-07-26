/**
 * 
 */
package microsoft.databee.generator;

import com.mifmif.common.regex.Generex;

/**
 * @author hakuchip
 *
 */
public class GenerExTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Generex genEx = new Generex("\\d{2}-[1-9]{5}-\\D{2}-\\w{5}-\\W{2}-[1-9]{6}-[n-z]{5}-[(true)||(false)]-[1-9]{3}\\.[1-9]{6}") ;
		for(int i=0; i< 10; i++) {
			System.out.println(genEx.random());
		}

	}

}
