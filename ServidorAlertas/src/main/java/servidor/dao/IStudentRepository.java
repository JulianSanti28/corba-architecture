package servidor.dao;

import sop_corba.IStudentControllerPackage.InformeDTO;
import sop_corba.IStudentControllerPackage.StudentDTO;

import java.util.List;

public interface IStudentRepository {
    public List<StudentDTO> findAllStudent();
    public boolean registrarNota(StudentDTO save);
    public StudentDTO findStudentById(int id);
    public InformeDTO generarInforme();
}
