import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {34, 5, 170},
        {44, 1, 44}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
        {-3, -5},
        {0, -3}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a, b), c);
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) throws IllegalArgumentException{
    try {
      ExampleException.rectangleArea(a, b);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException anIllegalArgumentException) {
      assertEquals(anIllegalArgumentException.getMessage(), ("Cannot be negative input values"));
    }
  }
}