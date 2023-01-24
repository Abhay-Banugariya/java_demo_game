package demo;

import demo.gamemanager;

import java.awt.event.*;

public class actionHandler implements ActionListener {

    final gamemanager gm;

    public actionHandler(gamemanager gm) {
        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (yourChoice) {
            //scene 1
            case "lookhut" -> gm.ev1.lookhut();
            case "talkhut" -> gm.ev1.talkhut();
            case "resthut" -> gm.ev1.resthut();
            case "lookguard" -> gm.ev1.lookguard();
            case "talkguard" -> gm.ev1.talkguard();
            case "attackguard" -> gm.ev1.attackguard();
            case "lookchest" -> gm.ev1.lookchest();
            case "talkchest" -> gm.ev1.talkchest();
            case "openchest" -> gm.ev1.openchest();

            //scene 2
            case "lookcave" -> gm.ev2.lookcave();
            case "talkcave" -> gm.ev2.talkcave();
            case "entercave" -> gm.ev2.entercave();
            case "talkroot" -> gm.ev2.talkroot();
            case "lookroot" -> gm.ev2.lookroot();
            case "searchroot" -> gm.ev2.searchroot();

            // change scenes
            case "goScene1" -> gm.SceneChanger.showScene1();
            case "goScene2" -> gm.SceneChanger.showScene2();
            case "restart" -> {
                gm.SceneChanger.existGameOverScene();
                gm.SceneChanger.showScene1();
            }
        }
    }

}
