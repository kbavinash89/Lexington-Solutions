package com.lexington.solution;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
/**
 * This class does unit testing
 * Creates a temporary folder and file and
 * generates output to this file and compares 
 * and compares it with existing file
 * 
 * @author Avinash
 *
 */
public class PublicTest {
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws IOException {	
	    final File expected = new File("model_output.txt");
	    final File output = new File("model_output.txt");
	    FileOutputSolution.checkFile(output);
	    Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
	}

}
