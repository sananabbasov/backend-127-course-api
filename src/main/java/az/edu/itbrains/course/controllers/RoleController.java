package az.edu.itbrains.course.controllers;

import az.edu.itbrains.course.dtos.role.RoleAssignUserDto;
import az.edu.itbrains.course.dtos.role.RoleCreateDto;
import az.edu.itbrains.course.dtos.role.RoleDto;
import az.edu.itbrains.course.payloads.ApiResponse;
import az.edu.itbrains.course.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAll(){
        List<RoleDto> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody RoleCreateDto roleCreateDto){
        ApiResponse response = roleService.create(roleCreateDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/assign")
    public ResponseEntity<ApiResponse> create(@RequestBody RoleAssignUserDto roleAssignUserDto){
        ApiResponse response = roleService.assignRoleToUser(roleAssignUserDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
