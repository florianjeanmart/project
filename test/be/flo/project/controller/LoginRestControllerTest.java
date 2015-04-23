package be.flo.project.controller;

import be.flo.project.dto.LoginSuccessDTO;
import be.flo.project.dto.post.LoginDTO;
import be.flo.project.dto.post.RegistrationDTO;
import be.flo.project.dto.technical.DTO;
import be.flo.project.model.entities.technical.AbstractEntity;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import play.Logger;
import play.Play;
import play.db.jpa.JPA;
import play.libs.Json;
import play.mvc.Result;


import java.util.Map;

import static java.lang.Thread.sleep;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.*;

/**
 * Created by florian on 19/04/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginRestControllerTest extends AbstractControllerTest{



    @Test
    public void test1_registration() {

        RegistrationDTO dto = new RegistrationDTO();
        dto.setFirstname(FIRSTNAME);
        dto.setLastname(LASTNAME);
        dto.setMale(true);
        dto.setEmail(EMAIL);
        dto.setPassword(PASSWORD);
        dto.setKeepSessionOpen(true);

        Result result = request(POST, "/registration", dto);

        assertEquals(printError(result), 200, status(result));

        // get LoginResultDTO
        LoginSuccessDTO formDTO = Json.fromJson(Json.parse(new String(contentAsBytes(result))), LoginSuccessDTO.class);

        assertEquals(FIRSTNAME,formDTO.getMyself().getFirstname());
        assertEquals(LASTNAME,formDTO.getMyself().getLastname());
        assertEquals(EMAIL,formDTO.getMyself().getEmail());

//        //test connection
//        Map<String, String> flashData = Collections.emptyMap();
//        Map<String, Object> argData = Collections.emptyMap();
//        Long id = 2L;
//        play.api.mvc.RequestHeader header = mock(play.api.mvc.RequestHeader.class);
//        Http.Context context = new Http.Context(id, header, request, flashData, flashData, argData);
//        Http.Context.current.set(context);

    }

    @Test
    public void test2_login(){

        Result result = request(POST, "/login", new LoginDTO(EMAIL,PASSWORD));

        LoginSuccessDTO formDTO = Json.fromJson(Json.parse(new String(contentAsBytes(result))), LoginSuccessDTO.class);

        assertEquals(FIRSTNAME,formDTO.getMyself().getFirstname());
        assertEquals(LASTNAME,formDTO.getMyself().getLastname());
        assertEquals(EMAIL,formDTO.getMyself().getEmail());

    }


}
