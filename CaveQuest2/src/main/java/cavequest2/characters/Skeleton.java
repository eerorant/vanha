package cavequest2.characters;


public class Skeleton extends Character {
    
    public Skeleton(double X, double Y) {
        super("file:skeleton.png", X, Y);
    }
    
    @Override
    public void control() {
        if (this.collision()) {
            this.turnRight();
            this.turnRight();
            this.turnRight();
            this.turnRight();
        } else {
            this.move();
        }
    }
}