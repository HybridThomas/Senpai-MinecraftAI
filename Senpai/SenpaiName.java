package me.Thomas.Senpai;

import org.apache.commons.lang3.text.WordUtils;

public class SenpaiName implements AIMessage {
	
	private String nameset = "my name is";
	private String nameknow = "what is my name";
	private final String[] setphrases = {"Hello, %n.","Nice to meet you, %n.","Oh! So your name's %n.","How can I help you? %n."};
	private final String[] knowphrases = {"I'm pretty sure your name is %n...","You don't remember your name, %n?","Your name is %n"};

	@Override
	public void parse(AIUser user, String message) {
		if (message.startsWith(nameset)) {
			String name = getWordAfter(message, "is");
			if (name != null) {
				user.setName(WordUtils.capitalize(name));
				Senpai.chat(Senpai.replaceNames(Senpai.choosePhrase(setphrases), user));
			}
		} else if (message.startsWith(nameknow)) {
			Senpai.chat(Senpai.replaceNames(Senpai.choosePhrase(knowphrases), user));
		}
	}
	
	public String getWordAfter(String message, String word) {
		String[] words = message.split(" ");
		boolean isNext = false;
		for (final String word1 : words) {
			if (isNext) {
				return word1;
			} else if (word1.equals(word)) {
				isNext = true;
			}
		}
		return null;
	}
}
