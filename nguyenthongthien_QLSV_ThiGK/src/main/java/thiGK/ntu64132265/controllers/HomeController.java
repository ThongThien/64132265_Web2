package thiGK.ntu64132265.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import thiGK.ntu64132265.models.Student;
import thiGK.ntu64132265.models.Topic;

public class HomeController {	
    	private List<Topic> topics = Arrays.asList(
            new Topic(1, "AI Development", "Exploring AI and ML", 101, "Research"),
            new Topic(2, "Web Security", "Cybersecurity for web apps", 102, "Security"),
            new Topic(3, "Blockchain Tech", "Decentralized finance systems", 103, "Finance")
        );

        private List<Student> students = Arrays.asList(
            new Student(1, "Alice", 1),
            new Student(2, "Bob", 1),
            new Student(3, "Charlie", 2)
        );

        @GetMapping("/")
        public String home(Model model) {
            model.addAttribute("topics", topics);
            model.addAttribute("students", students);
            return "frontEndViews/home";
        }

        @GetMapping("/topic/all")
        public String listTopics(Model model) {
            model.addAttribute("topics", topics);
            return "topic-list";
        }

        @GetMapping("/topic/new")
        public String newTopic() {
            return "topic-form";
        }

        @GetMapping("/topic/view/{id}")
        public String viewTopic(@PathVariable int id, Model model) {
            Optional<Topic> topic = topics.stream().filter(t -> t.getId() == id).findFirst();
            topic.ifPresent(value -> model.addAttribute("topic", value));
            return "topic-view";
        }

        @GetMapping("/topic/delete/{id}")
        public String deleteTopic(@PathVariable int id, Model model) {
            topics.removeIf(t -> t.getId() == id);
            model.addAttribute("topics", topics);
            return "redirect:/topic/all";
        }
        
        @GetMapping("/student/all")
        public String listStudents(Model model) {
            model.addAttribute("students", students);
            return "student-list";
        }

        @GetMapping("/student/view/{id}")
        public String viewStudent(@PathVariable int id, Model model) {
            Optional<Student> student = students.stream().filter(s -> s.getId() == id).findFirst();
            student.ifPresent(value -> model.addAttribute("student", value));
            return "student-view";
        }

        @GetMapping("/student/delete/{id}")
        public String deleteStudent(@PathVariable int id, Model model) {
            students.removeIf(s -> s.getId() == id);
            return "redirect:/student/all";
        }
}
