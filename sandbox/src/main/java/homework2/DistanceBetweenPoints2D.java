package homework2;

/**
 * Created by inwi on 01.03.2016.
 */
public class DistanceBetweenPoints2D {

  public static void main(String[] args) {

    Point p = new Point(1, 2, 4, 8);

    System.out.println("Координаты точки A = (" + p.a1 + ";" + p.b1 + ")");
    System.out.println("Координаты точки B = (" + p.a2 + ";" + p.b2 + ")");
    System.out.println("Расстояние между точками = " + p.distance());
  }

}
