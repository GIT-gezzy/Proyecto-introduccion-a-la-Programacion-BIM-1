
#Inicializando datos
salida = ""
reporte = ""
multiplicador = 0
totalSemanal = 0
contadorDia = 0

#CREO Bandera para remplazar el Do while por un while que opere en funcion de TRUE/FALSE
bandera = True

nombre = input("Ingrese su nombre: ")
genero = input("Ingrese su género Masculino/Femenino: ")
edad = int(input("Ingrese su edad: "))
peso = float(input("Ingrese su peso(Kg): "))
estatura = int(input("Ingrese su estatura(cm): "))
nivel_fisico = input("Ingrese su nivel de actividad física(Sedebtario, "
                + "Ligero, Moderado, Intenso, Muy intenso): ")


if (genero == "Masculino"):
    tmb = (10 * peso) + (6.25 * estatura)-(5 * edad)+5
elif genero == "Femenino": 
    tmb = (10 * peso) + (6.25 * estatura)-(5 * edad)-161
    
if nivel_fisico == "Sedentario":
    multiplicador = 1.2
elif nivel_fisico == "Ligero":
    multiplicador = 1.37
elif nivel_fisico == "Moderado":
    multiplicador = 1.55
elif nivel_fisico == "Intenso":
    multiplicador = 1.72
elif nivel_fisico == "Muy intenso":
    multiplicador = 1.9
    
while (contadorDia <= 7):
    # Contador Comida, para que se reinicie en cada dia a 1 comida, de igual manera en suma calorias se reinicie a 0, igual con bandera
    contadorComida = 0
    sumaCaloriasDia = 0
    bandera = True
    while (bandera):
        nombreComida = input("Ingrese nombre de su comida: ")
        tipoComida = input("Ingrese tipo de comida: ")
        caloriasComida = int(input("Ingrese las calorías su comida: "))
        sumaCaloriasDia = sumaCaloriasDia + caloriasComida
        contadorComida = contadorComida + 1
        salida = input("Escriba ´C´ para continuar ingresando comidas: ")
        if salida =="c":
            bandera = True
        else:
            bandera = False
    gastoEstimadoDiario = tmb * multiplicador
    # Agrego Linea if
    #if contadorComida>1:
    #   promedioDia = sumaCaloriasDia / (contadorComida - 1)
    #else:
    promedioDia = sumaCaloriasDia / contadorComida 

    #Agrego Linea fin if
    balanceDia = sumaCaloriasDia - gastoEstimadoDiario 
    if balanceDia < 0:
        estadoDieta = "Deficit"
    elif balanceDia > 0:
        estadoDieta = "Superávit"
    else:
        estadoDieta = "Equilibrado"
    reporte = "{} Día{}: Promedio Calorías= {}, Balance= {}, Estado, {}".format(reporte,contadorDia, promedioDia, balanceDia,estadoDieta)
    totalSemanal = totalSemanal + balanceDia #Posible corrección balance dia por suma calorias Dia.
    contadorDia = contadorDia+1

promedioSemanal = totalSemanal / 7
reporte = "REPORTE SEMANAL- CONTROL DE ALIMENTACIÓN\nNombre: {}\nGénero: {}\nEdad: {}\nPeso: {}\nEstatura: {}\nTMB: {}\nNivelFísico {}\n----------------------\n{}\n---------------------\nBalance Calórico promedio semanal{}".format(nombre,genero,edad,peso,estatura,tmb,nivel_fisico,reporte,promedioSemanal)

print(f"{reporte}")
