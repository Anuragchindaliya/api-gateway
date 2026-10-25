package in.anurag.gatekeeper.management.controller;

import in.anurag.gatekeeper.management.dto.requestDto.LoginRequest;
import in.anurag.gatekeeper.management.dto.responseDto.LoginResponse;
import in.anurag.gatekeeper.management.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

     private final AuthenticationService authenticationService;
     public AuthController(AuthenticationService authenticationService){
          this.authenticationService = authenticationService;
     }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
         System.out.println("reached to login");
        return ResponseEntity.ok(authenticationService.login(request));
    }

}
