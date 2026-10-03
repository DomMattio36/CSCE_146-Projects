
public class GameCollection {

	private String game;
	private String console;
	
	public GameCollection (String g, String c) 
	{
		game = g;
		console = c;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String g) {
		this.game = g;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String c) {
		this.console = c;
	}
	public String toString()
	{
		String c = new String(this.getGame() + this.getConsole());
		return c;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
