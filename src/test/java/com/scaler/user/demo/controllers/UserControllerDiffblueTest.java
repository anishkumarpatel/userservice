package com.scaler.user.demo.controllers;

import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.user.demo.models.User;
import com.scaler.user.demo.services.UserService;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class UserControllerDiffblueTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers() throws Exception {
        // Arrange
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserController#getSingleUser(Long)}
     */
    @Test
    void testGetSingleUser() throws Exception {
        // Arrange
        User user = new User();
        user.setCity("Oxford");
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setDeleted(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setLatitude("Latitude");
        user.setLongitude("Longitude");
        user.setNumber("42");
        user.setPassword("iloveyou");
        user.setPhone("6625550144");
        user.setStreet("Street");
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUsername("janedoe");
        user.setZipcode("21654");
        when(userService.getSingleUser(Mockito.<Long>any())).thenReturn(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"createdAt\":0,\"updatedAt\":0,\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password\":"
                                        + "\"iloveyou\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"city\":\"Oxford\",\"street\":\"Street\",\"number\":\"42\",\"zipcode"
                                        + "\":\"21654\",\"latitude\":\"Latitude\",\"longitude\":\"Longitude\",\"phone\":\"6625550144\",\"deleted\":true}"));
    }

    /**
     * Method under test: {@link UserController#addNewUser(User)}
     */
    @Test
    void testAddNewUser() throws Exception {
        // Arrange
        User user = new User();
        user.setCity("Oxford");
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setDeleted(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setLatitude("Latitude");
        user.setLongitude("Longitude");
        user.setNumber("42");
        user.setPassword("iloveyou");
        user.setPhone("6625550144");
        user.setStreet("Street");
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUsername("janedoe");
        user.setZipcode("21654");
        when(userService.addNewUser(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setCity("Oxford");
        user2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setDeleted(true);
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setLatitude("Latitude");
        user2.setLongitude("Longitude");
        user2.setNumber("42");
        user2.setPassword("iloveyou");
        user2.setPhone("6625550144");
        user2.setStreet("Street");
        user2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setUsername("janedoe");
        user2.setZipcode("21654");
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"createdAt\":0,\"updatedAt\":0,\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password\":"
                                        + "\"iloveyou\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"city\":\"Oxford\",\"street\":\"Street\",\"number\":\"42\",\"zipcode"
                                        + "\":\"21654\",\"latitude\":\"Latitude\",\"longitude\":\"Longitude\",\"phone\":\"6625550144\",\"deleted\":true}"));
    }

    /**
     * Method under test: {@link UserController#updateUser(Long, User)}
     */
    @Test
    void testUpdateUser() throws Exception {
        // Arrange
        User user = new User();
        user.setCity("Oxford");
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setDeleted(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setLatitude("Latitude");
        user.setLongitude("Longitude");
        user.setNumber("42");
        user.setPassword("iloveyou");
        user.setPhone("6625550144");
        user.setStreet("Street");
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUsername("janedoe");
        user.setZipcode("21654");
        when(userService.updateUser(Mockito.<Long>any(), Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setCity("Oxford");
        user2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setDeleted(true);
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setLatitude("Latitude");
        user2.setLongitude("Longitude");
        user2.setNumber("42");
        user2.setPassword("iloveyou");
        user2.setPhone("6625550144");
        user2.setStreet("Street");
        user2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setUsername("janedoe");
        user2.setZipcode("21654");
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.patch("/users/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"createdAt\":0,\"updatedAt\":0,\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password\":"
                                        + "\"iloveyou\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"city\":\"Oxford\",\"street\":\"Street\",\"number\":\"42\",\"zipcode"
                                        + "\":\"21654\",\"latitude\":\"Latitude\",\"longitude\":\"Longitude\",\"phone\":\"6625550144\",\"deleted\":true}"));
    }

    /**
     * Method under test: {@link UserController#replaceUser(Long, User)}
     */
    @Test
    void testReplaceUser() throws Exception {
        // Arrange
        User user = new User();
        user.setCity("Oxford");
        user.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setDeleted(true);
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1L);
        user.setLastName("Doe");
        user.setLatitude("Latitude");
        user.setLongitude("Longitude");
        user.setNumber("42");
        user.setPassword("iloveyou");
        user.setPhone("6625550144");
        user.setStreet("Street");
        user.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user.setUsername("janedoe");
        user.setZipcode("21654");
        when(userService.replaceUser(Mockito.<Long>any(), Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setCity("Oxford");
        user2.setCreatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setDeleted(true);
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setId(1L);
        user2.setLastName("Doe");
        user2.setLatitude("Latitude");
        user2.setLongitude("Longitude");
        user2.setNumber("42");
        user2.setPassword("iloveyou");
        user2.setPhone("6625550144");
        user2.setStreet("Street");
        user2.setUpdatedAt(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        user2.setUsername("janedoe");
        user2.setZipcode("21654");
        String content = (new ObjectMapper()).writeValueAsString(user2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/users/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":1,\"createdAt\":0,\"updatedAt\":0,\"email\":\"jane.doe@example.org\",\"username\":\"janedoe\",\"password\":"
                                        + "\"iloveyou\",\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"city\":\"Oxford\",\"street\":\"Street\",\"number\":\"42\",\"zipcode"
                                        + "\":\"21654\",\"latitude\":\"Latitude\",\"longitude\":\"Longitude\",\"phone\":\"6625550144\",\"deleted\":true}"));
    }

    /**
     * Method under test: {@link UserController#deleteUser(Long)}
     */
    @Test
    void testDeleteUser() throws Exception {
        // Arrange
        when(userService.deleteUser(Mockito.<Long>any())).thenReturn("Delete User");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{id}", 1L);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"message\":\"Delete User\"}"));
    }

    /**
     * Method under test: {@link UserController#login(String, String)}
     */
    @Test
    void testLogin() throws Exception {
        // Arrange
        when(userService.login(Mockito.<String>any(), Mockito.<String>any())).thenReturn("Login");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{username}/{password}", "janedoe",
                "iloveyou");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Login"));
    }
}
