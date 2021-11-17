package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordHash = passwordEncoder.encode(password);
        return passwordHash;
    }

    @Override
    public List<UserModel> getListUser() {
        return userDb.findAll();
    }

    @Override
    public UserModel getUserById(String id) {
        Optional<UserModel> user = userDb.findById(id);
        if(user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public UserModel getUserByUsername(String username) {
        UserModel user = userDb.findByUsername(username);
        return user;
    }

    @Override
    public UserModel updatePassword(UserModel user, String password){
        String pass = encrypt(password);
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public UserModel deleteUser(UserModel user) {
        UserModel deletedUser = user;
        userDb.delete(user);
        return deletedUser;
    }

    @Override
    public Boolean checkIfValidOldPassword(UserModel user, String oldPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean flag = passwordEncoder.matches(oldPassword, user.getPassword());
        if (flag){
            return true;
        } else
            return false;
    }

    @Override
    public Boolean checkPasswordifEqual(String password1, String password2) {
        boolean flag = password1.equals(password2);
        if (flag){
            return true;
        } else
            return false;
    }

    public List<String> Password_Validation(String password)
    {

        List<String> validators = new ArrayList<>();

        Pattern letterCapital = Pattern.compile("[A-Z]");
        Pattern letterSmall = Pattern.compile("[a-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasLetterCapital = letterCapital.matcher(password);
        Matcher hasLetterSmall = letterSmall.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        if (!(password.length()>=8)) validators.add("Password harus memiliki minimal 8 karakter");
        if (!hasLetterCapital.find()) validators.add("Password harus memiliki minimal satu huruf kapital");
        if (!hasLetterSmall.find()) validators.add("Password harus memiliki minimal satu huruf kecil");
        if (!hasDigit.find()) validators.add("Password harus memiliki minimal satu angka");
        if (!hasSpecial.find()) validators.add("Password harus memiliki minimal satu karakter spesial");

        return validators;
    }
}
