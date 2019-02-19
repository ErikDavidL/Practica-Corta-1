

import java.util.Scanner;

public class hanoi {

static int noDiscos,jugada,torre,disco,columna,fila,valorPos,nuevaPos,fBorrar,cBorrar;
    static int contadorMovimientos = 0,contadorBuscar=0,buscarFila=0,buscarColumna=0;
    static int datosHanoi[][] = new int[11][4];
        
    public static void main(String[] args) {
        Scanner ingresoDiscos = new Scanner(System.in);      
        
        datosHanoi[0][0]= 1;    datosHanoi[5][0]= 6;
        datosHanoi[1][0]= 2;    datosHanoi[6][0]= 7;
        datosHanoi[2][0]= 3;    datosHanoi[7][0]= 8;
        datosHanoi[3][0]= 4;    datosHanoi[8][0]= 9;
        datosHanoi[4][0]= 5;    datosHanoi[9][0]= 10;        
        datosHanoi[10][0]= 100; datosHanoi[10][1]= 100;
        datosHanoi[10][2]= 100;
            
            System.out.println("    BIENVENIDO A LAS TORRES DE HANOI:");
            System.out.println("LA REGLAS SON LAS SIGUIENTES:");
            System.out.println("-LA CANTIDAD MÍNIMA DE DISCOS PARA JUGAR ES DE 2");
            System.out.println("-EL JUGADOR NO PUEDE PONER DISCOS MÁS GRANDES ENCIMA DE OTROS DISCOS PEQUEÑOS.");
            System.out.println("-EL JUGADOR NO PUEDE MOVER DISCOS QUE TENGAN MÁS DISCOS ENCIMA. ");
            System.out.println("-SE LE MOSTRARÁ UNA IMAGEN ILUSTRATIVA, QUE SERÁ SUSTITUIDA POR NUḾEROS.");
            System.out.println("-LOS CUALES REPRESENTAN A CADA DISCO, TOMANDO EN CUENTA QUE NO PUEDE HABER UN NÚMERO MENOR DEBAJO DE UNO MAYOR.");
            System.out.print("\n\n-INGRESE LA CANTIDAD DE DISCOS CON LOS QUE DESEA JUGAR: ");
            noDiscos = ingresoDiscos.nextInt();            
            fila = noDiscos-1;
            dibujo();
            listadoHanoi();
            System.out.print("\n\nEL PRIMER MOVIMIENTO SIEMPRE DEBE SER EL DISCO NÚMERO 1.");
            
        while(contadorMovimientos >= 0){
                        
            System.out.println("\n\nHA REALIZADO: "+contadorMovimientos+" MOVIMIENTOS");
            System.out.print("\nINGRESE QUE NÚMERO DE DISCO DESEA MOVER: ");    
            jugada = ingresoDiscos.nextInt();
            disco = jugada-1;
            valorPos = jugada;            
            System.out.print("INDIQUE A QUE TORRE DESEA MOVERLO: ");
            torre = ingresoDiscos.nextInt();
            columna = torre-1;
            System.out.println("\n");
            movimientos();                                    
            contadorMovimientos++;
        }    
    }
    
    public static void dibujo(){
        System.out.println("\n");
        System.out.println("  Torre 1                    Torre 2                    Torre 3");
                for(int z=0;z<noDiscos;z++){
                    for(int q=0;q<z;q++){
                        System.out.print("=");
                    }
                        System.out.println("=");
                }          
    }
    public static void listadoHanoi(){
        System.out.println("\n");        
        System.out.println("   Torre 1                  Torre 2                  Torre 3");
                    for (int x=0; x < noDiscos; x++) {
                                System.out.print("    ");
                        for (int y=0; y < 3; y++) {
                                System.out.print (datosHanoi[x][y]);
                            if (y!=datosHanoi[x].length-1) System.out.print("\t                      ");
                        }
                                System.out.println("");
                    }
    }
    
    public static void movimientos(){
        
        buscarNumero();             
        if(datosHanoi[fila-1][cBorrar] < valorPos && datosHanoi[fila-1][cBorrar] !=0){
                            
                System.out.println("ESTE MOVIMIENTO NO ES PERMITIDO, HAY MÁS DISCOS PEQUEÑOS ARRIBA");
                datosHanoi[fBorrar][cBorrar]= valorPos;
                datosHanoi[nuevaPos][columna] = 0;
                listadoHanoi();                                    
        }
        else{              
            datosHanoi[fBorrar][cBorrar] = 0;
            if(columna==0){
                datosHanoi[noDiscos][0]=0;
                datosHanoi[noDiscos+1][0]=0;
                datosHanoi[noDiscos+2][0]=0;            
            }
            if((datosHanoi[noDiscos][columna]==0) && (datosHanoi[fila][columna] ==0)){           
                datosHanoi[fila][columna] = valorPos; 
                listadoHanoi();                            
            }
            else{
                if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0) && (datosHanoi[fila-3][columna] != 0) &&
                    (datosHanoi[fila-4][columna] != 0) && (datosHanoi[fila-5][columna] != 0) && (datosHanoi[fila-6][columna] != 0) && (datosHanoi[fila-7][columna] != 0) &&
                    (datosHanoi[fila-8][columna] != 0)){                
                
                        datosHanoi[fila-9][columna] = valorPos; nuevaPos = fila-9;                                     
                }else{
                    if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0) && (datosHanoi[fila-3][columna] != 0) &&
                        (datosHanoi[fila-4][columna] != 0) && (datosHanoi[fila-5][columna] != 0) && (datosHanoi[fila-6][columna] != 0) && (datosHanoi[fila-7][columna] != 0)){                
                
                            datosHanoi[fila-8][columna] = valorPos; nuevaPos = fila-8;                                   
                    }else{
                        if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0) && (datosHanoi[fila-3][columna] != 0) &&
                            (datosHanoi[fila-4][columna] != 0) && (datosHanoi[fila-5][columna] != 0) && (datosHanoi[fila-6][columna] != 0)){                
                
                            datosHanoi[fila-7][columna] = valorPos; nuevaPos = fila-7;                                    
                        }else{
                            if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0) && (datosHanoi[fila-3][columna] != 0) &&
                                (datosHanoi[fila-4][columna] != 0) && (datosHanoi[fila-5][columna] != 0)){                
                
                                datosHanoi[fila-6][columna] = valorPos; nuevaPos = fila-6;                                  
                            }else{
                                if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0) && (datosHanoi[fila-3][columna] != 0) &&
                                    (datosHanoi[fila-4][columna] != 0)){                
                
                                        datosHanoi[fila-5][columna] = valorPos; nuevaPos = fila-5;                          
                                }else{
                                    if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0) && (datosHanoi[fila-3][columna] != 0)){                
                                        datosHanoi[fila-4][columna] = valorPos; nuevaPos = fila-4;                              
                                    }else{               
                                        if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0) && (datosHanoi[fila-2][columna] != 0)){
                                            datosHanoi[fila-3][columna] = valorPos; nuevaPos = fila-3;                               
                                    
                                        }else{
                                            if((datosHanoi[fila][columna] != 0) && (datosHanoi[fila-1][columna] != 0)){
                                                datosHanoi[fila-2][columna] = valorPos; nuevaPos = fila-2;                
               
                                            }else{
                                                if(datosHanoi[fila][columna] != 0){                
                                                    datosHanoi[fila-1][columna] = valorPos; nuevaPos = fila-1;                
               
                                                }                                               
                                            }
                                        }    
                                    }
                                }
                            }
                        }
                    }                                          
                }
                condiciones();
            }
        }              
    }
    public static void condiciones(){           
                    
            if(datosHanoi[nuevaPos+1][columna] < datosHanoi[nuevaPos][columna]){
                    System.out.println("ESTE MOVIMIENTO NO ES PERMITIDO, HAY UN DISCO MÁS PEQUEÑO ABAJO");
                    datosHanoi[fBorrar][cBorrar]= valorPos;
                    datosHanoi[nuevaPos][columna] = 0;
                    listadoHanoi();                                    
            }
            else{
                    System.out.println("MOVIMIENTO EXITOSO");
                    listadoHanoi();
            }                
    }
    public static void buscarNumero(){
        contadorBuscar=0;
        for(int i=0;i< noDiscos;i++){
            for(int j=0;j< 3;j++){
                if(datosHanoi[i][j] == valorPos){                    
                     buscarFila=i;
                     buscarColumna=j;   
                }
                contadorBuscar++;
            }
        }      
        fBorrar = buscarFila;     
        cBorrar = buscarColumna;
    } 
}
