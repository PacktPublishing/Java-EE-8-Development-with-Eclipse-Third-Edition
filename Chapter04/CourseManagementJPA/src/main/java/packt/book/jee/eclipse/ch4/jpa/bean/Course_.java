package packt.book.jee.eclipse.ch4.jpa.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-11T15:44:16.474+0530")
@StaticMetamodel(Course.class)
public class Course_ {
	public static volatile SingularAttribute<Course, Integer> id;
	public static volatile SingularAttribute<Course, String> name;
	public static volatile SingularAttribute<Course, Integer> credits;
	public static volatile SingularAttribute<Course, Teacher> teacher;
	public static volatile ListAttribute<Course, Student> students;
}
