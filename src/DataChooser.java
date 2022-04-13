import java.time.*;

import javax.naming.Context;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DataChooser extends JFrame implements ActionListener{
	
		static int[] GIORNI_ANNO = {31,28,31,30,31,30,31,31,30,31,30,31};
		static int[] GIORNI_ANNO_BISESTILE = {31,29,31,30,31,30,31,31,30,31,30,31};
		static String[] MESI_NOMI= {"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno",
							"Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
		private String [] NAME_CARD = {"Day","Mouth","Year"};
		private JButton[] dayButton;
		private JButton[] mouthButton;
		private JButton[] yearButton;
		private JButton more,less,manual,confirm,next,previus;
		private JLabel date;
		private Container c;
		private CardLayout card;
		private JButton grillDay;
		private LocalDate app;
		private int cont;
		private Thread t;
		private JPanel prova;
		
		
		public DataChooser() {
			// TODO Auto-generated constructor stub
			super("scelta data");
			t = new Thread(Thread.currentThread());
			t.setName("prova thread");
			dayButton = new JButton[31];
			mouthButton = new JButton[12];
			yearButton= new JButton[15];
			for(int i = 0; i < 31;i++) {
				dayButton[i] = new JButton();
				dayButton[i].setMargin(new Insets(5,5,10,10));
				Integer z = i+1;
				dayButton[i].setText(z.toString());
				dayButton[i].addActionListener(this); 
			}
			for(int i = 0; i < 12;i++) {
				mouthButton[i] = new JButton();
				mouthButton[i].setMargin(new Insets(0,0,0,0));
				mouthButton[i].addActionListener(this);
			}
			for(int i = 0; i < 15;i++) {
				yearButton[i] = new JButton();
				yearButton[i].addActionListener(this);
			}
			c = getContentPane();
			card = new CardLayout();
			more = new JButton(new ImageIcon(new ImageIcon("plus.png").getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT)));
			less = new JButton(new ImageIcon(new ImageIcon("minus.png").getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT)));
			manual = new JButton("inserimento manuale");
			confirm  = new JButton(new ImageIcon(new ImageIcon("check.png").getImage().getScaledInstance(15,15,Image.SCALE_DEFAULT)));
			next  = new JButton(new ImageIcon(new ImageIcon("double-chevron_LX.png").getImage().getScaledInstance(25,135,Image.SCALE_DEFAULT)));
			previus  = new JButton(new ImageIcon(new ImageIcon("double-chevron.png").getImage().getScaledInstance(25,135,Image.SCALE_DEFAULT)));
			app = LocalDate.now();
			date = new JLabel();
			cont = 0;
			prova = new JPanel();
			
			JPanel east = new JPanel();
			JPanel center = new JPanel();
			JPanel center2 = new JPanel();
			JPanel center3 = new JPanel();
			JPanel north = new JPanel();
			JPanel south = new JPanel();
			JPanel west = new JPanel();
			JPanel base = new JPanel();
//			ImageIcon i = new ImageIcon();
			JLabel prova1 = new JLabel("                            ");
			JPanel prova2 = new JPanel();
			JLabel prova3 = new JLabel("                            ");
			JPanel base2 = new JPanel();
			JPanel base3 = new JPanel();
			prova = new JPanel();
			
			prova.setLayout(card);
			base.setLayout(new BorderLayout());
			less.setBorderPainted(false);
			less.setFocusPainted(false);
			more.setBorderPainted(false);
			more.setFocusPainted(false);
			//////////////////////////////NORD\\\\\\\\\\\\\\\\\\\\
			north.add(less);
			north.add(prova1);
			north.add(date);
	//		north.add(prova2);
			north.add(prova3);
			north.add(more);
			////////////////////////////CENTRO\\\\\\\\\\\\\\\\\\\
//			center.setBackground(Color.black);
			
			///////////////////////////ACTION LISTENER\\\\\\\\\\\
			confirm.addActionListener(this);
			manual.addActionListener(this);
			more.addActionListener(this);
			less.addActionListener(this);
			
			
			///////////////////////////////////\\\\\\\\\\\\\\\\\\\\\
			center.setLayout(new GridLayout(5,7));
			for(int j = 0; j < 31; j++) {
				center.add(dayButton[j]);
			}
			//////////////////////////CENTRO2\\\\\\\\\\\\\\\\\\\\\
			{
				JPanel fila1 =new JPanel();
				JPanel fila2 =new JPanel();
				JPanel fila3 =new JPanel();
				JPanel fila4 =new JPanel();
				for (int i = 0; i < 12; i++) {
					mouthButton[i].setText(MESI_NOMI[i]);
				}
				fila1.add(mouthButton[0]);
				fila1.add(mouthButton[1]);
				fila1.add(mouthButton[2]);
				fila2.add(mouthButton[3]);
				fila2.add(mouthButton[4]);
				fila2.add(mouthButton[5]);
				fila3.add(mouthButton[6]);
				fila3.add(mouthButton[7]);
				fila3.add(mouthButton[8]);
				fila4.add(mouthButton[9]);
				fila4.add(mouthButton[10]);
				fila4.add(mouthButton[11]);
				center2.add(fila1);
				center2.add(fila2);
				center2.add(fila3);
				center2.add(fila4);
				
			}
			/////////////////////////CENTRO3\\\\\\\\\\\\\\\\\\\\\\
			{
				center3.setLayout(new GridLayout(5,3));
				setIntervalYear();
				for(int i = 0; i < 15; i++) {
					center3.add(yearButton[i]);
				}
			}
			
			////////////////////////////SUD\\\\\\\\\\\\\\\\\\\\\\\\\
			south.setLayout(new GridLayout(1,2));
			south.add(confirm);
			south.add(manual);
//			east.setLayout(new BorderLayout());
//			east.add(less);
//			west.add(more);
			
//			north.setBackground(Color.black);
			///////////////////////////EST\\\\\\\\\\\\\\\\\\\\\\\\\
			east.add(previus);
			/////////////////////////OVEST\\\\\\\\\\\\\\\\\\\\\\\\\
			west.add(next);
			/////////////////////////BASE\\\\\\\\\\\\\\\\\\\\\\\\\\
			base.setLayout(new BorderLayout());
			base.add(north,"North");
			base.add(west,"West");
			base.add(prova);
			base.add(east,"East");
			base.add(south,"South");
			//////////////////////BASE2\\\\\\\\\\\\\\\\\\\\\\\\\\\
			
			//////////////////////CARD_LAYOUT\\\\\\\\\\\\\\\\\\\\\
			prova.add(center,NAME_CARD[0]);
			prova.add(center2,NAME_CARD[1]);
			prova.add(center3,NAME_CARD[2]);
			c.add(base);
			card.show(prova,NAME_CARD[0]);
			
			setDate(NAME_CARD[0]);
			
			setSize(400,250);
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataChooser.chooser();
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	private void setDate(String curren_panel){
		String s = "";
		if(curren_panel.compareTo(NAME_CARD[0]) == 0)
		{
			s =  MESI_NOMI[app.getMonthValue()-1] +"    " +  app.getYear();
		}
		else if(curren_panel.compareTo(NAME_CARD[1]) == 0)
		{
			s =  app.getDayOfMonth() +"                 " +  app.getYear();
		}
		else if(curren_panel.compareTo(NAME_CARD[2]) == 0)
		{
			s =+ app.getDayOfMonth() + "         " + MESI_NOMI[app.getMonthValue()-1] ;	
		}
		
		date.setText(s);
	}
	
	private void setIntervalYear() {
		for(int i = 0; i < 15; i++) {
			Integer z = app.getYear() - (15-i);
			yearButton[i].setText(z.toString());
		}
	}
	
	public static LocalDate chooser() {
		DataChooser x = new DataChooser();
		x.setVisible(true);
		return x.getApp();
	
	}

	protected LocalDate getApp() {
		return app;
	}
	

	
	
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Object o = e.getSource();
	if(o == confirm) {
		System.out.println("hai cliccato qui");
	}
	else if(o == more)
	{
		cont ++;
		if(cont == 2)
		{
			less.setEnabled(true);
			more.setEnabled(false);
		}
		else if(cont == 1)
		{
			less.setEnabled(true);
			more.setEnabled(true);
		}
		card.show(prova,NAME_CARD[cont]);
		setDate(NAME_CARD[cont]);
	}
	else if(o == less)
	{
		cont --;
		if(cont == 0)
		{
			less.setEnabled(false);
			more.setEnabled(true);
		}
		else if(cont == 1)
		{
			less.setEnabled(true);
			more.setEnabled(true);
		}
		card.show(prova,NAME_CARD[cont]);
		setDate(NAME_CARD[cont]);
	}
}




}
