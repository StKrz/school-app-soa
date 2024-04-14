package gr.aueb.cf.schoolapp.controllerview;

import gr.aueb.cf.schoolapp.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class SearchUserForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userTxt;
    private String username = "";

    public SearchUserForm() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                userTxt.setText("");
            }
        });
//        setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/resources/eduv2.png")));
//        setIconImage(Toolkit.getDefaultToolkit().getImage(url))
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("eduv2.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setTitle("Αναζήτηση Χρήστη");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel userLbl = new JLabel("Όνομα Χρήστη");
        userLbl.setForeground(new Color(128, 0, 0));
        userLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
        userLbl.setBounds(142, 27, 144, 35);
        contentPane.add(userLbl);

        userTxt = new JTextField();
        userTxt.setForeground(new Color(192, 192, 192));
        userTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
        userTxt.setText("Εισάγετε Username");
        userTxt.setBounds(112, 84, 195, 43);
        contentPane.add(userTxt);
        userTxt.setColumns(10);

        JButton closeBtn_1 = new JButton("Close");
        closeBtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Main.getMenu().setVisible(true);
//                Main.getSearchUsers().setEnabled(false);
//                Main.getSearchUsers().setVisible(false);
                System.exit(0);
            }
        });
        closeBtn_1.setForeground(Color.BLUE);
        closeBtn_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        closeBtn_1.setBounds(307, 204, 108, 49);
        contentPane.add(closeBtn_1);

        JButton searchBtn = new JButton("Αναζήτηση");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getUpdateDeleteUserForm().setVisible(true);
                Main.getSearchUsers().setEnabled(false);
                username = userTxt.getText().trim();
            }
        });
        searchBtn.setForeground(Color.BLUE);
        searchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchBtn.setBounds(154, 150, 120, 49);
        contentPane.add(searchBtn);
    }

    public String getUser() {
        return username;
    }
}
