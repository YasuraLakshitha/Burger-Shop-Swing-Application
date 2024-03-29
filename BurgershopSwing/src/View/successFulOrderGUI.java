package View;

import Model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;

public class successFulOrderGUI extends JFrame {

    private JButton btnHomePage;
    private JButton btnPlaceOrder;
    private JButton btnUpdateOrder;
    private JLabel titleLabel;
    private  JLabel subLabel;
    private JPanel detailPanel;
    private JPanel orderIdPanel;
    private JLabel orderIdLabel;
    private JPanel customerIdPanel;
    private JLabel customerIdLabel;
    private JPanel customerNamePanel;
    private JLabel customerNameLabel;
    private JPanel burgerQtyPanel;
    private JLabel burgerQtyLabel;
    private JPanel totalValuePanel;
    private JLabel totalValueLabel;
    private JPanel orderStatusPanel;
    private JLabel orderStatusLabel;
    private String status;
    public successFulOrderGUI(Order order) {
        setTitle("Successful Order Details");
        setSize(600,560);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));
        setLayout(null);

        //title label
        titleLabel = new JLabel("Order Details");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(0,0,600,50);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.darkGray);
        titleLabel.setOpaque(true);

        // subtitle label
        subLabel=new JLabel("Order Added Successfully...");
        subLabel.setFont(new Font("",Font.ITALIC,20));
        subLabel.setBounds(180,60,600,50);
        subLabel.setForeground(Color.RED);
        subLabel.setBackground(Color.WHITE);
        subLabel.setOpaque(true);
        add(subLabel);

        //details panel
        detailPanel = new JPanel(new GridLayout(6,1));
        detailPanel.setBounds(200,120,500,200);

        orderIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        orderIdLabel = new JLabel("OrderID                : " + order.getOrderID());
        orderIdLabel.setFont(new Font("",1,15));
        orderIdPanel.add(orderIdLabel);
        orderIdPanel.setBackground(Color.WHITE);
        detailPanel.add(orderIdPanel);

        customerIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerIdLabel = new JLabel("Customer ID        : " + order.getPhone());
        customerIdLabel.setFont(new Font("",1,15));
        customerIdPanel.add(customerIdLabel);
        customerIdPanel.setBackground(Color.WHITE);
        detailPanel.add(customerIdPanel);

        customerNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerNameLabel = new JLabel("Customer Name : " + order.getCustomerName());
        customerNameLabel.setFont(new Font("",1,15));
        customerNamePanel.add(customerNameLabel);
        customerNamePanel.setBackground(Color.WHITE);
        detailPanel.add(customerNamePanel);

        burgerQtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        burgerQtyLabel = new JLabel("Order Quantity   : " + order.getBurgerQty());
        burgerQtyLabel.setFont(new Font("",1,15));
        burgerQtyPanel.setBackground(Color.WHITE);
        burgerQtyPanel.add(burgerQtyLabel);
        detailPanel.add(burgerQtyPanel);

        totalValuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalValueLabel = new JLabel("Total Value         : " + order.getTotal());
        totalValueLabel.setFont(new Font("",1,15));
        totalValuePanel.add(totalValueLabel);
        totalValuePanel.setBackground(Color.WHITE);
        detailPanel.add(totalValuePanel);

        orderStatusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        status = null;
        switch (order.getStatus()){
            case 1:status = "PREPARING";break;
            case 2:status = "DELIVERED";break;
            case 0:status = "CANCELED";break;
        }
        orderStatusLabel = new JLabel("Order Status       : " + status);
        orderStatusLabel.setFont(new Font("",1,15));
        orderStatusPanel.setBackground(Color.WHITE);
        orderStatusPanel.add(orderStatusLabel);
        detailPanel.add(orderStatusPanel);

        //Button Panel
        btnHomePage = new JButton("Home page");
        btnHomePage.setFont(new Font("",Font.PLAIN,17));
        btnHomePage.setForeground(Color.WHITE);
        btnHomePage.setBackground(Color.darkGray);
        btnHomePage.setFocusable(false);
        btnHomePage.setBounds(200,350,200,40);
        btnHomePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePageGUI().setVisible(true);
            }
        });
        add(btnHomePage);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,17));
        btnPlaceOrder.setBounds(200,400,200,40);
        btnPlaceOrder.setBackground(Color.darkGray);
        btnPlaceOrder.setForeground(Color.WHITE);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PhoneGUI(0).setVisible(true);
            }
        });
        add(btnPlaceOrder);

        btnUpdateOrder = new JButton("Update Order");
        btnUpdateOrder.setFont(new Font("",1,15));
        btnUpdateOrder.setBounds(200,450,200,40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.setForeground(Color.WHITE);
        btnUpdateOrder.setBackground(Color.darkGray);
        btnUpdateOrder.addActionListener(evt->{
            setVisible(false);
            new UpdateOrderGUI(order).setVisible(true);
        });
        add(btnUpdateOrder);

        add(detailPanel);
        add(titleLabel);
    }
}



