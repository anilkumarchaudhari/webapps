package com.spring.redis;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    @Id
   // @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private long followers;

    public User() {
    }

    public User(String name,String email, long followers) {
        this.name = name;
        this.email= email;
        this.followers = followers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", followers=" + followers + "]";
	}

	
}
