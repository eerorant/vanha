package cavequest2.characters;
import java.util.Random;
public class Zombie extends Character {
    private Random ran;
    public Zombie(double X, double Y) {
        super("file:zomb.png", X, Y);
        this.ran = new Random();
        this.speed = 0.5;
    }
    
    
    @Override
    /**
     * Metodia kutsutaan 60 kertaa sekunnissa ja se ohjaa zombia. Se liikkuu eteenpäin ja kääntyy oikealle ja vasemmalle satunnaisesti.
     */
    public void control() {
        int randomNumber = ran.nextInt(100);
        if (randomNumber == 0) {
            this.turnRight();
        } else if (randomNumber == 1 ) {
            this.turnLeft();
        }
        
        if (collision()) {
            this.turnRight();
        } else {
            this.move();
        }
    }
    
}
