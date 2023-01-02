/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ll_simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author Rahul
 * 
 * SINGLY LINKED LIST SIMULATOR
 * 
 * 1. Simple simulator with push,append,delete and search functionality
 * 2. More features to be added soon.
 */

class simPage extends JPanel implements ActionListener
{
    Codes codes = new Codes();
    LLops simul = new LLops();
    
    JButton dynamicBt;
    
    JLabel dynamicArrow;
    JFrame f;
    
    JButton addBtn,appendBtn,delBtn,searchBtn;
    JTextField addField,apField,delField,searchField;
    
    JPanel listUI;
    
    JPanel masterPanel,codePanel,southPanel;
    JPanel subCode1,subCode2;
    JTextPane codeArea1,codeArea2;
    JScrollPane scroll1,scroll2;
    JLabel l1,l2;
    
    Font arrowFont = new Font("SansSerif",Font.BOLD,20);
    
    Font font2 = new Font("segoe ui",Font.BOLD,20);
    
//    Font mono = new Font(Font.MONOSPACED,Font.BOLD,17);
    
    Color beige = new Color(245,245,220);
    Color darkBeige =  new Color(159,140,118);
//    Color Ivory = new Color(255,255,240);
//    Color magenta = new Color(139,0,139);
//    Color indigo = new Color(75,0,130);
    Color silver = new Color(192,192,192);
    
    Color lightBlue = new Color(183,226,245);
    simPage()
    {  
        f = new JFrame("SINGLY LINKED LIST SIMULATOR");
        f.setSize(500,500);
        
        masterPanel = new JPanel();
        codePanel = new JPanel();
        subCode1 = new JPanel();
        subCode1.setLayout(new BoxLayout(subCode1,BoxLayout.Y_AXIS));
        subCode2 = new JPanel();
        subCode2.setLayout(new BoxLayout(subCode2,BoxLayout.Y_AXIS));
        masterPanel.setLayout(new GridLayout(2,1,0,0));
        codePanel.setLayout(new GridLayout(1,2,10,0));
        
        l1 = new JLabel("CODE(C language):");
        l1.setFont(font2);
        
        l2 = new JLabel("CODE(JAVA):");
        l2.setFont(font2);
        
        codeArea1 = new JTextPane();
        codeArea2 = new JTextPane();
        
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attributeSet, "monospaced");
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setFontSize(attributeSet, 17);
        StyleConstants.setForeground(attributeSet,Color.BLACK);

        codeArea1.setBackground(silver);
        codeArea2.setBackground(silver);
        codeArea1.setCharacterAttributes(attributeSet,true);
        codeArea2.setCharacterAttributes(attributeSet,true);
        
        codeArea1.setEditable(false);
        codeArea2.setEditable(false);
        
        scroll1 = new JScrollPane(codeArea1);
        scroll2 = new JScrollPane(codeArea2);

         subCode1.add(l1);
         subCode1.add(scroll1);
         
         subCode2.add(l2);
         subCode2.add(scroll2);
         
         codePanel.add(subCode1);
         codePanel.add(subCode2);
        southPanel = new JPanel();
        southPanel.add(new JLabel(""));

        addField = new JTextField(3);
        apField = new JTextField(3);
        delField = new JTextField(3);
        searchField = new JTextField(3);
        
        addBtn = new JButton("PUSH");
        appendBtn = new JButton("APPEND");
        delBtn = new JButton("DELETE(By Position)");
        searchBtn = new JButton("SEARCH");
        
        addBtn.setBackground(lightBlue);
        appendBtn.setBackground(lightBlue);
        delBtn.setBackground(lightBlue);
        searchBtn.setBackground(lightBlue);
        
        addBtn.addActionListener(this);
        appendBtn.addActionListener(this);
        delBtn.addActionListener(this);
        searchBtn.addActionListener(this);
       
        add(addField);
        add(addBtn);
        
        add(new JLabel("       "));
        add(apField);
        add(appendBtn);
        
        add(new JLabel("       "));
        add(delField);
        add(delBtn);
        
        
        add(new JLabel("       "));
        add(searchField);
        add(searchBtn);
        setBackground(beige);
        
        listUI = new JPanel();
        
        Border myBorder = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(darkBeige,5), 
                BorderFactory.createEmptyBorder(100,0,0,0));
        listUI.setBorder(myBorder);

        f.add(this,BorderLayout.NORTH);
        
        masterPanel.add(listUI);
        masterPanel.add(codePanel);
        f.add(masterPanel,BorderLayout.CENTER);
        
        f.add(southPanel,BorderLayout.SOUTH);
        f.setVisible(true);
        f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void displayEmptyMsg()
    {
        JOptionPane.showMessageDialog(listUI, "FIELD VALUE EMPTY!",
                                   "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    void displayNumFormatExp()
    {
        JOptionPane.showMessageDialog(this, "PLEASE ENTER VALID INTEGER!",
                                   "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    void writePushCode()
    {
        String[] spArr1 = l1.getText().split(":");
        String[] spArr2 = l2.getText().split(":");
        String label1,label2;
        if (spArr1.length>1 || spArr2.length>1)
        {
            
        spArr1[1] = " PUSH NODE";
        spArr2[1] = " PUSH NODE";
        label1 = spArr1[0]+":"+spArr1[1];
        
        
//        label1+=" PUSH NODE";
        l1.setText(label1);
        
        label2 = spArr2[0]+":"+spArr2[1];
//        label2+=" PUSH NODE";
        l2.setText(label2);
        }
        else
        {
            label1 = l1.getText();
            label1+=" PUSH NODE";
            l1.setText(label1);

            label2 = l2.getText();
            label2+=" PUSH NODE";
            l2.setText(label2);
        
        }
        
        codeArea1.setText(codes.CPush);
        codeArea2.setText(codes.javaPush);
    }
    
    void writeAppendCode()
    {
        String[] spArr1 = l1.getText().split(":");
        String[] spArr2 = l2.getText().split(":");
        String label1,label2;
        if (spArr1.length>1 || spArr2.length>1)
        {
            
        spArr1[1] = " APPEND NODE";
        spArr2[1] = " APPEND NODE";
        label1 = spArr1[0]+":"+spArr1[1];
        
        
//        label1+=" PUSH NODE";
        l1.setText(label1);
        
        label2 = spArr2[0]+":"+spArr2[1];
//        label2+=" PUSH NODE";
        l2.setText(label2);
        }
        else
        {
            label1 = l1.getText();
            label1+=" APPEND NODE";
            l1.setText(label1);

            label2 = l2.getText();
            label2+=" APPEND NODE";
            l2.setText(label2);
        
        }
        codeArea1.setText(codes.cAppend);
        codeArea2.setText(codes.javaAppend);
    }
    
    void writeDelCode()
    {
        String[] spArr1 = l1.getText().split(":");
        String[] spArr2 = l2.getText().split(":");
        String label1,label2;
        if (spArr1.length>1 || spArr2.length>1)
        {
            
        spArr1[1] = " DELETION OF NODE";
        spArr2[1] = " DELETION OF NODE";
        label1 = spArr1[0]+":"+spArr1[1];
        
        
//        label1+=" PUSH NODE";
        l1.setText(label1);
        
        label2 = spArr2[0]+":"+spArr2[1];
//        label2+=" PUSH NODE";
        l2.setText(label2);
        }
        else
        {
            label1 = l1.getText();
            label1+=" DELETION OF NODE";
            l1.setText(label1);

            label2 = l2.getText();
            label2+=" DELETION OF NODE";
            l2.setText(label2);
        
        }
        codeArea1.setText(codes.cDelPos);
        codeArea2.setText(codes.javaDelPos);
    }
    
    void writeSearchCode()
    {
        String[] spArr1 = l1.getText().split(":");
        String[] spArr2 = l2.getText().split(":");
        String label1,label2;
        if (spArr1.length>1 || spArr2.length>1)
        {
            
        spArr1[1] = " SEARCH A NODE";
        spArr2[1] = " SEARCH A NODE";
        label1 = spArr1[0]+":"+spArr1[1];
        
        
//        label1+=" PUSH NODE";
        l1.setText(label1);
        
        label2 = spArr2[0]+":"+spArr2[1];
//        label2+=" PUSH NODE";
        l2.setText(label2);
        }
        else
        {
            label1 = l1.getText();
            label1+=" SEARCH A NODE";
            l1.setText(label1);

            label2 = l2.getText();
            label2+=" SEARCH A NODE";
            l2.setText(label2);
        
        }
        codeArea1.setText(codes.cSearch);
        codeArea2.setText(codes.javaSearch);
    }
    
    void highLightNode(int data)
    {
         LLops.Node temp;
         temp = simul.head;
         
         listUI.removeAll();
         while (temp!=null)
         {
            int nodeData = temp.data;
            String toAdd = String.valueOf(nodeData);
            dynamicBt = new JButton(toAdd);
            dynamicArrow = new JLabel("-->");
            dynamicArrow.setFont(arrowFont);
            if (temp.data==data)
            {
                System.out.println("magenta");
                dynamicBt.setBackground(Color.yellow);
            }
            else
            {
                dynamicBt.setBackground(beige);
            }
            listUI.add(dynamicBt);
            listUI.add(dynamicArrow);

            temp = temp.next;
            
         }
         listUI.revalidate();
         listUI.repaint();
    }
    
    
    void display()
    {
        LLops.Node temp;

        temp = simul.head;

        listUI.removeAll();
        while (temp!=null)
        {
            int nodeData = temp.data;
            String toAdd = String.valueOf(nodeData);
    //                    arr[i] = new JButton(toAdd);
            dynamicBt = new JButton(toAdd);
            
            
//            float[] hsb = Color.RGBtoHSB(245, 245, 220, null);
            dynamicBt.setBackground(beige);
            dynamicArrow = new JLabel("-->");
            dynamicArrow.setFont(arrowFont);
            listUI.add(dynamicBt);
            listUI.add(dynamicArrow);


//            dynamicBt.setVisible(true);
//            dynamicArrow.setVisible(true);

            listUI.revalidate();
    //                    btnList.add(new JButton(toAdd));
    //                    i++;
            temp = temp.next;
        }
        
        listUI.revalidate();
        listUI.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==addBtn)
        {
            if (!(addField.getText().equals("")))
            {
                int val = 0;
                try
                {
                    val = Integer.parseInt(addField.getText());
                     simul.push(val);
                    simul.printList();
                    display();
                    writePushCode();
                    addField.setText("");
                }
                catch (NumberFormatException ep)
                {
                    displayNumFormatExp();
                    addField.setText("");
                    System.out.println("NUMBER FORMAT EXCEPTION");
                } 
               
            }
            else
            {
                displayEmptyMsg();
            }
        }
        
        else if (e.getSource()==appendBtn)
        {
            if (!apField.getText().equals(""))
            {
                int val = 0;
                try
                {
                    val = Integer.parseInt(apField.getText()); 
                    simul.append(val);
                    simul.printList();

                    display();
                    writeAppendCode();
                    apField.setText("");
                }
                catch (NumberFormatException ep)
                {
                    displayNumFormatExp();
                    apField.setText("");
                    System.out.println("NUMBER FORMAT EXCEPTION");
                } 
                
            }
            else
            {
                displayEmptyMsg();
            }
                
        }
        
        else if (e.getSource()==delBtn)
        {
            if (!delField.getText().equals(""))
            {
                int pos = 0;
                try
                {
                    pos = Integer.parseInt(delField.getText()); 
                    simul.delete(pos);
                    simul.printList();
                    display();
                    writeDelCode();
                    delField.setText("");
                }
                catch (NumberFormatException ep)
                {
                    displayNumFormatExp();
                    delField.setText("");
                    System.out.println("NUMBER FORMAT EXCEPTION");
                }
                
            }
            else
            {
                JOptionPane.showMessageDialog(listUI, "ENTER THE POSITION OF THE NODE FOR DELETION",
                                   "INFO", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
        else if (e.getSource()==searchBtn)
        {
            if (!searchField.getText().equals(""))
            {
                int pos = 0;
                try
                {
                    
                    int data = Integer.parseInt(searchField.getText()); 
                    boolean flag = simul.search(data);
                    writeSearchCode();
                    if (flag==true)
                    {
                         highLightNode(data);
                        JOptionPane.showMessageDialog(searchBtn, "VALUE FOUND",
                                           "INFO", JOptionPane.INFORMATION_MESSAGE);

                    }
                    else
                    {
                      JOptionPane.showMessageDialog(searchBtn, "VALUE NOT FOUND",
                                           "INFO", 
                                           JOptionPane.INFORMATION_MESSAGE);   
                    }
                    display();
                    searchField.setText("");
                }
                catch (NumberFormatException ep)
                {
                    displayNumFormatExp();
                    searchField.setText("");
                    System.out.println("NUMBER FORMAT EXCEPTION");
                }
            }
            else
            {
                  JOptionPane.showMessageDialog(this, "ENTER THE NODE DATA",
                                   "INFO", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}

public class LL_simulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new simPage();
    }
    
}
