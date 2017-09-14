//Missile.java  

package model; 
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Rectangle;  
  
/** 
 * �ӵ��� 
 * 
 */  
  
public class Missile {  
  
    private int x = 0;  
    private int y = 0;  
    private int size = 7;  
    private Color color = Color.BLACK;  
    private int xSpeed = 15;  
    private int ySpeed = 15;  
    private Tank.Direction dir = Tank.Direction.STOP;  
    private TankClient tc = null;  
    private Tank t = null;  
    private int attackHurt = 10;  
    private int bigAttackHurt = 100;  
  
    /** 
     * ���캯�� 
     * @param x �ӵ�����λ�õ�x���� 
     * @param y �ӵ�����λ�õ�y���� 
     * @param dir �ӵ��ɳ��ķ��� 
     * @param t �����ӵ���̹�˵����� 
     * @param tc �ӵ�������������� 
     */  
      
    public Missile(int x, int y, Tank.Direction dir, Tank t, TankClient tc) {  
        this.x = x - size / 2;  
        this.y = y - size / 2;  
        this.dir = dir;  
        this.tc = tc;  
        this.t = t;  
    }  
  
    /** 
     * ���캯�� 
     * @param x �ӵ�����λ�õ�x���� 
     * @param y �ӵ�����λ�õ�y���� 
     * @param dir �ӵ��ɳ��ķ��� 
     * @param t �����ӵ���̹�˵����� 
     * @param tc �ӵ�������������� 
     * @param size �ӵ��Ĵ�С 
     */  
      
    public Missile(int x, int y, Tank.Direction dir, Tank t, TankClient tc,  
            int size) {  
        this.size = size;  
        this.x = x - size / 2;  
        this.y = y - size / 2;  
        this.dir = dir;  
        this.tc = tc;  
        this.t = t;  
        this.attackHurt = bigAttackHurt;  
    }  
  
    /** 
     * ����Ļ�ϻ������Լ� 
     * @param g ͼ���� 
     */  
      
    public void draw(Graphics g) {  
        Color orgColor = g.getColor();  
        g.setColor(color);  
        g.fillOval(x, y, size, size);  
        g.setColor(orgColor);  
        move();  
    }  
      
    private void move() {  
        switch (dir) {  
        case U:  
            y -= ySpeed;  
            break;  
        case D:  
            y += ySpeed;  
            break;  
        case L:  
            x -= xSpeed;  
            break;  
        case R:  
            x += xSpeed;  
            break;  
        case LU:  
            x -= xSpeed;  
            y -= ySpeed;  
            break;  
        case RU:  
            x += xSpeed;  
            y -= ySpeed;  
            break;  
        case LD:  
            x -= xSpeed;  
            y += ySpeed;  
            break;  
        case RD:  
            x += xSpeed;  
            y += ySpeed;  
            break;  
        }  
        if (x + size / 2 < 0 || y + size / 2 < 0  
                || x + size / 2 > TankClient.GAME_WIDTH  
                || y + size / 2 > TankClient.GAME_HEIGHT)  
            tc.getMissiles().remove(this);  
    }  
      
    /** 
     * �ж��Ƿ�ײ����̹�� 
     * @param t ��Ҫ�жϵ�̹�� 
     * @return �Ƿ�ײ����̹�� 
     */  
  
    public boolean hitTank(Tank t) {  
        if (this.getRect().intersects(t.getRect())) {  
            if ((this.t.isGood() && !t.isGood())  
                    || (!this.t.isGood() && t.isGood()))  
                return true;  
        }  
        return false;  
    }  
  
    /** 
     * �ж��Ƿ�ײ����ǽ 
     * @param w ��Ҫ�жϵ�ǽ 
     * @return �Ƿ�ײ����ǽ 
     */  
      
    public boolean hitWall(Wall w) {  
        return this.getRect().intersects(w.getRect());  
    }  
  
    /** 
     * �õ���ʾ�ӵ���Χ�ľ��� 
     * @return ��ʾ�ӵ���Χ�ľ��� 
     */  
      
    public Rectangle getRect() {  
        return new Rectangle(x, y, size, size);  
    }  
  
    public int getX() {  
        return x;  
    }  
  
    public void setX(int x) {  
        this.x = x;  
    }  
  
    public int getY() {  
        return y;  
    }  
  
    public void setY(int y) {  
        this.y = y;  
    }  
  
    public int getSize() {  
        return size;  
    }  
  
    public void setSize(int size) {  
        this.size = size;  
    }  
  
    public Color getColor() {  
        return color;  
    }  
  
    public void setColor(Color color) {  
        this.color = color;  
    }  
  
    public int getxSpeed() {  
        return xSpeed;  
    }  
  
    public void setxSpeed(int xSpeed) {  
        this.xSpeed = xSpeed;  
    }  
  
    public int getySpeed() {  
        return ySpeed;  
    }  
  
    public void setySpeed(int ySpeed) {  
        this.ySpeed = ySpeed;  
    }  
  
    public Tank.Direction getDir() {  
        return dir;  
    }  
  
    public void setDir(Tank.Direction dir) {  
        this.dir = dir;  
    }  
  
    public TankClient getTc() {  
        return tc;  
    }  
  
    public void setTc(TankClient tc) {  
        this.tc = tc;  
    }  
  
    public Tank getT() {  
        return t;  
    }  
  
    public void setT(Tank t) {  
        this.t = t;  
    }  
  
    public int getAttackHurt() {  
        return attackHurt;  
    }  
  
    public void setAttackHurt(int attackHurt) {  
        this.attackHurt = attackHurt;  
    }  
  
}