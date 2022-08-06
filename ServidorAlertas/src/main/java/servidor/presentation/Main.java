package servidor.presentation;

import servidor.controller.ControllerStudentImpl;
import servidor.dao.IStudentRepository;
import servidor.dao.StudentRepositoryImpl;
import servidor.utils.UtilidadesRegistroS;

public class Main {

    public static void main (String args[]){
        try {
            String[] vectorDatosLocalizarNS = new String[4];
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            vectorDatosLocalizarNS[1] = "localhost";
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            vectorDatosLocalizarNS[3] = "2020";
            IStudentRepository objRepository = new StudentRepositoryImpl();
            ControllerStudentImpl objRemotoGestionCanciones = new ControllerStudentImpl(objRepository);
            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoGestionCanciones,"idObjetoRemoto");
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}
