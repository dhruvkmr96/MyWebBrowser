import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyWebBrowser extends JFrame{

	private JTextField jtf;
	private JEditorPane jep;
	
	public MyWebBrowser(){
		super("Dhruv's Browser");
		
		jtf=new JTextField("Enter a url.");
		jtf.addActionListener(
				new ActionListener(){
				
					public void actionPerformed(ActionEvent event){
						loadCrap(event.getActionCommand());
						}
					}
				);
		add(jtf,BorderLayout.NORTH);
		
		
		jep=new JEditorPane();
		jep.setEditable(false);
		jep.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadCrap((event.getURL()).toString());
						}
					}
				}
				
				);
		add(new JScrollPane(jep),BorderLayout.CENTER);
		setVisible(true);
		setSize(500,300);
	}
	
	public void loadCrap(String userText){
		try{
		jep.setPage(userText);
		jtf.setText(userText);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
