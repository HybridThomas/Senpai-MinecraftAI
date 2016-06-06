package me.Thomas.Senpai;

public class SenpaiInsult implements AIMessage {
	
	private String[] words = {"screw", "stupid", "asshole", "ugly", "suck", "retarded", "motherfucker"};
	private String[] phrases = {"Well, screw you too.", "Yeah, whatever mate.", "So?", "No wonder nobody likes you...", "I appreciate your feedback. *hangs up*"};
	private String[] lowamity = {"What is wrong with you?", "Leave me alone.", "For god's sake, leave me alone!", "..."};

	@Override
	public void parse(AIUser user, String message) {
		if (message.contains("you")) {
			for (String word : words) {
				if (message.contains(word)) {
					if (user.getAmity() <= 3) {
						Senpai.chat(Senpai.choosePhrase(lowamity));
					} else {
						Senpai.chat(Senpai.choosePhrase(phrases));
					}
					user.lowerAmity();
					break;
				}
			}
		}
	}
}
