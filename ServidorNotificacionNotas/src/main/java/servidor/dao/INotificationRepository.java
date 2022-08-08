/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.dao;

import java.util.List;
import sop_corba_notificacion.INotificationControllerPackage.NotificationDTO;

/**
 *
 * @author Paula
 */
public interface INotificationRepository {
    public boolean registrarNotificacion(NotificationDTO objNotification);   
    public List<NotificationDTO> listarNotification();
    public List<NotificationDTO> listarNotificationByStudentId(int id);
}
