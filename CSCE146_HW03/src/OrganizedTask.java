// written by Dominic Mattio
public class OrganizedTask
{

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private int priority;
	private String action;
	private static final String splitMarker = "\t";
	
	public OrganizedTask(int aPrio, String aAction) 
	{
		if(aPrio < 5 && aPrio > -1)
			priority = aPrio;
		else
			priority = 4;
		if(aAction != null)
			action = aAction;
		else
			action.equals("none");	
	}
	
	public void print() 
	{
		System.out.println("[Task] Priority: " + priority + "\t" + "Task: " + action);
	}
	
	public static OrganizedTask read(String check) 
	{
		String[] parts = check.split(splitMarker);
		int prio = Integer.parseInt(parts[0]);
		OrganizedTask a = new OrganizedTask(prio,parts[1]);
		return a;
	}
	
	
	
	
	
}
