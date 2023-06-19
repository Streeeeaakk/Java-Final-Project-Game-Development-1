import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane; 
import java.awt.FontMetrics;
public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private Random r;
	private Game game;
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		r = new Random();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player && tempObject.getX() < 610 && tempObject.getX() >= 70){
					if(key == KeyEvent.VK_A && tempObject.getY() == 81 && tempObject.getZ() == 0) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_S && tempObject.getY() == 81 && tempObject.getZ() == 1) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_D && tempObject.getY() == 81 && tempObject.getZ() == 2) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_F && tempObject.getY() == 81 && tempObject.getZ() == 3) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_Q && tempObject.getY() == 81 && tempObject.getZ() == 4) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_W && tempObject.getY() == 81 && tempObject.getZ() == 5) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_E && tempObject.getY() == 81 && tempObject.getZ() == 6) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_R && tempObject.getY() == 81 && tempObject.getZ() == 7) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					
					if(tempObject.getX() == 610){
						tempObject.setX(611);
					}
			}
			if(tempObject.getId() == ID.Player2 && tempObject.getX() < 610 && tempObject.getX() >= 70){
					if(key == KeyEvent.VK_H && tempObject.getY() == 161 && tempObject.getZ() == 0) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_J && tempObject.getY() == 161 && tempObject.getZ() == 1) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_K && tempObject.getY() == 161 && tempObject.getZ() == 2) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_L && tempObject.getY() == 161 && tempObject.getZ() == 3) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_Y && tempObject.getY() == 161 && tempObject.getZ() == 4) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_U && tempObject.getY() == 161 && tempObject.getZ() == 5) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_I && tempObject.getY() == 161 && tempObject.getZ() == 6) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					else if(key == KeyEvent.VK_O && tempObject.getY() == 161 && tempObject.getZ() == 7) {
						tempObject.setZ(r.nextInt(8));
						tempObject.setX(tempObject.getX() + 10);
					}
					
					if(tempObject.getX() == 610){
						tempObject.setX(611);
					}
			}
			
			if(tempObject.getX() < 70){
				if(key == KeyEvent.VK_ENTER){
					tempObject.setX(70);
					tempObject.setLoc(250);
					System.out.println(tempObject.getX());
				}	
			}
			
			if(key == KeyEvent.VK_ESCAPE){
				if(tempObject.getX() < 70 || tempObject.getX() == 611)
					System.exit(0);
			}
			if(key == KeyEvent.VK_ENTER && tempObject.getX() == 611){
				game = new Game();
			}	
				
			
		}
	
		System.out.println(key);
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_D) {
					tempObject.setVelX(0);
					System.out.println(tempObject.getX() + " " + tempObject.getY() );
				}	
			}
			if(tempObject.getId() == ID.Player2){
				if(key == KeyEvent.VK_RIGHT) {
					tempObject.setVelX(0);
					System.out.println(tempObject.getX());
					
				}
				
			}
		}
		
		System.out.println(key);
	}
	public void paint(Graphics g) {
    }
	
	
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
}