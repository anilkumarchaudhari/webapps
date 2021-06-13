package com.spring.crud.controller;

/*import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.crud.domain.User;
import com.spring.crud.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;


/***
 * Project Name     : spring-boot-testing
 * Username         : Teten Nugraha
 * Date Time        : 12/18/2019
 * Telegram         : @tennugraha
 */
/*
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<User> userList;

    @Before
   public void setUp() {
        this.userList = new ArrayList<>();
        this.userList.add(new User(1L, "user1@gmail.com", "pwd1","User1"));
        this.userList.add(new User(2L, "user2@gmail.com", "pwd2","User2"));
        this.userList.add(new User(3L, "user3@gmail.com", "pwd3","User3"));
    }

    @Test
    public void shouldFetchAllUsers() throws Exception {

        given(userService.findAllUsers()).willReturn(userList);

        this.mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(userList.size())));
    }
*/
	/*
	 * @Test void shouldFetchOneUserById() throws Exception { final Long userId =
	 * 1L; final User user = new User(1L, "ten@mail.com","teten","teten");
	 * 
	 * given(userService.findUserById(userId)).willReturn(Optional.of(user));
	 * 
	 * this.mockMvc.perform(get("/api/users/{id}", userId))
	 * .andExpect(status().isOk()) .andExpect(jsonPath("$.email",
	 * is(user.getEmail()))) .andExpect(jsonPath("$.name", is(user.getName()))); }
	 * 
	 * @Test void shouldReturn404WhenFindUserById() throws Exception { final Long
	 * userId = 1L;
	 * given(userService.findUserById(userId)).willReturn(Optional.empty());
	 * 
	 * this.mockMvc.perform(get("/api/user/{id}", userId))
	 * .andExpect(status().isNotFound()); }
	 * 
	 * @Test void shouldCreateNewUser() throws Exception {
	 * given(userService.createUser(any(User.class))).willAnswer((invocation) ->
	 * invocation.getArgument(0));
	 * 
	 * User user = new User(null, "newuser1@gmail.com", "pwd", "Name");
	 * 
	 * this.mockMvc.perform(post("/api/users")
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content(objectMapper.writeValueAsString(user)))
	 * .andExpect(status().isCreated()) .andExpect(jsonPath("$.email",
	 * is(user.getEmail()))) .andExpect(jsonPath("$.password",
	 * is(user.getPassword()))) .andExpect(jsonPath("$.name", is(user.getName()))) ;
	 * }
	 * 
	 * @Test void shouldReturn400WhenCreateNewUserWithoutEmail() throws Exception {
	 * User user = new User(null, null, "pwd", "Name");
	 * 
	 * this.mockMvc.perform(post("/api/users")
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content(objectMapper.writeValueAsString(user)))
	 * .andExpect(status().isBadRequest())
	 * .andExpect(header().string("Content-Type", is("application/problem+json")))
	 * .andExpect(jsonPath("$.type",
	 * is("https://zalando.github.io/problem/constraint-violation")))
	 * .andExpect(jsonPath("$.title", is("Constraint Violation")))
	 * .andExpect(jsonPath("$.status", is(400))) .andExpect(jsonPath("$.violations",
	 * hasSize(1))) .andExpect(jsonPath("$.violations[0].field", is("email")))
	 * .andExpect(jsonPath("$.violations[0].message",
	 * is("Email should not be empty"))) .andReturn() ; }
	 * 
	 * @Test void shouldUpdateUser() throws Exception { Long userId = 1L; User user
	 * = new User(userId, "user1@gmail.com", "pwd", "Name");
	 * given(userService.findUserById(userId)).willReturn(Optional.of(user));
	 * given(userService.updateUser(any(User.class))).willAnswer((invocation) ->
	 * invocation.getArgument(0));
	 * 
	 * this.mockMvc.perform(put("/api/users/{id}", user.getId())
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content(objectMapper.writeValueAsString(user))) .andExpect(status().isOk())
	 * .andExpect(jsonPath("$.email", is(user.getEmail())))
	 * .andExpect(jsonPath("$.password", is(user.getPassword())))
	 * .andExpect(jsonPath("$.name", is(user.getName())));
	 * 
	 * }
	 * 
	 * @Test void shouldReturn404WhenUpdatingNonExistingUser() throws Exception {
	 * Long userId = 1L;
	 * given(userService.findUserById(userId)).willReturn(Optional.empty()); User
	 * user = new User(userId, "user1@gmail.com", "pwd", "Name");
	 * 
	 * this.mockMvc.perform(put("/api/users/{id}", userId)
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .content(objectMapper.writeValueAsString(user)))
	 * .andExpect(status().isNotFound());
	 * 
	 * }
	 * 
	 * @Test void shouldDeleteUser() throws Exception { Long userId = 1L; User user
	 * = new User(userId, "user1@gmail.com", "pwd", "Name");
	 * given(userService.findUserById(userId)).willReturn(Optional.of(user));
	 * doNothing().when(userService).deleteUserById(user.getId());
	 * 
	 * this.mockMvc.perform(delete("/api/users/{id}", user.getId()))
	 * .andExpect(status().isOk()) .andExpect(jsonPath("$.email",
	 * is(user.getEmail()))) .andExpect(jsonPath("$.password",
	 * is(user.getPassword()))) .andExpect(jsonPath("$.name", is(user.getName())));
	 * 
	 * }
	 * 
	 * @Test void shouldReturn404WhenDeletingNonExistingUser() throws Exception {
	 * Long userId = 1L;
	 * given(userService.findUserById(userId)).willReturn(Optional.empty());
	 * 
	 * this.mockMvc.perform(delete("/api/users/{id}", userId))
	 * .andExpect(status().isNotFound());
	 * 
	 * }
	 

}*/