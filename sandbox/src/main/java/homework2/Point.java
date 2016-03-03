package homework2;

/**
 * Created by inwi on 01.03.2016.
 */
public class Point {
  public int a1;
  public int b1;
  public int a2;
  public int b2;

  public Point(int a1, int b1, int a2, int b2) {
    this.a1 = a1;
    this.b1 = b1;
    this.a2 = a2;
    this.b2 = b2;
  }

  public double distance() {
    double x = Math.pow(this.a2 - this.a1, 2) + Math.pow(this.b2 - this.b1, 2);
    return Math.sqrt(x);
  }

}
