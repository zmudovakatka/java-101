package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {
    private int temperature;
    private boolean state;
    private int damage;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;

    public Reactor() {
        this.state = false;
        this.damage = 0;
        this.temperature = 0;
        this.normalAnimation = new Animation(
            "sprites/reactor_on.png",
            80,
            80,
            0.1F, Animation.PlayMode.LOOP_PINGPONG);
        this.hotAnimation = new Animation(
            "sprites/reactor_hot.png",
            80,
            80,
            0.1F, Animation.PlayMode.LOOP_PINGPONG);
        this.brokenAnimation = new Animation(
            "sprites/reactor_broken.png",
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

        //update animation
        if (this.temperature >= 6000) {
//            Animation animation = new Animation("sprites/reactor_broken.png",
//                80, 80, 0.1f,
//                Animation.PlayMode.LOOP_PINGPONG);
//            setAnimation(animation);
            setAnimation(this.brokenAnimation);
        } else if (this.temperature >= 4000) {
//            Animation animation = new Animation("sprites/reactor_hot.png",
//                80, 80, 0.1f,
//                Animation.PlayMode.LOOP_PINGPONG);
//            setAnimation(animation);
            setAnimation(this.hotAnimation);

        } else  {
//            nastavenie normalnej animacie ale vieme vyuzit normalAnimation z konstruktora Reactor

//            Animation animation = new Animation("sprites/reactor_on.png",
//                80, 80, 0.1f,
//                Animation.PlayMode.LOOP_PINGPONG);
//            setAnimation(animation);
            setAnimation(this.normalAnimation);

        }

        if(this.temperature>2000){


        }

        int damage = this.temperature/40 - 50;


    }

}
