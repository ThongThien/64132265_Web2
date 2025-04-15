package QLSV.ntu64132265.models;

public class Topic implements Identifiable{
    private int id;
    private String topicName;
    private String topicDescription;
    private int supervisorID;
    private String topicType;
    
    public Topic(int id, String topicName, String topicDescription, int supervisorId, String topicType) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.supervisorID = supervisorId;
        this.topicType = topicType;
    }
    
    public Topic() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public int getId() {
        return this.id;
    }

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public int getSupervisorID() {
		return supervisorID;
	}

	public void setSupervisorID(int supervisorID) {
		this.supervisorID = supervisorID;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
    
}
