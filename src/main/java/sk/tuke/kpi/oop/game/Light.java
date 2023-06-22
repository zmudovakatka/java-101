package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {

    private Animation lightOn;
    private Animation lightOff;
    private boolean isOn;
    private boolean isPowered;

    public Light(){
        this.isOn=false;
        this.lightOff = new Animation("sprites/light_off.png");
        this.lightOn = new Animation("sprites/light_on.png");
        setAnimation(this.lightOff);


    }
    public void toogle(){
        if (this.isOn){
            this.isOn=false;
            setAnimation(lightOff);
        }else {
            this.isOn=true;
            setAnimation(lightOn);
        }

    }
    public void setElectricityFlow(boolean electricityFlow){
        this.isPowered=electricityFlow;
    }

}
