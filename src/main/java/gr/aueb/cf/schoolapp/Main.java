package gr.aueb.cf.schoolapp;

import gr.aueb.cf.schoolapp.controllerview.*;
import gr.aueb.cf.schoolapp.controllerview.InsertTeacherForm;
import gr.aueb.cf.schoolapp.controllerview.Menu;
import gr.aueb.cf.schoolapp.controllerview.SearchTeacherForm;
import gr.aueb.cf.schoolapp.controllerview.UpdateDeleteTeacherForm;

import java.awt.*;

public class Main {

    private static Login loginForm;
    private static Menu menu;
    private static InsertTeacherForm insertTeacherForm;
    private static UpdateDeleteTeacherForm updateDeleteTeacherForm;
    private static SearchTeacherForm searchTeacherForm;
    private static SearchUserForm searchUserForm;
    private static InsertUserForm insertUserForm;
    private static UpdateDeleteUserForm updateDeleteUserForm;
    private static SearchStudentForm searchStudentForm;
    private static InsertStudentForm insertStudentForm;
    private static UpdateDeleteStudentForm updateDeleteStudentForm;
    private static AdminMenu adminMenu;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menu = new Menu();
                    menu.setLocationRelativeTo(null);
                    menu.setVisible(false);

                    searchTeacherForm = new SearchTeacherForm();
                    searchTeacherForm.setLocationRelativeTo(null);
                    searchTeacherForm.setVisible(false);

                    insertTeacherForm = new InsertTeacherForm();
                    insertTeacherForm.setLocationRelativeTo(null);
                    insertTeacherForm.setVisible(false);

                    updateDeleteTeacherForm = new UpdateDeleteTeacherForm();
                    updateDeleteTeacherForm.setLocationRelativeTo(null);
                    updateDeleteTeacherForm.setVisible(false);

                    loginForm = new Login();
                    loginForm.setLocationRelativeTo(null);
                    loginForm.setVisible(true);

                    searchUserForm = new SearchUserForm();
                    searchUserForm.setLocationRelativeTo(null);
                    searchUserForm.setVisible(false);

                    insertUserForm = new InsertUserForm();
                    insertUserForm.setLocationRelativeTo(null);
                    insertUserForm.setVisible(false);

                    updateDeleteUserForm = new UpdateDeleteUserForm();
                    updateDeleteUserForm.setLocationRelativeTo(null);
                    updateDeleteUserForm.setVisible(false);

                    searchStudentForm = new SearchStudentForm();
                    searchStudentForm.setLocationRelativeTo(null);
                    searchStudentForm.setVisible(false);

                    insertStudentForm = new InsertStudentForm();
                    insertStudentForm.setLocationRelativeTo(null);
                    insertStudentForm.setVisible(false);

                    updateDeleteStudentForm = new UpdateDeleteStudentForm();
                    updateDeleteStudentForm.setLocationRelativeTo(null);
                    updateDeleteStudentForm.setVisible(false);

                    adminMenu = new AdminMenu();
                    adminMenu.setLocationRelativeTo(null);
                    adminMenu.setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static Menu getMenu() {
        return menu;
    }
//
    public static SearchTeacherForm getSearchTeacherForm() {
        return searchTeacherForm;
    }

    public static InsertTeacherForm getInsertTeacherForm() {
        return insertTeacherForm;
    }

    public static UpdateDeleteTeacherForm getUpdateDeleteTeacherForm() {
        return updateDeleteTeacherForm;
    }

    public static SearchUserForm getSearchUsers() {
        return searchUserForm;
    }

    public static InsertUserForm getInsertUserForm() {
        return insertUserForm;
    }

    public static UpdateDeleteUserForm getUpdateDeleteUserForm() {
        return updateDeleteUserForm;
    }

    public static Login getLoginForm() { return loginForm;}


    public static SearchStudentForm getSearchStudentForm() {
        return searchStudentForm;
    }


    public static InsertStudentForm getInsertStudentForm() {
        return insertStudentForm;
    }

    public static UpdateDeleteStudentForm getUpdateDeleteStudentForm() {
        return updateDeleteStudentForm;
    }

    public static AdminMenu getAdminMenu() {return adminMenu;}
}
