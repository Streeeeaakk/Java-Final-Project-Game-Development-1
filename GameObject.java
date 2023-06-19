import java.awt.*;

public abstract class GameObject {
	protected int x, y, z, loc;
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, int z, int loc,ID id){
		this.x = x;
		this.y = y;
		this.z = z;
		this.loc = loc;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setZ(int z){
		this.z = z;
	}
	public void setLoc(int loc){
		this.loc = loc;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getZ(){
		return z;
	}
	public int getLoc(){
		return loc;
	}
	
	public void setID(ID id){
		this.id = id;
	}
	public ID getId(){
		return id;
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}
}