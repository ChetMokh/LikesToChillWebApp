package CST438.softwareEngineering.LikesToChillWebApp;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyResources {

	@Test
	public void test() {
		MyResource test = new MyResource();
		
		assertEquals("Got it!", test.getIt());
	}

}
