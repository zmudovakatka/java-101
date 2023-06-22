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
    private Animation offAnimation;

    public Reactor() {
        this.state = false;
        this.damage = 0;
        this.temperature = 0;
        this.offAnimation = new Animation(
            "sprites/reactor.png");
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

        setAnimation(this.offAnimation);
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getDamage() {
        return this.damage;
    }
    public void turnOn(){
        this.state=true;
        if (this.damage == 100){
            return;
        }

        getAnimation().play();
        updateAnimation();
    }
    public void turnOff(){
        if(this.damage == 100){
            return;
        }
        this.state = false;
        getAnimation().pause();
        updateAnimation();
    }

    public boolean isRunning(){
        return this.state;
    }

    public void increaseTemperature(int increment) {
        if (increment < 0 || isRunning() == false){
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
                this.state = false;

            } else {
                int damage = this.temperature / 40 - 50;
                if (this.damage < damage) {
                    this.damage = damage;

                }

            }


        }


    }

    public void decreaseTemperature(int decrement) {
        if (decrement < 0|| isRunning()==false) {
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
    public void repairWith(Hammer hammer){
//        if (hammer != null && this.damage>0 && this.damage<100){
//
//            if (this.damage<50){
//                this.damage=0;
//            } else {
//                this.damage-=50;
//            }
//            hammer.getUsages();
//
//
//        }
        if (hammer==null){
            return;
        }
        if (this.damage==0){
            return;
        }
        if (this.damage==100){
            return;
        }
        hammer.use();
        this.damage=this.damage-50;


        if(this.damage<0){
            this.damage=0;
        }
        this.temperature = 0;
        updateAnimation();

    }
}


