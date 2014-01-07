package test;

public class Tokenizer {
	private String line;
	private String token;
	private int tokenPos;
	private int start;

	public Tokenizer(String line, String token) {
		this.line = line;
		this.token = token;
		tokenPos = 0;
		start = 0;
	}

	public String next() {
		start = tokenPos;

		tokenPos = line.indexOf(token, tokenPos + 1);

		if (tokenPos < 0)
			return line.substring(start);
		if (tokenPos < line.length())
			return line.substring(start, tokenPos++);
		else
			return null;
	}
}