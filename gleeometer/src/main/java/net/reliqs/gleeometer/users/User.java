package net.reliqs.gleeometer.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.reliqs.gleeometer.glee.Glee;

import java.util.Collection;

import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {

    public enum Role {USER, ADMIN, USER_MANAGER}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Email
    private String email;
    @JsonIgnore
    @ToString.Exclude
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
    private Double minGleePerDay;
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private Collection<Glee> glee;
    
    public User() {}
    
	public User(Long id, @NotEmpty @Email String email, String password, Role role, Double minGleePerDay,
			Collection<Glee> glee) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.minGleePerDay = minGleePerDay;
		this.glee = glee;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Double getMinGleePerDay() {
		return minGleePerDay;
	}
	public void setMinGleePerDay(Double minGleePerDay) {
		this.minGleePerDay = minGleePerDay;
	}
	public Collection<Glee> getGlee() {
		return glee;
	}
	public void setGlee(Collection<Glee> glee) {
		this.glee = glee;
	}
    
    
}