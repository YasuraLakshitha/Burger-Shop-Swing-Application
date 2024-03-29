package View;

import Controler.Controller;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BestCustomerGUI extends JFrame {

    private String customerID;
    private String customerName;
    private double orderValue;
    private JTable table;
    private JScrollPane tableScrollPane;
    private DefaultTableModel dtm;
    private JButton btnHomePage;
    private JLabel title;
    private String[] columns;
    private Object[] customerData;
    private JPanel btnHomePagePanel;

    public BestCustomerGUI(){
        setTitle("Best Customer");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        title = new JLabel("Best Customer");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("",Font.BOLD,30));
        title.setBackground(Color.WHITE);
        add("North",title);

        //table
        columns = new String[]{" CustomerID", "Name", "Total"};
        dtm = new DefaultTableModel(columns,0);
        table = new JTable(dtm);
        table.getTableHeader().setBackground(Color.yellow);
        table.getTableHeader().setFont(new Font("",Font.BOLD,15));
        table.setRowHeight(25);
        table.setFont(new Font("",Font.PLAIN,15));

        tableScrollPane = new JScrollPane(table);
        tableScrollPane.getViewport().setBackground(Color.WHITE);
        add("Center",tableScrollPane);
        Controller.removeDuplicates();
        Controller.sort();
        for (int i = 0; i < Controller.sorted.length; i++) {
            customerID = Controller.sorted[i].getOrderID();
            customerName = Controller.sorted[i].getCustomerName();
            orderValue = Controller.sorted[i].getTotal();
            customerData = new Object[]{customerID,customerName,orderValue};
            System.out.println(customerName);
            dtm.addRow(customerData);
        }
        table.setEnabled(false);

        //button Panel
        btnHomePagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnHomePage = new JButton("Home Page");
        btnHomePage.setFont(new Font("",Font.PLAIN,17));
        btnHomePage.setFocusable(false);
        btnHomePage.setBackground(Color.darkGray);
        btnHomePage.setForeground(Color.WHITE);
        btnHomePage.addActionListener(evt->{
            setVisible(false);
            new HomePageGUI().setVisible(true);
        });
        btnHomePagePanel.add(btnHomePage);
        add("South",btnHomePagePanel);

    }
}
