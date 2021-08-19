package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
class BiscuitTest {

	@Test
	void testEqualsWithoutHamcrest() {
		Biscuit thebiscuit = new Biscuit("Ginger");
		Biscuit mybiscuit = new Biscuit("Ginger");
		assertEquals(thebiscuit.getName(), mybiscuit.getName());
	}
	

	@Test
	void testEqualsUSingHamcrest() {
		Biscuit thebiscuit = new Biscuit("Ginger");
		Biscuit mybiscuit = new Biscuit("Ginger");
		assertThat(thebiscuit, equalTo(mybiscuit));
	}

}
