package cliente.view;

import sop_corba.IStudentController;
import sop_corba.IStudentControllerPackage.InformeDTO;
import sop_corba.IStudentControllerPackage.StudentDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private IStudentController objRemoto;
    public Menu(IStudentController objRemoto){
        this.objRemoto = objRemoto;
    }

    public void mostrarMenu(){
        Scanner entrada = new Scanner(System.in);
        int opcMain = 0;
        while(opcMain != 3) {
            System.out.println("Bienvenido...");
            System.out.println("1. Registrar Notas");
            System.out.println("2. Generar informe");
            System.out.println("3. Salir");
            System.out.println("Digite una opción: ");
            opcMain = entrada.nextInt();
            switch (opcMain){
                case 1:
                    menuRegistrarNotas(entrada);
                    break;
                case 2:
                    InformeDTO informe = this.objRemoto.generarInforme();
                    System.out.println("\t  Informe generado... ");
                    System.out.println("1. Números de alertas rojas por corte: "+ informe.alertasRojas);
                    System.out.println("2. Estudiante atendidos por bienestar: ");
                    System.out.println("\t 2.1. Corte 1: " + informe.estudiantesBienestar[0]);
                    System.out.println("\t 2.2. Corte 2: " + informe.estudiantesBienestar[1]);
                    System.out.println("\t 2.3. Corte 3: " + informe.estudiantesBienestar[2]);
                    System.out.println("3. Estudiantes con alerta verde:");
                    System.out.println("\t 3.1. Corte 1: " + informe.alertaVerdeCorte[0]);
                    System.out.println("\t 3.2. Corte 2: " + informe.alertaVerdeCorte[1]);
                    System.out.println("\t 3.3. Corte 3: " + informe.alertaVerdeCorte[2]);
                    System.out.println("\n");
                    break;
            }
        }
    }

    public void menuRegistrarNotas(Scanner entrada){
        int opcNota = 0;
        while(opcNota != 4){
            System.out.println("\t Registro de notas...");
            System.out.println("1. Primer corte");
            System.out.println("2. Segundo corte");
            System.out.println("3. Tercer corte");
            System.out.println("4. Salir");
            System.out.println("Digite una opción:");
            opcNota = entrada.nextInt();
            if(opcNota >= 1 && opcNota<=3){
                int opcEstudiante = 0;
                StudentDTO[] estudiantes;
                System.out.println("\t Seleccione un estudiante:");
                estudiantes = this.objRemoto.findAllStudent();
                for(StudentDTO e: estudiantes) {
                    System.out.println("\t"+e.id + ". " + e.nombre + " " + e.apellido);
                }
                opcEstudiante = entrada.nextInt();
                StudentDTO estudiante = this.objRemoto.findStudentById(opcEstudiante);
                estudiante.corte = opcNota;
                System.out.println("Digite el promedio del estudiante corte: " + opcNota);
                estudiante.nota = entrada.nextFloat();
                if(this.objRemoto.registrarNota(estudiante)) System.out.println("¡Registro exitoso!");
                else System.out.println("Error el guardar el registro");
            }


        }
    }
}
