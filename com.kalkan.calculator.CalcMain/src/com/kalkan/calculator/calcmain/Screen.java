package com.kalkan.calculator.calcmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kalkan.calculator.calculatorcore.Diff;
import com.kalkan.calculator.calculatorcore.Div;
import com.kalkan.calculator.calculatorcore.Mult;
import com.kalkan.calculator.calculatorcore.Sum;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen {

	private JFrame frame;
	private JTextField textFieldNum;
	
	private Sum sumInt;
	private Diff diffInt;
	private Mult multInt;
	private Div divInt;
	
	private int num1, num2;
	private int op;	// if op == 0, then equal
					// if op == 1, then sum
					// if op == 2, then diff
					// if op == 3, then mult
					// if op == 4, then div
					// if op == anything else, then exception
	private void setOp(int x){
		this.op = x;
	}
	private void resetNums(){
		this.num1 = 0;
		this.num2 = 0;
	}
	
	public Screen(Sum sumInt, Diff diffInt, Mult multInt, Div divInt) {
		this.sumInt = sumInt;
		this.diffInt = diffInt;
		this.multInt = multInt;
		this.divInt = divInt;
		initialize();
		this.op = -1;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 729, 450);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(66, 72, 513, 49);
		getFrame().getContentPane().add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel operaitonLabel = new JLabel("");
		operaitonLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		operaitonLabel.setBounds(597, 72, 61, 49);
		getFrame().getContentPane().add(operaitonLabel);
		
		JButton buttonSum = new JButton("+");
		buttonSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					num1 = (int)Double.parseDouble(textFieldNum.getText());
					setOp(1);
					operaitonLabel.setText("+");
					textFieldNum.setText("");
					
				}catch(Exception sumButtonException){
					JOptionPane.showMessageDialog(null, "Please enter a valid number!");
				}
			}
		});
		buttonSum.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonSum.setBounds(383, 154, 66, 40);
		getFrame().getContentPane().add(buttonSum);
		
		JButton buttonDiff = new JButton("-");
		buttonDiff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					num1 = (int)Double.parseDouble(textFieldNum.getText());
					setOp(2);
					operaitonLabel.setText("-");
					textFieldNum.setText("");
					
				}catch(Exception sumButtonException){
					JOptionPane.showMessageDialog(null, "Please enter a valid number!");
				}
			}
		});
		buttonDiff.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonDiff.setBounds(383, 220, 66, 40);
		getFrame().getContentPane().add(buttonDiff);
		
		//REAL OPERATIONS ARE HERE
		JButton buttonEqual = new JButton("=");
		buttonEqual.addActionListener(new ActionListener() {
			double result = -1;
			public void actionPerformed(ActionEvent e) {
				try{
					num2 = Integer.parseInt(textFieldNum.getText());
					operaitonLabel.setText("=");
					if(op == 1){
						result = sumInt.sum2(num1, num2);
						resetNums();
					}
					else if(op == 2){
						result = diffInt.diff2(num1, num2);
						resetNums();
					}
					else if(op == 3){
						result = multInt.mult2(num1, num2);
						resetNums();
					}
					else if(op == 4){
						result = divInt.div2(num1, num2);
						resetNums();
					}
					else if(op == 0){
						result = Integer.parseInt(textFieldNum.getText());
						resetNums();
					}
					else{
						resetNums();
						JOptionPane.showMessageDialog(null, "Error! Enter a valid number!");						
						return;
					}
					String sResult = "" + result;
					textFieldNum.setText(sResult);
				}catch(Exception sumButtonException){
					JOptionPane.showMessageDialog(null, "Please enter a valid number!");
				}
			}
		});
		buttonEqual.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonEqual.setBounds(472, 154, 66, 40);
		getFrame().getContentPane().add(buttonEqual);
		
		JButton buttonC = new JButton("C");
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operaitonLabel.setText("C");
				textFieldNum.setText("0");
				resetNums();
			}
		});
		buttonC.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonC.setBounds(472, 220, 66, 40);
		getFrame().getContentPane().add(buttonC);
		
		JButton buttonMult = new JButton("x");
		buttonMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					num1 = (int)Double.parseDouble(textFieldNum.getText());
					setOp(3);
					operaitonLabel.setText("x");
					textFieldNum.setText("");
					
				}catch(Exception sumButtonException){
					JOptionPane.showMessageDialog(null, "Please enter a valid number!");
				}
			}
		});
		buttonMult.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonMult.setBounds(383, 282, 66, 40);
		getFrame().getContentPane().add(buttonMult);
		
		JButton buttonDiv = new JButton("/");
		buttonDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					num1 = (int)Double.parseDouble(textFieldNum.getText());
					setOp(4);
					operaitonLabel.setText("/");
					textFieldNum.setText("");
					
				}catch(Exception sumButtonException){
					JOptionPane.showMessageDialog(null, "Please enter a valid number!");
				}
			}
		});
		buttonDiv.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonDiv.setBounds(383, 341, 66, 40);
		getFrame().getContentPane().add(buttonDiv);
		
		JButton buttonOf1 = new JButton("1");
		buttonOf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 1;
				textFieldNum.setText(str);
			}
		});
		buttonOf1.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf1.setBounds(66, 154, 66, 40);
		getFrame().getContentPane().add(buttonOf1);
		
		JButton buttonOf2 = new JButton("2");
		buttonOf2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 2;
				textFieldNum.setText(str);
			}
		});
		buttonOf2.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf2.setBounds(144, 154, 66, 40);
		getFrame().getContentPane().add(buttonOf2);
		
		JButton buttonOf3 = new JButton("3");
		buttonOf3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 3;
				textFieldNum.setText(str);
			}
		});
		buttonOf3.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf3.setBounds(222, 154, 66, 40);
		getFrame().getContentPane().add(buttonOf3);
		
		JButton buttonOf4 = new JButton("4");
		buttonOf4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 4;
				textFieldNum.setText(str);
			}
		});
		buttonOf4.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf4.setBounds(66, 206, 66, 40);
		getFrame().getContentPane().add(buttonOf4);
		
		JButton buttonOf5 = new JButton("5");
		buttonOf5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 5;
				textFieldNum.setText(str);
			}
		});
		buttonOf5.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf5.setBounds(144, 206, 66, 40);
		getFrame().getContentPane().add(buttonOf5);
		
		JButton buttonOf6 = new JButton("6");
		buttonOf6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 6;
				textFieldNum.setText(str);
			}
		});
		buttonOf6.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf6.setBounds(222, 206, 66, 40);
		getFrame().getContentPane().add(buttonOf6);
		
		JButton buttonOf7 = new JButton("7");
		buttonOf7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 7;
				textFieldNum.setText(str);
			}
		});
		buttonOf7.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf7.setBounds(66, 258, 66, 40);
		getFrame().getContentPane().add(buttonOf7);
		
		JButton buttonOf8 = new JButton("8");
		buttonOf8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 8;
				textFieldNum.setText(str);
			}
		});
		buttonOf8.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf8.setBounds(144, 258, 66, 40);
		getFrame().getContentPane().add(buttonOf8);
		
		JButton buttonOf9 = new JButton("9");
		buttonOf9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 9;
				textFieldNum.setText(str);
			}
		});
		buttonOf9.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf9.setBounds(222, 258, 66, 40);
		getFrame().getContentPane().add(buttonOf9);
		
		JButton buttonOf0 = new JButton("0");
		buttonOf0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textFieldNum.getText();
				str = str + 0;
				textFieldNum.setText(str);
			}
		});
		buttonOf0.setFont(new Font("Dialog", Font.BOLD, 25));
		buttonOf0.setBounds(144, 312, 66, 40);
		getFrame().getContentPane().add(buttonOf0);
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
