package demo;

public class player {

    final gamemanager gm;

    public int playerMaxlife;
    public int playerLife;
    public int hasSword;
    public int hasShield;
    public int hasLantern;

    public player(gamemanager gm) {
        this.gm = gm;

    }

    public void setPlayerDefaultStatus() {
        playerMaxlife = 5;
        playerLife = 3;
        hasSword = 0;
        hasShield = 0;
        hasLantern = 0;

        updatePlayerStatus();
    }

    public void updatePlayerStatus() {
        //Remove all life icon
        int i =1;
        while(i<6) {
            gm.ui.lifelabel[i].setVisible(false);
            i++;
        }
        int lifeCount = playerLife;
        while (lifeCount !=0) {
            gm.ui.lifelabel[lifeCount].setVisible(true);
            lifeCount--;
        }
        //check player items
        if (hasSword == 0) {
            gm.ui.swordlabel.setVisible(false);
        }
        if (hasSword == 1) {
            gm.ui.swordlabel.setVisible(true);
        } 
        if (hasShield == 0) {
            gm.ui.shieldlabel.setVisible(false);
        }
        if (hasShield == 1) {
            gm.ui.shieldlabel.setVisible(true);
        }
        if (hasLantern == 0) {
            gm.ui.lanternlabel.setVisible(false);
        }
        if (hasLantern == 1) {
            gm.ui.lanternlabel.setVisible(true);
        }
    }
}
