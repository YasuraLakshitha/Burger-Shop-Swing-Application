package View;

import Model.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewCustomerGUI extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnHomePage;
    private JButton btnSearchCustomer;
    private JPanel textPanel;
    private JPanel titlePanel;
    private JLabel title;
    private JPanel namePanel;
    private JLabel customerName;
    private JPanel idPanel;
    private JLabel orderId;
    private String[] colNames;
    private DefaultTableModel dtm;
    private JPanel btnPanel;
    private JPanel homePagePanel;
    private JPanel searchCustomerPanel;
    public ViewCustomerGUI(Order[] customerOrders) {
        setTitle("Customer Details");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

        textPanel =new JPanel(new GridLayout(3,1));

        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title = new JLabel("Customer Details");
        title.setFont(new Font("",Font.BOLD,25));
        title.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(title);
        titlePanel.setBackground(Color.WHITE);
        textPanel.add(titlePanel);

        namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        customerName  = new JLabel("Name: "+ customerOrders[0].getCustomerName() );
        customerName.setFont(new Font("",Font.BOLD,15));
        namePanel.setBackground(Color.WHITE);
        namePanel.add(customerName);
        textPanel.add(namePanel);

        idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        orderId = new JLabel("Order ID : "+customerOrders[0].getOrderID());
        orderId.setFont(new Font("",Font.BOLD,15));
        idPanel.setBackground(Color.WHITE);
        idPanel.add(orderId);
        textPanel.add(idPanel);

        add("North",textPanel);

        colNames = new String[]{"Order ID","Burger Quantity","Order Value"};
        dtm = new DefaultTableModel(colNames,0);
        table = new JTable(dtm);
        table.getTableHeader().setBackground(Color.yellow);
        table.getTableHeader().setFont(new Font("",Font.BOLD,15));
        table.setRowHeight(25);
        table.setFont(new Font("",Font.PLAIN,15));
        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        add("Center",scrollPane);

        for (int i = 0; i < customerOrders.length; i++) {
            String id = customerOrders[i].getOrderID();
            int qty = customerOrders[i].getBurgerQty();
            double price = customerOrders[i].getTotal();
            Object[] data = {id,qty, price};
            dtm.addRow(data);
        }
        table.setEnabled(false);

        //button panel
        btnPanel = new JPanel(new GridLayout(1,2));
        homePagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnHomePage = new JButton("Home Page");
        btnHomePage.setFont(new Font("",Font.PLAIN,17));
        btnHomePage.setFocusable(false);
        btnHomePage.setForeground(Color.WHITE);
        btnHomePage.setBackground(Color.darkGray);
        btnHomePage.addActionListener(evt->{
            setVisible(false);
            new HomePageGUI().setVisible(true);
        });
        homePagePanel.add(btnHomePage);
        btnPanel.add(homePagePanel);

        searchCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnSearchCustomer = new JButton("Search Customer");
        btnSearchCustomer.setFont(new Font("",Font.PLAIN,17));
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.setForeground(Color.WHITE);
        btnSearchCustomer.setBackground(Color.darkGray);
        btnSearchCustomer.addActionListener(evt->{
            setVisible(false);
            new PhoneGUI(1).setVisible(true);
        });
        searchCustomerPanel.add(btnSearchCustomer);
        btnPanel.add(searchCustomerPanel);

        add("South",btnPanel);
    }
}
