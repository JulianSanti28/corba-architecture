package cliente.view;

import sop_corba.IStudentController;
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
            System.out.println("\t\t Bienvenido...");
            System.out.println("\t1. Registrar Notas");
            System.out.println("\t2. Generar informe");
            System.out.println("\t3. Salir");
            System.out.println("Digite una opción: ");
            opcMain = entrada.nextInt();
            switch (opcMain){
                case 1:
                    menuRegistrarNotas(entrada);
                    break;

            }
        }
    }

    public void menuRegistrarNotas(Scanner entrada){
        int opcNota = 0;
        while(opcNota != 4){
            System.out.println("\t\t Registro de notas...");
            System.out.println("\t1. Primer corte");
            System.out.println("\t2. Segundo corte");
            System.out.println("\t3. Tercer corte");
            System.out.println("\t4. Salir");
            System.out.println("Digite una opción:");
            opcNota = entrada.nextInt();
            if(opcNota >= 1 && opcNota<=3){
                int opcEstudiante = 0;
                StudentDTO[] estudiantes;
                System.out.println("\tSeleccione un estudiante:");
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
