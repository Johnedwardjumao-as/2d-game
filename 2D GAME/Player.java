import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage; 
import java.io.IOException;

public class Player extends Entity {

   GamePanel gp;
   KeyHandler keyH;

   public Player(GamePanel gp, KeyHandler keyH) {
      this.gp = gp;
      this.keyH = keyH;
      
      setDefaultValues(); 
      getPlayerImage();
      System.out.println("Image loading started");
 
System.out.println("Image loading ended");
    }

   public void setDefaultValues() {
      x = 100; 
      y = 100; 
      speed = 4; 
      direction = "down";
   }
   
   public void getPlayerImage() {
    try {
    
         up1 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         up2 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         down1 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         down2 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         left1 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         left2 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         right1 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));
         right2 = ImageIO.read(getClass().getResourceAsStream("/mc_sprites/try.png"));

    } catch (IOException e) {
        e.printStackTrace();
    }
}

   
   
   public void update() {
      if (keyH.upPressed) {
         direction = "up";
         y -= speed;
      } else if (keyH.downPressed) {
         direction = "down";
         y += speed;
      } else if (keyH.leftPressed) {
         direction = "left";
         x -= speed;
      } else if (keyH.rightPressed) {
         direction = "right";
         x += speed;
      }
   }

   public void draw(Graphics2D g2) {
//      g2.setColor(Color.white);
//      g2.fillRect(x, y, gp.tileSize, gp.tileSize);

      
      
        BufferedImage image = null;
        
        switch(direction)  {
        case "up":
            image = up1;
            break;
        case "down":
            image = down1;
            break;
        case "left":
            image = left1;
            break;
        case "right":
            image = right1;  
            break;    
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        
   }
}
