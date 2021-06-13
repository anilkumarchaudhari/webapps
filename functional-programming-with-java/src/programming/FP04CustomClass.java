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

public class FP04CustomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
        		
        		);
        
             //all match ,nonematch ,anyMatch
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
		 
		 Comparator<Course> comparingNoOfStudentsDecreasing=Comparator.comparing(Course :: getNoOfStudents).reversed() ;
		 //[Microservices :25000:95, API :22000:95, AWS :21000:92, Azure :21000:99, Docker :20000:92, Kubernetes :20000:91, Spring Boot :18000:95, FullStack :14000:91, Spring :2000:98]
		 System.out.println(
				 courses.stream()
				 .sorted(comparingNoOfStudentsDecreasing)
				 .collect(Collectors.toList()));
		 
		 Comparator<Course> comparingNoOfStudentsAndNoOfReviews
		                       =Comparator.comparing(Course :: getNoOfStudents)
		                       .thenComparing(Course :: getReviewScore).reversed() ;
		 
		 System.out.println(
				 courses.stream()
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .collect(Collectors.toList()));
		 
		 //[Microservices :25000:95, API :22000:95, Azure :21000:99, AWS :21000:92, Docker :20000:92, Kubernetes :20000:91, Spring Boot :18000:95, FullStack :14000:91, Spring :2000:98]

		 
		 //Limit function with Comparator
		 System.out.println(
				 courses.stream()
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .limit(5)
				 .collect(Collectors.toList()));
//		 [Microservices :25000:95, API :22000:95, Azure :21000:99, AWS :21000:92, Docker :20000:92]

		//Limit ,Skip  function with Comparator using skip first mentioned records will be skip
		 System.out.println(
				 courses.stream()
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .skip(3)
				 .collect(Collectors.toList()));
	//[AWS :21000:92, Docker :20000:92, Kubernetes :20000:91, Spring Boot :18000:95, FullStack :14000:91, Spring :2000:98]
		 //skip 3 records and limit only 5 records
		 System.out.println(
				 courses.stream()
				 .sorted(comparingNoOfStudentsAndNoOfReviews)
				 .skip(3)
				 .limit(5)
				 .collect(Collectors.toList()));
		 //[AWS :21000:92, Docker :20000:92, Kubernetes :20000:91, Spring Boot :18000:95, FullStack :14000:91]
		
		 //takeWhile function -- return records till this condition is satified once false do not returns record
		 System.out.println(
		    courses.stream()
		          .takeWhile(course -> course.getReviewScore() >=95)
		          .collect(Collectors.toList()));
		 //[Spring :2000:98, Spring Boot :18000:95, API :22000:95, Microservices :25000:95]
		 
		 //dropWhile function --- drop the records till the condition satisfy and returns all records after this condition fails
		 System.out.println(
		    courses.stream()
		          .dropWhile(course -> course.getReviewScore() >=95)
		          .collect(Collectors.toList()));
          //[FullStack :14000:91, AWS :21000:92, Azure :21000:99, Docker :20000:92, Kubernetes :20000:91]
		
		 
		 // max function returns last element in the list
		 System.out.println(
				 courses.stream()
				 .max(comparingNoOfStudentsAndNoOfReviews));
		 //Optional[Spring :2000:98]

		 //min function returns first element from list
		 System.out.println(
				 courses.stream()
				 .min(comparingNoOfStudentsAndNoOfReviews));
		 //Optional[Microservices :25000:95]
		 
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreLessThan90Predicate)
				 .min(comparingNoOfStudentsAndNoOfReviews));
		//Optional.empty
		
		 //orElase function used to return default object when no result is there
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreLessThan90Predicate)
				 .min(comparingNoOfStudentsAndNoOfReviews)
				 .orElse(new Course("Kubernetes","Cloud" ,91,20000)));
		 //Kubernetes :20000:91
		 
		 //findFirst return first element from filtered list
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreGreaterThan95Predicate)
				 .findFirst()
				 );
		 //Optional[Spring :2000:98]
		 
		//findAny returns any random  element from filtered list
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreGreaterThan95Predicate)
				 .findAny()
				 );
		 
		 //sum function calculate total no of students
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreGreaterThan95Predicate)
				 .mapToInt(Course :: getNoOfStudents)
				 .sum());
		
		 //average function calculate avg of total no of students
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreGreaterThan95Predicate)
				 .mapToInt(Course :: getNoOfStudents)
				 .average());
		
		 
		//count function calculate count of no of courses who met the criteria
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreGreaterThan95Predicate)
				 .mapToInt(Course :: getNoOfStudents)
				 .count());
		 
		 //max no of student course from list
		 System.out.println(
				 courses.stream()
				 .filter(reviewScoreGreaterThan95Predicate)
				 .mapToInt(Course :: getNoOfStudents)
				 .max());
		 
		//groupingBy is used to group list based on some category
		 System.out.println(
				 courses.stream()
				 .collect(Collectors.groupingBy(Course :: getCategory)));
		 //{Docker=[Docker :20000:92, Kubernetes :20000:91], 
		 //Cloud=[AWS :21000:92, Azure :21000:99],
		 //FullStack=[FullStack :14000:91],
		 //Microservices=[API :22000:95, Microservices :25000:95], 
		 //Framework=[Spring :2000:98, Spring Boot :18000:95]}
		 
		 //get no of count for each category
		 System.out.println(
				 courses.stream()
				 .collect(Collectors.groupingBy(Course :: getCategory,Collectors.counting())));
		 //{Docker=2, Cloud=2, FullStack=1, Microservices=2, Framework=2}
		 
		//get course with maximum review score as per category
		 System.out.println(
				 courses.stream()
				 .collect(Collectors.groupingBy(Course :: getCategory,
				   Collectors.maxBy(Comparator.comparing(Course :: getReviewScore)))));
		 //{Docker=Optional[Docker :20000:92],
		 //Cloud=Optional[Azure :21000:99], 
		 //FullStack=Optional[FullStack :14000:91], 
		 //Microservices=Optional[API :22000:95], 
		 //Framework=Optional[Spring :2000:98]}
		 
		 System.out.println(
				 courses.stream()
				 .collect(Collectors.groupingBy(Course :: getCategory,
				   Collectors.mapping(Course :: getName ,Collectors.toList()))));
		 
		 //{Docker=[Docker, Kubernetes], 
		 //Cloud=[AWS, Azure], FullStack=[FullStack], Microservices=[API, Microservices],
		 //Framework=[Spring, Spring Boot]}


	}

}
