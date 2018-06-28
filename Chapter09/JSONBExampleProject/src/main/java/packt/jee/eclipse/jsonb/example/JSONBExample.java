package packt.jee.eclipse.jsonb.example;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JSONBExample {

	public static void main(String[] args) throws Exception {
		Course course = new Course(1,"Course-1", 5);
		course.setTeacher(new Teacher(1, "Teacher-1"));
		
		// Serialize to JSON string
		Jsonb jsonb = JsonbBuilder.create();
		String courseJson = jsonb.toJson(course, Course.class);
		System.out.println(courseJson);
		
		// De-serialize fromd JSON string
		Course deserializedCourse = jsonb.fromJson(courseJson, Course.class);
		System.out.println(deserializedCourse.getName());
	}
}
