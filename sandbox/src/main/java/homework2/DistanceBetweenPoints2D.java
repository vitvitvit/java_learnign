package homework2;

/**
 * Created by inwi on 01.03.2016.
 */
public class DistanceBetweenPoints2D {

  public static void main(String[] args) {

    Point p1 = new Point();
    p1.a = 1;
    p1.b = 2;

    Point p2 = new Point();
    p2.a = 4;
    p2.b = 8;

    System.out.println("Координаты точки A = (" + p1.a + ";" + p1.b + ")");
    System.out.println("Координаты точки B = (" + p2.a + ";" + p2.b + ")");
    System.out.println("Расстояние между точками = " + distance(p1, p2));
  }

  public static double distance(Point p1, Point p2) {
    double x = Math.pow(p2.a - p1.a, 2) + Math.pow(p2.b - p1.b, 2);
    return Math.sqrt(x);
  }

}
