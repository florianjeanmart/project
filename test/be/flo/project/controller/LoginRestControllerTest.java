package be.flo.project.controller;

import be.flo.project.dto.MyselfDTO;
import be.flo.project.dto.post.LoginDTO;
import be.flo.project.dto.post.RegistrationDTO;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import play.libs.Json;
import play.mvc.Result;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.*;

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
        MyselfDTO formDTO = Json.fromJson(Json.parse(new String(contentAsBytes(result))), MyselfDTO.class);

        assertEquals(FIRSTNAME,formDTO.getFirstname());
        assertEquals(LASTNAME,formDTO.getLastname());
        assertEquals(EMAIL,formDTO.getEmail());

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

        MyselfDTO formDTO = Json.fromJson(Json.parse(new String(contentAsBytes(result))), MyselfDTO.class);

        assertEquals(FIRSTNAME, formDTO.getFirstname());
        assertEquals(LASTNAME,formDTO.getLastname());
        assertEquals(EMAIL,formDTO.getEmail());

    }


}
