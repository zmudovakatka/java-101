package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {
    private int temperature;
    private boolean state;
    private int damage;
    private Animation normalAnimation;

    public Reactor() {
        this.temperature = 0;
        this.state = false;
        this.damage = 0;
        this.normalAnimation = new Animation(
            "sprites/reactor_on.png",
            80,
            80,
            0.1F, Animation.PlayMode.LOOP_PINGPONG);

        setAnimation(this.normalAnimation);
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getDamage() {
        return this.damage;
    }

    public void increaseTemperature(int increment) {
        this.temperature += increment;
        if (this.temperature>=2000 && this.temperature<=6000) {
            int damage = this.temperature / 40 - 50;
            if (this.damage<damage){
                this.damage=damage;
            }
        }



    }

}
