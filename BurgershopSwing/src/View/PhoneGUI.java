package View;

import Controler.Controller;
import Model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PhoneGUI extends JFrame {
    private JButton submit;
    private JLabel customerPhoneLabel;
    private JPanel phoneInputPanel;
    private JTextField phone;
    private String customerPhone;
    private String customerName;
    private static final int NEW_CUSTOMER = 0;
    private static final int SEARCH_CUSTOMER = 1;
    PhoneGUI(int field){
        setTitle("Phone number input from");
        setSize(500,250);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

        Order order = new Order();

        customerPhoneLabel  = new JLabel("Customer Phone");
        customerPhoneLabel.setFont(new Font("",Font.PLAIN,20));
        customerPhoneLabel.setBounds(50,20,200,100);

        phoneInputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        phone = new JTextField(5);
        phone.setFont(new Font("",1,15));
        phone.setBounds(230,60,200,30);

        //submit button
        submit = new JButton("submit");
        submit.setFont(new Font("",Font.PLAIN,15));
        submit.setFocusable(false);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.darkGray);
        submit.setBounds(110,130,250,50);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                customerPhone = phone.getText();
                customerName = Controller.isExistCustomer(customerPhone);
                PlaceOrderGUI placeOrder;
                switch (field){
                    case NEW_CUSTOMER:
                        if(!order.setPhone(customerPhone)){
                            JOptionPane.showMessageDialog(phoneInputPanel,"Invalid Phone Number");
                        }else if(customerName!=null){
                            System.out.println("not null");
                            setVisible(false);
                            order.setCustomerName(customerName);
                            placeOrder = new PlaceOrderGUI(order);
                            placeOrder.setVisible(true);
                        }else{
                            placeOrder = new PlaceOrderGUI(order);
                            setVisible(false);
                            placeOrder.setVisible(true);
                        }
                        break;
                    case SEARCH_CUSTOMER:
                        if (!Controller.validPhone(customerPhone)) {
                            JOptionPane.showMessageDialog(phoneInputPanel,"Invalid Phone Number");
                            setVisible(false);
                            new HomePageGUI().setVisible(true);
                        }else if(customerName==null) {
                            JOptionPane.showMessageDialog(phoneInputPanel,"This customer is not exist");
                            setVisible(false);
                            new HomePageGUI().setVisible(true);
                        }else{
                            Order[] customerOrders = Controller.searchCustomersDetails(customerPhone);
                            setVisible(false);
                            new ViewCustomerGUI(customerOrders).setVisible(true);
                        }
                }

            }
        });
        add(customerPhoneLabel);
        add(phone);
        add(submit);
    }
}
