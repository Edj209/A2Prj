package com.mycompany.a2;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.sun.glass.ui.SystemClipboard;
import com.sun.xml.internal.ws.api.server.LazyMOMProvider;

/**
 * Created by Edgar on 2/23/2016.
 */
public class Game extends Form{
    private GameWorld gw;
    private MapView mv;
    private ScoreView sv;

    public Game() {
        gw = new GameWorld();
        gw.initLayout();
        mv = new MapView();
        sv = new ScoreView();

        //gui stuff
        //title
        this.setTitle("Dog Catcher");
        //containers for the 5 regions
        this.setLayout(new BorderLayout());

        //buttons, add padding and color
        Button expandButton = new Button("Expand");

        this.addComponent(BorderLayout.WEST, expandButton);

        this.show();

        //play(); //obsolete
    }

    private void play() {
        Label myLabel = new Label("Enter a command:");
        this.addComponent(myLabel);
        final TextField myTextField = new TextField();
        this.addComponent(myTextField);
        this.show();

        myTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String sCommand = myTextField.getText().toString();
                myTextField.clear();

                //switch statement to handle the user input
                switch (sCommand.charAt(0)) {
                    case 'e':
                        gw.expand();
                        break;
                    case 'c':
                        gw.contract();
                        break;
                    case 's':
                        gw.scoop();
                        break;
                    case 'r':
                        gw.right();
                        break;
                    case 'l':
                        gw.left();
                        break;
                    case 'u':
                        gw.up();
                        break;
                    case 'd':
                        gw.down();
                        break;
                    case 'o':
                        gw.netToRandomDog();
                        break;
                    case 'a':
                        gw.netToRandomCat();
                        break;
                    case 'k':
                        gw.catCollision();
                        break;
                    case 'f':
                        gw.catDogFight();
                        break;
                    case 't':
                        gw.tick();
                        break;
                    case 'p':
                        gw.points();
                        break;
                    case 'm':
                        gw.map();
                        break;
                    case 'q':
                        //gw.quit();
                        break;
                    default:
                        System.out.println("\n\n please enter valid input\n\n");

                        break;

                }
            }
        });


    }

}
