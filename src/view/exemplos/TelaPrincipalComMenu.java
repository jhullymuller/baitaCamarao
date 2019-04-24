package view.exemplos;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import view.exemplos.paineis.InternalFrameCadastroProduto;
import view.exemplos.paineis.PanelListagemClientes;

public class TelaPrincipalComMenu extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalComMenu frame = new TelaPrincipalComMenu();
					// Inicializa a tela principal MAXIMIZADA
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

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
	public TelaPrincipalComMenu() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaPrincipalComMenu.class.getResource("/icones/icons8-сharlie-сhaplin.png")));
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar mbPrincipal = new JMenuBar();
		setJMenuBar(mbPrincipal);

		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setIcon(new ImageIcon(TelaPrincipalComMenu.class.getResource("/icones/icons8-comprar.png")));
		mbPrincipal.add(mnProdutos);

		JMenuItem mntmCadastrarProduto = new JMenuItem("Cadastrar");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Chamo o Painel DesktopPane (para mostrar as janelas internas)
				setContentPane(desktopPane);

				// Adiciona a tela de cadastro no painel principal (janela interna)
				InternalFrameCadastroProduto telaCadastro = new InternalFrameCadastroProduto();
				desktopPane.add(telaCadastro);

				// Maximiza o novo frame
				// desktopPane.getDesktopManager().maximizeFrame(telaCadastro);

				// Mostra o frame interno
				telaCadastro.show();
			}
		});
		mntmCadastrarProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCadastrarProduto.setIcon(new ImageIcon(
				TelaPrincipalComMenu.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		mnProdutos.add(mntmCadastrarProduto);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmListar.setIcon(new ImageIcon(TelaPrincipalComMenu.class.getResource("/icones/icons8-cardápio.png")));
		mnProdutos.add(mntmListar);

		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(TelaPrincipalComMenu.class.getResource("/icones/icons8-usuário.png")));
		mbPrincipal.add(mnClientes);

		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO trocar o PAINEL
				PanelListagemClientes telaListagemClientes = new PanelListagemClientes();
				setContentPane(telaListagemClientes);
			}
		});
		mntmCadastrarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmCadastrarCliente.setIcon(new ImageIcon(
				TelaPrincipalComMenu.class.getResource("/icones/icons8-adicionar-usuário-masculino.png")));
		mnClientes.add(mntmCadastrarCliente);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		desktopPane = new JDesktopPane();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Constrói o desktopPane com tamanho relativo à tela
		desktopPane.setBounds(10, 10, screenSize.width - 40, screenSize.height - 150);
		contentPane.add(desktopPane);
	}
}
