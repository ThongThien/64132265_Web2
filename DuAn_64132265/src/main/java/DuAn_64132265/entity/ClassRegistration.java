package DuAn_64132265.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "class_registration")
public class ClassRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class aClass;

    @Column(name = "registration_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp registrationDate;
    @PrePersist
    public void prePersist() {
        if (registrationDate == null) {
            registrationDate = new Timestamp(System.currentTimeMillis());
        }
    }
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
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the aClass
	 */
	public Class getaClass() {
		return aClass;
	}

	/**
	 * @param aClass the aClass to set
	 */
	public void setaClass(Class aClass) {
		this.aClass = aClass;
	}

	/**
	 * @return the registrationDate
	 */
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

    // Getter và Setter
    
}
