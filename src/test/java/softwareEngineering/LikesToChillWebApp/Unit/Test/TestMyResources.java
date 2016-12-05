package softwareEngineering.LikesToChillWebApp.Unit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import softwareEngineering.LikesToChillWebApp.MyResource;

public class TestMyResources {

	@Test
	public void test() {
		MyResource test = new MyResource();
		
		assertEquals("Got it!", test.getIt());
	}

}
