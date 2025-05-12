package az.edu.itbrains.course.controllers;

import az.edu.itbrains.course.dtos.user.UserInfoDto;
import az.edu.itbrains.course.services.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;



    @GetMapping("/me")
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserInfoDto> userInfo(Principal principal){

        UserInfoDto userInfoDto = userService.findLoggedUser(principal.getName());

        return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
    }

}
