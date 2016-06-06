package me.Thomas.Senpai;

public class SenpaiMention implements AIMessage {
	
	private final String[] phrase = {"Hello, %p.", "Good day, %p.", "What do you want from me? %p.", "You said my name? %p.", "How can I help you? %p."};
	private final String[] lowamity = {"Hello, %p...", "You again?", "What do you want from me now? %p", "Ugh... hi?"};
	private final String[] noamity = {"Screw you.", "You sicken me.", "I don't want to talk to you.", "Leave me alone.", "Go away.", "Piss off!"};

	@Override
	public void parse(AIUser user, String message) {
		if (message.equals("senpai") || message.startsWith("hello senpai")) {
			if (user.getAmity() == 0) {
				Senpai.chat(Senpai.choosePhrase(noamity));
			} else if (user.getAmity() < 5) {
				Senpai.chat(Senpai.replaceNames(Senpai.choosePhrase(lowamity), user));
			} else {
				Senpai.chat(Senpai.replaceNames(Senpai.choosePhrase(phrase), user));
			}
		}
	}
}
