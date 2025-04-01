package thiGK.ntu64132265.models;

public class Topic {
    private int id;
    private String topicName;
    private String topicDescription;
    private int supervisorID;
    private String topicType;
    
    public Topic(int id, String topicName, String topicDescription, int supervisorID, String topicType) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.supervisorID = supervisorID;
        this.topicType = topicType;
    }
    
    public Topic() {
		// TODO Auto-generated constructor stub
	}



	public int getId() { return id; }
    public String getTopicName() { return topicName; }
    public String getTopicDescription() { return topicDescription; }
    public int getSupervisorID() { return supervisorID; }
    public String getTopicType() { return topicType; }
}
