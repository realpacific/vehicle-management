package com.realpacific.vehiclemanagement.controllers

import com.realpacific.vehiclemanagement.constants.AppConstant
import com.realpacific.vehiclemanagement.entities.AuthenticateModel
import com.realpacific.vehiclemanagement.entities.BaseResponse
import com.realpacific.vehiclemanagement.entities.User
import com.realpacific.vehiclemanagement.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@CrossOrigin("http://localhost:4200")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/user/signup")
    fun createUser(@RequestBody @Valid user: User): ResponseEntity<BaseResponse<Nothing?>> {
        val newUser = userService.saveOneUser(user)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.id).toUri()
        return ResponseEntity.created(uri).body(BaseResponse(null, AppConstant.MESSAGE_OK))
    }

    @PostMapping("/user/authenticate")
    fun authenticateUser(@RequestBody authenticateModel: AuthenticateModel): ResponseEntity<BaseResponse<User>> {
        val user = userService.authenticateUser(authenticateModel)
        return ResponseEntity.ok(BaseResponse(user, AppConstant.MESSAGE_OK))
    }

    @GetMapping("/user/{email}")
    fun getUser(@PathVariable email: String): ResponseEntity<BaseResponse<User>> {
        val user = userService.getOneUserByEmail(email)
        return ResponseEntity.ok(BaseResponse(user, AppConstant.MESSAGE_OK))
    }
}