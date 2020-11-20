import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Window extends JFrame implements KeyListener {

	private static final int W = 200;
	private static final int H = 50;
	private static Game g;
	private JPanel p;
	private JLabel l;
	private JTextField t;

	public Window() {
		setTitle("Smelly Math Game");
		p = new JPanel();
		l = new JLabel("Label", SwingConstants.CENTER);
		t = new JTextField();
		g = new Game(l, t);
	}

	public void render() {
		renderJFrame();
		renderJPanel();
		pack();
		setVisible(true);
		g.setEquation();
	}

	private void renderJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private void renderJPanel() {
		p.setSize(100, 100);
		p.setLayout(new BorderLayout());

		renderJLabel();
		renderJTextField();

		super.add(p);
	}

	private void renderJLabel() {
		l.setPreferredSize(new Dimension(W, H));
		p.add(l, BorderLayout.WEST);
	}

	private void renderJTextField() {
		t.setPreferredSize(new Dimension(W, H));
		t.setHorizontalAlignment(JTextField.CENTER);
		t.addKeyListener(this);
		p.add(t, BorderLayout.EAST);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("Enter");

			if (!(t.getText().trim().equals(""))) {
				g.guess();
				t.setText("");
				g.setEquation();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_W && e.isControlDown()) {
			System.exit(0);
		}

	}

	// JUNK

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
