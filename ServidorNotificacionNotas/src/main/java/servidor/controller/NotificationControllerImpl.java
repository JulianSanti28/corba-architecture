/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controller;

import servidor.dao.INotificationRepository;
import servidor.view.VistaNotificacionBienestar;
import sop_corba_notificacion.INotificationControllerPOA;
import sop_corba_notificacion.INotificationControllerPackage.NotificationDTO;

/**
 *
 * @author Paula
 */
public class NotificationControllerImpl extends INotificationControllerPOA{

    private INotificationRepository notificationRepository;
    private VistaNotificacionBienestar vista;
    public NotificationControllerImpl(INotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
        
    }
    
    @Override
    public NotificationDTO[] findAllNotifications() {
        System.out.println("Obteniendo todos las notificaciones...");
        NotificationDTO[] vector=new NotificationDTO[notificationRepository.listarNotification().size()];
        this.notificationRepository.listarNotification().toArray(vector);
        return vector;
    }

    @Override
    public boolean registrarNotification(NotificationDTO save) {
        boolean bandera=false;
        if (this.notificationRepository.registrarNotificacion(save)){
            bandera =true;
            vista=new VistaNotificacionBienestar(save);
            vista.setVisible(true);
        }
        return bandera;
    }

    @Override
    public NotificationDTO[] findNotificationByStudentId(int id) {
        System.out.println("Obteniendo todos las notificaciones de un estudiante...");
        NotificationDTO[] vector=new NotificationDTO[notificationRepository.listarNotificationByStudentId(id).size()];
        this.notificationRepository.listarNotificationByStudentId(id).toArray(vector);
        return vector;
    }
    
}
