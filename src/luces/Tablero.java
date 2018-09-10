package luces;

public class Tablero {

	private int [][] matriz;
	private int MAX;
	
	public Tablero(int DIMENSION){
		MAX = DIMENSION;
		matriz = new int [MAX][MAX];
		for (int i = 0; i < MAX; i++) {
			for(int j=0; j < MAX; j++){
				matriz[i][j] = 0;
			}
		}
	}
	
	public void IniciarAleatorio(){	
		for (int i = 0; i < MAX; i++) {
			for(int j=0; j < MAX; j++){
				int valor = (int) Math.floor(Math.random()*2);
				matriz[i][j] = valor;
			}
		}
	}
	
	public void insertarMatriz(int [][] m){
		matriz = m;
	}
	
	public int [][] obtenerMatriz(){
		return matriz;
	}
	
	private int ObtenerCasilla(int fila, int columna){
		return matriz[fila][columna];
	}
	
	private void CambiarEstado(int fila, int columna){
		if (ObtenerCasilla(fila,columna) == 0){
			matriz[fila][columna] = 1;
		}else{
			matriz[fila][columna] = 0;
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
	
	public boolean SiTerminaJuego(){
		boolean estado = true;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (matriz[i][j] == 1){
					estado = false;
					break;
				}
			}
		}
		return estado;
	}
	public void Mostrar(){
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	
}
