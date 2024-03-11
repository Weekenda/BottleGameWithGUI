
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Game_GUI {
	
    private static int playernum = 2;
    private static int ainum = 0;
    private static int Bottles = 21;
    
	public static void main(String[] args) {

	
		  
		JFrame frame = new JFrame("Pick Cans(Cats) GAME");//窗口
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭程序执行
		
		JPanel JP = new JPanel(new GridLayout(3,7));//放置图片
	
		
		JPanel Text = new JPanel();//放置游戏说明
		Text.setLayout(new BoxLayout(Text, BoxLayout.Y_AXIS));//竖直排列
		
		JPanel Operation = new JPanel();//放置操作界面
		Operation.setBackground(Color.GRAY);
		Operation.setPreferredSize(new Dimension(800,50));
		
		JPanel Sit = new JPanel();//放置选取情况
		Sit.setBackground(Color.GRAY);
		Sit.setPreferredSize(new Dimension(800,300));
		
		JTextArea textArea1 = new JTextArea("\tThe 21 Coke Can Game\n                You and Computers are the players\n          Each one would pick only between 1 to 4\nThe one picking up last can is Loser and will pay bill\n");
		JTextArea textArea2 =new JTextArea("\tRemaining Cans:");
		textArea1.setFont(new Font("Arial", Font.BOLD, 16));
		textArea2.setFont(new Font("Arial", Font.BOLD, 16));
		textArea1.setEditable(false); 
		textArea2.setEditable(false); // 设置为不可编辑，仅用于显示文本

		
		Text.add(textArea1);//居中放置
		Text.add(Box.createVerticalStrut(50));//添加排列间距100
		Text.add(textArea2);
		
		//Game_GUI.class.getResource(
	
		ImageIcon image = new ImageIcon("src/images/Bottles.png");//可自行更换对应的啤酒瓶图片路径
		for(int i = 0;i<21;i++) {
			JLabel imageL=new JLabel(image);
			JP.add(imageL);}//排列21张图片
		
		JTextArea textArea3 =new JTextArea("You:");
		textArea1.setEditable(false); 
		Operation.add(textArea3);
	
		JTextField in = new JTextField(10);//10个字符的宽度
		Operation.add(in);

		JButton button = new JButton("PICK");
		Operation.add(button);

		
		JTextArea textArea4 =new JTextArea("The Computer has picked:           "+"\n\n"+"The bottles remaining are:                21");
		textArea4.setFont(new Font("Arial", Font.BOLD, 16));
		textArea4.setEditable(false); 
		Sit.add(textArea4);
		
	    button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	
               Game_GUI.Body(JP,textArea4, in );
            }
        });
	
		

//		if(Score==1){frame.add(result)
//		}
		frame.add(Text);
		frame.add(JP);
		frame.add(Operation);
		frame.add(Sit);
		frame.setLayout(new FlowLayout());
		
		frame.setSize(800,800);
		frame.setVisible(true);
	}
	
		
		
		






//	public static void game() {
//		//游戏开始前优先级部分----
//		Scanner input = new Scanner(System.in);
//		boolean PlayerFirst=false;//默认计算机先手
//		String answer = input.nextLine();//获取是否先手回答
//		if(answer.equals("yes")||answer.equals("YES")||answer.equals("Yes"));
//		{
//			PlayerFirst=true;//如果是则为玩家先手；
//		}
//		Body(PlayerFirst);
//	}

	//游戏本体部分---------
	
			public static void Body(JPanel JP,JTextArea textArea4,JTextField in ) {
			
			//瓶子选择循环提问---
				
					
					String num = in.getText();
					playernum = Integer.parseInt(num);//将字符串转换为int
				
					 for (int i = 0; i < playernum; i++) {
				            JP.remove(0);
				        }
				        
				        // 添加对应数量的空标签
				        for (int i = 0; i < playernum; i++) {
				            JLabel emptyLabel = new JLabel();
				            JP.add(emptyLabel);
				        }
					Bottles-=playernum;
					textArea4.setText("The Computer has picked:           "+ainum+"\n\n"+"The bottles remaining are:                "+Bottles);//
					textArea4.setFont(new Font("Arial", Font.BOLD, 16));
					
				
					ainum=ComputerGet(playernum);
					 for (int i = 0; i < ainum; i++) {
				            JP.remove(0);
				        }
				        
				        // 添加对应数量的空标签
				        for (int i = 0; i < ainum; i++) {
				            JLabel emptyLabel = new JLabel();
				            JP.add(emptyLabel);
				        }
					Bottles-=ainum;
					textArea4.setText("The Computer has picked:           "+ainum+"\n\n"+"The bottles remaining are:                "+Bottles);
					in.setText("");
					
				//循环结束，游戏结果判断---
				if(Bottles==1){
					textArea4.setText("The Computer has picked:           "+ainum+"\n\n"+"The bottles remaining are:                "+Bottles+"\n\nYou will have to pick up the last..you are loser");
					
				}
				
			}
			//计算机使用算法--------核心思想：让电脑总是拿走剩余瓶子数与玩家的选择之和为5
		public static int ComputerGet(int playernum)
		{	int Aipick=5-playernum;
			return Aipick;
		}


	
	
}