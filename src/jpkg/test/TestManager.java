package jpkg.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.runner.JUnitCore;

/**
 * TestManager is simply a centralized way to manage tests and to
 * make sure they get run. 
 * @author minerguy31
 */
public final class TestManager {
	
	/**
	 * Classes to test
	 */
	private static Set<Class<?>> testdeps = new HashSet<>();
	
	/**
	 * This class shouldn't be instantated
	 */
	private TestManager() { throw new AssertionError(); }
	
	/**
	 * Add a test to the dependancy list
	 * @param c Class to add
	 */
	public static final void addTest(Class<?> c) {
		testdeps.add(c);
	}
	
	/**
	 * Run the tests
	 */
	public static final void runTests() {
		JUnitCore junit = new JUnitCore();
		for(Class<?> c : testdeps)
			junit.run(c);
	}
}
