package servidor.controller;

import servidor.dao.IStudentRepository;
import sop_corba.IStudentControllerPOA;
import sop_corba.IStudentControllerPackage.InformeDTO;
import sop_corba.IStudentControllerPackage.StudentDTO;

public class ControllerStudentImpl extends IStudentControllerPOA {

    private IStudentRepository studentRepository;

    public ControllerStudentImpl(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO[] findAllStudent() {
        System.out.println("Obteniendo todos los estudiantes...");
        StudentDTO[] vector=new StudentDTO[studentRepository.findAllStudent().size()];
        this.studentRepository.findAllStudent().toArray(vector);
        return vector;
    }
    @Override
    public boolean registrarNota(StudentDTO save) {
       
        return this.studentRepository.registrarNota(save);
    }

    @Override
    public StudentDTO findStudentById(int id) {
        return this.studentRepository.findStudentById(id);
    }

    @Override
    public InformeDTO generarInforme() {
        return this.studentRepository.generarInforme();
    }

}
