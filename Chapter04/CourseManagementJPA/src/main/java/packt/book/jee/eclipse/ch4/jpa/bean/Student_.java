package packt.book.jee.eclipse.ch4.jpa.bean;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-11T15:44:16.475+0530")
@StaticMetamodel(Student.class)
public class Student_ extends Person_ {
	public static volatile SingularAttribute<Student, Date> enrolledsince;
	public static volatile ListAttribute<Student, Course> courses;
}
