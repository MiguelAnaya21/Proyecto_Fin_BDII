/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dosideas.fidelizacion.repository;

import com.dosideas.fidelizacion.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alopezorozco
 */
public interface RoleRepository extends JpaRepository<Role, Long>{    
}