public class ExampleException {
  public static int rectangleArea(int a, int b) {

    if (a < 0 | b < 0){
      throw new IllegalArgumentException("Cannot be negative input values");
    }
    return a * b;
  }
}