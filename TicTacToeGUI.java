import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToeGUI extends JFrame implements ActionListener {
private JButton[][] buttons = new JButton[3][3];
private char currentPlayer = 'X';

public TicTacToeGUI() {
setTitle("Tic Tac Toe");
setSize(400, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new GridLayout(3, 3));

// Initialize buttons
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 3; j++) {
buttons[i][j] = new JButton("");
buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
buttons[i][j].setFocusPainted(false);
buttons[i][j].addActionListener(this);
add(buttons[i][j]);
}
}
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent e) {
JButton clickedButton = (JButton) e.getSource();

if (!clickedButton.getText().equals("")) {
return; // Ignore if already clicked
}
clickedButton.setText(String.valueOf(currentPlayer));
if (checkWin()) {
JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
resetBoard();
} else if (isBoardFull()) {
JOptionPane.showMessageDialog(this, "It's a draw!");
resetBoard();
} else {
currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
}
}

private boolean checkWin() {
// Rows
for (int i = 0; i < 3; i++) {
if (!buttons[i][0].getText().equals("") &&
buttons[i][0].getText().equals(buttons[i][1].getText()) &&
buttons[i][1].getText().equals(buttons[i][2].getText())) {
return true;
}
}
// Columns
for (int j = 0; j < 3; j++) {
if (!buttons[0][j].getText().equals("") &&
buttons[0][j].getText().equals(buttons[1][j].getText()) &&
buttons[1][j].getText().equals(buttons[2][j].getText())) {
return true;
}
}
// Diagonals
if (!buttons[0][0].getText().equals("") &&
buttons[0][0].getText().equals(buttons[1][1].getText()) &&
buttons[1][1].getText().equals(buttons[2][2].getText())) {
return true;
}
if (!buttons[0][2].getText().equals("") &&
buttons[0][2].getText().equals(buttons[1][1].getText()) &&
buttons[1][1].getText().equals(buttons[2][0].getText())) {
return true;
}
return false;
}

private boolean isBoardFull() {
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 3; j++) {
if (buttons[i][j].getText().equals("")) {
return false;
}
}
}
return true;
}
private void resetBoard() {
for (int i = 0; i < 3; i++) {
for (int j = 0; j < 3; j++) {
buttons[i][j].setText("");
}
}
currentPlayer = 'X';
}
public static void main(String[] args) {
new TicTacToeGUI();
}
}
