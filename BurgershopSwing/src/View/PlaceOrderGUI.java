package View;
import Controler.Controller;
import Model.Order;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    class PlaceOrderGUI extends JFrame {
        private Order order;
        private String orderId;
        private JButton btnCancelOrder;
        private JButton btnCalculatePrice;
        private JButton btnPlaceOrder;
        private JLabel title;
        private JPanel inputPanel;
        private JPanel labelPanel;
        private JPanel idLabelPanel;
        private JPanel customerIDPanel;
        private JLabel idLabel;
        private JLabel cusIdLabel;
        private  JPanel BurgerQtyPanel;
        private JPanel customerNamePanel;
        private JLabel cusNameLabel;
        private JLabel qtyLabel;
        private GridLayout inputLayout;
        private JPanel textInputPanel;
        private  JPanel orderIDPanel;
        private JLabel orderIDLabel;
        private JPanel customerPhoneInputPanel;
        private JTextField customerPhoneInput;
        private JPanel customerNameInputPanel;
        private JTextField customerNameInput;
        private JPanel qtyPanel;
        private JTextField qtyInput;
        private JPanel totalPanel;
        private JLabel total;

        PlaceOrderGUI(Order order){
            setOrder(order);
            setTitle("Place Order Form");
            setSize(800,600);
            setLayout(null);
            setLocationRelativeTo(null);
            getContentPane().setBackground(Color.WHITE);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/th.jpg")));

            //title label
            title = new JLabel("Place Order");
            title.setHorizontalAlignment(JLabel.CENTER);
            title.setBackground(Color.darkGray);
            title.setOpaque(true);
            title.setForeground(Color.BLACK);
            title.setForeground(Color.WHITE);
            title.setFont(new Font("",1,30));
            title.setBounds(0,0,800,70);
            add("North",title);

            //input panel-------------------------------------------------------
            inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            inputPanel.setBounds(50,150,400,600);
            inputPanel.setBackground(Color.WHITE);

            //label panel
            labelPanel = new JPanel(new GridLayout(4,1));
            labelPanel.setBounds(50,150,500,600);
            labelPanel.setBackground(Color.WHITE);

            idLabelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            idLabel = new JLabel("Order ID : ");
            idLabelPanel.setBackground(Color.WHITE);
            idLabel.setFont(new Font("",Font.PLAIN,20));
            idLabelPanel.add(idLabel);
            labelPanel.add(idLabelPanel);

            customerIDPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            customerIDPanel.setBackground(Color.WHITE);
            cusIdLabel = new JLabel("Customer ID : ");
            cusIdLabel.setFont(new Font("",Font.PLAIN,20));
            customerIDPanel.add(cusIdLabel);
            labelPanel.add(customerIDPanel);

            customerNamePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            customerNamePanel.setBackground(Color.WHITE);
            cusNameLabel = new JLabel("Customer Name : ");
            cusNameLabel.setFont(new Font("",Font.PLAIN,20));
            customerNamePanel.add(cusNameLabel);
            labelPanel.add(customerNamePanel);

            BurgerQtyPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            BurgerQtyPanel.setBackground(Color.WHITE);
            qtyLabel = new JLabel("Burger QTY: ");
            qtyLabel.setFont(new Font("",Font.PLAIN,20));
            BurgerQtyPanel.add(qtyLabel);
            labelPanel.add(BurgerQtyPanel);

            inputPanel.add("West",labelPanel);

            // input text panel
            inputLayout = new GridLayout(4,1);
            textInputPanel = new JPanel(inputLayout);
            textInputPanel.setBackground(Color.WHITE);

            orderIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            orderIDPanel.setBackground(Color.WHITE);
            orderId = Controller.generateOrderId();
            orderIDLabel = new JLabel(orderId);
            orderIDLabel.setFont(new Font("",Font.PLAIN,20));
            orderIDPanel.add(orderIDLabel);
            textInputPanel.add(orderIDPanel);

            customerPhoneInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            customerPhoneInputPanel.setBackground(Color.WHITE);
            customerPhoneInput = new JTextField(10);
            customerPhoneInput.setText(order.getPhone());
            customerPhoneInput.setEditable(false);
            customerPhoneInput.setFont(new Font("",Font.PLAIN,20));

            customerNameInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            customerNameInputPanel.setBackground(Color.WHITE);
            customerNameInput = new JTextField(10);
            customerNameInput.setFont(new Font("",Font.PLAIN,20));

            if (order.getCustomerName()!=null) {
                customerNameInput.setText(order.getCustomerName());
                customerNameInput.setEditable(false);
            }else{
                order.setCustomerName(customerNameInput.getText());
            }
            customerPhoneInputPanel.add(customerPhoneInput);
            textInputPanel.add(customerPhoneInputPanel);
            customerNameInputPanel.add(customerNameInput);
            textInputPanel.add(customerNameInputPanel);

            qtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            qtyPanel.setBackground(Color.WHITE);
            qtyInput = new JTextField(5);
            qtyInput.setFont(new Font("",Font.PLAIN,20));
            qtyPanel.add(qtyInput);
            textInputPanel.add(qtyPanel);

            totalPanel = new JPanel(new FlowLayout());
            totalPanel.setBackground(Color.WHITE);
            total = new JLabel("Total value: " + 0.00);
            total.setFont(new Font("", Font.BOLD, 20));
            totalPanel.add(total);
            totalPanel.setBounds(140,450,200,50);

            btnCalculatePrice = new JButton("Calculate Price");
            btnCalculatePrice.setFont(new Font("",Font.PLAIN,17));
            btnCalculatePrice.setFocusable(false);
            btnCalculatePrice.setBackground(Color.darkGray);
            btnCalculatePrice.setForeground(Color.WHITE);
            btnCalculatePrice.setBounds(120,350,250,50);
            btnCalculatePrice.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int qty = Integer.parseInt(qtyInput.getText());
                    if(!order.setBurgerQty(qty)){
                        JOptionPane.showMessageDialog(qtyPanel,"Invalid value for qty");
                    }else{
                        totalPanel.removeAll();
                        int totalPrice = order.getBurgerQty() * 500;
                        JLabel totalFinal = new JLabel("Total value: " + totalPrice);
                        totalFinal.setFont(new Font("", Font.BOLD, 20));
                        totalPanel.add(totalFinal);
                        totalPanel.revalidate();
                    }
                }
            });

            btnPlaceOrder = new JButton("Place Order");
            btnPlaceOrder.setFont(new Font("",Font.PLAIN,17));
            btnPlaceOrder.setFocusable(false);
            btnPlaceOrder.setBackground(Color.darkGray);
            btnPlaceOrder.setForeground(Color.WHITE);
            btnPlaceOrder.setBounds(500,200,250,50);
            btnPlaceOrder.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    order.setCustomerName(customerNameInput.getText());
                    order.setOrderID(orderId);
                    order.setTotal(order.getBurgerQty()* BurgerShop.BURGERPRICE);
                    order.setStatus(BurgerShop.PREPARING);
                    if(Controller.addOrder(order)){
                        setVisible(false);
                        new successFulOrderGUI(order).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(totalPanel,"Model.Order Unsuccessful");
                    }
                }
            });

            btnCancelOrder = new JButton("Cancel Order");
            btnCancelOrder.setFocusable(false);
            btnCancelOrder.setBackground(Color.DARK_GRAY);
            btnCancelOrder.setForeground(Color.WHITE);
            btnCancelOrder.setFont(new Font("",Font.PLAIN,17));
            btnCancelOrder.setBounds(500,270,250,50);
            btnCancelOrder.addActionListener(evt->{
                JOptionPane.showMessageDialog(inputPanel,"Order Canceled");
                setVisible(false);
                new HomePageGUI().setVisible(true);
            });
            inputPanel.add(textInputPanel);
            add(btnCancelOrder);
            add(btnPlaceOrder);
            add(totalPanel);
            add(inputPanel);
            add(btnCalculatePrice);
        }
        public void setOrder(Order order){
            this.order= order;
        }
}
