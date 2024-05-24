package com.ulas.controller;

import com.ulas.config.HashService;
import com.ulas.entity.User;
import com.ulas.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Optional;
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final HashService hashService;
    public UserController(UserRepository userRepository, HashService hashService) {
        this.userRepository = userRepository;
        this.hashService = hashService;
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
        //user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        user.setPassword(hashService.md5(user.getPassword()));
        userRepository.save(user);
        return "Saved User";
    }


    @PostMapping("/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password, HttpServletRequest request) {
        //Optional<User> optionalUser = userRepository.findByUserNameAndPassword(username,Base64.getEncoder().encodeToString(password.getBytes()));
        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(username, hashService.md5(password));
        if (optionalUser.isPresent()) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            User user = optionalUser.get();
            user.setSessionId(session.getId());
            userRepository.saveAndFlush(user);


            return "Giriş başarılı, oturum ID: " + session.getId();
        } else {
            return "Giriş başarısız";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Mevcut oturumu al, eğer yoksa null döner
        if (session != null) {
            String username = (String) session.getAttribute("username");
            Optional<User> optionalUser = userRepository.findByUserName(username);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                user.setSessionId(null); // Oturum ID'sini temizle
                userRepository.saveAndFlush(user);
            }
            session.invalidate(); // Oturumu geçersiz kılar
            return "Çıkış başarılı, oturum sonlandırıldı.";
        } else {
            return "Geçerli bir oturum bulunamadı.";
        }
    }


}
