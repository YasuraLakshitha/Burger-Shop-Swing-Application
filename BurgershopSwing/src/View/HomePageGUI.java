package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageGUI extends JFrame {
    private JButton btnPlaceOrder;
    private JButton btnSearchOrder;
    private JButton btnViewOrders;
    private JButton btnUpdateOrder;
    private JButton btnSearchBestCustomer;
    private JButton btnSearchCustomer;
    private JButton btnExit;
    private ImageIcon img;

    public HomePageGUI() {
        setTitle("Home Page");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

        //button panel
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("", Font.PLAIN, 17));
        btnPlaceOrder.setBackground(Color.DARK_GRAY);
        btnPlaceOrder.setForeground(Color.WHITE);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.setBounds(500, 150, 300, 50);
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
                new PhoneGUI(0).setVisible(true);
            }
        });
        add(btnPlaceOrder);

        btnSearchOrder = new JButton("Search Order");
        btnSearchOrder.setFont(new Font("", Font.PLAIN, 17));
        btnSearchOrder.setBackground(Color.DARK_GRAY);
        btnSearchOrder.setForeground(Color.WHITE);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.setBounds(500, 220, 300, 50);
        btnSearchOrder.addActionListener(evt->{
            setVisible(false);
            new SearchOrderGUI().setVisible(true);
        });
        add(btnSearchOrder);

        btnViewOrders = new JButton("View Orders");
        btnViewOrders.setFont(new Font("", Font.PLAIN, 17));
        btnViewOrders.setBackground(Color.DARK_GRAY);
        btnViewOrders.setForeground(Color.WHITE);
        btnViewOrders.setFocusable(false);
        btnViewOrders.setBounds(500, 290, 300, 50);
        btnViewOrders.addActionListener(evt->{
           setVisible(false);
           new OrderSelectingFromGUI().setVisible(true);
        });
        add(btnViewOrders);

        btnUpdateOrder = new JButton("Update Order");
        btnUpdateOrder.setFont(new Font("", Font.PLAIN, 17));
        btnUpdateOrder.setBackground(Color.DARK_GRAY);
        btnUpdateOrder.setForeground(Color.WHITE);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.setBounds(500, 360, 300, 50);
        btnUpdateOrder.addActionListener(evt->{
            setVisible(false);
            new SearchOrderGUI().setVisible(true);
        });
        add(btnUpdateOrder);

        btnSearchBestCustomer = new JButton("Best Customer");
        btnSearchBestCustomer.setFont(new Font("",Font.PLAIN,17));
        btnSearchBestCustomer.setFocusable(false);
        btnSearchBestCustomer.setBounds(500,430,300,50);
        btnSearchBestCustomer.setBackground(Color.darkGray);
        btnSearchBestCustomer.setForeground(Color.WHITE);
        btnSearchBestCustomer.addActionListener(evt->{
            setVisible(false);
            new BestCustomerGUI().setVisible(true);
        });
        add(btnSearchBestCustomer);

        btnSearchCustomer = new JButton("Search Customer");
        btnSearchCustomer.setFont(new Font("",Font.PLAIN,17));
        btnSearchCustomer.setBounds(500,500,300,50);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.setForeground(Color.WHITE);
        btnSearchCustomer.setBackground(Color.darkGray);
        btnSearchCustomer.addActionListener(evt->{
           setVisible(false);
           new PhoneGUI(1).setVisible(true);
        });
        add(btnSearchCustomer);

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("",Font.PLAIN,17));
        btnExit.setBackground(Color.darkGray);
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusable(false);
        btnExit.setBounds(500,570,300,50);
        btnExit.addActionListener(evt->{
            System.exit(0);
        });
        add(btnExit);

        JLabel title = new JLabel("Welcome to BurgerShop");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("", 1, 40));
        title.setOpaque(true);
        title.setBackground(Color.darkGray);
        title.setForeground(Color.WHITE);
        title.setBounds(0, 0, 900, 100);

        img = new ImageIcon(getClass().getResource("/image/burger.jpg"));
        Image image = img.getImage();
        Image scaledImg = image.getScaledInstance(800,650,Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledImg);
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(100,150,300,450);
        add(imgLabel);

        add(title);
    }
}
