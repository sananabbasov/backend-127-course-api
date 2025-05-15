package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.role.RoleAssignUserDto;
import az.edu.itbrains.course.dtos.role.RoleCreateDto;
import az.edu.itbrains.course.dtos.role.RoleDto;
import az.edu.itbrains.course.exceptions.ResourceNotFoundException;
import az.edu.itbrains.course.models.Role;
import az.edu.itbrains.course.models.User;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.repositories.RoleRepository;
import az.edu.itbrains.course.services.RoleService;
import az.edu.itbrains.course.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;


    @Override
    @PreAuthorize("hasAnyAuthority('role_admin','role_user')")
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtoList = roles.stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
        return roleDtoList;
    }

    @Override
    @PreAuthorize("hasAnyAuthority('role_admin')")
    public ApiResponse create(RoleCreateDto roleCreateDto) {
       try {
           Role role = new Role();
           role.setName(roleCreateDto.getName());
           roleRepository.save(role);
           return new ApiResponse("Role created successfully.",true);
       }catch (Exception e){
           return new ApiResponse(e.getMessage(), false);
       }
    }

    @Override
    @PreAuthorize("hasAnyAuthority('role_admin','role_user')")
    public ApiResponse assignRoleToUser(RoleAssignUserDto roleAssignUserDto) {
        try {
            User user = userService.findUserByEmail(roleAssignUserDto.getEmail());
            Role role = roleRepository.findById(roleAssignUserDto.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("Role", "id", roleAssignUserDto.getRoleId()));
            user.getRoles().add(role);
            ApiResponse response = userService.saveRole(user);
            return response;
        }catch (Exception e){
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
