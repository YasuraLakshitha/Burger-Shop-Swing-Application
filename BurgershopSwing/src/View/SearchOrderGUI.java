package View;

import Controler.Controller;
import Model.Order;
import javax.swing.*;
import java.awt.*;

public class SearchOrderGUI extends JFrame {

    private JButton btnSubmit;
    private Order order;
    private JPanel inputPanel;
    private JPanel orderIdLabelPanel;
    private JLabel orderIDLabel;
    private JPanel orderIdInputPanel;
    private JTextField orderIdInput;
    SearchOrderGUI(){
        setTitle("Search Order");
        setSize(600,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

        //input panel
        inputPanel = new JPanel(new GridLayout(1,2));
        inputPanel.setBounds(100,70,360,100);

        orderIdLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        orderIDLabel = new JLabel("Enter Order ID");
        orderIDLabel.setFont(new Font("",1,20));
        orderIdLabelPanel.setBackground(Color.WHITE);
        orderIdLabelPanel.add(orderIDLabel);
        inputPanel.add(orderIdLabelPanel);

        orderIdInputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        orderIdInput = new JTextField(10);
        orderIdInput.setFont(new Font("",1,20));
        orderIdInputPanel.add(orderIdInput);
        orderIdInputPanel.setBackground(Color.WHITE);
        inputPanel.add(orderIdInputPanel);

        btnSubmit = new JButton("Search");
        btnSubmit.setFont(new Font("", Font.PLAIN,17));
        btnSubmit.setBounds(180,150,200,40);
        btnSubmit.setFocusable(false);
        btnSubmit.setBackground(Color.darkGray);
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(evt->{
            order= Controller.searchOrder(orderIdInput.getText());
            if(order==null){
                JOptionPane.showMessageDialog(orderIdInputPanel,"No order on that ID");
                setVisible(false);
                new HomePageGUI().setVisible(true);
            }else{
                setVisible(false);
                new OrderDetailsGUI(order).setVisible(true);
            }
        });

        add(btnSubmit);
        add(inputPanel);
    }
}
