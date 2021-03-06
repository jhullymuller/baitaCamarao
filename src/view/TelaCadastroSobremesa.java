package view;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladoraSobremesa;

/**
 * Classe que representa uma tela de cadastro de sobremesas.
 * 
 * @author Vilmar César Pereira Júnior.
 *
 */
public class TelaCadastroSobremesa extends JFrame {

	// Atributos da tela: componentes 'leves' ('lightweight')
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPreco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroSobremesa frame = new TelaCadastroSobremesa();
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
	public TelaCadastroSobremesa() {
		setTitle("Cadastro de nova sobremesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(10, 40, 69, 14);
		contentPane.add(lblNome);

		JLabel lblPreco = new JLabel("Preço. R$");
		lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco.setBounds(10, 65, 69, 14);
		contentPane.add(lblPreco);

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_C) {
					JOptionPane.showMessageDialog(null, "Errou!!");
				}
			}
		});
		txtNome.setBounds(85, 37, 165, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setToolTipText("Informe um valor separado com vírgula");
		txtPreco.setBounds(85, 62, 165, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		final JCheckBox checkLight = new JCheckBox("Light");
		checkLight.setBounds(85, 89, 97, 23);
		contentPane.add(checkLight);

		JButton btnSalvar = new JButton("Salvar");

		// Listener (ouvinte) de ação de mouse sobre o botão "Salvar"
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				ControladoraSobremesa controller = new ControladoraSobremesa();
				String mensagemRetorno = controller.salvar(txtNome.getText(), txtPreco.getText(),
						checkLight.isSelected());

				JOptionPane.showMessageDialog(null, mensagemRetorno);

			}
		});
		btnSalvar.setBounds(85, 129, 89, 23);
		contentPane.add(btnSalvar);
	}
}