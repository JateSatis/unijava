package pract4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FootballField extends JFrame {
    int RealMadridScore;
    int ACMilanScore;

    public FootballField() {
        super("AC Milan vs Real Madrid");
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));
        JPanel[] pnl = new JPanel[9];

        for(int i = 0 ; i < pnl.length ; i++)
        {
            pnl[i] = new JPanel();
            add(pnl[i]);
        }


        JButton RealMadridBtn = new JButton("Real Madrid");
        JButton ACMilanBtn = new JButton("AC Milan");

        pnl[0].add(RealMadridBtn);
        pnl[2].add(ACMilanBtn);

        JLabel score = new JLabel("0:0");
        JLabel winner = new JLabel("Draw");
        JLabel lastScorer = new JLabel("None");

        RealMadridBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RealMadridScore += 1;
                lastScorer.setText("RealMadrid");
                score.setText(RealMadridScore + ":" + ACMilanScore);
                winner.setText(defineWinner());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        ACMilanBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ACMilanScore += 1;
                lastScorer.setText("AC Milan");
                score.setText(RealMadridScore + ":" + ACMilanScore);
                winner.setText(defineWinner());
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        pnl[3].add(score);
        pnl[4].add(winner);
        pnl[5].add(lastScorer);


    }

    public String defineWinner() {
        if (this.RealMadridScore > this.ACMilanScore) return "Real Madrid wins";
        else if (this.RealMadridScore < this.ACMilanScore) return "AC Milan wins";
        else return "Draw";
    }

    public static void main(String[] args) {
        new FootballField().setVisible(true);
    }
}
