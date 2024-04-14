package gr.aueb.cf.schoolapp.controllerview;


import gr.aueb.cf.schoolapp.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

public class SearchStudentForm extends JFrame {
    private static final long serialVersionUID = 123456;
    private JPanel contentPane;
    private JTextField lastnameTxt;
    private String lastname = "";

    public SearchStudentForm() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource("eduv2.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setResizable(false);

        setTitle("Μενού Μαθητών");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 449, 481);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        searchPanel.setBounds(32, 23, 355, 170);
        contentPane.add(searchPanel);
        searchPanel.setLayout(null);

        JLabel lastnameLbl = new JLabel("Επώνυμο");
        lastnameLbl.setForeground(new Color(128, 0, 0));
        lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        lastnameLbl.setBounds(139, 11, 70, 35);
        searchPanel.add(lastnameLbl);

        lastnameTxt = new JTextField();
        lastnameTxt.setBounds(66, 46, 216, 35);
        searchPanel.add(lastnameTxt);
        lastnameTxt.setColumns(10);

        JButton searchBtn = new JButton("Αναζήτηση");
        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getUpdateDeleteStudentForm().setVisible(true);
                Main.getSearchStudentForm().setEnabled(false);
                lastname = lastnameTxt.getText();
            }
        });
        searchBtn.setForeground(new Color(0, 0, 255));
        searchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        searchBtn.setBounds(113, 98, 122, 47);
        searchPanel.add(searchBtn);

        JPanel insertPanel = new JPanel();
        insertPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        insertPanel.setBounds(32, 204, 355, 145);
        contentPane.add(insertPanel);
        insertPanel.setLayout(null);

        JButton insertbtn = new JButton("Εισαγωγή");
        insertbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.getInsertStudentForm().setVisible(true);
                Main.getSearchStudentForm().setEnabled(false);
            }
        });
        insertbtn.setForeground(new Color(0, 0, 255));
        insertbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        insertbtn.setBounds(113, 54, 122, 47);
        insertPanel.add(insertbtn);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Main.getMenu().setEnabled(true);
//                Main.getSearchStudentForm().setVisible(false);
                System.exit(0);
            }
        });
        closeBtn.setForeground(new Color(0, 0, 255));
        closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        closeBtn.setBounds(280, 384, 108, 49);
        contentPane.add(closeBtn);
    }

    public String getLastname() {
        return lastname;
    }
}
