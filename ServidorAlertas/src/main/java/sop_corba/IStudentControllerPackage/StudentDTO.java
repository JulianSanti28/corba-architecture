package sop_corba.IStudentControllerPackage;


/**
* sop_corba/IStudentControllerPackage/StudentDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 11:58:25 AM COT
*/

public final class StudentDTO implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String nombre = null;
  public String apellido = null;
  public int edad = (int)0;
  public int corte = (int)0;
  public float nota = (float)0;
  public float color = (float)0;

  public StudentDTO ()
  {
  } // ctor

  public StudentDTO (int _id, String _nombre, String _apellido, int _edad, int _corte, float _nota, float _color)
  {
    id = _id;
    nombre = _nombre;
    apellido = _apellido;
    edad = _edad;
    corte = _corte;
    nota = _nota;
    color = _color;
  } // ctor

} // class StudentDTO
