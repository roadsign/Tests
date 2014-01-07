package questao3;

import java.applet.Applet;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Main extends Applet implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton button;
	private TextField input;
	
	public void init(){
		FlowLayout layout = new FlowLayout(); 
		setLayout(layout);
		layout.setHgap(10);
		layout.setAlignment(FlowLayout.CENTER);
		setSize(500,200);
		
		Label label = new Label("Escreva a frase:");
		input = new TextField();
		input.setColumns(30);
		button = new JButton("Mostrar informacoes");
		button.addActionListener(this);
		/*Label info = new Label("<br>bcdHGA DHavdu aishfo <br>iahs fbskjaihsfoi hasd f");
		info.setAlignment((int)Label.BOTTOM_ALIGNMENT);
		info.setSize(200, 50);*/
		
		add(label);
		add(input);
		add(button);
		//add(info);
	
	}

	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == button){
			if (input.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Escreva uma frase!");
			else{
				Frase frase = new Frase(input.getText());
				StringBuffer buffer = new StringBuffer();
				buffer.append("Numero de vogais: " + frase.getNumVogais());
				buffer.append("\nNumero de consoantes: " + frase.getNumConsoantes());
				buffer.append("\nNumero de espacos: " + frase.getNumEspacos());
				buffer.append("\nTotal de caracteres: " + frase.toString().length());
				buffer.append("\nFrase ordenada: "+ frase.ordena());
				JOptionPane.showMessageDialog(null, buffer.toString());
			}
		}
		
	}

	/*public void paint (Graphics g){
		super.paint(g);
		
		g.drawString("ABCD", 50, 50);
	}*/

}
