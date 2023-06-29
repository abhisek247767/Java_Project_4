package com.first.demo;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.first.demo.user.UserRepository;

import com.first.demo.user.User;



@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/signup")
  public String signup(Model model) {
    model.addAttribute("user", new User());
    return "signup";
  }

  @PostMapping("/signup")
  public String signUpUser(@ModelAttribute("user") User user, Model model) {
      // set the password encoder
      user.setPassword(passwordEncoder.encode(user.getPassword()));

      // save the user to the database
      userRepository.save(user);

      // redirect to the login page
      return "redirect:/login";
  }


}
