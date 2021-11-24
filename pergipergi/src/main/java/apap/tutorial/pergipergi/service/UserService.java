package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();
    UserModel getUserById(String id);
    UserModel getUserByUsername(String username);
    UserModel updatePassword(UserModel user, String password);
    UserModel deleteUser(UserModel user);
    Boolean checkIfValidOldPassword(UserModel user, String oldPassword);
    Boolean checkPasswordifEqual(String password1, String password2);
    List<String> Password_Validation(String password);
}
