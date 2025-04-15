package QLSV.ntu64132265.models;

public class Student implements Identifiable{
    private int id;
    private String name;
    private int groupID;
    
    public Student(int id, String name, int groupID) {
        this.id = id;
        this.name = name;
        this.groupID = groupID;
    }

    @Override
    public int getId() {
        return this.id;
    }

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
    
    

}