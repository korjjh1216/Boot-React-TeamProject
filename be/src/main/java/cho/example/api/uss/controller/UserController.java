package cho.example.api.uss.controller;

import cho.example.api.news.domain.News;
import cho.example.api.uss.domain.UserDto;
import io.swagger.annotations.*;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cho.example.api.uss.domain.UserVo;
import cho.example.api.uss.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
@Api(tags = "users")
@Log
public class UserController {
    private final UserServiceImpl service;
    private final ModelMapper modelmapper;

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access Denied"),
            @ApiResponse(code = 422, message = "Username is already in use")})
    public ResponseEntity<String> signup(@ApiParam("signup User") @RequestBody UserDto user) {

        log.info("-----------------------------------------");
        log.info(""+user);


        return ResponseEntity.ok(service.signup(modelmapper.map(user,UserVo.class)));
    }

    @PostMapping("/login")
    @ApiOperation(value = "${UserController.login}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 422, message = "Invalid Username /Password supplied")})
    public ResponseEntity<UserDto> login(@RequestBody UserDto user) {
        return ResponseEntity.ok(service.login(modelmapper.map(user,UserVo.class)));
    }



    @GetMapping("")
    public ResponseEntity<List<News>> fetch(@RequestBody UserVo user) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("")
    public ResponseEntity<List<News>> update(@RequestBody UserVo user) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("")
    public ResponseEntity<List<News>> delete(@RequestBody UserVo user) {
        return ResponseEntity.ok(null);
    }


    @GetMapping("/all")
    public ResponseEntity<?> all() {
        log.info("로그인 하지 않은 사용자도 접근 가능한 URI");
        return ResponseEntity.ok(null);
    }

    @PostMapping("/{username}}")
    public ResponseEntity<?> auth(@PathVariable String username) {
        log.info("로그인한 사용자 접근 가능한 URI");
        return ResponseEntity.ok(null);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> admin() {
        log.info("관리자가 접근 가능한 URI");
        return ResponseEntity.ok(null);
    }
}
