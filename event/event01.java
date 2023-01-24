package event;

import demo.gamemanager;

public class event01 {
    final gamemanager gm;

    public event01(gamemanager gm) {
        this.gm = gm;
    }

    public void lookhut() {
        gm.ui.messageText.setText("This is your house");
    }

    public void talkhut() {
        gm.ui.messageText.setText("Who are you talking to?");
    }

    public void resthut() {
        if (gm.player.playerLife != gm.player.playerMaxlife) {
            gm.ui.messageText.setText("You rest at the house. \n Your Life has recovered. Let's go!");
            gm.player.playerLife++;
            gm.player.updatePlayerStatus();
        } else {
            gm.ui.messageText.setText("Your life is full.");
        }
    }

    public void lookchest() {
        gm.ui.messageText.setText("A chest is on the ground.");
    }

    public void talkchest() {
        gm.ui.messageText.setText("Uhhhh!");
    }

    public void openchest() {
        if(gm.player.hasSword==0){
            gm.ui.messageText.setText("You opened the chest and found the sword.");
            gm.player.hasSword = 1;
            gm.player.updatePlayerStatus();
        }
        else{
            gm.ui.messageText.setText("You already have a sword.");
        }
    }

    public void lookguard() {
        gm.ui.messageText.setText("A guard is standing in front of you.");
    }

    public void talkguard() {
        gm.ui.messageText
                .setText("Guard: Don't go any further without any weapon.\n You should check the chest for weapons.");
    }

    public void attackguard() {
        if(gm.player.hasShield==0){
            if(gm.player.hasSword ==0) {
                if(gm.player.playerLife !=1) {
                    gm.ui.messageText.setText("Guard: Hey don't be stupid.\n(Guard hits you back and life decreses by one heart.)");
                    gm.player.playerLife--;
                    // gm.player.updatePlayerStatus(); 
                }
                else {
                    gm.ui.messageText.setText("Guard: What the fool!.)");
                    gm.player.playerLife--;
                    gm.SceneChanger.gameoverScene(1); 
                }

            }
            else if (gm.player.hasSword == 1) {
                gm.ui.messageText.setText("Guard: Oh, shit! \n(Yo defeated the guard and got his shield.))");
                gm.player.hasShield =1;

            }
            gm.player.updatePlayerStatus(); 
        } 
        else gm.ui.messageText.setText("Guard: Have mercy  my lord!.))");   
    }
    
}
