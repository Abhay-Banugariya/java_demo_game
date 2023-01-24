package demo;

public class scenechanger {

    final gamemanager gm;

    public scenechanger(gamemanager gm) {
        this.gm = gm;
    }

    public void showScene1() {
        gm.ui.bgPanel[1].setVisible(true);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.messageText.setText("Let's defeat the demon lord. Save!");
    }

    public void showScene2() {
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(true);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.messageText.setText("tis is scene 2");
    }
    
    public void showScene3() {
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(true);
        gm.ui.messageText.setText("tis is scene 3");
    }
    public void gameoverScene(int currentbgNum) {

        gm.ui.bgPanel[currentbgNum].setVisible(false);
        gm.ui.titleLabel.setVisible(true);
        gm.ui.titleLabel.setText("You Died! Lol");
        gm.ui.restartButton.setVisible(true);
        gm.ui.restartButton.setText("Click here to restart the game.");
    }
    public void existGameOverScene() {
        gm.ui.titleLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
        gm.player.setPlayerDefaultStatus();
    }

}
