import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeloBancario {

    private JPanel panel1;
    private JButton btnRealizarSaque;
    private JButton btnRealizarDeposito;
    private JTextField txtMensagem;
    private JButton btnLimpar;
    private JTextField txtSaque;
    private JTextField txtDepositar;
    private JLabel labelSaldo;
    private JLabel lblReais;
    private JLabel lblSaque;
    private JLabel lblDepositar;
    private JLabel lblMensagem;


    double saldo = 500.0;
    double saldoFornecido = 0.0;


    public ModeloBancario() {
        lblReais.setText("R$ " + String.format("%.2f", saldo));
        btnRealizarDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lblDepositar.getText().replace(",", ".").isEmpty()) {
                    txtMensagem.setText("Insira um valor");
                    return;
                }
                try {
                    saldoFornecido = Double.parseDouble(txtDepositar.getText().replace(",", "."));
                    if (saldoFornecido > 1000.00) {
                        txtMensagem.setText("acima do limite");
                    } else if (saldoFornecido < 0) {
                        txtMensagem.setText("Valor negativo");
                    } else {
                        txtMensagem.setText("Sucesso");
                        saldo = saldo + saldoFornecido;
                        lblReais.setText("R$ " + String.format("%.2f", saldo));
                        saldoFornecido = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    txtMensagem.setText("Insira apenas numeros");
                }
            }
        });


        btnRealizarSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lblSaque.getText().replace(",", ".").isEmpty()) {
                    txtMensagem.setText("Insira um valor");
                    return;
                }
                try {
                    saldoFornecido = Double.parseDouble(txtSaque.getText().replace(",", "."));
                    if (saldoFornecido > 1000.00) {
                        txtMensagem.setText("acima do limite");
                    } else if (saldoFornecido < 0) {
                        txtMensagem.setText("insira somente valores positivos");
                    } else {
                        txtMensagem.setText("sucesso");
                        saldo = saldo - saldoFornecido;
                        lblReais.setText("R$ " + String.format("%.2f", saldo));
                        saldoFornecido = 0.0;
                    }
                } catch (NumberFormatException ex) {
                    txtMensagem.setText("insira apenas numeros");
                }
            }
        });


        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSaque.setText("");
                txtDepositar.setText("");
                txtMensagem.setText("");
            }
        });
    }


            public static void main(String[] args) {
                JFrame frame = new JFrame("Modelo Bancario");
                frame.setContentPane(new ModeloBancario().panel1);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);
                frame.setVisible(true);

            }

        }

