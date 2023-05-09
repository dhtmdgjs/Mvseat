import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Mvseats extends JFrame {
    private Set<Seat> selectedSeats;
    private JButton[][] seatButtons;

    public Mvseats() {
        // 프레임 설정
        setTitle("Cinema Seat Selection");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 5x5 크기의 자리 생성
        Seat[][] seats = new Seat[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seats[i][j] = SeatFactory.createSeat(i, j);
            }
        }

        // 선택한 자리를 저장할 Set
        selectedSeats = new HashSet<>();

        // 자리 버튼 생성
        JPanel seatPanel = new JPanel(new GridLayout(5, 5));
        seatButtons = new JButton[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seatButtons[i][j] = new JButton((i + 1) + "" + (char) ('A' + j));
                seatButtons[i][j].setPreferredSize(new Dimension(60, 60));
                seatButtons[i][j].addActionListener(new SeatButtonListener(seats[i][j], seatButtons[i][j]));
                seatPanel.add(seatButtons[i][j]);
            }
        }
        add(seatPanel, BorderLayout.CENTER);

        // 종료 버튼 생성
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton, BorderLayout.SOUTH);
    }

    // 자리 버튼 클릭 리스너
    class SeatButtonListener implements ActionListener {
        private Seat seat;
        private JButton button;

        public SeatButtonListener(Seat seat, JButton button) {
            this.seat = seat;
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // 이미 선택한 자리인지 확인하기
            if (selectedSeats.contains(seat)) {
                JOptionPane.showMessageDialog(Mvseats.this, "이 좌석은 이미 선택되었습니다.");
            } else {
    // 선택한 자리를 set에 추가하고 버튼 색깔을 변경하기
                selectedSeats.add(seat);
                seat.setSelected(true);
                button.setBackground(Color.GREEN);
            }
        }
    }

    public static void main(String[] args) {
        Mvseats frame = new Mvseats();
        frame.setVisible(true);
    }
}





