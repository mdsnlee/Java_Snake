import java.util.Random;


public class Apple {

    private Coordinate appleCoord;

    public Apple() {
        randApple();
    }

    public void randApple() {

        Random random = new Random();

        appleCoord = new Coordinate(random.nextInt(20), random.nextInt(20));
        //System.out.println(appleCoord);
    }

    public Coordinate getCoord() {

        return appleCoord;
    }

    public int getX() {
        return appleCoord.getX();
    }

    public int getY() {
        return appleCoord.getY();
    }

}