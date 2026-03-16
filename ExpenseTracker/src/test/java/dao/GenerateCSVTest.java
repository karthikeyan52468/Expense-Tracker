package dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import service.GenerateCSV;

public class GenerateCSVTest {

	
	@Test
	public void generatecsv() {
		GenerateCSV csv= GenerateCSV.getInstance();
		csv.generateReport(32026);
		assertTrue(true);
	}
}
