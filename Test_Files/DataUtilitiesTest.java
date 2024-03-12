package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Test;

public class DataUtilitiesTest {

//  CalculateColumnTotal tests start here
	@Test
	public void calculateColumnTotal_given_ZeroRows_then_ReturnZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(0));

			}
		});

		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);

		// verify
		assertEquals(0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotal_given_TwoPositiveRows_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});

		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);

		// verify
		assertEquals(10.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotal_given_TwoNegativeRows_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(-2.5));
			}
		});

		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);

		// verify
		assertEquals(-10.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotal_given_ThreePositiveRows_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(5));
			}
		});

		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);

		// verify
		assertEquals(15.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotal_given_ThreeNegativeRows_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(-7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(-2.5));
				oneOf(values).getValue(2, 0);
				will(returnValue(-5));
			}
		});

		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);

		// verify
		assertEquals(-15.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotal_given_InvalidColumnNumber_then_ReturnZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(1));
				allowing(values).getValue(0, 3);
			}
		});

		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 3);

		// verify
		assertEquals(0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateColumnTotal_given_InvalidData_then_ThrowInvalidParameterException() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
		} catch (InvalidParameterException ex) {

		} catch (Exception ex) {
			fail();
		}
	}

//    CalculateRowTotal tests start here
	@Test
	public void calculateRowTotal_given_ZeroColumns_then_ReturnZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(0));

			}
		});

		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);

		// verify
		assertEquals(0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotal_given_TwoPositiveColumns_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});

		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);

		// verify
		assertEquals(10.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotal_given_TwoNegativeColumns_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(-7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(-2.5));
			}
		});

		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);

		// verify
		assertEquals(-10.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotal_given_ThreePositiveColumns_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(5));
			}
		});

		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);

		// verify
		assertEquals(15.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotal_given_ThreeNegativeColumns_then_Success() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(3));
				oneOf(values).getValue(0, 0);
				will(returnValue(-7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(-2.5));
				oneOf(values).getValue(0, 2);
				will(returnValue(-5));
			}
		});

		// exercise
		double result = DataUtilities.calculateRowTotal(values, 0);

		// verify
		assertEquals(-15.0, result, .000000001d);

		// tear-down: NONE in this test method
	}

	@Test
	public void calculateRowTotal_given_InvalidRowNumber_then_ReturnZero() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(1));
				oneOf(values).getValue(-1, 0);
				will(throwException(new IndexOutOfBoundsException()));
			}
		});

		try {
		// exercise
		double result = DataUtilities.calculateRowTotal(values, -1);

		// verify
		assertEquals(0, result, .000000001d);

		// tear-down: NONE in this test method
		}
		catch(Exception ex) {
			fail("");
		}
	}

	@Test
	public void calculateRowTotal_given_InvalidData_then_ThrowInvalidParameterException() {
		// exercise
		try {
			DataUtilities.calculateRowTotal(null, 0);
		} catch (InvalidParameterException ex) {

		} catch (Exception ex) {
			fail();
		}

	}

//  createNumberArray tests start here

	@Test
	public void createNumberArray_given_DoubleArrayOfTwo_then_NumberArrayOfTwo() {

		double[] data = { 5.5, 7.0 };

		Number[] result = DataUtilities.createNumberArray(data);

		Number[] expected_result = { 5.5, 7.0 };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray_given_DoubleArrayWithMinValue_then_NumberArrayWithMinValue() {

		double[] data = { Double.MIN_VALUE, 1.0, 2.0 };

		Number[] result = DataUtilities.createNumberArray(data);

		Number[] expected_result = { Double.MIN_VALUE, 1.0, 2.0 };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray_given_DoubleArrayWithMaxValue_then_NumberArrayWithMaxValue() {

		double[] data = { Double.MAX_VALUE, 1.0, 2.0 };

		Number[] result = DataUtilities.createNumberArray(data);

		Number[] expected_result = { Double.MAX_VALUE, 1.0, 2.0 };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray_given_DoubleEmptyArray_then_NumberEmptyArray() {

		double[] data = {};

		Number[] result = DataUtilities.createNumberArray(data);

		Number[] expected_result = {};

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray_given_InvalidData_then_ThrowException() {
		double[] data = null;
		try {
			DataUtilities.createNumberArray(data);
		} catch (InvalidParameterException ex) {

		} catch (Exception ex) {
			fail();
		}
	}

//  createNumberArray2D tests start here

	@Test
	public void createNumberArray2D_given_DoubleArrayOfTwo_then_NumberArrayOfTwo() {

		double[][] data = { { 5.5, 7.0 }, { 1.5, 2.0 } };

		Number[][] result = DataUtilities.createNumberArray2D(data);

		Number[][] expected_result = { { 5.5, 7.0 }, { 1.5, 2.0 } };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray2D_given_DoubleArrayWithMinValue_then_NumberArrayWithMinValue() {

		double[][] data = { { Double.MIN_VALUE, 7.0 }, { 1.5, 2.0 } };

		Number[][] result = DataUtilities.createNumberArray2D(data);

		Number[][] expected_result = { { Double.MIN_VALUE, 7.0 }, { 1.5, 2.0 } };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray2D_given_DoubleArrayWithMaxValue_then_NumberArrayWithMaxValue() {

		double[][] data = { { Double.MAX_VALUE, 7.0 }, { 1.5, 2.0 } };

		Number[][] result = DataUtilities.createNumberArray2D(data);

		Number[][] expected_result = { { Double.MAX_VALUE, 7.0 }, { 1.5, 2.0 } };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray2D_given_DoubleEmptyArray_then_NumberEmptyArray() {

		double[][] data = { {} };

		Number[][] result = DataUtilities.createNumberArray2D(data);

		Number[][] expected_result = { {} };

		// verify
		assertArrayEquals(expected_result, result);
	}

	@Test
	public void createNumberArray2D_given_InvalidData_then_ThrowException() {

		double[][] data = null;
		try {
			DataUtilities.createNumberArray2D(data);
		} catch (InvalidParameterException ex) {
		} catch (Exception ex) {
			fail();
		}
	}

//  getCumulativePercentages tests start here
	
	@Test
	public void getCumulativePercentages_given_StringKeysPositiveValues_then_Success() {
		
		Mockery mockingContext1 = new Mockery();
		
		final KeyedValues mockObject = mockingContext1.mock(KeyedValues.class);
		
		mockingContext1.checking(new org.jmock.Expectations() {
			{
				allowing(mockObject).getItemCount();
				will(returnValue(4));
				
				allowing(mockObject).getKey(0);
				will(returnValue("Str1"));
				allowing(mockObject).getKey(1);
				will(returnValue("Str2"));
				allowing(mockObject).getKey(2);
				will(returnValue("Str3"));
				allowing(mockObject).getKey(3);
				will(returnValue("Str4"));
				
				
				allowing(mockObject).getIndex("Str1");
				will(returnValue(0));
				allowing(mockObject).getIndex("Str2");
				will(returnValue(1));
				allowing(mockObject).getIndex("Str3");
				will(returnValue(2));
				allowing(mockObject).getIndex("Str4");
				will(returnValue(3));
				
				
				allowing(mockObject).getValue(0);
				will(returnValue(5));
				allowing(mockObject).getValue(1);
				will(returnValue(10));
				allowing(mockObject).getValue(2);
				will(returnValue(15));
				allowing(mockObject).getValue(3);
				will(returnValue(20));
			}
		});
		
		  KeyedValues actualOutput = DataUtilities.getCumulativePercentages(mockObject);
		  
		  assertEquals(0.1,actualOutput.getValue(0).doubleValue(),  0.001d);
		  assertEquals(0.3,actualOutput.getValue(1).doubleValue(),  0.001d);
		  assertEquals(0.6,actualOutput.getValue(2).doubleValue(),  0.001d);
		  assertEquals(1,actualOutput.getValue(3).doubleValue(),  0.001d);
	}
	
	@Test
	public void getCumulativePercentages_given_StringKeysNegativeValues_then_Success() {
		
		Mockery mockingContext1 = new Mockery();
		
		final KeyedValues mockObject = mockingContext1.mock(KeyedValues.class);
		
		mockingContext1.checking(new org.jmock.Expectations() {
			{
				allowing(mockObject).getItemCount();
				will(returnValue(4));
				
				allowing(mockObject).getKey(0);
				will(returnValue("Str1"));
				allowing(mockObject).getKey(1);
				will(returnValue("Str2"));
				allowing(mockObject).getKey(2);
				will(returnValue("Str3"));
				allowing(mockObject).getKey(3);
				will(returnValue("Str4"));
				
				
				allowing(mockObject).getIndex("Str1");
				will(returnValue(0));
				allowing(mockObject).getIndex("Str2");
				will(returnValue(1));
				allowing(mockObject).getIndex("Str3");
				will(returnValue(2));
				allowing(mockObject).getIndex("Str4");
				will(returnValue(3));
				
				
				allowing(mockObject).getValue(0);
				will(returnValue(-5));
				allowing(mockObject).getValue(1);
				will(returnValue(-10));
				allowing(mockObject).getValue(2);
				will(returnValue(-15));
				allowing(mockObject).getValue(3);
				will(returnValue(-20));
			}
		});
		
			  KeyedValues actualOutput = DataUtilities.getCumulativePercentages(mockObject);
			  
			  assertEquals(0.1,actualOutput.getValue(0).doubleValue(), 0.001d);
			  assertEquals(0.3,actualOutput.getValue(1).doubleValue(), 0.001d);
			  assertEquals(0.6,actualOutput.getValue(2).doubleValue(), 0.001d);	  
			  assertEquals(1,actualOutput.getValue(3).doubleValue(), 0.001d);
	}	
	
	@Test
	public void getCumulativePercentages_given_InvalidData_then_ThrowInvalidParameterException() {
		
		try {
	
			DataUtilities.getCumulativePercentages(null);
	
		} catch (Exception e) {
			assertEquals("The exception thrown should be InvalidParameterException", InvalidParameterException.class,
					e.getClass());
		}
	}
	
	//new
	
	//equal
	@Test
	public void equal_given_bothNull_then_true() {
		assertTrue("This should return true.", DataUtilities.equal(null, null));
	}
	
	@Test
	public void equal_given_firstNullSecondNotNull_then_false() {
		double[][] data = { { 3, 7.0 }, { 1.5, 2.0 } };
		DataUtilities.equal(null, data);
	}
	
	@Test
	public void equal_given_secondNullFirstNotNull_then_false() {
		double[][] data = { { 3, 7.0 }, { 1.5, 2.0 } };
		assertFalse("This should return false.", DataUtilities.equal(data, null));
	}
	
	@Test
	public void equal_given_differentLenghts_then_false() {
		double[][] data1 = { { 3, 7.0 }, { 1.5, 2.0 } };
		double[][] data2 = { { 7.0 } };
		assertFalse("This should return false.", DataUtilities.equal(data1, data2));
	}
	
	@Test
	public void equal_given_differentItems_then_false() {
		double[][] data1 = { { 3, 7.0 }, { 1.5, 2.0 } };
		double[][] data2 = { { 3, 7.0 }, { 1.5, 3.0 } };
		assertFalse("This should return false.", DataUtilities.equal(data1, data2));
	}
	
	@Test
	public void equal_given_sameArrays_then_true() {
		double[][] data1 = { { 3, 7.0 }, { 1.5, 2.0 } };
		double[][] data2 = { { 3, 7.0 }, { 1.5, 2.0 } };
		assertTrue("This should return false.", DataUtilities.equal(data1, data2));
	}

	//clone
	@Test
	public void clone_given_nullData_then_ThrowException() {

		double[][] data = null;
		try {
			DataUtilities.clone(data);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException ex) {
		} catch (Exception ex) {
			fail("IllegalArgumentException should be thrown.");
		}
	}
	
	@Test
	public void clone_given_normalValues_then_result() {
		double[][] data = { { 3 }, { 1.5, 2.0 } };
		assertArrayEquals("This should clone all but null", data ,DataUtilities.clone(data));
	}
	
	//calculateColumnTotal(Values2D data, int column, int[] validRows)
	@Test
	public void calculateColumnTotal_given_nullData_then_Success() {
		try {
			int[] validRows = {1,2};
			DataUtilities.calculateColumnTotal(null, 0, validRows);
			fail("IllegalArgumentException  should be thrown.");
		}
		catch(IllegalArgumentException ex) {
		}
		catch(Exception ex) {
			fail("IllegalArgumentException  should be thrown.");
		}
	}
	@Test
	public void calculateColumnTotal_given_normalData_then_Success() {
		int[] validRows = {1,2};
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});

		double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
		assertEquals(2.5, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotal_given_validRowOutOfRange_then_Success() {
		int[] validRows = {1,2,5};
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});

		double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
		assertEquals(2.5, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotal_given_containNullItem_then_Success() {
		int[] validRows = {1,2,5};
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getRowCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(1, 0);
				will(returnValue(null));
			}
		});

		double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
		assertEquals(7.5, result, .000000001d);
	}
	
	//calculateRowTotal(Values2D data, int column, int[] validCols)
	@Test
	public void calculateRowTotal_given_nullData_then_Success() {
		try {
			int[] validCols = {1,2};
			DataUtilities.calculateRowTotal(null, 0, validCols);
			fail("IllegalArgumentException  should be thrown.");
		}
		catch(IllegalArgumentException ex) {
		}
		catch(Exception ex) {
			fail("IllegalArgumentException  should be thrown.");
		}
	}
	@Test
	public void calculateRowTotal_given_normalData_then_Success() {
		int[] validCols = {1,2};
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		assertEquals(2.5, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotal_given_validColumnOutOfRange_then_Success() {
		int[] validCols = {1,2,5};
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		assertEquals(2.5, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotal_given_containNullItem_then_Success() {
		int[] validCols = {1,2,5};
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				oneOf(values).getColumnCount();
				will(returnValue(2));
				oneOf(values).getValue(0, 0);
				will(returnValue(7.5));
				oneOf(values).getValue(0, 1);
				will(returnValue(null));
			}
		});

		double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		assertEquals(7.5, result, .000000001d);
	}
	
}
