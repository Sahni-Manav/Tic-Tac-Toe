import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class a1 implements ActionListener
{
	JFrame f1;
	static JButton b1[]=new JButton[3];
	JLabel l;
	static int i;
	public a1()
	{
		f1=new JFrame("tic tac toe");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(700,700);
		f1.setLayout(null);
		//f1.getContentPane().setBackground(Color.RED);
		l=new JLabel("TIC TAC TOE");
		l.setBounds(150,100,200,100);
		f1.add(l);
		b1[0]=new JButton("New game against computer");
		b1[1]=new JButton("New game against human");
		b1[2]=new JButton("Exit");
		b1[0].setBounds(200,300,300,50);
		b1[1].setBounds(200,400,300,50);
		b1[2].setBounds(300,500,100,50);
		for(i=0;i<3;i++)
		{
			f1.add(b1[i]);
			b1[i].addActionListener(this);
		}
		f1.setVisible(true);
	}
	public void actionPerformed(ActionEvent ev)
	{
		String c=ev.getActionCommand();
		if(c.equalsIgnoreCase("new game against computer"))
		{
			a2 ob1=new a2();
		}
		else if(c.equalsIgnoreCase("new game against human"))
		{
			a3 ob2=new a3();
		}
		else
		{
			System.exit(0);
		}
	}
	public static void main(String args[])
	{
		new a1();
	}
}
class a2  implements ActionListener
{
	static JButton b[]=new JButton[11];
	JFrame f2;
	
	JPanel pan;
	static int a=0,i;
	public a2()
	{
		f2=new JFrame("TIC TAC TOE");
		f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f2.setSize(700,700);
		f2.setLayout(null);
		pan=new JPanel();
		pan.setBounds(100,100,500,500);
		pan.setLayout(new GridLayout(3,3));
		f2.add(pan);
		for(i=0;i<9;i++)
		{
			b[i]=new JButton("");
			pan.add(b[i]);
		}
		b[9]=new JButton("return");
		b[10]=new JButton("Clear");
		b[9].setBounds(150,625,100,50);
		b[10].setBounds(450,625,100,50);
		f2.add(b[9]);
		f2.add(b[10]);
		for(i=0;i<11;i++)
			b[i].addActionListener(this);
		f2.setVisible(true);
	}
	public void actionPerformed(ActionEvent ev)
	{
		String st=ev.getActionCommand();
		if(st.equals(""))
		{
				((JButton)ev.getSource()).setText("0");
				a=1;
				check();
				comp();
		}
		if(st.equals("Clear"))
			clear();
		if(st.equals("return"))
			f2.setVisible(false);
	}
	public void comp()
	{
		for(;;)
		{
			int B=(int)(Math.random()*9);
			if(b[B].getText().equals(""))
			{
				b[B].setText("X");
				a=0;
				break;
			}
		}	
		check();
	}
	public static void check()
	{
		if(!(b[4].getText().equals(""))&&((b[4].getText().equals(b[1].getText())) && (b[1].getText().equals(b[7].getText()))||(b[4].getText().equals(b[0].getText())) && (b[0].getText().equals(b[8].getText()))||(b[4].getText().equals(b[2].getText())) && (b[2].getText().equals(b[6].getText()))||(b[4].getText().equals(b[3].getText())) && (b[3].getText().equals(b[5].getText()))))
		{
			JOptionPane.showMessageDialog(null,b[4].getText()+" wins");
			clear();
		}
		if(!(b[0].getText().equals(""))&&((b[0].getText().equals(b[1].getText())) && (b[1].getText().equals(b[2].getText()))||(b[0].getText().equals(b[3].getText())) && (b[3].getText().equals(b[6].getText()))))
		{
			JOptionPane.showMessageDialog(null,b[0].getText()+" wins");
			clear();
		}
		if(!(b[8].getText().equals(""))&&((b[8].getText().equals(b[5].getText())) && (b[5].getText().equals(b[2].getText()))||(b[8].getText().equals(b[7].getText())) && (b[7].getText().equals(b[6].getText()))))
		{
			JOptionPane.showMessageDialog(null,b[8].getText()+" wins");
			clear();
		}
		boolean f=true;
		for(i=0;i<9;i++)
		{
			if(b[i].getText().equals(""))
			{
				f=false;
				break;
			}
		}
		if(f)
			clear();
	}
	public static void clear()
	{
		for(int i=0;i<9;i++)
			b[i].setText("");
	}
}
class a3 implements ActionListener
{
	static JButton b[]=new JButton[11];
	JFrame f3;
	JPanel pan;
	static int a=0,i;
	public a3()
	{
		f3=new JFrame("TIC TAC TOE");
		f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f3.setSize(700,700);
		f3.setLayout(null);
		pan=new JPanel();
		pan.setBounds(100,100,500,500);
		pan.setLayout(new GridLayout(3,3));
		f3.add(pan);
		for(i=0;i<9;i++)
		{
			b[i]=new JButton("");
			pan.add(b[i]);
		}
		b[9]=new JButton("return");
		b[10]=new JButton("Clear");
		b[9].setBounds(150,625,100,50);
		b[10].setBounds(450,625,100,50);
		f3.add(b[9]);
		f3.add(b[10]);
		for(i=0;i<11;i++)
			b[i].addActionListener(this);
		f3.setVisible(true);
	}
	public void actionPerformed(ActionEvent ev)
	{
	String st=ev.getActionCommand();
		if(st.equals(""))
		{
			if(a==0)
			{
				((JButton)ev.getSource()).setText("0");
				a=1;
			}
			else
			{
				((JButton)ev.getSource()).setText("X");
				a=0;
			}
			check();
		}
		if(st.equals("Clear"))
			clear();
		if(st.equals("return"))
			f3.setVisible(false);
	}
	public static void check()
	{
		if(!(b[4].getText().equals(""))&&((b[4].getText().equals(b[1].getText())) && (b[1].getText().equals(b[7].getText()))||(b[4].getText().equals(b[0].getText())) && (b[0].getText().equals(b[8].getText()))||(b[4].getText().equals(b[2].getText())) && (b[2].getText().equals(b[6].getText()))||(b[4].getText().equals(b[3].getText())) && (b[3].getText().equals(b[5].getText()))))
		{
			JOptionPane.showMessageDialog(null,b[4].getText()+" wins");
			clear();
		}
		if(!(b[0].getText().equals(""))&&((b[0].getText().equals(b[1].getText())) && (b[1].getText().equals(b[2].getText()))||(b[0].getText().equals(b[3].getText())) && (b[3].getText().equals(b[6].getText()))))
		{
			JOptionPane.showMessageDialog(null,b[0].getText()+" wins");
			clear();
		}
		if(!(b[8].getText().equals(""))&&((b[8].getText().equals(b[5].getText())) && (b[5].getText().equals(b[2].getText()))||(b[8].getText().equals(b[7].getText())) && (b[7].getText().equals(b[6].getText()))))
		{
			JOptionPane.showMessageDialog(null,b[0].getText()+" wins");
			clear();
		}
		boolean f=true;
		for(i=0;i<9;i++)
		{
			if(b[i].getText().equals(""))
			{
				f=false;
				break;
			}
		}
		if(f)
			clear();
	}
	public static void clear()
	{
		for(int i=0;i<9;i++)
			b[i].setText("");
	}
}
