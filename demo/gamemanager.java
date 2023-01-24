package demo;

import event.event01;
import event.event02;

public class gamemanager {
    final actionHandler ActionHandler = new actionHandler(this);
    public final UI ui = new UI(this);
    public final demo.player player = new demo.player(this);
    public final scenechanger SceneChanger = new scenechanger(this);

    public final event01 ev1 = new event01(this);
    public final event02 ev2 = new event02(this);

    public static void main(String[] args) {
        new gamemanager();

    }

    public gamemanager() {
        player.setPlayerDefaultStatus();
        SceneChanger.showScene1();
    }
}
