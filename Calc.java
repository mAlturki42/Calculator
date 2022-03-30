/*
Name: Mohammed Alturki
Course: CSC 2310
Instructor: Dr. Mehedi
Date: 07/28/21
Purpose:
This is a calculator that uses addition, subtraction, multiplication, and division
*/

package Calc;

import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calc extends JFrame {

   // Control variables
   private boolean notPlaced = true;
   private boolean divmsg = false;

   // Elements
   private int w, h;
   private JPanel panel;
   private GridBagConstraints gc;
   private JLabel resultLabel;
   private JLabel operandLabel;
   private JTextField resultField;
   private JTextField operandField;
   private JButton resetButton;
   private JButton clearButton;
   private JButton button7;
   private JButton button8;
   private JButton button9;
   private JButton buttonAdd;
   private JButton button4;
   private JButton button5;
   private JButton button6;
   private JButton buttonSub;
   private JButton button1;
   private JButton button2;
   private JButton button3;
   private JButton buttonMul;
   private JButton button0;
   private JButton buttonDec;
   private JButton buttonDiv;

   private class ClearAction implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent e) {
         operandField.setText("");
         notPlaced = true;
         divmsg = false;
      }
   }

   private class DecAction implements ActionListener {
      @Override
      public void actionPerformed (ActionEvent e) {
         if (notPlaced) {
            if(divmsg)
               new ClearAction().actionPerformed(e);
            operandField.setText(operandField.getText() + ".");
            notPlaced = false;
         }
      }
   }

   private class DivAction implements ActionListener {
      public void thrower () throws DivisionByZeroException {
         throw new DivisionByZeroException();
      }
      @Override
      public void actionPerformed (ActionEvent e) {
         try{
            double op = Double.parseDouble(operandField.getText());
            if (op >= -1.0e-10 && op <= 1.0e-10)
               thrower();
            resultField.setText(
                    Double.toString(
                            Double.parseDouble(resultField.getText())
                                    /
                                    op
                    )
            );
            new ClearAction().actionPerformed(e);
         } catch (Exception mismatch) {}
      }
   }

   // Exception
   private class DivisionByZeroException extends Exception {
      public DivisionByZeroException () {
         operandField.setText("Division By Zero");
         divmsg = true;
      }
   }

   public Calc () {

      // Initialization
      notPlaced = true;

      // Size
      w = 400;
      h = 400;
      setSize(w, h);

      // Position
      setLocationRelativeTo(null);

      // Close Operation
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Title
      setTitle("Java Swing GUI Calculator");

      // Resizable false
      setResizable(false);

      // Make panel
      panel = new JPanel(new GridBagLayout());

      // Set default GridBagConstraints
      gc = new GridBagConstraints();
      gc.gridx		= 0;
      gc.gridy		= 0;
      gc.gridwidth	= 2;
      gc.gridheight	= 1;
      gc.weightx		= 50;
      gc.weighty		= 100;
      gc.insets		= new Insets (5, 5, 5, 5);
      gc.anchor		= gc.CENTER;
      gc.fill			= gc.BOTH;

      // Panel contents

      // Result label
      resultLabel = new JLabel("Result Field", SwingConstants.CENTER);
      panel.add(resultLabel, gc);

      // Operand label
      operandLabel = new JLabel("Operand Field", SwingConstants.CENTER);
      gc.gridx = 2;
      panel.add(operandLabel, gc);

      // Result Field
      resultField = new JTextField(Double.toString(0.0), 19);
      resultField.setEditable(false);
      gc.gridx = 0;
      gc.gridy = 1;
      panel.add(resultField, gc);

      // Operand Field
      operandField = new JTextField("", 19);
      operandField.setEditable(false);
      gc.gridx = 2;
      panel.add(operandField, gc);

      // Reset button
      resetButton = new JButton("Reset");
      resetButton.addActionListener(e -> resultField.setText(Double.toString(0.0)));
      gc.gridx = 0;
      gc.gridy = 2;
      panel.add(resetButton, gc);

      // Clear button
      clearButton = new JButton("Clear");
      clearButton.addActionListener(new ClearAction());
      gc.gridx = 2;
      panel.add(clearButton, gc);

      // 7
      button7 = new JButton("7");
      button7.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "7");
      });
      gc.gridwidth = 1;
      gc.gridx = 0;
      gc.gridy = 3;
      panel.add(button7, gc);

      // 8
      button8 = new JButton("8");
      button8.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "8");
      });
      gc.gridx = 1;
      panel.add(button8, gc);

      // 9
      button9 = new JButton("9");
      button9.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "9");
      });
      gc.gridx = 2;
      panel.add(button9, gc);

      // +
      buttonAdd = new JButton("+");
      buttonAdd.addActionListener( e -> {
                 try{
                    resultField.setText(
                            Double.toString(
                                    Double.parseDouble(resultField.getText())
                                            +
                                            Double.parseDouble(operandField.getText())
                            )
                    );
                    new ClearAction().actionPerformed(e);
                 } catch (Exception mismatch) {}
              }
      );
      gc.gridx = 3;
      panel.add(buttonAdd, gc);

      // 4
      button4 = new JButton("4");
      button4.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "4");
      });
      gc.gridx = 0;
      gc.gridy = 4;
      panel.add(button4, gc);

      // 5
      button5 = new JButton("5");
      button5.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "5");
      });
      gc.gridx = 1;
      panel.add(button5, gc);

      // 6
      button6 = new JButton("6");
      button6.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "6");
      });
      gc.gridx = 2;
      panel.add(button6, gc);

      // -
      buttonSub = new JButton("-");
      buttonSub.addActionListener( e -> {
                 try{
                    resultField.setText(
                            Double.toString(
                                    Double.parseDouble(resultField.getText())
                                            -
                                            Double.parseDouble(operandField.getText())
                            )
                    );
                    new ClearAction().actionPerformed(e);
                 } catch (Exception mismatch) {}
              }
      );
      gc.gridx = 3;
      panel.add(buttonSub, gc);

      // 1
      button1 = new JButton("1");
      button1.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "1");
      });
      gc.gridx = 0;
      gc.gridy = 5;
      panel.add(button1, gc);

      // 2
      button2 = new JButton("2");
      button2.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "2");
      });
      gc.gridx = 1;
      panel.add(button2, gc);

      // 3
      button3 = new JButton("3");
      button3.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "3");
      });
      gc.gridx = 2;
      panel.add(button3, gc);

      // *
      buttonMul = new JButton("*");
      buttonMul.addActionListener( e -> {
                 try{
                    resultField.setText(
                            Double.toString(
                                    Double.parseDouble(resultField.getText())
                                            *
                                            Double.parseDouble(operandField.getText())
                            )
                    );
                    new ClearAction().actionPerformed(e);
                 } catch (Exception mismatch) {}
              }
      );
      gc.gridx = 3;
      panel.add(buttonMul, gc);

      // 0
      button0 = new JButton("0");
      button0.addActionListener(e -> {
         if (divmsg)
            new ClearAction().actionPerformed(e);
         operandField.setText(operandField.getText() + "0");
      });
      gc.gridwidth = 2;
      gc.gridx = 0;
      gc.gridy = 6;
      panel.add(button0, gc);

      // .
      buttonDec = new JButton(".");
      buttonDec.addActionListener(new DecAction());
      gc.gridwidth = 1;
      gc.gridx = 2;
      panel.add(buttonDec, gc);

      // /
      buttonDiv = new JButton("/");
      buttonDiv.addActionListener(new DivAction());
      gc.gridx = 3;
      panel.add(buttonDiv, gc);

      // Add panel
      add(panel);

      // Visible
      setVisible(true);
   }

   public static void main (String[] args) {
      new Calc();
   }

}
