import java.util.Random;
import java.util.Scanner;

public class Cartas {

    String representar1,representar2;
    public static void main(String[] args) {
    
        Scanner juegoCartas = new Scanner(System.in);
        String dineroInicial;
        Double apuesta;
        
            System.out.println("\nBIENVENIDO A LAS VEGAS.\nESTE JUEGO TE HARÁ SENTIR COMO TODO UN APOSTADOR.\n");
            System.out.println("LAS REGLAS SON BÁSICAS");
            System.out.println("\n-EL JUGADOR INGRESARÁ TODO EL DINERO QUE DESEE APOSTAR\n-EN CADA TURNO SE LE PRESENTARÁN DOS CARTAS");
            System.out.println("-SI EL VALOR DE LA CARTA QUE SAQUE EL JUGADOR SE ENCUENTRA ENTRE LOS VALORES DE LAS DOS CARTAS, EL JUGADOR GANA, DE NO SER ASÍ EL JUGADOR PERDERÁ SU DINERO");
            System.out.println("-INGRESARÁ LA CANTIDAD QUE DESEA APOSTAR EN CADA TURNO.\n-EL JUEGO ACABA CUANDO EL JUGADOR SE QUEDE SIN DINERO\n");
            System.out.println("\033[32m    ORDEN DE LAS CARTAS: ");
            System.out.println("\033[32m ♠️   2 3 4 5 6 7 8 9 10 J Q K \n");
            System.out.print("INGRESE SU APUESTA: Q ");
            dineroInicial = juegoCartas.nextLine();
            Double dineroFinal = Double.parseDouble(dineroInicial);
            Double dineroenJuego=dineroFinal;
        
        while(dineroenJuego > 0){
            
            
            int numeroUno = numerosAleatorios();
            int numeroDos = numerosAleatorios();
            int numeroTres =numerosAleatorios();
            
            if(numeroUno == numeroDos){
                numeroUno = numerosAleatorios();
                numeroDos = numerosAleatorios();
            }
            else{
                
                if((numeroUno - numeroDos) == 1 || (numeroDos-numeroUno) == 1){
                numeroDos = numerosAleatorios();
                }
                else{
                    String representar1 = String.valueOf(numeroUno);
                    String representar2 = String.valueOf(numeroDos);
                    String representar3 = String.valueOf(numeroTres);
            
                    if(numeroUno==1){
                    representar1 = "♠️";
                    }
                    if(numeroDos==1){
                    representar2 = "♠️";
                    }
                    if(numeroTres==1){
                    representar3 = "♠️";
                    }
                    if(numeroUno==11){
                    representar1 = "J";
                    }
                    if(numeroDos==11){
                    representar2 = "J";
                    }
                    if(numeroTres==11){
                    representar3 = "J";
                    }
                    if(numeroUno==12){
                    representar1 = "Q ";
                    }
                    if(numeroDos==12){
                    representar2 = "Q";
                    }
                    if(numeroTres==12){
                    representar3 = "Q";
                    }
                    if(numeroUno==13){
                    representar1 = "K";
                    }
                    if(numeroDos==13){
                    representar2 = "K";
                    }
                    if(numeroTres==13){
                    representar3 = "K";
                    }
                        System.out.print("\nSIGUIENTE JUEGO DE CARTAS:\n");
                        System.out.println("                CARTA 1 =          ♠️   "+representar1+"   ♦️  ");
                        System.out.println("                CARTA 2 =          ♠️   "+representar2+"   ♦️  ");                                                          
                        System.out.print("¿CUÁNTO DESEA APOSTAR?: Q ");
                        apuesta = juegoCartas.nextDouble();
                                                
                        System.out.println("\n\n\n\033[32m                SU CARTA ES:     ♠️    "+representar3+"   ♦️  "); 
            
                            if((numeroTres<numeroDos && numeroTres>numeroUno) || (numeroTres>numeroDos && numeroTres<numeroUno) ){
                    
                                dineroenJuego = dineroenJuego + apuesta;
                                System.out.println("\033[32m                HA GANADO EN ESTA JUGADA");
                                System.out.println("\nDINERO ACTUAL EN EL JUEGO: Q "+dineroenJuego);
                    
                            }
                
                            else{
                    
                                dineroenJuego = dineroenJuego - apuesta;
                    
                                if(dineroenJuego <= 0 ){
                    
                                    dineroenJuego = 0.00;
                                    System.out.println("\nYA NO CUENTA CON DINERO SUFICIENTE PARA SEGUIR JUGANDO: ");
                                    System.out.println("DINERO ACTUAL EN JUEGO: Q "+dineroenJuego);
                                }
                                else{
                                    System.out.println("\033[32m                HA PERDIDO EN ESTA JUGADA");
                                    System.out.println("\nDINERO ACTUAL EN EL JUEGO: Q "+dineroenJuego);    
                                }
                            }                                                                                               
                }
            }
        }
    }
       
   
    public static int numerosAleatorios(){
        
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(13)+1;
        
    }
    
}
