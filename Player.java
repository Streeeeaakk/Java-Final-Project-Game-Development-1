import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane; 
import java.awt.FontMetrics;

public class Player extends GameObject {
	
	private Random r;
	public String[] enemy = {"A","S","D","F","Q","W","E","R"};
	
	public Player(int x, int y, int z, int loc,ID id){
		super(x, y, z, loc,id);
		r = new Random();
	}
	
	public void tick(){
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g){
		r = new Random();
		
		if(id == ID.Player){
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
		}
		g.drawString(enemy[z],100, loc);
		g.fillRect(x, y, 32, 32);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
}