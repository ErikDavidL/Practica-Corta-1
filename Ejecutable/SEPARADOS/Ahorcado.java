import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) {
        
    Scanner inicioJuego = new Scanner (System.in);
    String intentoLetra[] = new String[100];
    String palabraInicial;
    String palabraOculta = "";
    String palabraIntentos = "";
    int oportunidades = 0;
        
        
        System.out.println("BIENVENIDO AL JUEGO DEL AHORCADO:\n");
        System.out.print("-LAS REGLAS SON BÁSICAS, UNA PERSONA QUE NO SEA EL JUGADOR DEBERÁ DE INGRESAR UNA PALABRA.\n");
        System.out.print("-EL JUGADOR TENDRÁ UNA CIERTA CANTIDAD DE INTENTOS PARA ADIVINAR LA PALABRA QUE ESTÁ OCULTA.\n");
        System.out.print("¡QUE LA FUERZA TE ACOMPAÑE!\n\n");
        
            System.out.print("Ingrese la palabra para iniciar el juego: ");
            palabraInicial = inicioJuego.nextLine();
            String letrasPalabra[] = new String[palabraInicial.length()];
            String palabraconLineas[] = new String[palabraInicial.length()];
            
            for(int i=0; i<palabraInicial.length(); i++){
                letrasPalabra[i] = String.valueOf(palabraInicial.charAt(i));
                palabraOculta = palabraOculta+"-";
                palabraconLineas[i]= "-";
            }
            
        System.out.print("\nPALABRA OCULTA [");
        System.out.print(palabraOculta);
        System.out.print("]");
               
            for(int x=0; x < intentoLetra.length ; x++ ){
            
            System.out.print("     Ingrese una letra: ");
            intentoLetra[x] = inicioJuego.nextLine();  
            
            if(intentoLetra[x].equalsIgnoreCase(palabraInicial)){
                System.out.println("\033[32m¡HAS ADIVINADO LA PALABRA, ENHORABUENA!");
                System.exit(0);
            }
            if(x>=1){
                for(int z=0; z<x ; z++){
                    if(intentoLetra[z].equalsIgnoreCase(intentoLetra[x])){
                    System.out.println("Esta letra ya ha sido adivinada.\n¡SE LE QUITARÁ UNA OPORTUNIDAD!");
                    }
                }
            
            }    
                    if(palabraInicial.contains(intentoLetra[x])==true){
                       
                        for(int y=0; y<palabraInicial.length(); y++){
                            if(intentoLetra[x].equalsIgnoreCase(letrasPalabra[y])){
                            palabraconLineas[y] = intentoLetra[x];
                            }
                        }
                        
                        String palabradelJuego ="";
                        for(int w=0; w<palabraInicial.length(); w++ ){
                            palabradelJuego = palabradelJuego + palabraconLineas[w];
                        } 
                        palabraIntentos = palabradelJuego;                                              
                        System.out.print("\n\033[32mPALABRA OCULTA [");
                        System.out.print("\033[32m"+palabradelJuego);
                        System.out.print("\033[32m]");
                            
                    }
                    else{
                        
                        System.out.print("\nNo es una letra perteneciente a la palabra");
                        System.out.print("\nPALABRA OCULTA [");
                        System.out.print(palabraIntentos);
                        System.out.print("]");
                        oportunidades++;
                        
                        if(oportunidades == 1){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n\n");
                            System.out.print("\033[36mTE QUEDAN 9 OPORTUNIDADES");
                        }
                        if(oportunidades == 2){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");
                            System.out.print("\033[36mTE QUEDAN 8 OPORTUNIDADES");
                        }
                        if(oportunidades == 3){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 7 OPORTUNIDADES");                            
                        }
                        if(oportunidades == 4){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 6 OPORTUNIDADES");                            
                        }
                        if(oportunidades == 5){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                   ||\\");
                            System.out.println("\033[36m||                   || \\");
                            System.out.println("\033[36m||                   ||  ¬¬");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 5 OPORTUNIDADES");                            
                        }
                        if(oportunidades == 6){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //||\\");
                            System.out.println("\033[36m||                // || \\");
                            System.out.println("\033[36m||               ¬¬  ||  ¬¬");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 4 OPORTUNIDADES");                         
                        }
                        if(oportunidades == 7){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //||\\");
                            System.out.println("\033[36m||                // || \\");
                            System.out.println("\033[36m||               ¬¬  ||  ¬¬");
                            System.out.println("\033[36m||                    \\");
                            System.out.println("\033[36m||                     \\");
                            System.out.println("\033[36m||                      \\");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 3 OPORTUNIDADES");                         
                        }
                        if(oportunidades == 8){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //||\\");
                            System.out.println("\033[36m||                // || \\");
                            System.out.println("\033[36m||               ¬¬  ||  ¬¬");
                            System.out.println("\033[36m||                  //\\");
                            System.out.println("\033[36m||                 //  \\");
                            System.out.println("\033[36m||                //    \\");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 2 OPORTUNIDADES");                         
                        }
                        if(oportunidades == 9){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 (    )");
                            System.out.println("\033[36m||                 (  ¬ )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //||\\");
                            System.out.println("\033[36m||                // || \\");
                            System.out.println("\033[36m||               ¬¬  ||  ¬¬");
                            System.out.println("\033[36m||                  //\\");
                            System.out.println("\033[36m||                 //  \\");
                            System.out.println("\033[36m||                //    \\");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36mTE QUEDAN 1 OPORTUNIDADES");                         
                        }
                        if(oportunidades == 10){
                            System.out.print("\n\n\033[36m¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬\n");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //////");
                            System.out.println("\033[36m||                 ( x x)");
                            System.out.println("\033[36m||                 (  ¬ )");
                            System.out.println("\033[36m||                   ||");
                            System.out.println("\033[36m||                 //||\\");
                            System.out.println("\033[36m||                // || \\");
                            System.out.println("\033[36m||               ¬¬  ||  ¬¬");
                            System.out.println("\033[36m||                  //\\");
                            System.out.println("\033[36m||                 //  \\");
                            System.out.println("\033[36m||                //    \\");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||");
                            System.out.println("\033[36m||\n");  
                            System.out.print("\033[36m\n¡SE ACABARON LAS OPORTUNIDADES! NO HAS LOGRADO ADIVINAR LA PALABRA\n"); 
                            System.out.println("\n\033[36mLA PALABRA ERA: "+palabraInicial);
                            System.exit(0);
                        }
                                                                        
                    }
             if(palabraIntentos.equalsIgnoreCase(palabraInicial)){
                 System.out.println("\n\n\033[32m¡HAS COMPLETADO LA PALABRA, ENHORABUENA!\n\n ");
                 System.exit(0);
             }
                    
                    
            }  
    
           
    }

   
 
    
}

