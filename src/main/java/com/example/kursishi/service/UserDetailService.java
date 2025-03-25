package com.example.kursishi.service;


import com.example.kursishi.repository.UserDetailRepository;
import com.example.kursishi.role.UserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService {
    private final UserDetailRepository userDetailRepository;

    //Create UserDetail
    public UserDetail create(String name, String phoneNumber) {
        UserDetail userDetail = new UserDetail();
        userDetail.setName(name);
        userDetail.setPhoneNumber(phoneNumber);
        return userDetailRepository.save(userDetail);
    }
    //Save UserDetail
    public UserDetail save(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }


}

