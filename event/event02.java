package event;

import demo.gamemanager;

public record event02(gamemanager gm) {

    public void lookcave() {
        gm.ui.messageText.setText("It's a cave.");
    }

    public void talkcave() {
        gm.ui.messageText.setText("You hear the echo of your voice.");
    }

    public void entercave() {
        if (gm.player.hasLantern == 0) {
            gm.ui.messageText.setText("It's too dark to enter.");
        } else {
            gm.SceneChanger.showScene3();
        }
    }

    public void lookroot() {
        gm.ui.messageText.setText("There's something beside the tree");
    }

    public void talkroot() {
        gm.ui.messageText.setText("....");
    }

    public void searchroot() {
        if (gm.player.hasLantern == 0) {
            gm.ui.messageText.setText("You found the lantern.");
            gm.player.hasLantern = 1;
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.messageText.setText("You didn't find anything.");
        }
    }

}
