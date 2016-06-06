package me.Thomas.Senpai;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringEscapeUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SenpaiJoke implements AIMessage {
	
	private String[] words = {"tell", "me", "joke"};
	private final String url = "http://api.icndb.com/jokes/random";

	@Override
	public void parse(AIUser user, String message) {
		for (String word : words) {
			if (!message.contains(word)) {
				return;
			}
		}
		String joke = "Sorry, I'm not in the mood right now.";
		try {
			URL url = new URL(this.url);
		    HttpURLConnection request = (HttpURLConnection) url.openConnection();
		    request.connect();

		    JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		    
		    JsonObject rootobj = root.getAsJsonObject();
		    joke = StringEscapeUtils.unescapeHtml4(rootobj.getAsJsonObject("value").getAsJsonObject().get("joke").getAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Senpai.chat(joke);
	}
}
