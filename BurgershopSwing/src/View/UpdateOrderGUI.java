package View;
import Model.Order;
import javax.swing.*;
import java.awt.*;

public class UpdateOrderGUI extends JFrame {
    private JButton btnUpdate;
    private JLabel titleLabel;
    private JPanel detailPanel;
    private JPanel orderIdPanel;
    private JLabel orderIdLabel;
    private JPanel customerIdPanel;
    private JLabel customerIdLabel;
    private JPanel customerNamePanel;
    private JLabel customerNameLabel;
    private JPanel qtyPanel;
    private JPanel burgerQtyPanel;
    private JLabel burgerQtyLabel;
    private JPanel burgerQtyInputPanel;
    private JTextField qtyInput;
    private String[] statusArray;
    private JPanel orderStatesPanel;
    private JLabel orderStatusLabel;
    private JComboBox statusBox;
    public UpdateOrderGUI(Order order) {
        setTitle("Update Order Details");
        setSize(600,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

        //title label
        titleLabel = new JLabel("Order Details");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setBackground(Color.darkGray);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setBounds(0,0,600,50);

        //details panel
        detailPanel = new JPanel(new GridLayout(5,1));
        detailPanel.setBounds(200,90,500,200);
        detailPanel.setBackground(Color.WHITE);

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

        qtyPanel = new JPanel(new GridLayout(1,2));
        qtyPanel.setBounds(200,210,245,30);

        burgerQtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        burgerQtyLabel = new JLabel("Order Quantity : ");
        burgerQtyLabel.setFont(new Font("",1,15));
        burgerQtyPanel.setBackground(Color.WHITE);
        burgerQtyPanel.add(burgerQtyLabel);
        qtyPanel.add(burgerQtyPanel);

        burgerQtyInputPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        qtyInput = new JTextField(6);
        qtyInput.setFont(new Font("",1,15));
        qtyInput.setText(order.getBurgerQty()+"");
        burgerQtyInputPanel.add(qtyInput);
        burgerQtyInputPanel.setBackground(Color.WHITE);
        qtyPanel.add(burgerQtyInputPanel);

        statusArray = new String[]{"PREPARING","CANCEL","DELIVERED"};
        orderStatesPanel = new JPanel(new GridLayout(1,2));
        orderStatesPanel.setBounds(205,250,300,30);

        orderStatusLabel = new JLabel("Order Status       : " );
        orderStatusLabel.setFont(new Font("",1,15));
        statusBox = new JComboBox(statusArray);
        orderStatesPanel.add(orderStatusLabel);
        orderStatesPanel.setBackground(Color.WHITE);
        statusBox.setBackground(Color.WHITE);
        orderStatesPanel.add(statusBox);

        //Update button
        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("",1,15));
        btnUpdate.setFocusable(false);
        btnUpdate.setBackground(Color.darkGray);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBounds(200,350,150,40);
        btnUpdate.addActionListener(evt->{
            order.setBurgerQty(Integer.parseInt(qtyInput.getText()));
            order.setTotal(Integer.parseInt(qtyInput.getText())* BurgerShop.BURGERPRICE);
           int status = 0;
           switch(statusBox.getSelectedItem().toString()){
               case "PREPARING" : status = 1;break;
               case "DELIVERED" : status = 2;break;
           }
           order.setStatus(status);
           setVisible(false);
           new UpdatedOrderDetailsGUI(order).setVisible(true);
        });

        add(btnUpdate);
        add(qtyPanel);
        add(orderStatesPanel);
        add(detailPanel);
        add(titleLabel);
    }
}
