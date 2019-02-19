import java.util.Random;
import java.util.Scanner;

public class Basketball {    
    static int opcionTiro,puntosAnotados,probabilidadAnotar,probabilidadFalta;
    static int opcionDefensa,puntosFaltas,falta,puntosJugador1,puntosJugador2;
    
    public static void main(String[] args) {    
        Random turnos = new Random();
        Scanner basketball = new Scanner(System.in);
        String jugadorUno,jugadorDos,turno;
        int inicioJuego;
        
        System.out.println("BIENVENIDO A UNA PARTIDA DE BASKETBALL\n");
        System.out.println("LAS REGLAS SON LAS SIGUIENTES:\n-CADA JUGADOR INGRESARÁ SU NOMBRE\n-INGRESARÁN LA CANTIDAD DE TURNOS PARA CADA JUGADOR");
        System.out.println("-AL FINAL DE LOS TURNOS EL QUE TENGA MÁS PUNTOS SERÁ EL GANADOR.");
        System.out.print("\nINGRESE SU NOMBRE: ");
        jugadorUno = basketball.nextLine();
        System.out.print("\nINGRESE SU NOMBRE: ");
        jugadorDos = basketball.nextLine();
        
        inicioJuego = turnos.nextInt(2)+1;
            
            if(inicioJuego ==1){
                System.out.println("\nEL PRIMER TURNO SERÁ PARA: "+jugadorUno);
                System.out.println("EL SEGUNDO TURNO SERÁ PARA: "+jugadorDos);
            }
            else{
                System.out.println("\nEL PRIMER TURNO SERÁ PARA: "+jugadorDos);
                System.out.println("EL SEGUNDO TURNO SERÁ PARA: "+jugadorUno);
            }            
                System.out.print("\n¿CUÁNTOS TURNOS TENDRÁ CADA JUGADOR?: ");
                turno = basketball.nextLine();
                int noTurnos = Integer.parseInt(turno);
                noTurnos = noTurnos*2;
                
            while(noTurnos > 0){
                System.out.println("\n\n\033[32mQUEDAN: "+noTurnos+" TURNOS PARA QUE ACABE EL JUEGO");
                
                if(inicioJuego ==1){
                    
                    if(noTurnos%2==0){
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorUno);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorDos);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println(jugadorUno+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorUno+ " HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador1 = puntosJugador1 + (puntosAnotados + puntosFaltas);                       
                    }
                    else{
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorDos);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorUno);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println(jugadorDos+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorDos+" HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador2 = puntosJugador2 + (puntosAnotados + puntosFaltas);
                    }                                     
                }
                else{                    
                    if(noTurnos%2==0){
                        System.out.println("\033[32mTURNO DE LANZAMIENTO PARA: "+jugadorDos);
                        System.out.println("\033[32mTURNO DE DEFENSA PARA:     "+jugadorUno);
                        lanzamientosJugador();
                        defensaJugador();
                        combinacionPuntos();
                        combinacionFaltas();
                        System.out.println(jugadorDos+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
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
                        System.out.println(jugadorUno+" HA ANOTADO: "+puntosAnotados+" PUNTOS");
                        System.out.println(jugadorUno+" HA HECHO: "+puntosFaltas+" PUNTOS POR FALTA");
                        puntosJugador1 = puntosJugador1 + (puntosAnotados + puntosFaltas);
                    }
                }
                System.out.println("\nPUNTOS DE "+jugadorUno+" = "+puntosJugador1);
                System.out.println("PUNTOS DE "+jugadorDos+" = "+puntosJugador2);        
                noTurnos--;
                if(noTurnos == 0){
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
    }            
    public static int porcentajes(){
        Random porcentaje = new Random();
        return porcentaje.nextInt(99)+1;
    }    
    public static int lanzamientosJugador(){        
            Scanner lanzar = new Scanner(System.in);
                System.out.println("\n               SELECCIONE EL TIPO DE LANZAMIENTO: ");
                System.out.println("1. -LANZAMIENTO LARGO (3 PUNTOS).      -PROBABILIDAD DE ANOTAR = 65%");
                System.out.println("2. -LANZAMIENTO CORTO (2 PUNTOS).      -PROBABILIDAD DE ANOTAR = 80%");
                System.out.print("¿QUÉ LANZAMIENTO REALIZARÁ? (ESCRIBA EL NÚMERO DE LA OPCIÓN): ");
            opcionTiro = lanzar.nextInt();        
        return opcionTiro;
    }        
    public static int defensaJugador (){        
            Scanner defender = new Scanner(System.in);       
                System.out.println("\n                            SELECCIONE EL TIPO DE DEFENSA: ");
                System.out.println("1. -DEFENSA CUERPO A CUERPO (35% DE COMETER FALTA).   -REDUCE UN 15% LA PROBABILIDAD DE ANOTAR");
                System.out.println("2. -DEFENSA FUERTE (65% DE COMETER FALTA).            -REDUCE UN 30% LA PROBABILIDAD DE ANOTAR");
                System.out.print("¿QUÉ DEFENSA USARÁ? (ESCRIBA EL NÚMERO DE LA OPCIÓN): ");
            opcionDefensa = defender.nextInt();                        
        return opcionDefensa;            
    }
    public static int puntosFalta (){
        falta = porcentajes();  
        System.out.println("\n¡FALTA COMETIDA!");
                if(falta <= 90){
                    System.out.println("FALTA ANOTADA, EL JUGADOR OBTIENE 2 PUNTOS");
                    puntosFaltas = 2;
                }
                else{
                    System.out.println("HAS FALLADO LA FALTA");
                    puntosFaltas = 0;
                } 
        return puntosFaltas;
    }
    public static int combinacionPuntos(){
        probabilidadAnotar = porcentajes();
        probabilidadFalta = porcentajes();        
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
        return puntosAnotados;
    }
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
}
