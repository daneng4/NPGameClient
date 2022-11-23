
// JavaObjClientView.java ObjecStram 기반 Client
//실질적인 채팅 창
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.ImageObserver;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JavaGameClientView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static final int BUF_LEN = 128; // Windows 처럼 BUF_LEN 을 정의
    private Socket socket; // 연결소켓
    private InputStream is;
    private OutputStream os;
    private DataInputStream dis;
    private DataOutputStream dos;

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private Frame frame;
    private FileDialog fd;
    private JButton imgBtn;

    JPanel panel;
    private JLabel lblMouseEvent;
    private Graphics gc;
    private JLabel GameMap;
    private JLabel GameScreen;
    private JLabel UserScreen;
    private JLabel CookieMapImg;

    // 플레이어 1 첫 위치 및 캐릭터 랜덤 결정
    int p1x = 100;
    int p1y = 100;

    // 플레이어 2 첫 위치 및 캐릭터 랜덤 결정
    int p2x = 500;
    int p2y = 500;

    // 캐릭터 이미지 삽입
    private JLabel bazzi = new JLabel(new ImageIcon("image/bazzi_front.png"));
    private JLabel woonie = new JLabel(new ImageIcon("image/woonie_front.png"));

    private ImageIcon btnOutimg = new ImageIcon("image/exit_button.png");
    private ImageIcon gameScreen = new ImageIcon("image/play_bg.png");



    // 게임화면
    public JavaGameClientView(String username, String ip_addr, String port_no)  {
        setResizable(false);

        //전체 pane
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1053, 815);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 전체 맵 배경
        GameScreen = new JLabel(new ImageIcon(gameScreen.getImage()));
        GameScreen.setBorder(null);
        GameScreen.setOpaque(true);
        GameScreen.setBounds(0,0,1040,780);

        // 0과 1중 랜덤으로 한 숫자를 뽑아 맵 결정
        Random random = new Random();
        String map;
        int chooseMap = random.nextInt(2);
        if (chooseMap == 0)
            map = "image/cookiemapbg.png";
        else
            map = "image/woodmapbg.png";


        //게임 screen
        GameMap = new JLabel(new ImageIcon(map));
        GameMap.setBorder(null);
        GameMap.setOpaque(true);
        GameMap.setBounds(24, 52, 783, 678);

        //입장한 유저 screen
        String userscreen = "image/userscreen.png";

        UserScreen = new JLabel(new ImageIcon(userscreen));
        UserScreen.setBorder(null);
        UserScreen.setOpaque(true);
        UserScreen.setBackground(Color.decode("#436EBD"));
        UserScreen.setBounds(600,0,220,600);
        
        //캐릭터들 첫 위치
        firstLocation();

        //나가기 버튼
        JButton Game_btnOut = new JButton(btnOutimg);
        Game_btnOut.setBounds(630, 500, 150, 42);
        Game_btnOut.setBorderPainted(false);
        Game_btnOut.setContentAreaFilled(false);

        contentPane.add(GameMap);
        contentPane.add(GameScreen);
        contentPane.add(Game_btnOut);

        contentPane.add(UserScreen);
        setVisible(true);
    }

    private void firstLocation() {
        // 배찌
        //bazzi.setSize(44, 56);
        bazzi.setBounds(p1x,p1y,44,56);
        // 우니
        //woonie.setSize(44, 56);
        woonie.setBounds(p2x, p2y, 44, 56);

        contentPane.add(bazzi);
        contentPane.add(woonie);
    }

    public void actionPerformed(ActionEvent e) {

    }

}
