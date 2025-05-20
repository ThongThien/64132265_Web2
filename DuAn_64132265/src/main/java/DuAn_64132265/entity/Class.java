package DuAn_64132265.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "max_students", nullable = false)
    private Integer maxStudents;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the schedule
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	/**
	 * @return the maxStudents
	 */
	public Integer getMaxStudents() {
		return maxStudents;
	}

	/**
	 * @param maxStudents the maxStudents to set
	 */
	public void setMaxStudents(Integer maxStudents) {
		this.maxStudents = maxStudents;
	}

	/**
	 * @return the trainer
	 */
	public Trainer getTrainer() {
		return trainer;
	}

	/**
	 * @param trainer the trainer to set
	 */
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public String toString() {
	    // Trả về thông tin mô tả đối tượng theo định dạng tùy chỉnh
	    return "Class{id=" + id + ", className='" + className + "', description='" + description + "', schedule=" + schedule + ", maxStudents=" + maxStudents + ", trainer=" + trainer + "}";
	}


    // Getter và Setter
    
}
