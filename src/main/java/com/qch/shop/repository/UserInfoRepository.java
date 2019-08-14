package com.qch.shop.repository;

import com.qch.shop.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo getUserInfoByUsername(String username);

    boolean existsByUsername(String username);
}
