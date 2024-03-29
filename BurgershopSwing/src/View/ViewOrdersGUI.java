package View;

import Model.Order;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewOrdersGUI extends JFrame {

    private JTable table;
    private JScrollPane scrollPane;
    private JButton btnHomePage;
    private JButton btnSearchOrder;
    private JLabel title;
    private String[] colNames;
    private DefaultTableModel dtm;
    private String id;
    private String name;
    private String phone;
    private int qty;
    private double price;
    private Object[] data;
    private JPanel btnPanel;
    private JPanel homePagePanel;
    private JPanel searchOrderPanel;
    public ViewOrdersGUI(Order[] orderArray) {
        setTitle("Orders");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

        title = new JLabel("Order Details");
        title.setFont(new Font("",Font.BOLD,25));
        title.setBackground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        add("North",title);

        colNames = new String[]{"Order ID","Customer ID","Customer Name","Burger Quantity","Order Value"};
        dtm = new DefaultTableModel(colNames,0);
        table = new JTable(dtm);
        table.getTableHeader().setBackground(Color.yellow);
        table.getTableHeader().setFont(new Font("",Font.BOLD,15));
        table.setRowHeight(25);
        table.setFont(new Font("",Font.PLAIN,15));
        scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);

        for (int i = 0; i < orderArray.length; i++) {
            id = orderArray[i].getOrderID();
            name = orderArray[i].getCustomerName();
            phone = orderArray[i].getPhone();
            qty = orderArray[i].getBurgerQty();
            price = orderArray[i].getTotal();
            data = new Object[]{id, phone, name, qty, price};
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

        searchOrderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnSearchOrder = new JButton("View Orders");
        btnSearchOrder.setFont(new Font("",Font.PLAIN,17));
        btnSearchOrder.setFocusable(false);
        btnSearchOrder.setForeground(Color.WHITE);
        btnSearchOrder.setBackground(Color.darkGray);
        btnSearchOrder.addActionListener(evt->{
            setVisible(false);
            new SearchOrderGUI().setVisible(true);
        });
        searchOrderPanel.add(btnSearchOrder);
        btnPanel.add("South",searchOrderPanel);


        add("South",btnPanel);
    }
}
