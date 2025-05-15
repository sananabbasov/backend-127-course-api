package az.edu.itbrains.course.services;

import az.edu.itbrains.course.dtos.role.RoleAssignUserDto;
import az.edu.itbrains.course.dtos.role.RoleCreateDto;
import az.edu.itbrains.course.dtos.role.RoleDto;
import az.edu.itbrains.course.payloads.ApiResponse;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAllRoles();
    ApiResponse create(RoleCreateDto roleCreateDto);
    ApiResponse assignRoleToUser(RoleAssignUserDto roleAssignUserDto);
}
