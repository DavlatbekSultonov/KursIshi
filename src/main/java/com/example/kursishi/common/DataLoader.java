package com.example.kursishi.common;

import com.example.kursishi.entity.About;
import com.example.kursishi.repository.AboutRepository;
import com.example.kursishi.repository.UserRepository;
import com.example.kursishi.role.Role;
import com.example.kursishi.role.User;
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

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .role(Role.ADMIN)
                    .username("admin")
                    .password(passwordEncoder.encode("admin123")) // Parol shifrlanadi
                    .build();
            userRepository.save(admin);
            System.out.println("Admin yaratildi:");
        } else {
            System.out.println("Admin allaqachon mavjud.");
        }

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