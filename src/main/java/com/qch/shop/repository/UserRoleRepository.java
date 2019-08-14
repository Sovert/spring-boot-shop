package com.qch.shop.repository;

import com.qch.shop.entity.UserInfo;
import com.qch.shop.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserInfo getIdByRoleName(String roleName);
}
