package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import model.vo.SobremesaVO;

/**
 * Classe que representa uma tela de edição de sobremesas.
 * 
 * @author Vilmar César Pereira Júnior.
 *
 */
public class TelaEdicaoSobremesa extends JFrame {

	//Atributos da tela: componentes 'leves' ('lightweight')
	private JPanel contentPane;
	private JTextField txtNomePesquisa;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JCheckBox cbxLight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEdicaoSobremesa frame = new TelaEdicaoSobremesa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Construtor da tela.
	 */
	public TelaEdicaoSobremesa() {
		setTitle("Edição de sobremesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformeONome = new JLabel("Informe o nome de uma sobremesa:");
		lblInformeONome.setBounds(10, 23, 187, 14);
		contentPane.add(lblInformeONome);
		
		txtNomePesquisa = new JTextField();
		txtNomePesquisa.setBounds(200, 20, 86, 20);
		contentPane.add(txtNomePesquisa);
		txtNomePesquisa.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(296, 19, 71, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(31, 67, 96, 14);
		contentPane.add(lblNome);
		
		JLabel lblPreco = new JLabel("Preço. R$: ");
		lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco.setBounds(31, 103, 96, 14);
		contentPane.add(lblPreco);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(137, 64, 149, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setEnabled(false);
		txtPreco.setBounds(137, 100, 149, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		cbxLight = new JCheckBox("Light");
		cbxLight.setEnabled(false);
		cbxLight.setBounds(126, 138, 97, 23);
		contentPane.add(cbxLight);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(136, 166, 89, 23);
		contentPane.add(btnAtualizar);
		
		// ----------- Listeners (ouvintes) de ações sobre os componentes ----------- //
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO implementar, chamando o Controller
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladoraSobremesa controller = new ControladoraSobremesa();
				try {
					SobremesaVO sobremesaEditavel = controller.consultarSobremesaPorNome(txtNomePesquisa.getText());
					
					if(sobremesaEditavel != null) {
						//Desbloquear todos os campos
						habilitarCamposSobremesa(true);
						
						//Preencher todos os campos 
						preencherCamposSobremesa(sobremesaEditavel);
					}
				} catch (Exception e) {
					//Cuidado ao capturar Exception, pois qualquer exceção gerada será mostrada na tela!
					JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
				}
			}

			/**
			 * Preenche todos os campos da tela com uma sobremesa passada como parâmetro
			 * @param sobremesa
			 */
			private void preencherCamposSobremesa(SobremesaVO sobremesa) {
				txtNome.setText(sobremesa.getNome());
				
				String strPreco = "";
				
				strPreco = String.valueOf(sobremesa.getPreco());
				strPreco = strPreco.replace('.', ',');
				
				txtPreco.setText(strPreco);
				txtNome.setText(sobremesa.getNome());
				cbxLight.setSelected(sobremesa.isLight());
				
			}
			
			/**
			 * Habilita ou desabilita os campos da tela de sobremesa.
			 * @param habilitado
			 */
			private void habilitarCamposSobremesa(boolean habilitado) {
				txtNome.setEnabled(habilitado);
				txtPreco.setEnabled(habilitado);
				cbxLight.setEnabled(habilitado);
			}
		});
	
	}
}
