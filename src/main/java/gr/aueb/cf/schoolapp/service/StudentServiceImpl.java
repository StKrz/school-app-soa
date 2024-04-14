package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.StudentDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.StudentInsertDTO;
import gr.aueb.cf.schoolapp.dto.StudentUpdateDTO;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.exceptions.StudentNotFoundException;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements IStudentService {
    private final IStudentDAO studentDAO;

    public StudentServiceImpl(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student insertStudent(StudentInsertDTO dto) throws StudentDAOException {
        if (dto == null) return null;

        try {
            return Optional.of(studentDAO.insert(map(dto)))
                    .orElseThrow(() -> new RuntimeException(""));
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student updateStudent(StudentUpdateDTO dto) throws StudentNotFoundException, StudentDAOException {
        if (dto == null) return null;
        Student student = null;

        try {
            student = map(dto);
//
//            if (studentDAO.getById(teacher.getId()) == null) {
//                throw new TeacherNotFoundException(student);
//            }

            Student existingStudent = Optional.ofNullable(studentDAO.getById(student.getId()))
                    .orElseThrow(() -> new StudentNotFoundException("Student not found"));
//            return teacherDAO.update(teacher);
            return Optional.of(studentDAO.update(student))
                    .orElseThrow(() -> new RuntimeException("runtime exception"));
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudent(Integer id) throws StudentNotFoundException, StudentDAOException {
        if (id == null) return;

        try {
//            if (studentDAO.getById(id) == null) {
//                throw new StudentNotFoundException("Student not found");
//            }
//            studentDAO.delete(id);
            Student existingStudent = Optional.ofNullable(studentDAO.getById(id))
                    .orElseThrow(() -> new StudentNotFoundException("Student with id: " +  id + " not found"));
            studentDAO.delete(existingStudent.getId());
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Student getStudentById(Integer id) throws StudentNotFoundException, StudentDAOException {
        Student student;
        try {
//            student = studentDAO.getById(id);
//            if (student == null) {
//                throw new StudentNotFoundException("Student with id " + id + " not found");
//            }
            return Optional.ofNullable(studentDAO.getById(id))
                    .orElseThrow(() -> new StudentNotFoundException("Student with id: " +  id + " not found"));
        } catch (StudentDAOException | StudentNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        // return student;
    }

    @Override
    public List<Student> getStudentsByLastname(String lastname) throws StudentDAOException {
        //List<Student> student;

        try {
//            student = studentDAO.getByLastname(lastname);
//            return student;
            return Optional.ofNullable(studentDAO.getByLastname(lastname))
                    .orElseThrow(() -> new RuntimeException("Students not found"));
        } catch (StudentDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private Student map(StudentInsertDTO dto) {
        return new Student(null, dto.getFirstname(), dto.getLastname(),
                            dto.getGender(), dto.getBirthday(),
                            dto.getCityId(), dto.getUserId());
    }

    private Student map(StudentUpdateDTO dto) {
        return new Student(null, dto.getFirstname(), dto.getLastname(),
                            dto.getGender(), dto.getBirthday(),
                            dto.getCityId(), dto.getUserId());
    }
}
