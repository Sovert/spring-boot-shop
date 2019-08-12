package com.qch.login.repository;

import com.qch.login.entity.UserInfo;
import com.qch.login.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    UserInfo getIdByRoleName(String roleName);
}
