package sop_corba;


/**
* sop_corba/IStudentControllerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interface.idl
* lunes 8 de agosto de 2022 11:58:25 AM COT
*/

public interface IStudentControllerOperations 
{
  sop_corba.IStudentControllerPackage.StudentDTO[] findAllStudent ();
  boolean registrarNota (sop_corba.IStudentControllerPackage.StudentDTO save);
  sop_corba.IStudentControllerPackage.StudentDTO findStudentById (int id);
  sop_corba.IStudentControllerPackage.InformeDTO generarInforme ();
} // interface IStudentControllerOperations
