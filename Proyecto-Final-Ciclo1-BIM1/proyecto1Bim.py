salida = ""
reporte = ""
multiplicador = 0
totalSemanal = 0
contadorDia = 1
bandera = True

nombre = input("Ingrese su nombre: ")
genero = int(input("Ingrese su género (1 = Masculino / 2 = Femenino): "))
edad = int(input("Ingrese su edad: "))
peso = float(input("Ingrese su peso(Kg): "))
estatura = int(input("Ingrese su estatura(cm): "))

print("Ingrese su nivel de actividad física:")
print("Sedentario (0), Ligero (1), Moderado (2), Intenso (3), Muy intenso (4)")
nivel_fisico = int(input("Nivel: "))

if genero == 1:
    genero_nombre = "Masculino"
    tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) + 5
elif genero == 2:
    genero_nombre = "Femenino"
    tmb = (10 * peso) + (6.25 * estatura) - (5 * edad) - 161
else:
    genero_nombre = "No definido"
    tmb = 1500 

if nivel_fisico == 0:
    nivel_fisico_nombre = "Sedentario"
    multiplicador = 1.2
elif nivel_fisico == 1:
    nivel_fisico_nombre = "Ligero"
    multiplicador = 1.37
elif nivel_fisico == 2:
    nivel_fisico_nombre = "Moderado"
    multiplicador = 1.55
elif nivel_fisico == 3:
    nivel_fisico_nombre = "Intenso"
    multiplicador = 1.72
elif nivel_fisico == 4:
    nivel_fisico_nombre = "Muy Intenso"
    multiplicador = 1.9
else:
    nivel_fisico_nombre = "Sin Registro"
    multiplicador = 1.2

while contadorDia <= 7:

    contadorComida = 1
    sumaCaloriasDia = 0
    detalleComidas = ""  
    bandera = True

    while bandera:
        print(f"Día-{contadorDia} Comida-{contadorComida}")

        nombreComida = input("Ingrese nombre de su comida: ")
        tipoComida = input("Ingrese tipo de comida: ")
        caloriasComida = int(input("Ingrese las calorías de su comida: "))

        sumaCaloriasDia = sumaCaloriasDia + caloriasComida
        contadorComida = contadorComida + 1

        detalleComidas = detalleComidas + "\t- {} ({}): {} calorías\n".format(
            nombreComida, tipoComida, caloriasComida)

        salida = input("Escriba ''C'' para continuar ingresando comidas o ''N'' para saltar al siguiente dia:")
        salida = salida.upper()

        if salida == "C":
            bandera = True
        else:
            bandera = False

    gastoEstimadoDiario = tmb * multiplicador
    balanceDia = sumaCaloriasDia - gastoEstimadoDiario

    if balanceDia < 0:
        estadoDieta = "Deficit"
    elif balanceDia > 0:
        estadoDieta = "Superávit"
    else:
        estadoDieta = "Equilibrado"

    reporte = "{}Día {}:\nCalorías Consumidas = {}\n{}Balance = {}, Estado = {}\n\n".format(
    reporte, contadorDia, sumaCaloriasDia, detalleComidas, balanceDia, estadoDieta)

    totalSemanal = totalSemanal + balanceDia
    contadorDia = contadorDia+  1

promedioSemanal = totalSemanal / 7

if promedioSemanal < 0:
    estadoSemanal = "Deficit"
elif promedioSemanal > 0:
    estadoSemanal = "Superávit"
else:
    estadoSemanal = "Equilibrado"

reporteFinal = "REPORTE SEMANAL- CONTROL DE ALIMENTACIÓN\nNombre: {}\n" \
"Género: {}\n" \
"Edad: {}\n" \
"Peso: {}\n" \
"Estatura: {}\n" \
"TMB: {}\n" \
"Nivel de Actividad Física {}\n----------------------\n{}\n---------------------\n" \
"Balance Calórico promedio semanal: {} ({})".format(
    nombre, genero_nombre, edad, peso, estatura, tmb, nivel_fisico_nombre,
    reporte, promedioSemanal, estadoSemanal)
print(reporteFinal)