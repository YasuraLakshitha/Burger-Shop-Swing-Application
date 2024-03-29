package View;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatedOrderDetailsGUI  extends JFrame {
    private JButton btnHomePage;
    private JButton btnUpdateThisOrder;
    private JButton btnUpdateAnotherOrder;
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
    private String status;
    public UpdatedOrderDetailsGUI(Order order) {
        setTitle("Updated Order Details");
        setSize(600, 520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));
        setLayout(null);

        //title label
        titleLabel = new JLabel("Order Details");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBounds(0, 0, 600, 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(Color.darkGray);
        titleLabel.setOpaque(true);

        //details panel
        detailPanel = new JPanel(new GridLayout(6, 1));
        detailPanel.setBounds(200, 90, 500, 200);
        detailPanel.setBackground(Color.WHITE);

        orderIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        orderIdLabel = new JLabel("OrderID                : " + order.getOrderID());
        orderIdLabel.setFont(new Font("", 1, 15));
        orderIdPanel.setBackground(Color.WHITE);
        orderIdPanel.add(orderIdLabel);
        detailPanel.add(orderIdPanel);

        customerIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerIdLabel = new JLabel("Customer ID        : " + order.getPhone());
        customerIdLabel.setFont(new Font("", 1, 15));
        customerIdPanel.setBackground(Color.WHITE);
        customerIdPanel.add(customerIdLabel);
        detailPanel.add(customerIdPanel);

        customerNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        customerNameLabel = new JLabel("Customer Name : " + order.getCustomerName());
        customerNameLabel.setFont(new Font("", 1, 15));
        customerNamePanel.setBackground(Color.WHITE);
        customerNamePanel.add(customerNameLabel);
        detailPanel.add(customerNamePanel);

        burgerQtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        burgerQtyLabel = new JLabel("Order Quantity   : " + order.getBurgerQty());
        burgerQtyLabel.setFont(new Font("", 1, 15));
        burgerQtyPanel.add(burgerQtyLabel);
        burgerQtyPanel.setBackground(Color.WHITE);
        detailPanel.add(burgerQtyPanel);

        totalValuePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalValueLabel = new JLabel("Total Value         : " + order.getTotal());
        totalValueLabel.setFont(new Font("", 1, 15));
        totalValuePanel.add(totalValueLabel);
        totalValuePanel.setBackground(Color.WHITE);
        detailPanel.add(totalValuePanel);

        orderStatusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        orderStatusPanel.setBackground(Color.WHITE);
        status = "";
        switch (order.getStatus()) {
            case 1:
                status = "PREPARING";
                break;
            case 2:
                status = "DELIVERED";
                break;
            case 0:
                status = "CANCELED";
                break;
        }
        orderStatusLabel = new JLabel("Order Status       : " + status);
        orderStatusLabel.setFont(new Font("", 1, 15));
        orderStatusPanel.add(orderStatusLabel);
        detailPanel.add(orderStatusPanel);

        //Button Panel

        btnHomePage = new JButton("Home page");
        btnHomePage.setFocusable(false);
        btnHomePage.setBackground(Color.darkGray);
        btnHomePage.setForeground(Color.WHITE);
        btnHomePage.setBounds(200,310,200,40);
        btnHomePage.setFont(new Font("", 1, 15));
        btnHomePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePageGUI().setVisible(true);
            }
        });
        add(btnHomePage);

        btnUpdateThisOrder = new JButton("Update Order");
        btnUpdateThisOrder.setFont(new Font("", 1, 15));
        btnUpdateThisOrder.setFocusable(false);
        btnUpdateThisOrder.setBackground(Color.darkGray);
        btnUpdateThisOrder.setForeground(Color.WHITE);
        btnUpdateThisOrder.setBounds(200,370,200,40);
        btnUpdateThisOrder.setFont(new Font("", 1, 15));
        btnUpdateThisOrder.addActionListener(evt->{
            if (order.getStatus()==1) {
                setVisible(false);
                new UpdateOrderGUI(order).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(orderStatusPanel,"This Order is either canceled or delivered");
                setVisible(false);
                new HomePageGUI().setVisible(true);
            }
        });
        add(btnUpdateThisOrder);

        btnUpdateAnotherOrder = new JButton("Update Another Order");
        btnUpdateAnotherOrder.setFont(new Font("", 1, 15));
        btnUpdateAnotherOrder.setFocusable(false);
        btnUpdateAnotherOrder.setBackground(Color.darkGray);
        btnUpdateAnotherOrder.setForeground(Color.WHITE);
        btnUpdateAnotherOrder.setBounds(200,430,200,40);
        btnUpdateAnotherOrder.setFont(new Font("", 1, 15));
        btnUpdateAnotherOrder.addActionListener(evt -> {
            setVisible(false);
            new SearchOrderGUI().setVisible(true);
        });
        add(btnUpdateAnotherOrder);

        add(detailPanel);
        add(titleLabel);
    }
}
