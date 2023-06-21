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
        if (increment < 0) {
            return;
        }
        this.temperature += increment;
        if (this.damage == 100) {
            return;

        }

        updateAnimation();

        if (this.temperature > 2000) {
            if (this.temperature >= 6000) {
                this.damage = 100;

            } else {
                int damage = this.temperature / 40 - 50;
                if (this.damage < damage) {
                    this.damage = damage;

                }

            }


        }


    }

    public void decreaseTemperature(int decrement) {
        if (decrement < 0) {
            return;
        }

        this.temperature -= decrement;
        if (this.damage == 100) {
            return;
        }

        updateAnimation();
    }

    public void updateAnimation() {
        if (this.temperature >= 6000) {
//
            setAnimation(this.brokenAnimation);
        } else if (this.temperature >= 4000) {
//
            setAnimation(this.hotAnimation);

        } else {
//
            setAnimation(this.normalAnimation);

        }
    }
}


