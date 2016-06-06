package me.Thomas.Senpai;

public class SenpaiCompliment implements AIMessage {
	
	private String[] words = {"cute", "kawaii", "nice", "pretty", "beautiful", "thoughtful", "clever", "smart"};
	private String[] phrases = {"You're so thoughtful. *giggles*", "Thanks for thinking I'm %w that's very kind of you.", "Thanks for complimenting me <3", "Thank you, it's very nice of you to say that."};
	private String[] lowamity = {"Oh... well, thanks.", "Thanks.", "I didn't expect that coming from you, thanks, I guess.", "Thank you."};
	private String[] noamity = {"May I ask why?", "Do you really expect me to pardon you for that?", "What do you expect me to say?"};

	@Override
	public void parse(AIUser user, String message) {
		if (message.contains("you")) {
			for (String word : words) {
				if (message.contains(word)) {
					if (user.getAmity() == 0) {
						Senpai.chat(Senpai.choosePhrase(noamity));
					} else if (user.getAmity() <= 3) {
						Senpai.chat(Senpai.choosePhrase(lowamity));
						user.raiseAmity();
					} else {
						Senpai.chat(Senpai.choosePhrase(phrases).replaceAll("%w", word));
						user.raiseAmity();
					}
					break;
				}
			}
		}
	}
}
