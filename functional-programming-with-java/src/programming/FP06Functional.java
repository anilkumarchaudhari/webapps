package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;
	
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		//super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	
	public String toString() {
		return name+ " :"+noOfStudents +":"+reviewScore;
	}
	
	
}

public class FP06Functional {
  public static void main(String args[]) {
	  List<Course>courses=List.of(
      		new Course("Spring","Framework",98,2000),
      		new Course("Spring Boot","Framework",95,18000),
      		new Course("API","Microservices",95,22000),
      		new Course("Microservices","Microservices",95,25000),
      		new Course("FullStack","FullStack",91,14000),
      		new Course("AWS","Cloud",92,21000),
      		new Course("Azure","Cloud",99,21000),
      		new Course("Docker","Docker",92,20000),
      		new Course("Kubernetes","Docker",91,20000)
      		
      		);	  //all match ,nonematch ,anyMatch
      Predicate<? super Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() >=95;
	  
	  Predicate<? super Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() >90;
	 
	  Predicate<? super Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() <90;

	  System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
	  System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));
	  
	 System.out.println(courses.stream().allMatch(reviewScoreLessThan90Predicate));
	 System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
	 System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
	 System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan90Predicate));

	 Comparator<Course> comparingNoOfStudentsIncreasing=Comparator.comparing(Course :: getNoOfStudents) ;
	 //[Spring :2000:98, FullStack :14000:91, Spring Boot :18000:95, Docker :20000:92, Kubernetes :20000:91, AWS :21000:92, Azure :21000:99, API :22000:95, Microservices :25000:95]
	 System.out.println(
			 courses.stream()
			 .sorted(comparingNoOfStudentsIncreasing)
			 .collect(Collectors.toList()));
	 int cutOffPredicate=95;
	 Predicate<? super Course> reviewScoreGreaterThan95Predicate2 = createCutOffPredicate(95);
	  	 
	 Predicate<? super Course> reviewScoreGreaterThan90Predicate2 = createCutOffPredicate(90);
  }

private static Predicate<? super Course> createCutOffPredicate(int cutOffPredicate) {
	return course -> course.getReviewScore() >=cutOffPredicate;
}
}
