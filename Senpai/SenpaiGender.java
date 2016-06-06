package me.Thomas.Senpai;

public class SenpaiGender implements AIMessage {
	
	private String[] words = {"are", "you", "boy", "girl", "male", "female"};
	private String[] phrases = {"I'll be whatever you want me to *winks eye*", "I'm a kawaii anime girl.", "My gender is unspecified.", "Why would you ask that?", "I am neither male nor female, I am just JAVA code."};

	@Override
	public void parse(AIUser user, String message) {
		if (message.contains("you")) {
			int i = 0;
			for (String word : words) {
				if (message.contains(word)) {
					i++;
				}
			}
			if (i >= 3) {
				Senpai.chat(Senpai.choosePhrase(phrases));
			}
		}
	}
}
