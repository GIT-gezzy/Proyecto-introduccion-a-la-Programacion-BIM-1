/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal1;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Alexito
 */
public class ProyectoFinalCorreciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);
        String nombre;
        String genero_nombre;
        String nivel_fisico_nombre;
        int genero;
        int nivel_fisico;
        String nombreComida;
        String tipoComida;
        String detalleComidas = "";
        String estadoDieta;
        String estadoSemanal;
        String salida;
        String reporte = "";
        int edad;
        double peso;
        double estatura;
        double multiplicador;
        double tmb;
        double gastoEstimadoDiario = 0;
        double caloriasComida;
        double sumaCaloriasDia;
        double balanceDia;
        double totalSemanal = 0;
        double promedioSemanal;
        int contadorDia = 1;
        int contadorComida;

        System.out.println("Ingrese su nombre: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese su genero(Masculino = 1/ Femenino = 2): ");
        genero = entrada.nextInt();
        System.out.println("Ingrese su edad: ");
        edad = entrada.nextInt();
        System.out.println("Ingrese su peso(Kg): ");
        peso = entrada.nextDouble();
        System.out.println("Ingrese su estatura(cm): ");
        estatura = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Ingrese su nivel de actividad física (Sedentario (0), "
                + "Ligero (1), Moderado (2), Intenso (3), Muy intenso(4))");
        nivel_fisico = entrada.nextInt();
        entrada.nextLine();

        switch (genero) {
            case 1:
                genero_nombre = "Masculino";
                tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) + 5;
                break;
            case 2:
                genero_nombre = "Femenino";
                tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161;
                break;
            default:
                genero_nombre = "No definido";
                tmb = 1500;
                break;
        }

        switch (nivel_fisico) {
            case 0:
                nivel_fisico_nombre = "Sedentario";
                multiplicador = 1.2;
                break;
            case 1:
                nivel_fisico_nombre = "Ligero";
                multiplicador = 1.37;
                break;
            case 2:
                nivel_fisico_nombre = "Moderado";
                multiplicador = 1.55;
                break;
            case 3:
                nivel_fisico_nombre = "Intenso";
                multiplicador = 1.72;
                break;
            case 4:
                nivel_fisico_nombre = "Muy Intenso";
                multiplicador = 1.9;
                break;
            default:
                nivel_fisico_nombre = "Sin Registro";
                multiplicador = 1.2;
                break;
        }

        while (contadorDia <= 7) {
            contadorComida = 1;
            sumaCaloriasDia = 0;
            do {
                System.out.printf("Día-%d Comida-%d\n", contadorDia,
                        contadorComida);
                System.out.println("Ingrese nombre de su comida: ");
                nombreComida = entrada.nextLine();
                System.out.println("Ingrese tipo de comida: ");
                tipoComida = entrada.nextLine();
                System.out.println("Ingrese las calorías su comida: ");
                caloriasComida = entrada.nextInt();
                entrada.nextLine();
                sumaCaloriasDia = sumaCaloriasDia + caloriasComida;
                detalleComidas += String.format("   - %s (%s): %.2f calorías\n",
                        nombreComida, tipoComida, caloriasComida);
                System.out.println("Escriba ''C'' para continuar ingresando "
                        + "comidas\nEscriba ''N'' para saltar al siguiente dia");
                salida = entrada.nextLine();
                salida = salida.toUpperCase();
                contadorComida = contadorComida + 1;
            } while (salida.equals("C"));
            gastoEstimadoDiario = tmb * multiplicador;
            balanceDia = sumaCaloriasDia - gastoEstimadoDiario;
            if (balanceDia < 0) {
                estadoDieta = "Deficit";
            } else {
                if (balanceDia > 0) {
                    estadoDieta = "Superávit";
                } else {
                    estadoDieta = "Equilibrado";
                }
            }
            reporte = String.format("%sDía %d:\nCalorías Consumidas = %.2f\n%s"
                    + "Balance = %.2f, Estado = %s\n\n",
                    reporte, contadorDia, sumaCaloriasDia, detalleComidas, 
                    balanceDia, estadoDieta);
            totalSemanal = totalSemanal + balanceDia;
            contadorDia = contadorDia + 1;
        }
        promedioSemanal = totalSemanal / 7;
        if (promedioSemanal < 0) {
            estadoSemanal = "Deficit";
        } else {
            if (promedioSemanal > 0) {
                estadoSemanal = "Superávit";
            } else {
                estadoSemanal = "Equilibrado";
            }
        }
        reporte = String.format("REPORTE SEMANAL - CONTROL DE ALIMENTACIÓN\n"
                + "Nombre: %s\n"
                + "Género: %s\n"
                + "Edad: %d\n"
                + "Peso: %.2f\n"
                + "Estatura: %.2f\n"
                + "TMB: %.2f\n"
                + "Nivel de Actividad Física: %s\n"
                + "Gasto Estimado diario (Segun su actividad física): %.2f\n"
                + "------------------\n"
                + "%s"
                + "-------------------\n"
                + "Balance calórico promedio semanal: %.2f (%s)", nombre,
                genero_nombre, edad, peso, estatura, tmb, nivel_fisico_nombre,
                gastoEstimadoDiario, reporte, promedioSemanal, estadoSemanal);
        System.out.printf("%s", reporte);
    }
}
