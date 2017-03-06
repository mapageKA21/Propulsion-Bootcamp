
package demo;

/**
 * @author Sam Brannen
 */
public class SystemPropertyDemo {

	public static void main(String[] args) {

		// Run as:
		// java -Ddb.username=test demo.SystemPropertyDemo
		//
		// Or specify as a "VM Argument" in the Eclipse "Run Configuration"
		System.out.println("database username: " + System.getProperty("db.username"));
	}

}
