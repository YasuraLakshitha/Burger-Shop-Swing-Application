package View;
import Controler.Controller;
import Model.Order;
import javax.swing.*;
import java.awt.*;

public class OrderSelectingFromGUI extends JFrame {

    private JButton btnViewOrders;
    private JComboBox typeBox;
    private JPanel inputPanel;
    private JPanel typeLabelPanel;
    private JLabel typeLabel;
    private String[] type;
    private JPanel typeBoxPanel;
    private Order[] orderArray;
    public OrderSelectingFromGUI(){
        setTitle("Order Type Selecting Form");
        setSize(350,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));
        setLocationRelativeTo(null);
        setLayout(null);

        inputPanel = new JPanel(new GridLayout(1,2));
        inputPanel.setBounds(30,70,300,100);

        typeLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typeLabel = new JLabel("Enter the type");
        typeLabel.setFont(new Font("",Font.PLAIN,20));
        typeLabelPanel.add(typeLabel);
        inputPanel.add(typeLabelPanel);

        type = new String[]{"PREPARING","DELIVERED","CANCEL"};
        typeBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typeBox = new JComboBox(type);
        typeBoxPanel.add(typeBox);
        inputPanel.add(typeBoxPanel);

        btnViewOrders = new JButton("View Orders");
        btnViewOrders.setFont(new Font("",Font.PLAIN,17));
        btnViewOrders.setBounds(75,140,180,50);
        btnViewOrders.setFocusable(false);
        btnViewOrders.setBackground(Color.darkGray);
        btnViewOrders.setForeground(Color.WHITE);
        btnViewOrders.addActionListener(evt->{
            if(typeBox.getSelectedItem().toString().equals("PREPARING")){
                orderArray =Controller.getPreparedOrders();
            } else if (typeBox.getSelectedItem().toString().equals("DELIVERED")) {
                orderArray =Controller.getDeliveredOrders();
            }else{
                orderArray = Controller.getCanceledOrders();
            }
            setVisible(false);

            if (orderArray.length>0) {
                new ViewOrdersGUI(orderArray).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(inputPanel,"There is no orders on this type");
                new SearchOrderGUI().setVisible(true);
            }
        });

        add(btnViewOrders);
        add(inputPanel);
    }
}
