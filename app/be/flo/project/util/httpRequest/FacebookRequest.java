package be.flo.project.util.httpRequest;

import be.flo.project.dto.externalDTO.FacebookTokenAccessControlDTO;
import be.flo.project.util.ErrorMessageEnum;
import be.flo.project.util.exception.MyRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import play.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by florian on 3/05/15.
 */
@Component
public class FacebookRequest {

    private String accessKey = Configuration.root().getString("facebook.app.token");

    @Autowired
    private HttpRequest httpRequest;

    public FacebookTokenAccessControlDTO debugToken(String inputToken) {

        Map<String, String> map = new HashMap<>();
        map.put("input_token", inputToken);
        map.put("access_token", accessKey);


        try {
            return httpRequest.sendRequest(HttpRequest.RequestMethod.GET, "https://graph.facebook.com/debug_token", map, FacebookTokenAccessControlDTO.class);
        } catch (HttpRequestException e) {
            e.printStackTrace();
            throw new MyRuntimeException(ErrorMessageEnum.FATAL_ERROR);
        }
    }


}
