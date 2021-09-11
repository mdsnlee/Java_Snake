import java.util.LinkedList;

public class Snake {
    private Coordinate head;
    private LinkedList<Coordinate> body; //update 
    //templating <>

    private Coordinate direction;

    public Snake() {
        head = new Coordinate(3, 3);
        body = new LinkedList<Coordinate>();

        direction = new Coordinate(1, 0);

        body.add(new Coordinate(1, 3));
        body.add(new Coordinate(2, 3));
    }

    public void grow() {
        body.addFirst(new Coordinate(body.get(0)));
    }

    //getter for head
    public Coordinate getHead() {
        return head;
    }

    public LinkedList<Coordinate> getBody() {
        return body;
    }

    public void move() {
        body.add(new Coordinate(head));
        body.removeFirst();

        //Head
        head.setX(head.getX() + direction.getX());
        head.setY(head.getY() + direction.getY());
    }

    public void moveUp() {
        if (!(direction.equals(new Coordinate(0, 1)))) {
            direction = new Coordinate(0, -1);
        }
    }

    public void moveDown() {
        if (!(direction.equals(new Coordinate(0, -1)))) {
            direction = new Coordinate(0, 1);
        }
    }

    public void moveLeft() {
        if (!(direction.equals(new Coordinate(1, 0)))) {
            direction = new Coordinate(-1, 0);
        }
    }

    public void moveRight() {
        if (!(direction.equals(new Coordinate(-1, 0)))) {
            direction = new Coordinate(1, 0);
        }
    }

    public boolean isColliding() {
        if (head.getX() > 19 ||
            head.getY() > 19 ||
            head.getX() < 0 ||
            head.getY() < 0 ) {
            return true;
        }
        for (Coordinate part : body) {
            if (part.getX() == head.getX() && 
                part.getY() == head.getY()) {
                    return true;
                }

        }

        return false;
    }

    // //getter for body?
    // public LinkedList<Coordinate> getBody() {
    //     return body;
    // }
}


//main menu + game over screen
//comments on top
/*
dafs
*/