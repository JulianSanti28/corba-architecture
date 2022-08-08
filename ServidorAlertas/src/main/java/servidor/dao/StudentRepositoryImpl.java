 package servidor.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import servidor.service.INotificarBienestarService;
import servidor.service.NotificacionBienestarServiceImpl;
import sop_corba.IStudentControllerPackage.InformeDTO;
import sop_corba.IStudentControllerPackage.StudentDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import servidor.utils.UtilidadesRegistroC;
import sop_corba_notificacion.INotificationController;
import sop_corba_notificacion.INotificationControllerPackage.NotificationDTO;


public class StudentRepositoryImpl implements IStudentRepository{

    private HashMap<Integer, ArrayList<StudentDTO>> registroNotas;
    private ArrayList<StudentDTO> estudiantes;

    private INotificationController objRemotoNotificacion;
    
    public StudentRepositoryImpl(){
        this.registroNotas = new HashMap<>();
        this.estudiantes = new ArrayList<>();
        this.objRemotoNotificacion= obtenerObjRemotoNotificacion();
        this.init();
    }

    public void init(){
        this.estudiantes.add(new StudentDTO(1, "Paula", "Peña", 20, 0,0,0));
        this.estudiantes.add(new StudentDTO(2, "Julián", "Martinez", 19, 0,0,0));
        this.estudiantes.add(new StudentDTO(3, "María", "Gonzales", 22, 0,0,0));
    }
    @Override
    public List<StudentDTO> findAllStudent() {
        return this.estudiantes;
    }

    @Override
    public boolean registrarNota(StudentDTO save) {
        System.out.println("Registrando nota  " + save.nota  + " para: "+ save.nombre + " " + save.apellido + " corte: " + save.corte);
        asignarColor(save);
        if(!this.registroNotas.containsKey(save.corte)) {
            this.registroNotas.put(save.corte, new ArrayList<StudentDTO>());
        }
        if(this.registroNotas.get(save.corte).add(save)){
            if (requiereNotificar(save)){
                NotificationDTO noti = new NotificationDTO(save.id,save.nombre,save.apellido,save.edad,save.color,getFecha());
                INotificarBienestarService notificarBienestarService = new NotificacionBienestarServiceImpl(this.objRemotoNotificacion,noti);
                Thread notificarBienestar = new Thread((Runnable) notificarBienestarService);
                notificarBienestar.run();
            }
            return true;
        }
        return false;
    }
    private String getFecha(){
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(date);
        return today;
    }
    public boolean requiereNotificar(StudentDTO save){
        return  save.color == 1 || save.color == 2;
    }
    public void asignarColor(StudentDTO save){
        if(save.nota>=1.0 && save.nota<3.0){
            save.color = 1;//Rojo
        }else if(save.nota>=3.0 && save.nota<3.5){
            save.color = 2;//Naranja
        }else if (save.nota>=3.5 && save.nota<4.5){
            save.color = 3;//Verde
        }
    }

    @Override
    public StudentDTO findStudentById(int id) {
        for( StudentDTO e: this.estudiantes){
            if(e.id == id) return e;
        }
        return null;
    }
    @Override
    public InformeDTO generarInforme() {
        return null;
    }

    private INotificationController obtenerObjRemotoNotificacion() {
        String[] vectorDatosLocalizarNS = new String[4];
        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        //System.out.println("Ingrese la direcci�n IP donde escucha el n_s");
        vectorDatosLocalizarNS[1] = "localhost";//UtilidadesConsola.leerCadena();
        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        //System.out.println("Ingrese el puerto donde escucha el n_s");
        vectorDatosLocalizarNS[3] ="2020";// UtilidadesConsola.leerCadena();
        System.out.println("Conectado al servidor de notificaciones");
        return UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS,"idObjetoRemotoNotificacion");
    }
}
