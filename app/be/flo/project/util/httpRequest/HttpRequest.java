package be.flo.project.util.httpRequest;

import be.flo.project.dto.technical.DTO;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import play.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by florian on 30/08/14.
 */
@Component
public class HttpRequest {


	public enum RequestMethod {
		GET, POST;
	}

	public <T extends DTO> T sendRequest(RequestMethod requestMethod, String site, Map<String, String> params, Class<T> returnExcepted) throws HttpRequestException {

		JsonNode actualObj = sendRequest(requestMethod,site,params);

		return DTO.getDTO(actualObj, returnExcepted);
	}

	public JsonNode sendRequest(RequestMethod requestMethod, String site, Map<String, String> params) throws HttpRequestException {



        //test connection
        try{
            URL urlTest = new URL("http://www.google.be");
            HttpURLConnection connection = (HttpURLConnection) urlTest.openConnection();
            InputStream is = connection.getInputStream();
        }
        catch(java.net.UnknownHostException e){
            e.printStackTrace();
            throw new HttpRequestException("no connection");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new HttpRequestException("bad url");
        } catch (IOException e) {
            e.printStackTrace();
            throw new HttpRequestException("connection error");
        }


        if(params == null){
			params = new HashMap<>();
		}

		//todo auth for quandl params.put(AUTH_PARAM,AUTH);

		String paramString = buildOption(params);


		try {

			if(!site.contains("http")){
				site="http://"+site;
			}

			if (requestMethod.equals(RequestMethod.GET)) {
				site = site + "?" + buildOption(params);
			}

			URL url = new URL(site);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(requestMethod.toString());
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			if (requestMethod.equals(RequestMethod.POST)) {
				connection.setRequestProperty("Content-Length", "" +
						Integer.toString(paramString.getBytes().length));
			}
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			//Send request
			if (requestMethod.equals(RequestMethod.POST)) {
				DataOutputStream wr = new DataOutputStream(
						connection.getOutputStream());
				wr.writeBytes(paramString);
				wr.flush();
				wr.close();
			}

			Logger.info("Send request... ("+url+")");

			//Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();

			Logger.info("Request finish ! ");

			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getJsonFactory(); // since 2.1 use mapper.getFactory() instead
			JsonParser jp = factory.createJsonParser(response.toString());
			return mapper.readTree(jp);

		} catch (MalformedURLException e) {
			throw new HttpRequestException(e, "URL malformed");
		} catch (IOException e) {
			throw new HttpRequestException(e, "URL error");
		}


	}

	private String buildOption(Map<String, String> params) {
		if(params==null){
			return "";
		}

		String content = "";
		boolean first = false;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (first) {
				first = false;
			} else {
				content += "&";
			}
			content += entry.getKey() + "=" + entry.getValue();
		}
		return content;
	}
}
