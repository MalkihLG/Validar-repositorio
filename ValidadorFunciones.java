
import java.util.Scanner;

public class ValidadorFunciones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una funcion: ");
        String funcion = sc.nextLine().trim();

        int espacio = funcion.indexOf(' ');
        int parentesis = funcion.indexOf('(');

        if (espacio == -1 || parentesis == -1 || espacio >= parentesis) {
            System.out.println("Funcion invalida");
            sc.close();
            return;
        }

        String tipo = funcion.substring(0, espacio);
        String nombre = funcion.substring(espacio, parentesis).trim();
        String simbolos = funcion.substring(parentesis);

        boolean tipoValido = validarVoid(tipo);
        boolean nombreValido = validarNombre(nombre);
        boolean simbolosValidos = validarSimbolos(simbolos);

        if (tipoValido && nombreValido && simbolosValidos) {
            System.out.println("Funcion valida");
        } else {
            System.out.println("Funcion invalida");
        }

        sc.close();
    }

    //  AUTOMATA PARA VOID

    public static boolean validarVoid(String tipo) {
       
        return false;
    }

    //  AUTOMATA PARA  NOMBRE

    public static boolean validarNombre(String nombre) {
       
        return false;
    }

    // Cami: AUTOMATA DE SIMBOLOS

    public static boolean validarSimbolos(String simbolos) {

        int estado = 0;

        for (int i = 0; i < simbolos.length(); i++) {

            char letra = simbolos.charAt(i);

            if (Character.isWhitespace(letra)) {
                continue;
            }

            switch (estado) {

                case 0:
                    if (letra == '(') {
                        estado = 1;
                    } else {
                        estado = -1;
                    }
                    break;

                case 1:
                    if (letra == ')') {
                        estado = 2;
                    } else {
                        estado = -1;
                    }
                    break;

                case 2:
                    if (letra == '{') {
                        estado = 3;
                    } else {
                        estado = -1;
                    }
                    break;

                case 3:
                    if (letra == '}') {
                        estado = 4;
                    } else {
                        estado = -1;
                    }
                    break;

                default:
                    estado = -1;
                    break;
            }
        }

        return estado == 4;
    }
}
