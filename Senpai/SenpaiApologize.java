package me.Thomas.Senpai;

public class SenpaiApologize implements AIMessage {
	
	private String[] highamity = {"You don't have to be sorry.", "Sorry, for what?", "Why?"};
	private String[] midamity = {"No worries.", "Apology accepted.", "It's fine.", "No problem."};
	private String[] lowamity = {"I forgive you.", "I appreciate your apology.", "You should be.", "Please don't let it happen again."};

	@Override
	public void parse(AIUser user, String message) {
		message = message.replace("im", "i am");
		if (message.contains("i am sorry") || message.contains("i am really sorry")) {
			byte amity = user.getAmity();
			if (amity == 0) {
				Senpai.chat(Senpai.choosePhrase(lowamity));
			} else if (amity < 7) {
				Senpai.chat(Senpai.choosePhrase(midamity));
			} else {
				Senpai.chat(Senpai.choosePhrase(highamity));
			}
			user.boostAmity();
		}
	}
}
