package homework2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {

  @Test
  public void test1Distance() {
    Point p = new Point(2,2,8,2);
    assert p.distance() == 6;
  }

  @Test
  public void test2Distance() {
    Point p = new Point(2,2,8,2);
    Assert.assertEquals(p.distance(),6.0);
  }

  @Test
  public void test3Distance() {
    Point p = new Point(2,2,2,8);
    Assert.assertEquals(p.distance(),6.0);
  }

  @Test
  public void test4Distance() {
    Point p = new Point(2,2,5,6);
    Assert.assertEquals(p.distance(),5.0);
  }

}

