import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

   public class GamePanel extends JPanel implements Runnable   {

      //SCREEN SIZE MF
      int originalTileSize = 16; //16x16 tile
      int scale = 3;
      
      public int tileSize = originalTileSize * scale; // 48x48 tiles
      int maxScreenCol = 16;
      int maxScreenRow = 12;
      int screenWidth = tileSize * maxScreenCol; // 768 pix
      int screenHeight = tileSize * maxScreenRow; ///576
      
      //for Fps
      
      int FPS = 60; 
      
      
      KeyHandler keyH = new KeyHandler();
      Thread gameThread;
      Player player = new Player(this,keyH);
      
      int playerX = 100;
      int playerY = 100;
      int playerSpeed = 4;
      
      
      public GamePanel()   {
         
         this.setPreferredSize(new Dimension(screenWidth, screenHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
         this.addKeyListener(keyH);
         this.setFocusable(true);
      }
      
      public void startGameThread() {
         
         gameThread = new Thread(this);
         gameThread.start();
      }
      
      @Override
//      public void run() {
//      
//         while(gameThread != null) {   
//         
//         double drawInterval = 1000000000/FPS;
//         double nextDrawTime = System.nanoTime() + drawInterval;
//         
//         update();
//         
//         
//         repaint();
//         
//            
//            try {
//               double remainingTime = nextDrawTime - System.nanoTime();
//               remainingTime = remainingTime/1000000;
//               
//               if(remainingTime < 0)  {
//                     remainingTime = 0;
//               }
//               
//               Thread.sleep((long) remainingTime);
//               
//               nextDrawTime += drawInterval;
//               
//            }  catch(InterruptedException e)    {
//               e.printStackTrace();
//            }
//            
//         }
//      
//      }
      public void run() {
      
         double drawInterval = 1000000000/FPS;
         double delta = 0;
         long lastTime = System.nanoTime();
         long currentTime;
         long timer = 0;
         long drawCount = 0;
         
         while(gameThread != null)  {
         
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime)  / drawInterval;
            timer += (currentTime - lastTime);
            
            lastTime = currentTime;
            
            if(delta >= 1) {
               update();
               repaint();
               delta--;
               drawCount++;
            }
            
            if(timer >= 1000000000)  {
               System.out.println("FPS:" + drawCount);  
               drawCount = 0;
               timer = 0; 
            }  
         
                
         }
      
      }
      
      public void update() {
      
         player.update();
      
      }
      public void paintComponent(Graphics g)  {
      
         super.paintComponent(g);
         
         Graphics2D g2 = (Graphics2D) g;
         
         player.draw(g2);
         
         g2.dispose();
      }   
}
