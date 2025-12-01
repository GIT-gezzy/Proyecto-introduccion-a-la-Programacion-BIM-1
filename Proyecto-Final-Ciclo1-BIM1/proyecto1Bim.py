# Inicializando datos
salida = ""
reporte = ""
multiplicador = 0
totalSemanal = 0
contadorDia = 0

# Bandera para reemplazar un do-while
bandera = True

nombre = input("Ingrese su nombre: ")
genero = input("Ingrese su género Masculino/Femenino: ")
edad = int(input("Ingrese su edad: "))
peso = float(input("Ingrese su peso(Kg): "))
estatura = int(input("Ingrese su estatura(cm): "))
nivel_fisico = input("Ingrese su nivel de actividad física(Sedentario, Ligero, Moderado, Intenso, Muy intenso): ")

# Cálculo TMB según género
if genero == "Masculino":
    tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) + 5
elif genero == "Femenino":
    tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161
else:
    tmb = 1500  # Valor por defecto 

# Multiplicador según nivel físico
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
else:
    multiplicador = 1.2 

while contadorDia <= 7:
    contadorComida = 0
    sumaCaloriasDia = 0
    bandera = True

    while bandera:
        print(f"Día-{contadorDia} Comida-{contadorComida}")
        nombreComida = input("Ingrese nombre de su comida: ")
        tipoComida = input("Ingrese tipo de comida: ")
        caloriasComida = int(input("Ingrese las calorías de su comida: "))

        sumaCaloriasDia = sumaCaloriasDia + caloriasComida
        contadorComida = contadorComida + 1

        salida = input("Escriba 'C' para continuar ingresando comidas: ").upper()

        if salida == "C":
            bandera = True
        else:
            bandera = False

    gastoEstimadoDiario = tmb * multiplicador
    promedioDia = sumaCaloriasDia / contadorComida

    balanceDia = sumaCaloriasDia - gastoEstimadoDiario

    if balanceDia < 0:
        estadoDieta = "Deficit"
    elif balanceDia > 0:
        estadoDieta = "Superávit"
    else:
        estadoDieta = "Equilibrado"

    reporte = "{} Día{}: Promedio Calorías= {}, Balance= {}, Estado, {}".format(
        reporte, contadorDia, promedioDia, balanceDia, estadoDieta
    )

    totalSemanal = totalSemanal + balanceDia
    contadorDia = contadorDia + 1

promedioSemanal = totalSemanal / 7

reporte = "REPORTE SEMANAL- CONTROL DE ALIMENTACIÓN\nNombre: {}\nGénero: {}\nEdad: {}\nPeso: {}\nEstatura: {}\nTMB: {}\nNivelFísico {}\n----------------------\n{}\n---------------------\nBalance Calórico promedio semanal{}".format(
    nombre, genero, edad, peso, estatura, tmb, nivel_fisico, reporte, promedioSemanal
)

print(f"{reporte}")
