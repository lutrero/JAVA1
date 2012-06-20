package stuff;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Bullet {
	
	public static final int DIAMETER = 10;

	private static final float ANCHO = 500;

	private static final float ALTO = 500;
	
	private float x, y, vx, vy;
	private Ellipse2D bullet;
	private boolean on;
	
	
	public Bullet() {
		super();
		x = y = vx = vy = 0;
		bullet = new Ellipse2D.Float();
		on = true;
	}
	
	public Bullet(float x, float y, float vx, float vy) {
		super();
		bullet = new Ellipse2D.Float(x , y, DIAMETER, DIAMETER);
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		on = true;
	}

	public void fisica(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETER >= ANCHO)
            vx = -vx;
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETER >= ALTO)
            vy = -vy;
        bullet.setFrame(x, y, DIAMETER, DIAMETER);
    }

	public void paintBullet(Graphics2D g){
		bullet.setFrame(x, y, DIAMETER, DIAMETER);
		g.setPaint(new GradientPaint((float)bullet.getX(),(float) bullet.getY(), Color.GREEN,(float) bullet.getCenterX(),(float) bullet.getY(), Color.YELLOW, true));
		g.fill(bullet);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void invertVx() {
		vx = -vx;
	}

	public void invertVy() {
		vy = -vy;
	}

	public float getVx() {
		return vx;
	}

	public float getVy() {
		return vy;
	}

	public void accelX() {
		if (vx > 0 ){
			if(vx < 400){
				if (vx < 50)
					vx += 20f;
				else
					vx += 50f;
			}
		}else{
			if (vx > -400){
				if(vx > -50)
					vx -= 20f;
				else
					vx -= 50f;
			}
		}
	}

	public void deccelX() {
		if(vx > 0 )
			vx -= 50f;
		else 
			vx += 50f;
	}
	
	public void startM(float x, float y) {
		on = true;
		if (vx == 0 && vy == 0){
			this.x = x;
			this.y = y;
			vx = 100f;
			vy = -300f;
		}
	}
	
	public void stopM(){
		vx = vy = 0;
		on = false;
	}

	public Ellipse2D getBullet() {
		return bullet;
	}

	public void setFisicsY(int i) {
		y = i;
	}

	public boolean isOn(){
		return on;
	}
	
}
