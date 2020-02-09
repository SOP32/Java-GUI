package Assignment2;

import java.awt.Graphics;   
import javax.swing.*; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;
import java.awt.*;

public class Message extends JFrame {
	
public Message() {
	setSize(500,300);
	setVisible(true);
}

public boolean colorChecker(String color) {
	   String[] colors = {"black","blue","cyan","dark gray","gray","green","light gray","magenta","orange","pink","red","white","yellow"};
	   boolean contains = Arrays.stream(colors).anyMatch(color::equals);
	   return contains;
}

public boolean fontStyleChecker(String fontStyle) {
	   String[] styles = {"regular","bold","italic","bolditalic"};
	   boolean contains = Arrays.stream(styles).anyMatch(fontStyle::equals);
	   return contains;
}

public boolean shapeChecker(String shape) {
	   String[] shapes = {"rectangle","roundrectangle","oval"};
	   boolean contains = Arrays.stream(shapes).anyMatch(shape::equals);
	   return contains;
}

public void paint( Graphics g )
{
   String message, shape, fontStyle, bgColor, fontColor, fontSize, shapeWidth, shapeHeight;
 
   int fSize, sWidth, sHeight;
   
   
   message = JOptionPane.showInputDialog("Enter Message Text");
   
   shape = JOptionPane.showInputDialog("Enter shape(rectangle,roundrectangle,oval)");
   if(shapeChecker(shape)==false) 
	   JOptionPane.showMessageDialog(null,"Shape entered does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
   
   fontStyle = JOptionPane.showInputDialog("Enter font style(regular,bold,italic,bolditalic)");
   if(fontStyleChecker(fontStyle)==false) 
	   JOptionPane.showMessageDialog(null,"Font style entered does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
   
   bgColor = JOptionPane.showInputDialog("Enter background color");
   if(colorChecker(bgColor)==false) 
	   JOptionPane.showMessageDialog(null,"Color entered does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
   
   fontColor = JOptionPane.showInputDialog("Enter font color");
   if(colorChecker(fontColor)==false) 
	   JOptionPane.showMessageDialog(null,"Color entered does not exist", "ERROR",JOptionPane.ERROR_MESSAGE);
   
   fontSize = JOptionPane.showInputDialog("Enter font size");
   shapeWidth = JOptionPane.showInputDialog("Enter shape width");
   shapeHeight = JOptionPane.showInputDialog("Enter shape height");

//Parsing values
   fSize = Integer.parseInt(fontSize); 
   sWidth = Integer.parseInt(shapeWidth); 
   sHeight = Integer.parseInt(shapeHeight);
   
//Setting font style
   Font font = new Font("Serif", Font.PLAIN, fSize);
   
   if(fontStyle.equals("bold")) {
		font = new Font("Serif", Font.BOLD, fSize);
	} 
   else if(fontStyle.equals("italic")) {
		font = new Font("Serif", Font.ITALIC, fSize);
   } 
   else if(fontStyle.equals("bolditalic")) {
		font = new Font("Serif", Font.BOLD + Font.ITALIC, fSize);
   }
   g.setFont(font);

//Setting background color
   Color bgC = Color.black;
   if(bgColor.equals("blue")) {
	   bgC = Color.blue;
   }
   else if(bgColor.equals("cyan")) {
	   bgC = Color.cyan;
   }
   else if(bgColor.equals("dark gray")) {
	   bgC = Color.darkGray;
   }
   else if(bgColor.equals("gray")) {
	   bgC = Color.gray;
   }
   else if(bgColor.equals("green")) {
	   bgC = Color.green;
   }
   else if(bgColor.equals("light gray")) {
	   bgC = Color.lightGray;
   }
   else if(bgColor.equals("magenta")) {
	   bgC = Color.magenta;
   }
   else if(bgColor.equals("orange")) {
	   bgC = Color.orange;
   }
   else if(bgColor.equals("pink")) {
	   bgC = Color.pink;
   }
   else if(bgColor.equals("red")) {
	   bgC = Color.red;
   }
   else if(bgColor.equals("white")) {
	   bgC = Color.white;
   }
   else if(bgColor.equals("yellow")) {
	   bgC = Color.yellow;
   }
   
   g.setColor(bgC);
   g.fillRect(0, 0, 500, 300);
   
//Setting font color
   Color fC = Color.black;
   if(fontColor.equals("blue")) {
	   fC = Color.blue;
   }
   else if(fontColor.equals("cyan")) {
	   fC = Color.cyan;
   }
   else if(fontColor.equals("dark gray")) {
	   fC = Color.darkGray;
   }
   else if(fontColor.equals("gray")) {
	   fC = Color.gray;
   }
   else if(fontColor.equals("green")) {
	   fC = Color.green;
   }
   else if(fontColor.equals("light gray")) {
	   fC = Color.lightGray;
   }
   else if(fontColor.equals("magenta")) {
	   fC = Color.magenta;
   }
   else if(fontColor.equals("orange")) {
	   fC = Color.orange;
   }
   else if(fontColor.equals("pink")) {
	   fC = Color.pink;
   }
   else if(fontColor.equals("red")) {
	   fC = Color.red;
   }
   else if(fontColor.equals("white")) {
	   fC = Color.white;
   }
   else if(fontColor.equals("yellow")) {
	   fC = Color.yellow;
   }

   g.setColor(fC);
   
//Shape
   if(shape.equals("rectangle")) {
	   g.drawRect((500-sWidth)/2, (300-sHeight)/2, sWidth, sHeight);
   }
   else if(shape.equals("roundrectangle")) {
	   g.drawRoundRect((500-sWidth)/2, (300-sHeight)/2, sWidth, sHeight, 10, 10);
   }
   else if(shape.equals("oval")) {
	   g.drawOval((500-sWidth)/2, (300-sHeight)/2, sWidth, sHeight);
	}
 
 //Message
   FontMetrics fm = g.getFontMetrics();
   if(fm.stringWidth(message) > sWidth || fm.getHeight() > sHeight) 
	   JOptionPane.showMessageDialog(null,"Font size is too large", "ERROR", JOptionPane.ERROR_MESSAGE);
	
   //int x = (sHeight-fm.getHeight())/2;
   //int y = (sWidth-fm.stringWidth(message))/2 + (fm.getHeight());
   //g.drawString(message, ((500-sWidth)/2), (300-sHeight)/2);
   int x = (500-sWidth)/2 + (sWidth - fm.stringWidth(message)) / 2;
   int y = (300-sHeight)/2 + ((sHeight - fm.getHeight()) / 2) + fm.getAscent();
   g.drawString(message, x, y);
}

public static void main(String args[]) {
	System.out.println("Sohini Palit");
	Message app = new Message();
	app.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);

				}
			});
}
}
