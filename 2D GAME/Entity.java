import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage;

public class Entity{

   public int x, y;
   public int speed;
   
   public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
   public String direction;
   
}