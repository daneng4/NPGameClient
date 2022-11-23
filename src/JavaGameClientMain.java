// JavaObjClient.java
// ObjecStream 사용하는 채팅 Client

import com.sun.tools.javac.Main;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class JavaGameClientMain extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel contentPane;
    private JTextField txtUserName;
    private JTextField txtIpAddress;
    private JTextField txtPortNumber;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JavaGameClientMain frame = new JavaGameClientMain();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JavaGameClientMain() {

        Font font1 = new Font("SansSerif", Font.BOLD, 20);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1280, 720);
        contentPane = new JLabel();
        contentPane = new JLabel(new ImageIcon("image/loginimg.png"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel(new ImageIcon("image/id.png"));
        lblNewLabel.setBounds(340, 300, 553, 58);
        contentPane.add(lblNewLabel);

        txtUserName = new JTextField();
        txtUserName.setFont(font1);
        txtUserName.setHorizontalAlignment(SwingConstants.LEFT);
        txtUserName.setBounds(565, 310, 320, 35);
        contentPane.add(txtUserName);
        txtUserName.setColumns(10);
        txtUserName.setBorder(null);



        JButton btnConnect = new JButton("게임시작");
        btnConnect = new JButton(new ImageIcon("image/start_button.png"));
        btnConnect.setBounds(550, 500, 179, 56);
        contentPane.add(btnConnect);
        Myaction action = new Myaction();
        btnConnect.addActionListener(action);
        txtUserName.addActionListener(action);
    }
    class Myaction implements ActionListener // 내부클래스로 액션 이벤트 처리 클래스
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = txtUserName.getText().trim();
            String ip_addr = "127.0.0.1";
            String port_no = "30000";
            JavaGameClientView view = new JavaGameClientView(username, ip_addr, port_no);
            setVisible(false);
        }
    }
}


