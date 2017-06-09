package pkgfinal.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author debia7331
 */
public class GAME extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    //Title of the window
    String title = "My Game";
    // creating rectangle for player 1
    Rectangle player1 = new Rectangle(500, 650, 30, 30);
    // creating rectangle for player 2 
    Rectangle player2 = new Rectangle(500, 50, 30, 30);
    // commanding player 1 to move right once the right key is pressed 
    boolean rightPressed;
    // comanding player 1 to move left once the left key is pressed 
    boolean leftPressed;
    // commanding player 1 to move up once the up key is pressed 
    boolean upPressed;
    // commanding player 1 to move down once the down key is pressed
    boolean downPressed;
    // commanding player 2 to move right once the d key is pressed 
    boolean dPressed;
    // commanding player 2 to move left once the a key is pressed
    boolean aPressed;
    // commanding player 2 to move up once the w key is pressed
    boolean wPressed;
    // commmanding player 2 to move up once the s key is pressed 
    boolean sPressed; 
    
    
    
    
    Rectangle[] blocks = new Rectangle[19];
    
    
    
    
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;

    // YOUR GAME VARIABLES WOULD GO HERE
   


    
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
        g.fillRect(0, 0, 1000, 800);
        
        
        

        // creating the dimensions for player one (spaceship)
        g.setColor(Color.red);
        g.fillRect(player1.x, player1.y, player1.width, player1.height);

        // creating the dimensions for player two (UFO)
        g.setColor(Color.green);
        g.fillRect(player2.x, player2.y, player2.width, player2.height);
        
        // making the map 
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1000, 8);
        
        
        g.fillRect(300, 200, 200, 8);
        
        
        
        
        for (int i = 0; i < blocks.length; i++){
            g.fillRect(blocks[i].x, blocks[i].y, blocks[i].width, blocks[i].height);
        } 

        
        // GAME DRAWING ENDS HERE




        
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        // boundaries start here 
        blocks[0] = new Rectangle(700, 500, 300, 8);
        blocks[1] = new Rectangle(0,795,1000,8);
        blocks[2] = new Rectangle(0,0,8,800);
        blocks[3] = new Rectangle(0,0,8,800);
        //boundaries end here
        blocks[4] = new Rectangle(400, 0, 8, 200);
        blocks[5] = new Rectangle(200, 200, 400, 8);
        blocks[6] = new Rectangle(200,100,8,100);
        blocks[7] = new Rectangle(300,200,8,100);
        blocks[8] = new Rectangle();
        blocks[9] = new Rectangle();
        blocks[10] = new Rectangle();
        blocks[11] = new Rectangle();
        blocks[12] = new Rectangle();
        blocks[13] = new Rectangle();
        blocks[14] = new Rectangle();
        blocks[15] = new Rectangle();
        blocks[16] = new Rectangle();
        blocks[17] = new Rectangle();
        blocks[18] = new Rectangle();
        
//        blocks[1] = new Rectangle();
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
            collisions();
            // if the d key is pressed, player 2 will move at a speed of +10  
            if (dPressed) {
                player2.x = player2.x + 10;
            }
            // if the a key is pressed, player 2 will move at a speed of -10
            if (aPressed) {
                player2.x = player2.x - 10;
            }
            // if the w key is pressed, player 2 will move up at a speed of -10
            if(wPressed){
                player2.y = player2.y - 10;
            }
            // if the s key is pressed, player 2 will move down at a speed of +10 
            if(sPressed){
                player2.y = player2.y + 10;
            }
            
            
            
            // if the right key is pressed, player 1 will move at a speed of +10
            if(rightPressed) {
                player1.x = player1.x + 10;

            }
            // if the left key is pressed, player 1 will move at a speed of -10
            if(leftPressed) {
                player1.x = player1.x - 10;
            }
            // if the up key is pressed, player 1 will move up at a speed of -10
            if(upPressed){
                player1.y = player1.y - 10;
         
            }
            // if the down key is pressed, player 1 will move down at a speed of =10
            if(downPressed){
                player1.y = player1.y + 10;
            }

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
            
            // player 2
            if (e.getKeyCode() == KeyEvent.VK_A) {
                aPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                dPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = true;
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
            if (e.getKeyCode() == KeyEvent.VK_A) {
                aPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                dPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                wPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                sPressed = false;
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

        if (player1.x >= 970) {
            player1.x = 970;
        }
        
        if (player1.y <= 0){
            player1.y = 0;
        }
        
        if (player1.y >= 770){
            player1.y = 770;
        }

        if (player2.x <= 0) {
            player2.x = 0;
            
        }
        
        if (player2.x >= 970) {
            player2.x = 970;
        }
        
        if (player2.y <= 0){
            player2.y = 0;
        }
        if (player2.y >= 770){
            player2.y = 770;
        }

    }
}
