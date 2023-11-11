package com.blogs.apis.entites;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@NoArgsConstructor
@Getter
@Setter
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;

	@Column(name = "post_title", nullable = false, length = 100)
	private String title;

	@Column(length = 800)
	private String contant;

	private String imageName;

	private Date addedDate;
	
    @ManyToOne
    @JoinColumn(name="category_id")
	private Category category;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
	private User user;
	
	

}
