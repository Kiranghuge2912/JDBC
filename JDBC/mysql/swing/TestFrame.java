import javax.swing.JFrame;

class DemoFrame		//if extend JFrame then (no need to crate JFrame obj)
{
	DemoFrame()
	{
		JFrame frame = new JFrame("Login App");
		//frame.setTitle("Login App");
		frame.setVisible(true);					//for visibility
		frame.setSize(500,500);					//window size
		frame.setLocation(400,100);				//window placing
		frame.getContentPane().setBackground(java.awt.Color.RED);	//color(contentpane-for portion)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//(X-click to exit)
	}
}

class TestFrame
{
	public static void main(String args[])
	{
		DemoFrame f = new DemoFrame();
	}
}