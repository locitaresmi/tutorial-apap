package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.RoleModel;
import apap.tutorial.pergipergi.model.UserModel;
import apap.tutorial.pergipergi.service.RoleService;
import apap.tutorial.pergipergi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    public String addUserFormPage(Model model) {
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value = "/add")
    public String addUserSubmit(@RequestParam("password") String password,
                                @ModelAttribute UserModel user,
                                Model model) {

        List<String> validators = userService.Password_Validation(password);

        if (!validators.isEmpty()){
            System.out.println(validators.toString());
            List<RoleModel> listRole = roleService.findAll();
            model.addAttribute("listRole", listRole);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("nama", user.getNama());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("password", password);
            model.addAttribute("validators", validators);
            return "form-add-user";
        }

        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listUser(Model model){
        List<UserModel> listUser = userService.getListUser();
        model.addAttribute("listUser", listUser);
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUser(
            @PathVariable String username,
            Model model
    ){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String usernameNow;

        if (principal instanceof UserDetails) {
            usernameNow = ((UserDetails)principal).getUsername();
        } else {
            usernameNow = principal.toString();
        }

        if (username.equals(usernameNow)){
            return "redirect:/logout";
        }

        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("nama", user.getNama());
        userService.deleteUser(user);

        return "delete-user";
    }


    @GetMapping("/updatePassword")
    @PreAuthorize("hasRole('READ_PRIVILEGE')")
    public String changePassword(
            Model model
    ) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        UserModel user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "form-update-password";
    }


    @PostMapping("/updatePassword")
    public String changeUserPassword( @RequestParam("password") String password,
                                      @RequestParam("oldpassword") String oldPassword,
                                      @RequestParam("passwordverify") String passwordverify,
                                      Model model
    ) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        UserModel user = userService.getUserByUsername(username);

        model.addAttribute("oldPassword", oldPassword);
        model.addAttribute("password", password);
        model.addAttribute("passwordverify", passwordverify);

        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            model.addAttribute("keterangan1", "Password lama tidak sesuai");
            return "form-update-password";
        } else if (!userService.checkPasswordifEqual(password, passwordverify)) {
            model.addAttribute("keterangan2", "Password baru tidak sesuai");
            return "form-update-password";
        }

        List<String> validators = userService.Password_Validation(password);

        if (!validators.isEmpty()){
            System.out.println(validators.toString());
            model.addAttribute("validators", validators);
            return "form-update-password";
        }

        userService.updatePassword(user, password);

        return "update-password";
    }
}
