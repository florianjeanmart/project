package be.flo.project.controller;

import be.flo.project.dto.externalDTO.FacebookTokenAccessControlDTO;
import be.flo.project.dto.technical.DTO;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

/**
 * Created by florian on 7/05/15.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JsonConversionTest extends AbstractControllerTest{

    @Test
    public void test1() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            JsonParser jp = factory.createParser(" {\"data\":{\"error\":{\"code\":190,\"message\":\"Invalid OAuth access token.\"},\"is_valid\":false}}");
            JsonNode treeNode = mapper.readTree(jp);

            FacebookTokenAccessControlDTO dto = DTO.getDTO(treeNode, FacebookTokenAccessControlDTO.class);

            Assert.assertNotNull(dto);
        }
        catch(Exception e){
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

    }
}
