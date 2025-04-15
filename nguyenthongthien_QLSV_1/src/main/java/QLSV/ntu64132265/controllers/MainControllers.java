package QLSV.ntu64132265.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QLSV.ntu64132265.models.Identifiable;
import QLSV.ntu64132265.models.Student;
import QLSV.ntu64132265.models.Topic;

@Controller
public class MainControllers {		
		private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic(1, "AI Development", "Exploring AI and ML", 101, "Research"),
            new Topic(2, "Web Security", "Cybersecurity for web apps", 102, "Security"),
            new Topic(3, "Blockchain Tech", "Decentralized finance systems", 103, "Finance")
        ));
		
    	private List<Student> students = new ArrayList<>(Arrays.asList(
    		    new Student(1, "Nguyễn Thông Thiên", 1),
    		    new Student(2, "Lê Thanh Sơn", 2),
    		    new Student(3, "Trần Minh Tâm", 3)
    	));

    	private <T extends Identifiable> Optional<T> findById(List<T> list, int id) {
    	    return list.stream().filter(item -> item.getId() == id).findFirst();
    	}


        @GetMapping("/")
        public String dashboard() {
            return "dashboard";  
        }

        @GetMapping("/topic/all")
        public String listTopics(Model model) {
            model.addAttribute("topics", topics);
            return "topic-list";
        }

        @GetMapping("/topic/new")
        public String newTopic(Model model) {
            model.addAttribute("topic", new Topic());
            return "topic-Addnew";
        }

        @GetMapping("/topic/view/{id}")
        public String viewTopic(@PathVariable int id, Model model) {
            findById(topics, id).ifPresent(topic -> model.addAttribute("topic", topic));
            return "topic-View";
        }
        
        @GetMapping("/topic/edit/{id}")
        public String editTopic(@PathVariable int id, Model model) {
            findById(topics, id).ifPresent(topic -> model.addAttribute("topic", topic));
            return "topic-edit";
        }

        @PostMapping("/topic/update/{id}")
        public String updateTopic(
            @PathVariable int id,
            @RequestParam String topicName,
            @RequestParam String topicDescription,
            @RequestParam int supervisorID,
            @RequestParam String topicType
        ) {
            findById(topics, id).ifPresent(topic -> {
                topic.setTopicName(topicName);
                topic.setTopicDescription(topicDescription);
                topic.setSupervisorID(supervisorID);
                topic.setTopicType(topicType);
            });
            return "redirect:/topic/all";
        }

        @GetMapping("/topic/delete/{id}")
        public String deleteTopic(@PathVariable int id) {
            topics.removeIf(topic -> topic.getId() == id);
            return "redirect:/topic/all";
        }

        @PostMapping("/topic/save")
        public String saveTopic(
            @RequestParam String topicName,
            @RequestParam String topicDescription,
            @RequestParam int supervisorID,
            @RequestParam String topicType
        ) {
            Topic newTopic = new Topic(topics.size() + 1, topicName, topicDescription, supervisorID, topicType);
            topics.add(newTopic);
            return "redirect:/topic/all";
        }

        @GetMapping("/student/all")
        public String listStudents(Model model) {
            model.addAttribute("students", students);
            return "student-List";
        }
        
        @GetMapping("/student/new")
        public String newStudent() {
            return "student-Addnew";
        }
        
        // Lưu sinh viên mới
        @PostMapping("/student/save")
        public String saveStudent(
            @RequestParam String name,
            @RequestParam int groupID
        ) {
            Student newStudent = new Student(students.size() + 1, name, groupID);
            students.add(newStudent);
            return "redirect:/student/all";
        }

        @GetMapping("/student/view/{id}")
        public String viewStudent(@PathVariable int id, Model model) {
            findById(students, id).ifPresent(student -> model.addAttribute("student", student));
            return "student-View";
        }
        
        @GetMapping("/student/edit/{id}")
        public String editStudent(@PathVariable int id, Model model) {
            findById(students, id).ifPresent(student -> model.addAttribute("student", student));
            return "student-edit";
        }

        @PostMapping("/student/update/{id}")
        public String updateStudent(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam int groupID
        ) {
            findById(students, id).ifPresent(student -> {
                student.setName(name);
                student.setGroupID(groupID);
            });
            return "redirect:/student/all";
        }


        @GetMapping("/student/delete/{id}")
        public String deleteStudent(@PathVariable int id) {
            students.removeIf(student -> student.getId() == id);
            return "redirect:/student/all";
        }
        
}