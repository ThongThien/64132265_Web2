package thiGK.ntu64132265.models;

public class Student {
    private int id;
    private String name;
    private int groupID;
    
    public Student(int id, String name, int groupID) {
        this.id = id;
        this.name = name;
        this.groupID = groupID;
    }
    

	public int getId() { return id; }
    public String getName() { return name; }
    public int getGroupID() { return groupID; }


	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
}