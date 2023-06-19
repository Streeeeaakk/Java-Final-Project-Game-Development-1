import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane; 
import java.awt.FontMetrics;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1000000002L;
	
	public static final int WIDTH = 700, HEIGHT = WIDTH / 12 * 9;
	
	
	
	private Thread thread;
	private boolean running = false;
	private Random r;
	private Handler handler;
	private String Message = " ";
	
	
	public Game(){
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Kung e Type moko, Madalagan ko!", this);
		r = new Random();
		
		handler.addObject(new Player(20,(HEIGHT)/2-180, r.nextInt(8), 0,ID.Player)); 
		handler.addObject(new Player2(20,(HEIGHT)/2-100, r.nextInt(8), 0,ID.Player2));
	} 
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
				while(delta >= 1){
					tick();
					delta--;
				}
			if(running){
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
	}
	
	private void render(){
		
		
		BufferStrategy bufStrat = this.getBufferStrategy();
		if(bufStrat == null){
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bufStrat.getDrawGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		
		g.setColor(Color.BLACK);
		g.drawLine(600,82,600,200);
		g.drawLine(599,82,599,200);
		g.drawLine(598,82,598,200);
		g.drawLine(597,82,597,200);
		
		g.drawLine(60,82,60,200);
		g.drawLine(59,82,59,200);
		g.drawLine(58,82,58,200);
		g.drawLine(57,82,57,200);
		
		
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 25));
		drawString(g,"Kung e Type moko, madalagan ko!", 150, 3);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
    	drawString(g,"The game is played by Pressing the\n   Letters Displayed on the Screen\n\nEach correct key will be credited to\n   Either Player 1 or 2's Box\n\nPlayer wins if the players box reaches\n   The finish line first\n\n          Press ENTER to start\n          Press Escape to EXIT", 210, 60);
		
		
		for(int i = 0; i < handler.object.size(); i++){
		GameObject tempObject = handler.object.get(i);
		
			if(tempObject.getId() == ID.Player){	
				if(tempObject.getX() >= 70){
					g.setColor(Color.WHITE);
					g.fillRect(100,60,400,300);
				}
			}
			
			
			if(tempObject.getId() == ID.Player){	
				if(tempObject.getX() == 611){
					g.setColor(Color.BLACK);
					drawString(g,"Player 1 Wins", 100, 100);
					g.setColor(Color.BLACK);
					g.setFont(new Font("TimesRoman", Font.BOLD, 20));
    				drawString(g,"Do you want to play again?\n\nPress ENTER to play again\nPress Escape to EXIT", 190, 200);
		
				}
			}
			if(tempObject.getId() == ID.Player2){	
				if(tempObject.getX() == 611){
					g.setColor(Color.RED);
					drawString(g,"Player 2 Wins", 100, 180);
					
					g.setColor(Color.BLACK);
					g.setFont(new Font("TimesRoman", Font.BOLD, 20));
    				drawString(g,"Do you want to play again?\n\nPress ENTER to play again\nPress Escape to EXIT", 190, 200);
	
				}
			}
			
			
		}
				
		
		handler.render(g);
		
		g.dispose();
		
		bufStrat.show();
	}
	
	
	private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
    
   	
	
	public static void main(String args[]){
		new Game();
		
		
	}
}