import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.io.*;
import javax.swing.JOptionPane; 
import java.awt.FontMetrics;

public class Enemy2 extends GameObject {
	
	private Random r;
	public String[] enemy2 = {"H","J","K","L"};

	public Enemy2(int x, int y, int z, int loc,ID id){
		super(x, y, z, loc, id);
		r = new Random();
	}
	
	public void tick(){
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g){
		
		r = new Random();
		
		
		if(id == ID.Enemy2){
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		}
		g.drawString(enemy2[z],500, loc);
	}
}