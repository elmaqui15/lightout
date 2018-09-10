package luces;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Entorno extends JPanel implements ComponentListener {
    private JButton[][] mCasillas = null ;
    private int MAX;

    public Entorno(int dimension) {
    	MAX = dimension;
        this.setBackground(Color.WHITE);
        this.addComponentListener(this);
        this.setLayout(null);                
        
    }

    public void acomodar() {
        int ancho = this.getWidth();
        int alto = this.getHeight();
        int dimensionMenor = Math.min( ancho , alto ); 
        int anchoDeCasilla = dimensionMenor / MAX; 
        int altoDeCasilla = dimensionMenor / MAX;
        
        for( int fila = 0 ; fila < MAX; fila ++ ) {
            for( int columna = 0 ; columna < MAX; columna ++ ) {
                JButton temp = mCasillas[fila][columna] ;          
                temp.setBounds(columna * anchoDeCasilla, fila * altoDeCasilla, 71, 71);
            }    
        }
    }
    
    public void inicializar(int [][] matrizTab) {
    	
        mCasillas = new JButton[MAX][MAX];
    
        for( int fila = 0 ; fila < MAX ; fila ++ ) {            
            for( int columna = 0 ; columna < MAX ; columna ++ ) {
                
                JButton temp = new JButton();
                temp.setEnabled(false);
                if (matrizTab[fila][columna] == 0){
                	temp.setBackground(Color.BLACK);	
                }else{
                	temp.setBackground(Color.YELLOW);
                }
                
                mCasillas[fila][columna] = temp;                        
                
                this.add(temp);
            }
        }
        this.ActivarCasilla(0, 0);
    }

    public void componentResized(ComponentEvent e) {
    	this.acomodar();
    }

    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {
    }

    public void ActivarCasilla(int fila, int columna){
    	mCasillas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    }
    
    public void DesactivarCasilla(int fila, int columna){
    	mCasillas[fila][columna].setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }

    public void EncenderCasilla(int fila, int columna){
    	mCasillas[fila][columna].setBackground(Color.YELLOW);
    }
    
    public void ApagarCasilla(int fila, int columna){
    	mCasillas[fila][columna].setBackground(Color.BLACK);
    }
    
    public int getDimension(){
    	return MAX;
    }
    
    public void CambiarEstado(int fila, int columna){
    	if(mCasillas[fila][columna].getBackground() == Color.BLACK){
    		EncenderCasilla(fila, columna);
    	}else{
    		ApagarCasilla(fila, columna);
    	}
    }

    public void PatronEstandar(int fila, int columna){
    	if ( (fila >= 0) & (fila < MAX) & (columna >= 0) & (columna < MAX) ){
			CambiarEstado(fila, columna);
		}
		
		if ( (fila-1 >= 0) & (fila-1 < MAX) & (columna >= 0) & (columna < MAX) ){
			CambiarEstado(fila-1, columna);
		}
		
		if ( (fila+1 >= 0) & (fila+1 < MAX) & (columna >= 0) & (columna < MAX) ){
			CambiarEstado(fila+1, columna);
		}
		
		if ( (fila >= 0) & (fila < MAX) & (columna-1 >= 0) & (columna-1 < MAX) ){
			CambiarEstado(fila, columna-1);
		}
		
		if ( (fila >= 0) & (fila < MAX) & (columna+1 >= 0) & (columna+1 < MAX) ){
			CambiarEstado(fila, columna+1);
		}
    }
    
    public void PatronFlipFlop(int fila, int columna){
    	for(int i=0; i < MAX; i++){
			CambiarEstado(i, columna);
		}
		
		for (int j = 0; j < MAX; j++) {
			CambiarEstado(fila, j);
		}
		CambiarEstado(fila, columna);
    }
    
    public void PatronDiagonal(int fila, int columna){
    	int i = fila;
		int j = columna;
		while ((i-1 >= 0) && (j-1 >= 0)){
			CambiarEstado(i-1, j-1);
			i--;
			j--;
		}
		i = fila;
		j = columna;
		while ((i-1 >= 0) && (j+1 < MAX)){
			CambiarEstado(i-1, j+1);
			i--;
			j++;
		}
		
		i = fila;
		j = columna;
		while ((i+1 < MAX) && (j-1 >= 0)){
			CambiarEstado(i+1, j-1);
			i++;
			j--;
		}
		
		i = fila;
		j = columna;
		while ((i+1 < MAX) && (j+1 < MAX)){
			CambiarEstado(i+1, j+1);
			i++;
			j++;
		}
		CambiarEstado(fila, columna);
    }
    
    
}
