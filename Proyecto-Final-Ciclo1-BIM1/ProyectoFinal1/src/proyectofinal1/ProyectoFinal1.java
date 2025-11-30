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
public class ProyectoFinal1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);
        String nombre;
        String genero;
        String nivel_fisico;
        String nombreComida;
        String tipoComida;
        String estadoDieta;
        String salida = "";
        String reporte = "";
        int edad;
        double peso;
        double estatura;
        double multiplicador = 0;
        double tmb;
        double gastoEstimadoDiario;
        double caloriasComida;
        double sumaCaloriasDia = 0;
        double promedioDia;
        double balanceDia;
        double totalSemanal = 0;
        double promedioSemanal;
        int contadorDia = 1;
        int contadorComida = 0;

        System.out.println("Ingrese su nombre: ");
        nombre = entrada.nextLine();
        System.out.println("Ingrese su genero(Maculino/Femenino): ");
        genero = entrada.nextLine();
        System.out.println("Ingrese su edad: ");
        edad = entrada.nextInt();
        System.out.println("Ingrese su peso(Kg): ");
        peso = entrada.nextDouble();
        System.out.println("Ingrese su estatura(cm): ");
        estatura = entrada.nextDouble();
        entrada.nextLine();
        System.out.println("Ingrese su nivel de actividad física(Sedebtario, "
                + "Ligero, Moderado, Intenso, Muy intenso)");
        nivel_fisico = entrada.nextLine();

        //Condicional asignar valores segun el genero
        if (genero.equals("Masculino")) {
            tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) + 5;
        } else {
            tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161;
        }
        // Condicional para asignar Multiplicador segun 

        if (nivel_fisico.equals("Sedentario")) {
            multiplicador = 1.2;
        } else {
            if (nivel_fisico.equals("Ligero")) {
                multiplicador = 1.37;
            } else {
                if (nivel_fisico.equals("Moderado")) {
                    multiplicador = 1.55;
                } else {
                    if (nivel_fisico.equals("Intenso")) {
                        multiplicador = 1.72;
                    } else {
                        if (nivel_fisico.equals("Muy Intenso")) {
                            multiplicador = 1.9;
                        }
                    }
                }

            }
        }

        while (contadorDia <= 7) {
            contadorComida = 0;
            sumaCaloriasDia = 0;
            //agrego linea
                System.out.printf("Dia %d\n",contadorDia);
            do {
                //Agrego Linea
                System.out.printf("Comida%d\n",contadorComida);
                System.out.println("Ingrese nombre de su comida: ");
                nombreComida = entrada.nextLine();
                System.out.println("Ingrese tipo de comida: ");
                tipoComida = entrada.nextLine();
                System.out.println("Ingrese las calorías su comida: ");
                caloriasComida = entrada.nextInt();
                entrada.nextLine();
                sumaCaloriasDia = sumaCaloriasDia + caloriasComida;
                System.out.println("Escriba ´C´ para continuar ingresando comidas: ");
                salida = entrada.nextLine();
                contadorComida = contadorComida + 1;
            } while (salida.equals("C"));
            gastoEstimadoDiario = tmb * multiplicador;
//            promedioDia = sumaCaloriasDia / (contadorComida - 1);
            promedioDia = sumaCaloriasDia / contadorComida;
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
            reporte = String.format("%sDía %d: Promedio Calorías= %.2f, Balance="
                    + "%.2f, Estado= %s\n",reporte,contadorDia,promedioDia,balanceDia,estadoDieta );
            totalSemanal = totalSemanal + balanceDia;
            contadorDia = contadorDia + 1;
        }
        promedioSemanal = totalSemanal / 7;
        reporte = String.format("REPORTE SEMANAL - CONTROL DE ALIMENTACIÓN\n"
                + "Nombre: %s\n"
                + "Género: %s\n"
                + "Edad:%d\n"
                + "Peso: %.2f"
                + "Estatura: %.2f\n"
                + "TMB: %.2f\n"
                + "Nivel Físico: %s\n"
                + "------------------\n"
                + "%s"
                + "-------------------\n"
                + "Balance calórico promedio semanal:  %.2f",nombre,genero,edad,
                peso,estatura,tmb,nivel_fisico,reporte,promedioSemanal);
        System.out.printf("%s", reporte);
    }
}
