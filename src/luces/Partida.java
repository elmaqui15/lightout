package luces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Partida extends JFrame{
    
    private Entorno mEntorno = new Entorno(8);
    private Tablero mTablero = new Tablero(8);
    private JPanel panel = new JPanel();
    private int patronseleccionado; 
    private boolean finJuego;
    // 0 - patron estandar
    // 1 - patron flip flop
    // 2 - patron diagonal
    
    public Partida() {
    	patronseleccionado = 0;
    	finJuego = false;
    	//mTablero.IniciarAleatorio();
    	int [][] ma = {{0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,0},{0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}; 
    	mTablero.insertarMatriz(ma);
    	mEntorno.inicializar(mTablero.obtenerMatriz());
    	this.setVisible(true);
    	this.setLayout(new BorderLayout());
        this.setSize( new Dimension(770, 590) );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("LUCES");
        this.add(mEntorno, BorderLayout.CENTER );
        
        
       this.addKeyListener(new KeyListener(){
    	   int fila = 0;
    	   int columna = 0;
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case 37: // Izquierda
				if (columna > 0){
					mEntorno.DesactivarCasilla(fila, columna);
					columna--;
					mEntorno.ActivarCasilla(fila, columna);
				}else{
						mEntorno.DesactivarCasilla(fila, columna);
						columna = mEntorno.getDimension()-1;
						mEntorno.ActivarCasilla(fila, columna);
				}
				break;
			case 38: // Arriba
				if (fila > 0){
					mEntorno.DesactivarCasilla(fila, columna);
					fila--;
					mEntorno.ActivarCasilla(fila, columna);
				}else{
						mEntorno.DesactivarCasilla(fila, columna);
						fila = mEntorno.getDimension()-1;
						mEntorno.ActivarCasilla(fila, columna);
				}
				break;
			case 39: // Derecha
				if (columna < mEntorno.getDimension()-1){
					mEntorno.DesactivarCasilla(fila, columna);
					columna++;
					mEntorno.ActivarCasilla(fila, columna);
				}else{
						mEntorno.DesactivarCasilla(fila, columna);
						columna = 0;
						mEntorno.ActivarCasilla(fila, columna);
				}
				break;
			case 40: // Abajo
				if (fila < mEntorno.getDimension()-1){
					mEntorno.DesactivarCasilla(fila, columna);
					fila++;
					mEntorno.ActivarCasilla(fila, columna);
				}else{
						mEntorno.DesactivarCasilla(fila, columna);
						fila = 0;
						mEntorno.ActivarCasilla(fila, columna);
				}
				break;
			case 27: // Escape
				System.exit(0);
				break;
			case 10: // Enter
				//mEntorno.CambiarEstado(fila, columna);
				switch (patronseleccionado){
				case 0:
					mEntorno.PatronEstandar(fila, columna);
					mTablero.PatronEstandar(fila, columna);
					break;
				case 1:
					mEntorno.PatronFlipFlop(fila, columna);
					mTablero.PatronFlipFlop(fila, columna);
					break;
				case 2:
					mEntorno.PatronDiagonal(fila, columna);
					mTablero.PatronDiagonal(fila, columna);
					break;
				}
				
				if(mTablero.SiTerminaJuego()){
					JOptionPane.showMessageDialog(null, "Has ganado");
					System.exit(0);
				}
			
				break;
			case 67: // tecla C: para altenar entre flip flop y estandar
				if(patronseleccionado == 0){
					patronseleccionado = 1;
				}else{
					patronseleccionado = 0;
				}
				
				break;
			case 88: // Tecla X: para poner patron diagonal
				mEntorno.PatronDiagonal(fila, columna);
				mTablero.PatronDiagonal(fila, columna);
				patronseleccionado = 2;
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    	   
       });
       PonerMensajePanelMensajes();
      
       this.add(panel, BorderLayout.EAST);
      
    }

    public void PonerMensajePanelMensajes(){
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	JLabel label111 = new JLabel(" ");
    	JLabel label112 = new JLabel(" ");
    	JLabel label113 = new JLabel(" ");
    	JLabel label114 = new JLabel(" ");
    	JLabel label115 = new JLabel(" ");
    	JLabel label116 = new JLabel(" ");
    	JLabel label117 = new JLabel(" ");
    	JLabel label118 = new JLabel(" ");
    	JLabel label119 = new JLabel(" ");
    	JLabel label120 = new JLabel(" ");
    	JLabel label121 = new JLabel(" ");
    	
    	JLabel label =   new JLabel(" *************   LIGHT OUT   *********** ");
    	JLabel label1 =  new JLabel("  TECLAS:                                ");
    	JLabel label2 =  new JLabel("  Arriba: Flecha arriba        ");
    	JLabel label3 =  new JLabel("  Abajo:       Flecha abajo         ");
    	JLabel label4 =  new JLabel("  Izquierda: Flecha izquierda     ");
    	JLabel label5 =  new JLabel("  Derecha:  Flecha derecha       ");
    	JLabel label6 =  new JLabel("  Salir:      Tecla escape		 ");
    	JLabel label7 =  new JLabel("  Seleccionar: Tecla enter			 ");
    	JLabel label8 =  new JLabel("  Cambiar patrón: Tecla C				 ");
    	JLabel label9 =  new JLabel("  Patrón diagonal: Tecla X              ");
    	JLabel label10 = new JLabel(" *************************************** ");
    	
    	panel.add(label111);
    	panel.add(label112);
    	panel.add(label113);
    	panel.add(label114);
    	panel.add(label115);
    	panel.add(label116);
    	panel.add(label117);
    	panel.add(label118);
    	panel.add(label119);
    	panel.add(label120);
    	panel.add(label121);
    	
    	panel.add(label);
    	panel.add(label1);
    	panel.add(label2);
    	panel.add(label3);
    	panel.add(label4);
    	panel.add(label5);
    	panel.add(label6);
    	panel.add(label7);
    	panel.add(label8);
    	panel.add(label9);
    	panel.add(label10);
    }
	
	
	
}