package flyweight;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class FlyWeightTest extends JFrame {
	
	JButton startDrawing;
	
	int windowWidth=1750;
	int windowHeight=550;
	
	Color[] shapeColor= {Color.orange,Color.red, Color.yellow,
			Color.blue,Color.pink,Color.cyan, Color.magenta, Color.black, Color.gray};
	
	public static void main(String[] args)
	{
		new FlyWeightTest();
	}
	
	public FlyWeightTest()
	{
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("FlyWeight Test");
		
		JPanel cotentPane=new JPanel();
		cotentPane.setLayout(new BorderLayout());
		
		final JPanel drawingPanel=new JPanel();
		
		startDrawing=new JButton("Draw Stuff");
		
		cotentPane.add(drawingPanel,BorderLayout.CENTER);
		cotentPane.add(startDrawing,BorderLayout.SOUTH);
		
		startDrawing.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event)
			{
				Graphics g=drawingPanel.getGraphics();
				
				long startTime=System.currentTimeMillis();
				
				for(int i=0;i<100000;++i)
				{
					
					 MyRect rect = RectFactory.getRect(getRandColor());
					 rect.draw(g, getRandX(), getRandY(), 
							 getRandX(), getRandY());

				}
				
				long endTime=System.currentTimeMillis();
				
				System.out.println("Time needded "+(endTime-startTime));
				
				
			}
			
		});
		
		this.add(cotentPane);
		this.setVisible(true);	
		
	}
	
	private Color getRandColor()
	{
		Random randomGenerator=new Random();
		int randInt=randomGenerator.nextInt(9);
		
		return shapeColor[randInt];
		
	}

	private int getRandX()
	{
		return (int)(Math.random()*windowWidth);
	}
	
	private int getRandY()
	{
		return (int)(Math.random()*windowHeight);
	}
}
