package demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI {
    final gamemanager gm;
    JFrame window;
    public JTextArea messageText;
    public final JPanel[] bgPanel = new JPanel[10];
    public final JLabel[] bgLabel = new JLabel[10];

    // Player UI
    JPanel lifepanel;
    final JLabel[] lifelabel = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordlabel, shieldlabel, lanternlabel;

    //Game Over UI
    public JLabel titleLabel;
    public JButton restartButton;

    public UI(gamemanager gm) {
        this.gm = gm;

        createMainfield();
        createPlayerfield();
        createGameOverfield();
        generateScreen();

        window.setVisible(true);
    }

    public void createMainfield() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        messageText = new JTextArea("Tis is a sample text");
        messageText.setBounds(50, 410, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }

    public void createbackground(int bgNum, String fileName) { // part2 5.55 very important for basics
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50, 50, 700, 350);
        bgPanel[bgNum].setBackground(Color.blue);
        bgPanel[bgNum].setLayout(null);
        bgPanel[bgNum].setVisible(false);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(fileName));

        bgLabel[bgNum].setIcon(bgIcon);
    }

    public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFilename,
            String menu1Name, String menu2Name, String menu3Name,
            String action1Command, String action2Command, String action3Command) { // part2 5.55 very important for
                                                                                   // basics

        // Create Pop Menu
        JPopupMenu popMenu = new JPopupMenu();

        // Create Pop Menu Item
        JMenuItem[] menuItem = new JMenuItem[4]; // use [1][2][3]
        menuItem[1] = new JMenuItem(menu1Name);
        menuItem[1].addActionListener(gm.ActionHandler);
        menuItem[1].setActionCommand(action1Command);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(menu2Name);
        menuItem[2].addActionListener(gm.ActionHandler);
        menuItem[2].setActionCommand(action2Command);
        popMenu.add(menuItem[2]);

        menuItem[3] = new JMenuItem(menu3Name);
        menuItem[3].addActionListener(gm.ActionHandler);
        menuItem[3].setActionCommand(action3Command);
        popMenu.add(menuItem[3]);

        // Create Objects
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(objx, objy, objWidth, objHeight);

        ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFilename));
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        bgPanel[bgNum].add(objectLabel);

    }

    public void createArrowbutton(int bgNum, int x, int y, int width, int height, String arrowFilename,
            String command) {
        ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFilename));

        JButton arrowButton = new JButton();
        arrowButton.setBounds(x, y, width, height);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.ActionHandler);
        arrowButton.setActionCommand(command);
        arrowButton.setBorderPainted(false);

        bgPanel[bgNum].add(arrowButton);
    }

    public void createPlayerfield() {
        lifepanel = new JPanel();
        lifepanel.setBounds(50, 0, 250, 50);
        // lifepanel.setBackground(Color.blue);
        lifepanel.setLayout(new GridLayout(1, 5));
        window.add(lifepanel);

        ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("hearts.png"));
        Image image = lifeIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i = 1;
        while (i < 6) {
            lifelabel[1] = new JLabel();
            lifelabel[i].setIcon(lifeIcon);
            lifepanel.add(lifelabel[i]);
            i++;
        }
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(650, 0, 100, 50);
        // inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(1, 3));
        window.add(inventoryPanel);

        // Create items
        swordlabel = new JLabel();
        ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("plain-dagger.png"));
        Image image1 = swordIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image1);
        swordlabel.setIcon(swordIcon);
        inventoryPanel.add(swordlabel);

        shieldlabel = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("dragon-shield.png"));
        Image image2 = shieldIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image2);
        shieldlabel.setIcon(shieldIcon);
        inventoryPanel.add(shieldlabel);

        lanternlabel = new JLabel();
        ImageIcon lanterIcon = new ImageIcon(getClass().getClassLoader().getResource("lantern-flame.png"));
        Image image3 = lanterIcon.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image3);
        lanternlabel.setIcon(lanterIcon);
        inventoryPanel.add(lanternlabel);

    }
    public void createGameOverfield() {
        titleLabel = new JLabel("",JLabel.CENTER);
        titleLabel.setBounds(200,150,400,200);
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(new Font("Times Nw Roman", Font.PLAIN, 70));
        titleLabel.setVisible(false);
        window.add(titleLabel);

        restartButton = new JButton();
        restartButton.setBounds(340,320,120,50);
        restartButton.setBorder(null);
        restartButton.setBackground(null);
        restartButton.setForeground(Color.white);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.ActionHandler);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        window.add(restartButton);
    }

    public void generateScreen() {

        // Scene 1
        createbackground(1, "background-g8357511bc_1280.png");

        createObject(1, 440, 120, 200, 200,
                "log-cabin-g3bee5055f_1280.png", "Look", "Talk", "Rest",
                "lookhut", "talkhut", "resthut");

        createObject(1, 70, 180, 150, 150,
                "fantasy-g59b0ef9ca_1280.png", "Look", "Talk", "Attack",
                "lookguard", "talkguard", "attackguard");

        createObject(1, 310, 280, 70, 70,
                "chest.png", "Look", "Talk", "Open",
                "lookchest", "talkchest", "openchest");

        createArrowbutton(1, 0, 150, 50, 50, "arrow-g2eaf7e326_640.png", "goScene2");

        bgPanel[1].add(bgLabel[1]);

        // Scene 2
        createbackground(2, "23325212.jpg");

        // createObject(2, 440, 120, 200, 200,
        // "log-cabin-g3bee5055f_1280", "Look", "Talk", "Rest",
        // "lookhut", "talkhut", "resthut");
        createArrowbutton(2, 650, 150, 50, 50, "arrow-g9950399cf_640.png", "goScene1");

        createObject(2, 0, 100, 100, 300,
                "blank.png", "Look", "Talk", "Enter",
                "lookcave", "talkcave", "entercave");

        createObject(2, 355, 250, 50, 50,
                "blank.png", "Look", "Talk", "Search",
                "lookroot ", "talkroot", "searchroot");
        bgPanel[2].add(bgPanel[2]);

        // Scene 3
        createbackground(3, "23134394.jpg");

        createArrowbutton(3, 650, 150, 50, 50, "arrow-g9950399cf_640.png", "goScene2");

        bgPanel[3].add(bgPanel[3]);

    }

}
