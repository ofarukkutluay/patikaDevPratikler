package com.example.arackiralamaportali.Controllers;

import com.example.arackiralamaportali.Data.RoleRepository;
import com.example.arackiralamaportali.Data.UserRepository;
import com.example.arackiralamaportali.Models.Role;
import com.example.arackiralamaportali.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Controller
public class AuthController {
    private final UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public AuthController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model, Map<String, Object> map) {
        List<Role> roles = roleRepository.findAll();
        map.put("roles", roles);
        ControllerTools.navbarAuth(map);
        model.addAttribute("user", new User());
        return "auth/register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegisterPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, Map<String, Object> map, HttpServletRequest request) {

        model.addAttribute("user", user);
        if (result.hasErrors()) {
            return "auth/register";
        }
        User findUser = userRepository.findByUserName(user.getUserName());
        if(findUser != null){
            return "auth/register";
        }
        var requestParameter = request.getParameter("roles");
        int id = Integer.valueOf(requestParameter);
        Role role = roleRepository.findById(id).get();
        user.setRoles(new HashSet<Role>() {
            {
                add(role);
            }
        });
        String pwd = user.getPassword();
        String encryptPwd = passwordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        map.put("message", "Successful");
        userRepository.save(user);
        return "auth/login";
    }


    @RequestMapping("/login")
    public String login(Map<String, Object> map) {
        ControllerTools.navbarAuth(map);
        return "auth/login";
    }

    @RequestMapping("/secure")
    public String secure(Map<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        map.put("message", "Kullanıcı Detaylı bilgileri");
        ControllerTools.navbarAuth(map);
        /*System.out.println(auth.getDetails().toString()); //WebAuthenticationDetails [RemoteIpAddress=127.0.0.1, SessionId=5227E1A02E6D5E16851CD2F372BC6321]
        System.out.println(auth.getCredentials()); // null
        System.out.println(auth.getPrincipal().toString()); // com.example.arackiralamaportali.Services.User_Details@152ab11f
        System.out.println(auth.getAuthorities().toString()); // [ROLE_ADMIN]*/
        return "auth/secure";
    }
}
