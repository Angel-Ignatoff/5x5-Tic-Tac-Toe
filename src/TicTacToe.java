import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{ //A listener interface for receiving action events
	//creating the window pop-up
	Random random = new Random();
	JFrame frame = new JFrame(); 
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel(); 
	JLabel TextField = new JLabel();
	JButton[] buttons = new JButton[25];
	String player_sign;
	boolean player_turn;
	static int count = 0;




	TicTacToe() { 
		//setting the parameters for the window pop-up
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //CLOSE
		frame.setSize(800, 800); //window size
		frame.getContentPane().setBackground(new Color(25,25,25)); //RGB color used for background black
		frame.setLayout(new BorderLayout()); //Constructing a border layout with no gaps in between
		frame.setVisible(true); //making the window visible
		//Text Field
		TextField.setBackground(new Color(25, 25, 25)); //setting background color using RGB black
		TextField.setForeground(new Color(25, 255, 0)); //setting the foreground color using RGB lime
		TextField.setFont(new Font("Ink Free", Font.BOLD, 75)); //setting the font to BOLD
		TextField.setHorizontalAlignment(JLabel.CENTER); //setting the label's location
		TextField.setText("TicTacToe"); //assigning the label's name
		TextField.setOpaque(true); //when set to true, the component paints every pixel within its bounds
		//Title
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 800, 100); //Move and resizes the component
		//Buttons layout and color
		button_panel.setLayout(new GridLayout(5,5)); //Creating 5x5 blocks
		button_panel.setBackground(new Color(150, 150, 150)); //Background color of component grey
		//Creating the buttons and setting font and size
		for(int i=0; i<25; i++) {                    
			buttons[i] = new JButton(); 
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.ITALIC, 120));
			buttons[i].setFocusable(false);//indicates if the component is focusable and overrides the components default focusability
			buttons[i].addActionListener(this);//adds action to the button
		}

		title_panel.add(TextField);
		frame.add(title_panel, BorderLayout.NORTH);//placement and adding the title 
		frame.add(button_panel);//adding the buttons

		firstTurn(); //calling the method called "firstTurn"

	}

	public void actionPerformed (ActionEvent e) {

		for(int i=0; i<25; i++) {   
			if(e.getSource()==buttons[i]) {
				if(player_turn) {
					if(buttons[i].getText()=="") { //when text imputed in the button "X" or "O"
						buttons[i].setForeground(new Color(255, 0, 0)); //set color to red
						buttons[i].setText("X"); //set text to red X
						player_turn=false;
						if (Draw()) { //calling the "Draw" method
							TextField.setText("DRAW!"); //When no buttons available, print "DRAW!"
						} else {
							TextField.setText("O turn"); } //if buttons available, print "O turn" in the text field
						check(); //calling "check" method
						RandomMove(); //calling "RandomMove" method

					}
				}
				else {
					if(buttons[i].getText()=="") { //when text imputed
						buttons[i].setForeground(new Color(0, 0, 255)); //set color to blue
						buttons[i].setText("O"); //set text to be "O"
						player_turn=true; 
						if (Draw()) {
							TextField.setText("DRAW!"); //when no buttons available, call the "Draw" method
						} else {
							TextField.setText("X turn"); }
						check(); //calling the "check" method

					}
				} 
			}
		}

	}
	public void RandomMove() {

		int position = random.nextInt(25);
		if (buttons[position].getText().equals("")){
			buttons[position].setText("O"); //when a button empty, input "O"
			player_turn = true;
			TextField.setText("X turn");
			check(); //calling the check method
		}
		else{
			RandomMove();} //the method is calling itself

	}
	public void firstTurn() { //setting the first turn

		try {
			Thread.sleep(2000); //waits 2 seconds, before the title changes to who's turn it is
		} catch (InterruptedException e) {
			e.printStackTrace(); //error catching
		}  

		if(random.nextInt(2)==0) {
			player_turn=true;
			TextField.setText("X turn");
		}
		else {  
			player_turn=false;
			TextField.setText("O turn");
			RandomMove(); //calling the "RandomMove" method

		}
	}



	public void check() {  

		//Check X win conditions horizontally
		if((buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X"))
		{
			xWins(0,1,2,3,4); //if 5 X's are inputed in buttons 0-4, X wins
		}
		if((buttons[5].getText()=="X") &&
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X") &&
				(buttons[9].getText()=="X"))
		{
			xWins(5,6,7,8,9);
		}
		if((buttons[10].getText()=="X") &&
				(buttons[11].getText()=="X") &&
				(buttons[12].getText()=="X") &&
				(buttons[13].getText()=="X") &&
				(buttons[14].getText()=="X"))
		{
			xWins(10,11,12,13,14);
		}
		if((buttons[15].getText()=="X") &&
				(buttons[16].getText()=="X") &&
				(buttons[17].getText()=="X") &&
				(buttons[18].getText()=="X") &&
				(buttons[19].getText()=="X"))
		{
			xWins(15,16,17,18,19);
		}
		if((buttons[20].getText()=="X") &&
				(buttons[21].getText()=="X") &&
				(buttons[22].getText()=="X") &&
				(buttons[23].getText()=="X") &&
				(buttons[24].getText()=="X"))
		{
			xWins(20,21,22,23,24);
		}

		//Check X win conditions vertically
		if((buttons[0].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[10].getText()=="X") &&
				(buttons[15].getText()=="X") &&
				(buttons[20].getText()=="X"))
		{
			xWins(0,5,10,15,20);
		}
		if((buttons[1].getText()=="X") &&
				(buttons[6].getText()=="X") &&
				(buttons[11].getText()=="X") &&
				(buttons[16].getText()=="X") &&
				(buttons[21].getText()=="X"))
		{
			xWins(1,6,11,16,21);
		}
		if((buttons[2].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[12].getText()=="X") &&
				(buttons[17].getText()=="X") &&
				(buttons[22].getText()=="X"))
		{
			xWins(2,7,12,17,22);
		}
		if((buttons[3].getText()=="X") &&
				(buttons[8].getText()=="X") &&
				(buttons[13].getText()=="X") &&
				(buttons[18].getText()=="X") &&
				(buttons[23].getText()=="X"))
		{
			xWins(3,8,13,18,23);
		}
		if((buttons[4].getText()=="X") &&
				(buttons[9].getText()=="X") &&
				(buttons[14].getText()=="X") &&
				(buttons[19].getText()=="X") &&
				(buttons[24].getText()=="X"))
		{
			xWins(4,9,14,19,24);
		}
		//Check X win conditions diagonally
		if((buttons[0].getText()=="X") &&
				(buttons[6].getText()=="X") &&
				(buttons[12].getText()=="X") &&
				(buttons[18].getText()=="X") &&
				(buttons[24].getText()=="X"))
		{
			xWins(0,6,12,18,24);
		}

		if((buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X") &&
				(buttons[12].getText()=="X") &&
				(buttons[16].getText()=="X") &&
				(buttons[20].getText()=="X"))
		{
			xWins(4,8,12,16,20);
		}

		//Check O win conditions horizontally
		if((buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O"))
		{
			oWins(0,1,2,3,4);
		}
		if((buttons[5].getText()=="O") &&
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O") &&
				(buttons[9].getText()=="O"))
		{
			oWins(5,6,7,8,9);
		}
		if((buttons[10].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[13].getText()=="O") &&
				(buttons[14].getText()=="O"))
		{
			oWins(10,11,12,13,14);
		}
		if((buttons[15].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[19].getText()=="O"))
		{
			oWins(15,16,17,18,19);
		}
		if((buttons[20].getText()=="O") &&
				(buttons[21].getText()=="O") &&
				(buttons[22].getText()=="O") &&
				(buttons[23].getText()=="O") &&
				(buttons[24].getText()=="O"))
		{
			oWins(20,21,22,23,24);
		}
		//Check O win conditions vertically 
		if((buttons[0].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[10].getText()=="O") &&
				(buttons[15].getText()=="O") &&
				(buttons[20].getText()=="O"))
		{
			oWins(0,5,10,15,20);
		}
		if((buttons[1].getText()=="O") &&
				(buttons[6].getText()=="O") &&
				(buttons[11].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[21].getText()=="O"))
		{
			oWins(1,6,11,16,21);
		}
		if((buttons[2].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[17].getText()=="O") &&
				(buttons[22].getText()=="O"))
		{
			oWins(2,7,12,17,22);
		}
		if((buttons[3].getText()=="O") &&
				(buttons[8].getText()=="O") &&
				(buttons[13].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[23].getText()=="O"))
		{
			oWins(3,8,13,18,23);
		}
		if((buttons[4].getText()=="O") &&
				(buttons[9].getText()=="O") &&
				(buttons[14].getText()=="O") &&
				(buttons[19].getText()=="O") &&
				(buttons[24].getText()=="O"))
		{
			oWins(4,9,14,19,24);
		}
		//Check O win conditions diagonally
		if((buttons[0].getText()=="O") &&
				(buttons[6].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[18].getText()=="O") &&
				(buttons[24].getText()=="O"))
		{
			oWins(0,6,12,18,24);
		}

		if((buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O") &&
				(buttons[12].getText()=="O") &&
				(buttons[16].getText()=="O") &&
				(buttons[20].getText()=="O"))
		{
			oWins(4,8,12,16,20);
		}

	}

	public boolean Draw() { //No more spaces left, for an X or O to be inputed. Please restart


		boolean check = true;

		for(int i=0;i<25;i++) {
			if(buttons[i].getText() == "O" || buttons[i].getText() == "X") {} else { check = false;}
		}

		return check;

	}

	public void xWins(int a, int b, int c, int d, int e) {
		buttons[a].setBackground(Color.GREEN); //winning color for X set to GREEN
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		buttons[d].setBackground(Color.GREEN);
		buttons[e].setBackground(Color.GREEN);

		for(int i=0;i<25;i++) {
			buttons[i].setEnabled(false); //buttons not able to press after button fields are filled
		}
		TextField.setText("Human WON!"); //If X wins, "Human WON!" will be printed in the title field
	}
	public void oWins(int a, int b, int c, int d, int e) {
		buttons[a].setBackground(Color.RED); //winning color for O set to RED
		buttons[b].setBackground(Color.RED);
		buttons[c].setBackground(Color.RED);
		buttons[d].setBackground(Color.RED);
		buttons[e].setBackground(Color.RED);

		for(int i=0;i<25;i++) {
			buttons[i].setEnabled(false); //buttons not able to press after button fields are filled
		}
		TextField.setText("Computer WON!"); //If X wins, "Computer WON!" will be printed in the title field
	}

}
