package com.example.kursishi.common;

import com.example.kursishi.entity.About;
import com.example.kursishi.repository.AboutRepository;
import com.example.kursishi.repository.RoleRepository;
import com.example.kursishi.repository.UserDetailRepository;
import com.example.kursishi.repository.UserRepository;
import com.example.kursishi.role.RolName;
import com.example.kursishi.role.Role;
import com.example.kursishi.role.User;
import com.example.kursishi.role.UserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final AboutRepository aboutRepository;
    private final UserDetailRepository userDetailRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        UserDetail userDetail = new UserDetail();

        userDetail.setName("Admin");
        userDetail.setPhoneNumber("+998881020023");
        userDetailRepository.save(userDetail);

        Role Admin = new Role();
        Admin.setName(RolName.ADMIN);
        roleRepository.save(Admin);

        Role userRole = new Role();
        userRole.setName(RolName.USER);
        roleRepository.save(userRole);


        User user = new User();
        user.setUserDetail(userDetail);
        user.setUserRole(Admin);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode("1406"));
        userRepository.save(user);


        About about = new About();
         about.setName("TATU Multimedia Kafedrasi");
              about.setDescription("TATU Multimedia Kafedrasi axborot texnologiyalari va multimedia tizimlari bo'yicha ilg‘or ta'lim va tadqiqot markazidir.");
                about.setPhoneNumber("+998712034444");
                about.setImageUrl("https://i.ibb.co/MDjY84Fw/photo-2025-03-06-19-42-19.jpg");
                about.setTelegram("https://t.me/tuituz_official");
                about.setId(123L);
                aboutRepository.save(about);
    }
}