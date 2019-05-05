package cavequest2.characters;


public class Skeleton extends Character {
    
    public Skeleton(double X, double Y) {
        super("file:skeleton.png", X, Y);
        this.speed = 1.2;
    }
    
    @Override
    /**
     * Metodia kutsutaan 60 kertaa sekunnissa ja se ohjaa luurankoa. Luuranko liikkuu eteenpäin ja törmätessään seinään kääntyy ympäri.
     */
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