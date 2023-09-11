package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculationsTest {
    
    private Customer customer;
    private Vehicle orderedVehicle;

    
    @Before
	public void setUp() {
		orderedVehicle = new Vehicle();
        customer = new Customer("John Smith", );
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testDeposit_PositiveAmount() {
		
	}
	
}
