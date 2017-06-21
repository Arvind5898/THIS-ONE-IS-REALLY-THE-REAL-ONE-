package pkgfinal.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;

/**
 *
 * @author debia7331
 */
public class GAME extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1275;
    static final int HEIGHT = 950;
    //Title of the window
    String title = "Arvinds Game // Powered by Maloof";
    // creating rectangle for player 1
    Rectangle player1 = new Rectangle(WIDTH / 2 - 35, HEIGHT - 30, 90, 90);
    // creating rectangle for player 2 
    Rectangle player2 = new Rectangle(WIDTH / 2 - 35, 0, 70, 30);
    // creating a boolean for player 1 to move right using the right key  
    boolean rightPressed;
    // creating a boolean for player 1 to move left using the left key  
    boolean leftPressed;
    // creating a boolean for player 1 to move up using the up key  
    boolean upPressed;
    // creating a boolean for player 1 to move down using the down key 
    boolean downPressed;
    // creating a boolean for player 2 to move up using the e key 
    boolean ePressed;
    // creating a boolean for player 2 to move left using the s key
    boolean sPressed;
    // creating a boolean for player 2 to move right using the f key
    boolean fPressed;
    // creating a boolean for player 2 to move down using the d key
    boolean dPressed;
    // creating a boolean for player 2 to shoot using the q key 
    boolean qPressed;
    // creating a boolean for player 1 to shoot using the m key 
    boolean mPressed;
    
    // creating an array for the obstacles in the map 
    Rectangle[] blocks = new Rectangle[6];
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    Rectangle divider = new Rectangle(0, HEIGHT / 2, 1275, 5);
    // creation of array list for player 1
    ArrayList<Rectangle> bullet = new ArrayList();
    // creation of iterator for player 1
    Iterator<Rectangle> it = bullet.iterator();
    // creating an array list and iterator to allow player 2 to shoot 
    // creation of array list for player 2
    ArrayList<Rectangle> bullet2 = new ArrayList();
    // creation of iterator for player 2
    Iterator<Rectangle> it2 = bullet2.iterator();
    // score keeping for both player one and two 
    int player1Score = 0;
    int player2Score = 0;
    // creating a font for scoreboard
    Font myfont = new Font("Arial", Font.BOLD, 75);
    
    BufferedImage space = loadImage("space.jpeg");
    BufferedImage spaceship = loadImage("spaceship.png");
    BufferedImage ufo = loadImage("ufo.png");
    

    // GAME VARIABLES END HERE   
    // Constructor to create the Frame and place the panel in
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

    @Override
    public void paintComponent(Graphics g) {

        // GAME DRAWING GOES HERE

        g.clearRect(0, 0, WIDTH, HEIGHT);

        // drawing background and setting the color to black 
        g.setColor(Color.BLACK);
        // filling the background completely black
        g.drawImage(space, 0, 0, 1275, 950, this);
//        g.fillRect(0, 0, 1275, 950);
        

        // line dividing the map 
        g.setColor(Color.red);
        g.fillRect(0, HEIGHT / 2, 1275, 5);

        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] != null) {
                g.fillRect(blocks[i].x, blocks[i].y, blocks[i].width, blocks[i].height);
            }
        }

        // drawing player one 
//        g.drawRect(player1.x, player1.y, player1.width, player1.height);
        g.drawImage(spaceship, player1.x, player1.y, player1.width, player1.height, this);
        // drawing player two 
        g.drawImage(ufo, player2.x, player2.y, 120,35,this);

        for (Rectangle bullets : bullet) {
            g.fillRect(bullets.x, bullets.y, bullets.width, bullets.height);
        }
        for (Rectangle bullets2 : bullet2) {
            g.fillRect(bullets2.x, bullets2.y, bullets2.width, bullets2.height);
        }
        // Scoreboard
        g.setFont(myfont);
        g.setColor(Color.red);
        g.drawString("" + player1Score, WIDTH / 100, 75);
        g.drawString("" + player2Score, WIDTH / 100, 550);

        // creating the top screen sheilds for player two 
        blocks[0] = new Rectangle(WIDTH - 350, 230, 100, 30);
        blocks[1] = new Rectangle(WIDTH - 700, 230, 100, 30);
        blocks[2] = new Rectangle(WIDTH - 1050, 230, 100, 30);
        // creating the bottom screen sheilds for player one 
        blocks[3] = new Rectangle(WIDTH - 350, 720, 100, 30);
        blocks[4] = new Rectangle(WIDTH - 700, 720, 100, 30);
        blocks[5] = new Rectangle(WIDTH - 1050, 720, 100, 30);

        g.setColor(Color.white);
        //bullet for player 1 allowing it to be outlined in white 
        for (Rectangle bullets : bullet) {
            g.drawRect(bullets.x, bullets.y, bullets.width, bullets.height);
        }

    }

    public BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            File file = new File(filename);
            img = ImageIO.read(file);
        } catch (Exception e) {
            //if there is error, print
            e.printStackTrace();
        }
        return img;
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        System.out.println("Special thanks to Maloof for literally everything LMAO JK but he nice");
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


            // GAME LOGIC STARTS HERE 



            // calling the collisions
            collisions();
            bulletCollisions();

            if (sPressed) {
                player2.x = player2.x - 10;

            }
            //if the left key is pressed, player 1 will move at a speed of +10
            if (fPressed) {
                player2.x = player2.x + 10;
            }
            //if the up key is pressed, player 1 will move up at a speed of -10
            if (ePressed) {
                player2.y = player2.y - 10;

            }
            // if the down key is pressed, player 1 will move down at a speed of +10
            if (dPressed) {
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

            if (qPressed) {
            }

            if (mPressed) {

                bullet.add(new Rectangle(player1.x + 30, player1.y - 20, 20, 20));

                mPressed = false;

            }
            if (qPressed) {

                bullet2.add(new Rectangle(player2.x + 40, player2.y + 70, 20, 20));

                qPressed = false;
            }

            for (Rectangle bullets : bullet) {
                bullets.y -= 10;
            }
            for (Rectangle bullets : bullet2) {
                bullets.y += 10;
            }

            shooting();
            scoreboard();

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

    private void scoreBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_E) {
                ePressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_F) {
                fPressed = true;
            }
            // key preesed for shooting 
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                qPressed = true;
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
            if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_E) {
                ePressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_F) {
                fPressed = false;
            }
            // key released for shooting 
            if (e.getKeyCode() == KeyEvent.VK_Q) {
                qPressed = false;
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
        // player 1 collisions start here
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
        // player 1 will not be able to cross the divider 
        if (player1.intersects(divider)) {
            player1.y = 485;
        }



        // player 1 collision end here 

        // player two collisions start here 
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
        if (player2.intersects(divider)) {
            player2.y = 439;
        }





        // player 2 collisions end here 



    }
    // creating a method for bullet collisions 
    public void bulletCollisions() {
        // when a bullet impacts a  it is removed
        for (int i = 0; i < blocks.length; i++) {
            for (int a = 0; a < bullet.size(); a++) {
                
                if (blocks[i].intersects(bullet.get(a))) {

                    bullet.remove(a);
                }

            }

        }

        for (int i = 0; i < blocks.length; i++) {
            for (int a = 0; a < bullet2.size(); a++) {

                if (blocks[i].intersects(bullet2.get(a))) {

                    bullet2.remove(a);
                }

            }

        }
    }
    // creating a method for shooting 
    public void shooting() {
    }
    // creating a method for the scoreboard 
    public void scoreboard() {
        // once player 2 gets hit by player one's bullet, player one's score will increase 
        for (int i = 0; i < bullet.size(); i++) {
            // once player 2 intersects bullet 
            if (player2.intersects(bullet.get(i))) {
                // increasing player 2's score 
                player2Score++;
                // removing the bullet
                bullet.remove(i);
            }
        }
        // once player 1 gets hit by player two's bullet, player two's score will increase
        for (int i = 0; i < bullet2.size(); i++) {
            // once player 1 intersects bullet 
            if (player1.intersects(bullet2.get(i))) {
                // increasing player 1's score 
                player1Score++;
                // removing the bullet 
                bullet2.remove(i);
            }

        }


//        
//            
//        
    }
}