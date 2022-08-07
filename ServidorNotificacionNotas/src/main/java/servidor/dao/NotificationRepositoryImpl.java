/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.dao;

import java.util.ArrayList;
import java.util.List;
import sop_corba_notificacion.INotificationControllerPackage.NotificationDTO;

/**
 *
 * @author Paula
 */
public class NotificationRepositoryImpl implements INotificationRepository {

    private final ArrayList<NotificationDTO> listaNotifications;

    public NotificationRepositoryImpl() {
        this.listaNotifications = new ArrayList<>();
    }
    
    
    @Override
    public boolean registrarNotificacion(NotificationDTO objNotification) {
        boolean bandera;        
        bandera= this.listaNotifications.add(objNotification);
        System.out.println("Notificacion creado en el servidor");  
        
        
        return bandera;
    }

    @Override
    public List<NotificationDTO> listarNotification() {
        return this.listaNotifications;
    }

    @Override
    public List<NotificationDTO> listarNotificationByStudentId(int id) {
        ArrayList<NotificationDTO> copia = this.listaNotifications;
        copia.removeIf(e-> e.id!=id);
        return copia;
    }
    
}
