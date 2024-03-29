package View;
import Model.Order;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderDetailsGUI extends JFrame {
    private String status;
    private JButton btnHomePage;
    private JButton btnSearchOrder;
    private JButton btnUpdateOrder;
    private JLabel titleLabel;
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
    private JPanel soPanel;
    public OrderDetailsGUI(Order order) {
        setTitle("Order Details");
        setSize(600,530);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));
        setLocationRelativeTo(null);
        setLayout(null);

        //title label
        titleLabel = new JLabel("Order Details");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBounds(0,0,600,50);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.darkGray);
        titleLabel.setOpaque(true);

        //details panel
        detailPanel = new JPanel(new GridLayout(6,1));
        detailPanel.setBounds(200,90,400,200);

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
        btnHomePage.setBounds(200,320,200,40);
        btnHomePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePageGUI().setVisible(true);
            }
        });
        add(btnHomePage);

        soPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSearchOrder = new JButton("Search Order");
        btnSearchOrder.setFont(new Font("",Font.PLAIN,17));
        btnSearchOrder.setBounds(200,370,200,40);
        btnSearchOrder.setBackground(Color.darkGray);
        btnSearchOrder.setForeground(Color.WHITE);
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SearchOrderGUI().setVisible(true);
            }
        });
        add(btnSearchOrder);

        btnUpdateOrder = new JButton("Update Order");
        btnUpdateOrder.setFont(new Font("",1,15));
        btnUpdateOrder.setBounds(200,420,200,40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.setForeground(Color.WHITE);
        btnUpdateOrder.setBackground(Color.darkGray);
        btnUpdateOrder.addActionListener(evt->{
            if (order.getStatus()==1) {
                setVisible(false);
                new UpdateOrderGUI(order).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(soPanel,"This order is either canceled or delivered");
            }
        });
        add(btnUpdateOrder);

        add(detailPanel);
        add(titleLabel);
    }
}