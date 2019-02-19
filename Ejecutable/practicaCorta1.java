


import java.util.Random;
import java.util.Scanner;

public class practicaCorta1 { //INICIALIZACION DEL PROGRAMA
    static int opciones;
    public static void main(String[] args) {    //METODO PRINCIPAL ENCARGADO DE LLAMAR A LOS DEMAS METODOS
        menuJuegos();
    }
    public static void menuJuegos(){    //METODO PARA EL MENU DE  OPCIONES
        Scanner numeroEscogido = new Scanner(System.in);
        boolean salir = false;
        int opcion;         
            while(!salir){  //CICLO PARA QUE SE REPITA EL MENU HASTA QUE EL USUARIO ELIJA LA OPCION SALIR 
                System.out.println("\n\n\n\n\n\n\033[37mSALA DE JUEGOS:\n");
                System.out.println("\033[37m1. EL AHORCADO ");
                System.out.println("\033[37m2. BASKETBALL ");
                System.out.println("\033[37m3. JUEGO DE CARTAS ");
                System.out.println("\033[37m4. HANOI ");
                System.out.println("\033[37m5. SALIR\n");                
                System.out.print("Seleccione el número del juego que desee:  ");
                opcion = numeroEscogido.nextInt();  //INGRESAMOS LA OPCION QUE DESEAMOS PARA EMPEZAR                
                    switch(opcion){
                        case 1:
                                juegoAhorcado();    //LLAMAR AL METODO DEL JUEGO DEL AHORCADO                                                                    
                            break;
                        case 2:
                                juegoBasketball();  //LLAMAR AL METODO DEL JUEGO DE BASKETBALL
                                opcionesJuegos();
                                    while(opciones == 1){   //USAMOS UN CICLO WHILE PARA REPETIR EL JUEGO AL MOMENTO QUE ESTE TERMINE
                                        juegoBasketball();
                                        opcionesJuegos();
                                    }
                            break;
                        case 3:
                                juegoCartas();      //LLAMAR AL METODO DEL JUEGO DE CARTAS
                                opcionesJuegos();                                
                                    while(opciones == 1){   //COMO EN EL CASE 2 DEL JUEGO DE BASKETBALL, USAREMOS UN CICLO PARA REPETIR EL JUEGO
                                    juegoCartas();  
                                    opcionesJuegos();
                                    }
                            break;
                        case 4:
                                hanoi();    //METODO PARA LLAMAR AL JUEGO TORRES DE HANOI
                            break;
                        case 5:
                            System.exit(0); //ESTA OPCION DA POR FINALIZADA LA EJECUCION DEL PROGRAMA
                            break;
                        default:
                            System.out.println("\nINGRESE UNA OPCIÓN VÁLIDA\n"); //SI EN CASO NO SE INGRESA NINGUN NUMERO DE LAS OPCIONES ESTE MENSAJE APARECERA
                    }    
            }
    }//INICIO DEL METODO PARA GENERAR LAS OPCIONES DENTRO DE LOS JUEGOS
    public static void opcionesJuegos(){        
        Scanner opcionJuego = new Scanner(System.in);        
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\033[37m¿QUÉ DESEA HACER?");
        System.out.println("\033[37m1. VOLVER A JUGAR.\n2. REGRESAR AL MENÚ\n3. SALIR DEL PROGRAMA");
        System.out.print("\033[37mINGRESE EL NÚMERO DE LA OPCIÓN: ");
        opciones = opcionJuego.nextInt();   //GUARDAR OPCION 
            if(opciones==2){    //SI ELIGE LA OPCION  2 REGRESARA AL MENU, MEDIANTE EL LLAMADO AL METODO
                menuJuegos();
            }    
            if(opciones==3){    //SI ELIGE LA OPCION 3 EL PROGRAMA FINALIZARA
                System.exit(0);
            }            
    }
    //INICIO DEL JUEGO DEL AHORCADO, GUARDADO EN UN METODO POR APARTE
    public static void juegoAhorcado() {        
        Scanner inicioJuego = new Scanner (System.in);  //INICIALIZACION DE VARIABLES
        String intentoLetra[] = new String[100];
        String palabraInicial;
        String palabraOculta = "";
        String palabraIntentos = "";
        int oportunidades = 0;                
                System.out.println("\n\n\n\n\n\nBIENVENIDO AL JUEGO DEL AHORCADO:\n");  //INSTRUCCIONES GENERALES DEL JUEGO
                System.out.print("-LAS REGLAS SON BÁSICAS, UNA PERSONA QUE NO SEA EL JUGADOR DEBERÁ DE INGRESAR UNA PALABRA.\n");
                System.out.print("-EL JUGADOR TENDRÁ UNA CIERTA CANTIDAD DE INTENTOS PARA ADIVINAR LA PALABRA QUE ESTÁ OCULTA.\n");
                System.out.print("¡QUE LA FUERZA TE ACOMPAÑE!\n\n");        
                System.out.print("Ingrese la palabra para iniciar el juego: "); //INGRESAR LA PALABRA QUE SE ADIVINARA
                palabraInicial = inicioJuego.nextLine();
                String letrasPalabra[] = new String[palabraInicial.length()];   //CREAR DOS ARREGLOS CON EL TAMAÑO DE LA PALABRA
                String palabraconLineas[] = new String[palabraInicial.length()];
            
                    for(int i=0; i<palabraInicial.length(); i++){   //CONVERTIR LA PALABRA EN CARACTERES, DESPUES GUARDAR EN UNA VARIABLE EL LARGO DE LA PALABRA Y ASIGNARLE CARACTERES DIFERENTES, EN ESTE CASO LINEAS --
                    letrasPalabra[i] = String.valueOf(palabraInicial.charAt(i));
                    palabraOculta = palabraOculta+"-";
                    palabraconLineas[i]= "-";   //GUARDAR UN ARREGLO DONDE GUARDAREMOS EL PROCESO PARA ADIVINAR LA PALABRA
                    }            
                System.out.print("\nPALABRA OCULTA ["); //MOSTRAR LA PALABRA YA OCULTA
                System.out.print(palabraOculta);
                System.out.print("]");
               
                    for(int x=0; x < intentoLetra.length ; x++ ){   //SENTENCIA DEL CICLO PARA EL PROCESO DEL JUEGO, INICIO DEL JUEGO            
                        System.out.print("     Ingrese una letra: ");
                        intentoLetra[x] = inicioJuego.nextLine();  //GUARDAR LAS LETRAS EN UN ARREGLO
            
                            if(intentoLetra[x].equalsIgnoreCase(palabraInicial)){   //SI EL USUARIO INGRESA LA PALABRA COMPLETA ESTA CONDICION DIRA QUE YA GANO Y DESPLEGARA LAS OPCIONES
                                System.out.println("\033[32m¡HAS ADIVINADO LA PALABRA, ENHORABUENA!");
                                opcionesJuegos();
                                    while(opciones == 1){
                                        juegoAhorcado();
                                        opcionesJuegos();
                                    }
                            }
                            if(x>=1){   //SI EL USUARIO INGRESA UNA LETRA REPETIDA LE ADVERTIRA QUE YA LA USO
                                for(int z=0; z<x ; z++){
                                    if(intentoLetra[z].equalsIgnoreCase(intentoLetra[x])){
                                        System.out.println("Esta letra ya ha sido adivinada.\n¡SE LE QUITARÁ UNA OPORTUNIDAD!");
                                    }
                                }            
                            }    
                            if(palabraInicial.contains(intentoLetra[x])==true){ // AQUI INICIA LA SENTENCIA SI LA LETRA ESTA DENTRO DEL ARREGLO
                       
                                    for(int y=0; y<palabraInicial.length(); y++){   //LEEMOS EL ARREGLO COMPARANDO SI LOS CARACTERES EN CADA UNO
                                        if(intentoLetra[x].equalsIgnoreCase(letrasPalabra[y])){
                                            palabraconLineas[y] = intentoLetra[x];
                                        }
                                    }                        
                                    String palabradelJuego =""; //CREAMOS UNA VARIABLE PARA GUARDAR EL ARREGLO YA CON LAS LETRAS DESCUBIERTAS
                                        for(int w=0; w<palabraInicial.length(); w++ ){
                                            palabradelJuego = palabradelJuego + palabraconLineas[w];
                                        } 
                            palabraIntentos = palabradelJuego;  //MOSTRAMOS LA PALABRA YA CON LAS LETRAS DESCUBIERTAS                                              
                            System.out.print("\n\033[32mPALABRA OCULTA [");
                            System.out.print("\033[32m"+palabradelJuego);
                            System.out.print("\033[32m]");
                            
                            }
                            else{   //SI LA LETRA NO ES PARTE DE LA PALABRA ENTONCES SE HARA LO SIGUIENTE
                                System.out.print("\nNo es una letra perteneciente a la palabra");
                                System.out.print("\nPALABRA OCULTA [");
                                System.out.print(palabraIntentos);
                                System.out.print("]");
                                oportunidades++;// SE LE INDICARA AL JUGADOR QUE LA LETRA NO FORMA PARTE DE LA PALABRA Y QUE HA PERDIDO UNA OPORTUNIDAD
                                //A CONTINUACION SE ESTRUCUTURA EN CADA OPORTUNIDAD EL DIBUJO DEL AHORCADO, MARCANDO EN CADA OPORTUNIDAD UN DIBUJO DISTINTO    
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
                                        System.out.println("\n\033[36mLA PALABRA ERA: "+palabraInicial);    //SI EL JUGADOR LLEGA A DIBUJAR TODO EL MUÑECO EL MISMO PERDERA, GENERANDO ASI EL MENU DE OPCIONES
                                        opcionesJuegos();
                                            while(opciones == 1){
                                                juegoAhorcado();
                                                opcionesJuegos();
                                            }
                                    }                                                                        
                            }   //SI EL JUGADOR LOGRA COMPLETAR LAS LETRAS SE LE NOTIFICARA QUE HA GANADO, DESPUES APARECERA EL MENU DE OPCIONES
                            if(palabraIntentos.equalsIgnoreCase(palabraInicial)){
                                System.out.println("\n\n\033[32m¡HAS COMPLETADO LA PALABRA, ENHORABUENA! ");
                                opcionesJuegos();
                                    while(opciones == 1){
                                        juegoAhorcado();
                                        opcionesJuegos();
                                    }
                            }                                        
                    }                 
    }
    //INICIO DEL JUEGO DE BASKETBALL, GUARDADO EN UN METODO
    static int opcionTiro,puntosAnotados,probabilidadAnotar,probabilidadFalta;
    static int opcionDefensa,puntosFaltas,falta,puntosJugador1,puntosJugador2;    
    public static void juegoBasketball() {    
        Random turnos = new Random();
        Scanner basketball = new Scanner(System.in);
        String jugadorUno,jugadorDos,turno;
        int inicioJuego;
        
        System.out.println("\n\n\n\n\n\nBIENVENIDO A UNA PARTIDA DE BASKETBALL\n");
        System.out.println("LAS REGLAS SON LAS SIGUIENTES:\n-CADA JUGADOR INGRESARÁ SU NOMBRE\n-INGRESARÁN LA CANTIDAD DE TURNOS PARA CADA JUGADOR");
        System.out.println("-AL FINAL DE LOS TURNOS EL QUE TENGA MÁS PUNTOS SERÁ EL GANADOR.");
        System.out.print("\nINGRESE SU NOMBRE: "); //SE INGRESAN LOS NOMBRES DE LOS DOS JUGADORES
        jugadorUno = basketball.nextLine();
        System.out.print("\nINGRESE SU NOMBRE: ");
        jugadorDos = basketball.nextLine();
        
        inicioJuego = turnos.nextInt(2)+1;  //AQUI SE SENTENCIA EL ORDEN PARA EL INICIO DEL PARTIDO MEDIANTE UN RANDOM            
            if(inicioJuego ==1){    //DEPENDIENDO DE LA COMBINACION QUE SE GENERE SERA EL ORDEN
                System.out.println("\nEL PRIMER TURNO SERÁ PARA: "+jugadorUno);
                System.out.println("EL SEGUNDO TURNO SERÁ PARA: "+jugadorDos);
            }
            else{
                System.out.println("\nEL PRIMER TURNO SERÁ PARA: "+jugadorDos);
                System.out.println("EL SEGUNDO TURNO SERÁ PARA: "+jugadorUno);
            }            
                System.out.print("\n¿CUÁNTOS TURNOS TENDRÁ CADA JUGADOR?: ");   //EL USUARIO INGRESA EL NUMERO DE TURNOS POR JUGADOR
                turno = basketball.nextLine();
                int noTurnos = Integer.parseInt(turno); //SE USO UNA VARIABLE TIPO STRING Y DESPUES SE CONVIRTIO A ENTERO DEBIDO AL SALTO QUE GENERA UN ENTERO
                noTurnos = noTurnos*2;
                
        while(noTurnos > 0){    //INICIO DEL PARTIDO DE BASKETBALL
                        System.out.println("\n\n\033[32mQUEDAN: "+noTurnos+" TURNOS PARA QUE ACABE EL JUEGO");                
                if(inicioJuego ==1){    //AQUI DEPENDIENDO DEL ORDEN SERA EL CICLO UTILIZADO, ESTE CICLO DEFINE EL ORDEN DE LOS TURNOS DEPENDIENDO DE QUIEN HAYA SIDO ELEGIDO PRIMERO EN LA SENTENCIA ANTERIOR
                    //UNA CONDICION PARA QUE LOS TURNOS VAYAN ALTERANDO DE UNA MANERA QUE NINGUNO TENGA TURNO DEMAS O TURNOS MENOS
                    if(noTurnos%2==0){  //SENTENCIA EN DONDE EL JUGADOR UNO INICIA CON LANZAMIENTOS
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorUno);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorDos);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println("\n"+jugadorUno+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorUno+" HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador1 = puntosJugador1 + (puntosAnotados + puntosFaltas);                       
                    }
                    else{
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorDos);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorUno);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println("\n"+jugadorDos+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorDos+" HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador2 = puntosJugador2 + (puntosAnotados + puntosFaltas);
                    }                                     
                }
                else{   //SENTENCIA EN DONDE LE JUGADOR DOS INICIA CON LANZAMIENTOS                    
                    if(noTurnos%2==0){
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorDos);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorUno);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println("\n"+jugadorDos+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorDos+" HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador2 = puntosJugador2 + (puntosAnotados + puntosFaltas);                        
                    }
                    else{
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorUno);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorDos);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println("\n"+jugadorUno+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorUno+" HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador1 = puntosJugador1 + (puntosAnotados + puntosFaltas);
                    }
                }   //AL FINALIZAR CADA TURNO SE MUESTRA LOS PUNTOS HECHOS POR CADA UNO, ADEMAS DE LAS FALTAS HECHAS
                System.out.println("\nPUNTOS DE "+jugadorUno+" = "+puntosJugador1);
                System.out.println("PUNTOS DE "+jugadorDos+" = "+puntosJugador2);        
                noTurnos--; //CONTADOR PARA IR RESTANDO LOS TURNOS HASTA LLEGAR A 0, DE SER ASI EL PARTIDO ACABA
                if(noTurnos == 0){//CUANDO EL PARTIDO ACABE SE DEBE DE ELEGIR AL GANADOR, ESTO MEDIANTE UNA COMPARACION DE PUNTOS
                    if(puntosJugador1 < puntosJugador2) {
                        System.out.println("\n\033[32m¡EL JUGADOR "+jugadorDos+" HA GANADO EL PARTIDO DE BASKETBALL");
                    }
                    if(puntosJugador1 == puntosJugador2){
                        System.out.println("\n\033[32m¡SORPRENDENTE! EL PARTIDO HA QUEDADO EN EMPATE");
                    }                    
                    if(puntosJugador2 < puntosJugador1){
                        System.out.println("\n\033[32m¡EL JUGADOR "+jugadorUno+" HA GANADO EL PARTIDO DE BASKETBALL");
                    }
                }
        }            
    }   //METODO PARA GENERAR EL PORCENTAJE DE TIRO Y DEFENSA MEDIANTE UN RANDOM
    public static int porcentajes(){
        Random porcentaje = new Random();
        return porcentaje.nextInt(99)+1;
    }   //METODO PARA INGRESAR Y GUARDAR LA OPCION DE TIRO
    public static int lanzamientosJugador(){        
            Scanner lanzar = new Scanner(System.in);
                System.out.println("\n               SELECCIONE EL TIPO DE LANZAMIENTO: ");
                System.out.println("1. -LANZAMIENTO LARGO (3 PUNTOS).      -PROBABILIDAD DE ANOTAR = 65%");
                System.out.println("2. -LANZAMIENTO CORTO (2 PUNTOS).      -PROBABILIDAD DE ANOTAR = 80%");
                System.out.print("¿QUÉ LANZAMIENTO REALIZARÁ? (ESCRIBA EL NÚMERO DE LA OPCIÓN): ");
            opcionTiro = lanzar.nextInt();        
        return opcionTiro;
    }        //METODO PARA INGRESAR Y GUARDAR LA OPCION DE DEFENSA
    public static int defensaJugador (){        
            Scanner defender = new Scanner(System.in);       
                System.out.println("\n                            SELECCIONE EL TIPO DE DEFENSA: ");
                System.out.println("1. -DEFENSA CUERPO A CUERPO (35% DE COMETER FALTA).   -REDUCE UN 15% LA PROBABILIDAD DE ANOTAR");
                System.out.println("2. -DEFENSA FUERTE (65% DE COMETER FALTA).            -REDUCE UN 30% LA PROBABILIDAD DE ANOTAR");
                System.out.print("¿QUÉ DEFENSA USARÁ? (ESCRIBA EL NÚMERO DE LA OPCIÓN): ");
            opcionDefensa = defender.nextInt();                        
        return opcionDefensa;            
    }   //METODO PARA EL CALCULO DE LAS LAS FALTAS Y LOS PUNTOS MEDIANTE EL USO DEL METODO DE PORCENTAJES Y RETORNANDO LOS PUNTOS OBTENIDOS POR DICHA FALTA
    public static int puntosFalta (){
        falta = porcentajes();  
        System.out.println("\n¡FALTA COMETIDA!");
                if(falta <= 90){    //SENTENCIA PARA SABER SI ANOTA O NO LA FALTA
                    System.out.println("FALTA ANOTADA, EL JUGADOR OBTIENE 2 PUNTOS");
                    puntosFaltas = 2;
                }
                else{
                    System.out.println("HAS FALLADO LA FALTA");
                    puntosFaltas = 0;
                } 
        return puntosFaltas;
    }   //METODO PARA CALCULAR LOS PUNTOS QUE CADA JUGADOR OBTIENE
    public static int combinacionPuntos(){
        probabilidadAnotar = porcentajes();
        probabilidadFalta = porcentajes(); //SENTENCIAMOS LOS PUNTOS QUE SE OBTIENEN DEPENDIENDO DE LAS COMBINACIONES QUE SE PUEDAN DAR
                if(opcionTiro == 1 && opcionDefensa ==1){                    
                        if(probabilidadAnotar <= 50){
                            puntosAnotados = 3;
                        }
                        else{
                            puntosAnotados = 0;
                        }
                }
                if(opcionTiro == 1 && opcionDefensa ==2){
                        if(probabilidadAnotar <= 35){
                            puntosAnotados = 3;
                        }
                        else{
                            puntosAnotados = 0;
                        }
                }
                if(opcionTiro == 2 && opcionDefensa ==1){
                        if(probabilidadAnotar <= 65 ){
                            puntosAnotados = 2;
                        }
                        else{
                            puntosAnotados = 0;
                        }
                }
                if(opcionTiro == 2 && opcionDefensa ==2){
                        if(probabilidadAnotar <= 50){
                            puntosAnotados = 2;
                        }
                        else{
                            puntosAnotados = 0;
                        }
                }                                            
        return puntosAnotados;  //RETORNAMOS LOS PUNTOS QUE HA GANADO
    }   //METODO PARA CALCULAR SI LA FALTA SI EXISTE O NO DEPENDIENDO DE PORCENTAJES Y MEDIANTE RANDOM
    public static int combinacionFaltas(){
                if(opcionDefensa == 1){                                        
                        if(probabilidadFalta <= 35){
                            puntosFalta();
                        }
                }
                else{
                        if(probabilidadFalta <= 65){
                            puntosFalta();
                        }                
                }
        return puntosFaltas;
    } 
    //INICIO JUEGO DE CARTAS, GUARDADO EN SU PROPIO METODO
    String representar1,representar2;
    public static void juegoCartas() {    
        Scanner juegoCartas = new Scanner(System.in);
        String dineroInicial;
        Double apuesta;        
            System.out.println("\n\n\n\n\n\nBIENVENIDO A LAS VEGAS.\nESTE JUEGO TE HARÁ SENTIR COMO TODO UN APOSTADOR.\n");
            System.out.println("LAS REGLAS SON BÁSICAS");
            System.out.println("\n-EL JUGADOR INGRESARÁ TODO EL DINERO QUE DESEE APOSTAR\n-EN CADA TURNO SE LE PRESENTARÁN DOS CARTAS");
            System.out.println("-SI EL VALOR DE LA CARTA QUE SAQUE EL JUGADOR SE ENCUENTRA ENTRE LOS VALORES DE LAS DOS CARTAS, EL JUGADOR GANA, DE NO SER ASÍ EL JUGADOR PERDERÁ SU DINERO");
            System.out.println("-INGRESARÁ LA CANTIDAD QUE DESEA APOSTAR EN CADA TURNO.\n-EL JUEGO ACABA CUANDO EL JUGADOR SE QUEDE SIN DINERO\n");
            System.out.println("\033[32m  ORDEN DE LAS CARTAS: ");
            System.out.println("\033[32m ♠️   2 3 4 5 6 7 8 9 10 J Q K \n");
            System.out.print("INGRESE SU APUESTA: Q ");
            dineroInicial = juegoCartas.nextLine(); //SE INGRESA LA CANTIDAD INICIAL CON LA QUE EL JUGADOR VA A INICIAR
            Double dineroFinal = Double.parseDouble(dineroInicial);
            Double dineroenJuego=dineroFinal;//EL CAMBIO DE VARIABLE PAR EVITAR QUE EL CICLO SE REPITA SIN PREVIA ORDEN
        
        while(dineroenJuego > 0){   //INICIO DEL JUEGO      
            int numeroUno = numerosAleatorios();    //SE SENTENCIAN TRES NUMEROS QUE SERAN ALEATORIOS USANDO UN METODO
            int numeroDos = numerosAleatorios();
            int numeroTres =numerosAleatorios();
                //SI LOS NUMEROS ALEATORIOS SON IGUALES, ENTONCES SE DEBEN DE VOLVER A GENERAR, DEBIDO A QUE NO EXISTEN ENTEROS ENTRE ELLOS
                if(numeroUno == numeroDos){
                    numeroUno = numerosAleatorios();
                    numeroDos = numerosAleatorios();
                }   //SI LA DIFERENCIA ENTRE ELLOS ES DE 1, SE VOLVERA A GENERAR UNO DE LOS NUMEROS, DEBIDO A QUE LOS NUMEROS SON CONSECUTIVOS
                else{ //SI NO OCUUREN NINGUNA DE LAS COMBINACIONES ANTERIORES, EL JUEGO EMPEZARA Y ASI EMPEZARAN LAS JUGADAS
                    if((numeroUno - numeroDos) == 1 || (numeroDos-numeroUno) == 1){     //SI EL NUMERO SE ENCUENTRA CONTENIDO ENTRE LOS OTROS DOS ENTONCES...
                    numeroDos = numerosAleatorios();
                    }
                    else{   //VARIABLES TIPO STRING PARA GUARDAR LOS CARACTERES ESPECIALES DE LAS CARTAS
                    String representar1 = String.valueOf(numeroUno);
                    String representar2 = String.valueOf(numeroDos);
                    String representar3 = String.valueOf(numeroTres);
                            //MEDIANTE ESTA COMBINACION DE CICLOS SE SUSTITUYEN LOS NUMEROS POR LOS CARACTERES CORRESPONDIENTES, COMO EL AS, LA J, Q Y K
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
                            representar1 = "Q";
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
                        }   //SE MUESTRAN LAS DOS CARTAS DEL JUEGO
                            System.out.print("\nSIGUIENTE JUEGO DE CARTAS:\n");
                            System.out.println("                CARTA 1 =        ♦️   "+representar1+"   ♠️");
                            System.out.println("                CARTA 2 =        ♦️   "+representar2+"   ♠️");                                                          
                            System.out.print("¿CUÁNTO DESEA APOSTAR?: Q ");//EL USUARIO INGRESA EL DINERO QUE VA A APOSTAR, DESPUES DE INGRESARLO SE MOSTRARA SU CARTA DE JUEGO
                            apuesta = juegoCartas.nextDouble();                                            
                            System.out.println("\n\n\n\n\033[32m                SU CARTA ES:     ♦️   "+representar3+"   ♠️"); 
                                        // DESPUES DE MOSTRARSE LA CARTA, SE PROCEDE A SENTENCIAR SI GANO O NO LA PARTIDA
                                if((numeroTres<numeroDos && numeroTres>numeroUno) || (numeroTres>numeroDos && numeroTres<numeroUno) ){                    
                                        dineroenJuego = dineroenJuego + apuesta;//SI EL JUGADOR GANA SE LE SUMARA EL DINERO DE LA APUESTA A SU DINERO ACTUAL
                                        System.out.println("\033[32m                HA GANADO EN ESTA JUGADA");
                                        System.out.println("\nDINERO ACTUAL EN EL JUEGO: Q "+dineroenJuego);
                    
                                }                
                                else{ //EN CASO DE NO GANAR SE LE RESTARA EL DINERO DE LA APUESTA A SU DINERO
                                    dineroenJuego = dineroenJuego - apuesta;                    
                                        if(dineroenJuego <= 0 ){    //SI EL JUGADOR PIERDE TODO SU DINERO, ENTONCES SE LE NOTIFICARA QUE YA NO PUEDE SEGUIR JUGANDO
                                            dineroenJuego = 0.00;
                                            System.out.println("\nYA NO CUENTA CON DINERO SUFICIENTE PARA SEGUIR JUGANDO: ");
                                            System.out.println("DINERO ACTUAL EN JUEGO: Q "+dineroenJuego);
                                        }   
                                        else{//SI AUN CUENTA CON DINERO SOLO SE LE NOTIFICARA EL DINERO QUE HA PERDIDO Y EL JUEGO SEGUIRA
                                            System.out.println("\033[32m                HA PERDIDO EN ESTA JUGADA");
                                            System.out.println("\nDINERO ACTUAL EN EL JUEGO: Q "+dineroenJuego);    
                                        }
                                }                                                                                               
                    }
                }
        }
    }          //METODO PARA GENERAR LOS NUMEROS ALEATORIOS PARA LAS CARTAS
    public static int numerosAleatorios(){        
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(13)+1;
    }//INICIO DEL JUEGO TORRES DE HANOI
    static int noDiscos,jugada,torre,disco,columna,fila,valorPos,nuevaPos,fBorrar,cBorrar;
    static int contadorMovimientos = 0,contadorBuscar=0,buscarFila=0,buscarColumna=0;
    static int datosHanoi[][] = new int[11][4];
    static int hanoiResuelto[][] = new int [11][4];
    //METODO PARA LAS TORRES DE HANOI
    public static void hanoi() {
        Scanner ingresoDiscos = new Scanner(System.in);
        //YA QUE EN EL ENUNCIADO SE DEFINE QUE HASTA DIEZ DISCOS, ENTONCES SE ASIGNAN VALORES PARA LA PRIMERA COLUMNA DE LA MATRIZ
        datosHanoi[0][0]= 1;    datosHanoi[5][0]= 6;
        datosHanoi[1][0]= 2;    datosHanoi[6][0]= 7;
        datosHanoi[2][0]= 3;    datosHanoi[7][0]= 8;
        datosHanoi[3][0]= 4;    datosHanoi[8][0]= 9;
        datosHanoi[4][0]= 5;    datosHanoi[9][0]= 10;        
        datosHanoi[10][0]= 100; datosHanoi[10][1]= 100;
        datosHanoi[10][2]= 100;
            
            System.out.println("\n\n\n\n\n    BIENVENIDO A LAS TORRES DE HANOI:");
            System.out.println("\n\nLA REGLAS SON LAS SIGUIENTES:");
            System.out.println("-LA CANTIDAD MÍNIMA DE DISCOS PARA JUGAR ES DE 2 Y EL MÁXIMO ES DE 10 DISCOS");
            System.out.println("-EL JUGADOR NO PUEDE PONER DISCOS MÁS GRANDES ENCIMA DE OTROS DISCOS PEQUEÑOS.");
            System.out.println("-EL JUGADOR NO PUEDE MOVER DISCOS QUE TENGAN MÁS DISCOS ENCIMA. ");
            System.out.println("-SE LE MOSTRARÁ UNA IMAGEN ILUSTRATIVA, QUE SERÁ SUSTITUIDA POR NUḾEROS.");
            System.out.println("-LOS CUALES REPRESENTAN A CADA DISCO, TOMANDO EN CUENTA QUE NO PUEDE HABER UN NÚMERO MENOR DEBAJO DE UNO MAYOR.");
            System.out.print("\n\n-INGRESE LA CANTIDAD DE DISCOS CON LOS QUE DESEA JUGAR: ");
            noDiscos = ingresoDiscos.nextInt();  //SE GUARDA LA CANTIDAD DE DISCOS QUE SE VAN A GENERAR
            fila = noDiscos-1;
            dibujo();//SE MANDA A LLAMAR AL METODO DIBUJO PARA GENERAR EL DIBUJO DE LOS DISCOS
            listadoHanoi();//SE MANDA A LLAMAR AL METODO PARA MOSTRAR UN TIPO DE TORRES DE HANOI CON NUMEROS
            System.out.print("\n\nEL PRIMER MOVIMIENTO SIEMPRE DEBE SER EL DISCO NÚMERO 1.");
            
        while(contadorMovimientos >= 0){    //INICIO DEL JUEGO
                        
            System.out.println("\n\nHA REALIZADO: "+contadorMovimientos+" MOVIMIENTOS");    //SE LE VA NOTIFICANDO AL JUGADOR LA CANTIDAD DE MOVIMIENTOS QUE HA REALIZADO
            System.out.print("\nINGRESE QUE NÚMERO DE DISCO DESEA MOVER: ");    
            jugada = ingresoDiscos.nextInt();
            disco = jugada-1;//VARIABLES PARA INDICAR LA FILA Y LA COLUMNA A DONDE SE MOVERA
            valorPos = jugada;            
            System.out.print("INDIQUE A QUE TORRE DESEA MOVERLO: ");
            torre = ingresoDiscos.nextInt();
            columna = torre-1;
            System.out.println("\n");
            movimientos();  //SE LLAMA AL METODO ENCARGADO DE CONTROLAR LOS METODOS LOGICOS Y DE VERIFICAR LAS REGLAS DEL JUEGO
            contadorMovimientos++;
        }    
    }
    //METODO PARA GENERAR EL DIBUJO DE LOS DISCOS DEPENDIENDO DE LA CANTIDAD QUE EL USUARIO HAYA ELEGIDO
    public static void dibujo(){
        System.out.println("\n");
        System.out.println("  Torre 1                    Torre 2                    Torre 3");
                for(int z=0;z<noDiscos;z++){
                    for(int q=0;q<z;q++){
                        System.out.print("=");
                    }
                        System.out.println("=");
                }          
    }//METODO PARA GENERAR UN DIBUJO CON NUMEROS EN LUGAR DE DISCOS EL CUAL MOSTRARA CADA JUGADA QUE EL USUARIO HAYA HECHO
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
    //METODO ENCARGADO DE QUE LOS MOVIMIENTOS SEAN DE ACORDE A LAS REGLAS DEL JUEGO HANOI
    public static void movimientos(){
        //SE HAN HECHO SENTENCIAS ANIDADAS DEBIDO A LA COMPLEJIDAD QUE REQUIRE CADA MOVIMIENTO
        buscarNumero();//INICIO DE LAS SENTENCIAS
        if(datosHanoi[fila-1][cBorrar] < valorPos && datosHanoi[fila-1][cBorrar] !=0){//SI EL DISCO QUE SE DESEA PONER SE ENCUENTRA DEBAJO DE OTROS MAS PEQUEÑOS EL MOVIMIENTO NO ES VALIDO
                            
                System.out.println("ESTE MOVIMIENTO NO ES PERMITIDO, HAY MÁS DISCOS PEQUEÑOS ARRIBA");
                datosHanoi[fBorrar][cBorrar]= valorPos;
                datosHanoi[nuevaPos][columna] = 0;
                listadoHanoi();                                    
        }// SI ESTO NO SUCEDE, SE PODRA SEGUIR EL JUEGO
        else{ //SE BORRA EL VALOR DEL DISCO, PARA ASI HACER CONSTAR QUE SE REALIZO EL MOVIMIENTO
            datosHanoi[fBorrar][cBorrar] = 0;
            if(columna==0){ //SI SE ENCUENTRA EN LA COLUMNA, SE PROCEDEN A BORRAR ALGUNOS ELEMENTOS POSTERIORES EN ESA COLUMNA, PARA EVITAR QUE HAYA PROBLEMAS CON LAS SENTENCIAS SIGUIENTES
                datosHanoi[noDiscos][0]=0;
                datosHanoi[noDiscos+1][0]=0;
                datosHanoi[noDiscos+2][0]=0;            
            }//SI EL ESPACIO SIGUIENTE AL QUE QUEREMOS ES CERO Y EL QUE QUEREMOS ES CERO PODREMOS PONER EL DISCO SIN PROBLEMA
            if((datosHanoi[noDiscos][columna]==0) && (datosHanoi[fila][columna] ==0)){           
                datosHanoi[fila][columna] = valorPos; 
                listadoHanoi();                            
            }
            else{// DE NO SER ASI SE DEBERA DE HACER UNA DE ESTAS COMBINACIONES, DEPENDIENDO DE LA CANTIDAD DE DISCOS QUE SE HAYAN ELEGIDO, YA QUE EL MAXIMO ES DIEZ SE EMPEZARA DESDE ESE NUMERO
                //DEBIDO A QUE SI SE EMPIEZA DESDE EL MAS PEQUEÑO LA SENTENCIA DETECTARA QUE DEBE GUARDAR EL NUMERO DEL DISCO EN TODAS LAS POSICIONES, ENTONCES EN BASE A ESTO SE LEERA DESDE LA SENTENIA MAS GRANDE
                //ASI IRA LEYENDO DESDE ABAJO HASTA ARRIBA HASTA ENCONTRAR UN ESPACIO QUE CUMPLA, ES DECIR, NO SOBREESCRIBIR SOBRE UN NUMERO QUE NO SEA 0
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
                }//UNA VEZ TERMINADO DE UBICAR AL DISCO EN SU POSICION SE DEBE DE ANALIZAR SI NO LAJUGADA ES VALIDA DE ACUERDO A LAS REGLAS DEL JUEGO
                condiciones();
            }
        }              
    }   //METODO PARA LAS CONDICIONES O REGLAS DEL JUEGO
    public static void condiciones(){           
            // SI EL NUMERO O DISCO DE ABAJO ES MENOR, EL MOVIENTO NO SE PUEDE REALIZAR
            if(datosHanoi[nuevaPos+1][columna] < datosHanoi[nuevaPos][columna]){
                    System.out.println("ESTE MOVIMIENTO NO ES PERMITIDO, HAY UN DISCO MÁS PEQUEÑO ABAJO");
                    datosHanoi[fBorrar][cBorrar]= valorPos;
                    datosHanoi[nuevaPos][columna] = 0;
                    listadoHanoi();                                    
            }
            else{   //DE CASO CONTRARIO EL MOVIMIENTO ES VALIDO
                    System.out.println("MOVIMIENTO EXITOSO");
                    listadoHanoi();
            }                
    } //METODO PARA BUSCAR EN LA MATRIZ EL NUMERO DEL DISCO QUE SE DESEA MOVER, ASI DAR LA POSICION EXACTA DEL MISMO
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







