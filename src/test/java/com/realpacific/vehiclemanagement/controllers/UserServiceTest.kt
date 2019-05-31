package com.realpacific.vehiclemanagement.controllers

import com.realpacific.vehiclemanagement.entities.AuthenticateModel
import com.realpacific.vehiclemanagement.entities.User
import com.realpacific.vehiclemanagement.entities.Vehicle
import com.realpacific.vehiclemanagement.exceptions.AuthenticationException
import com.realpacific.vehiclemanagement.exceptions.UserNotFoundException
import com.realpacific.vehiclemanagement.services.UserService
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner


@SpringBootTest(properties = ["job.autorun.enabled=false"])
@RunWith(SpringRunner::class)
class UserServiceTest {

    @Autowired
    lateinit var userService: UserService

    val vehicle1 = Vehicle("BA1CHA1234", "i10")
    val vehicle2 = Vehicle("BA1CHA1235", "i20")
    val user = User("prashantbarahi@gmail.com", "password",
            "Prashant Barahi", "Patan",
            "9849010616")
    val badUser = User("prashantbarahi.com", "password",
            "Prashant Barahi", "Patan",
            "a")

    @Before
    fun setup() {
        vehicle1.user = user
        vehicle2.user = user
        userService.saveOneUser(user)
    }

    @Test
    @DirtiesContext
    fun testForSavingUser() {
        Assertions.assertThat(userService.getAllUsers()).hasSize(1)
    }

    @Test
    @DirtiesContext
    fun testForUserByIdSearch() {
        Assertions.assertThat(userService.getOneUserByEmail("prashantbarahi@gmail.com")).satisfies {
            it != null && it.email == "prashantbarahi@gmail.com"
        }
        Assertions.assertThatExceptionOfType(UserNotFoundException::class.java).isThrownBy {
            userService.getOneUserByEmail("xyz@gmail.com")
        }
    }

    @Test
    @DirtiesContext
    fun testForAuthentication() {
        val authentication = AuthenticateModel(user.email, user.password)
        Assertions.assertThat(userService.authenticateUser(authentication)).isNotNull

        val falseAuthentication = AuthenticateModel("prashantbarahi@gmail.com", "passwordzz")
        Assertions.assertThatExceptionOfType(AuthenticationException::class.java).isThrownBy {
            userService.authenticateUser(falseAuthentication)
        }

        val falseAuthentication2 = AuthenticateModel("zxc@gmail.com", "hello")
        Assertions.assertThatExceptionOfType(AuthenticationException::class.java).isThrownBy {
            userService.authenticateUser(falseAuthentication2)
        }
    }

}