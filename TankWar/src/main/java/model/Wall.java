//Wall.java  
  
package model;   
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Rectangle;  
  
/** 
 * ǽ�� 
 */  
  
public class Wall {  
    private int x = 0;  
    private int y = 0;  
    private int width = 0;  
    private int height = 0;  
    private Color color = Color.BLACK;  
  
    /** 
     * ���췽�� 
     * @param x ǽ���ֵ�x���� 
     * @param y ǽ���ֵ�y���� 
     * @param width ǽ�Ŀ�� 
     * @param height ǽ�ĸ߶� 
     */  
      
    public Wall(int x, int y, int width, int height) {  
        this.x = x;  
        this.y = y;  
        this.width = width;  
        this.height = height;  
    }  
      
    /** 
     * ���췽�� 
     * @param x ǽ���ֵ�x���� 
     * @param y ǽ���ֵ�y���� 
     * @param width ǽ�Ŀ�� 
     * @param height ǽ�ĸ߶� 
     * @param color ǽ����ɫ 
     */  
      
    public Wall(int x, int y, int width, int height, Color color) {  
        this.x = x;  
        this.y = y;  
        this.width = width;  
        this.height = height;  
        this.color = color;  
    }  
  
    /** 
     * ����Ļ�ϻ������Լ� 
     * @param g ͼ���� 
     */  
      
    public void draw(Graphics g) {  
        Color orgColor = g.getColor();  
        g.setColor(color);  
        g.fillRect(x, y, width, height);  
        g.setColor(orgColor);  
    }  
      
    /** 
     * �õ�������ռ��Χ�ľ��� 
     * @return ��������ռ��Χ�ľ��� 
     */  
  
    public Rectangle getRect() {  
        return new Rectangle(x, y, width, height);  
    }  
}  