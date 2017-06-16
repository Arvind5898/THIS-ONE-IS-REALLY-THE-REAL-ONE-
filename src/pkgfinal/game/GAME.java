package pkgfinal.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author debia7331
 */
public class GAME extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1275;
    static final int HEIGHT = 950;
    //Title of the window
    String title = "My Game";
    // creating rectangle for player 1
    Rectangle player1 = new Rectangle(WIDTH / 2 - 35, HEIGHT - 30, 70, 30);
    // creating rectangle for player 2 
    Rectangle player2 = new Rectangle(WIDTH / 2 - 35, 0, 70, 30);
    // commanding player 1 to move right once the right key is pressed 
    boolean rightPressed;
    // comanding player 1 to move left once the left key is pressed 
    boolean leftPressed;
    // commanding player 1 to move up once the up key is pressed 
    boolean upPressed;
    // commanding player 1 to move down once the down key is pressed
    boolean downPressed;
    // move up
    boolean wPressed;
    // move down
    boolean sPressed;
    // move left 
    boolean aPressed;
    // move right 
    boolean dPressed;
    // rotate left
    boolean vPressed;
    // rotate right 
    boolean bPressed;
    // player 2 shoot
    boolean spacePressed;
    // player 1 shoot 
    boolean mPressed;
    Rectangle[] blocks = new Rectangle[6];
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    // shooting for platyer one 
    ArrayList<Rectangle> bullet = new ArrayList();
    Iterator<Rectangle> it = bullet.iterator();
    // shooting for player 2
    ArrayList<Rectangle> bullet2 = new ArrayList();
    Iterator<Rectangle> it2 = bullet2.iterator();

    // GAME VARIABLES END HERE   
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public GAME() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();

        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {


        // GAME DRAWING GOES HERE

        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // drawing background and setting the color to black 
        g.setColor(Color.BLACK);
        // filling the background completely black
        g.fillRect(0, 0, 1275, 950);

        // line dividing the map 
        g.setColor(Color.red);
        g.fillRect(0, HEIGHT / 2, 1275, 5);



        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] != null) {
                g.fillRect(blocks[i].x, blocks[i].y, blocks[i].width, blocks[i].height);
            }
        }

        // drawing player one 
        g.drawRect(player1.x, player1.y, player1.width, player1.height);
        // drawing player two 
        g.drawRect(player2.x, player2.y, player2.width, player2.height);

        for (Rectangle bullets : bullet) {
            g.fillRect(bullets.x, bullets.y, bullets.width, bullets.height);
        }
        for (Rectangle bullets2 : bullet2) {
            g.fillRect(bullets2.x, bullets2.y, bullets2.width, bullets2.height);
        }

        // top screen sheilds
        blocks[0] = new Rectangle(WIDTH - 350, HEIGHT / 5, 150, 30);
        blocks[1] = new Rectangle(WIDTH - 700, HEIGHT / 5, 150, 30);
        blocks[2] = new Rectangle(WIDTH - 1050, HEIGHT / 5, 150, 30);
        // bottom screen sheilds 
        blocks[3] = new Rectangle(WIDTH / 2, HEIGHT / 5, 150, 30);
        blocks[4] = new Rectangle(WIDTH / 2, HEIGHT / 5, 150, 30);
        blocks[5] = new Rectangle(WIDTH / 2, HEIGHT / 5, 150, 30);

        g.setColor(Color.white);
        //bullet for player 1
        for (Rectangle bullets : bullet) {
            g.drawRect(bullets.x, bullets.y, bullets.width, bullets.height);
        }






    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    



    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //ask if bullet intersect player
            for (int i = 0; i < bullet.size(); i++) {
                bulletCollisions(i);

            }









            if (aPressed) {
                player2.x = player2.x - 10;

            }
            //if the left key is pressed, player 1 will move at a speed of +10
            if (dPressed) {
                player2.x = player2.x + 10;
            }
            //if the up key is pressed, player 1 will move up at a speed of -10
            if (wPressed) {
                player2.y = player2.y - 10;

            }
            // if the down key is pressed, player 1 will move down at a speed of +10
            if (sPressed) {
                player2.y = player2.y + 10;
            }

            //if the right key is pressed, player 1 will move at a speed of +10
            if (rightPressed) {
                player1.x = player1.x + 10;

            }
            //if the left key is pressed, player 1 will move at a speed of -10
            if (leftPressed) {
                player1.x = player1.x - 10;
            }
            //if the up key is pressed, player 1 will move up at a speed of -10
            if (upPressed) {
                player1.y = player1.y - 10;

            }
            // if the down key is pressed, player 1 will move down at a speed of +10
            if (downPressed) {
                player1.y = player1.y + 10;
            }

            if (spacePressed) {
            }




            if (mPressed) {

                bullet.add(new Rectangle(player1.x, player1.y-50, 20, 20));


                mPressed = false;


            }
            if (spacePressed){
                
                bullet2.add(new Rectangle(player2.x, player2.y + 50, 20, 20));
                
                spacePressed = false;
            }
            
            for (Rectangle bullets : bullet) {
                bullets.y -= 5;
            }
            for (Rectangle bullets : bullet2){
                bullets.y += 5;
            }

            shooting();



            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {

            // player 1

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;

            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;

            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
            // key pressed for shooting 
            if (e.getKeyCode() == KeyEvent.VK_M) {
                mPressed = true;
            }




            // player 2
            if (e.getKeyCode() == KeyEvent.VK_D) {
                dPressed = true;

            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                aPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = true;
            }
            // key preesed for shooting 
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }


        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
            // key released for shooting 
            if (e.getKeyCode() == KeyEvent.VK_M) {
                mPressed = false;
            }







            if (e.getKeyCode() == KeyEvent.VK_D) {
                dPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                aPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = false;
            }
            // key released for shooting 
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                spacePressed = false;
            }



        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        GAME game = new GAME();

        // starts the game loop
        game.run();
    }

    public void collisions() {
        if (player1.x <= 0) {
            player1.x = 0;
        }

        if (player1.x >= 1205) {
            player1.x = 1205;
        }

        if (player1.y <= 0) {
            player1.y = 0;
        }

        if (player1.y >= 920) {
            player1.y = 920;
        }

        if (player2.x <= 0) {
            player2.x = 0;

        }

        if (player2.x >= 1205) {
            player2.x = 1205;
        }

        if (player2.y <= 0) {
            player2.y = 0;
        }
        if (player2.y >= 920) {
            player2.y = 920;
        }

    




    }

    public void bulletCollisions(int number) {
        if (player1.intersects(bullet.get(number))) {

            bullet.remove(bullet.get(number));
        }
    }

     


    public void shooting() {
    }
}
