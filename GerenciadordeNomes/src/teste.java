import javax.swing.*;
import java.awt.*;

public class teste extends JFrame{

    private JButton btnInsert, btnAlterar;
    private JTextField txtNome, txtAntigo, txtNovo;
    private JLabel lblNome, lblAntigo, lblNovo;
    private JFrame jnlPrincipal;
    private Conexao conexao;




    public teste (){
        jnlPrincipal = new JFrame("== Aplicativo Gestor de Nomes ==");
        setSize (400,300);
        jnlPrincipal.setBackground(new Color(24, 9, 236));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);


        //area para inserir o nome
        lblNome = new JLabel("Digite seu nome:");
        lblNome.setBounds(5,10,100,30);
        add(lblNome);
        txtNome = new JTextField();
        txtNome.setBounds(100,10,150,30);
        add(txtNome);
        btnInsert = new JButton("enviar");
        btnInsert.setBounds(250,10,100,30);
        btnInsert.addActionListener(e -> {
            String nome = txtNome .getText();
            conexao = new Conexao();
            conexao.inserir(nome);
            txtNome.setText("");
        });
        add(btnInsert);





          setVisible(true);
    }
    public static void main(String[] args){
        new teste();

    }

}