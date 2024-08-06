package com.spearhead.nova.model;

import java.util.Collection;
import java.util.Objects;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;
	
    private String username;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private String customerId;
    
    private String phoneNumber;
   
   private String bvn;
 
   
   
   

    @JsonIgnore   
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
  
    

    public UserPrincipal(Long userId, String username,String email,String password, String firstName, String lastName, 
    		String customerId, String phoneNumber, String bvn
    // , Collection<? extends GrantedAuthority> authorities
    ) {
		super();
		this.userId = userId;
		this.username = username;
		this.email=email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
		this.phoneNumber = phoneNumber;
		this.bvn = bvn;
		// this.authorities = authorities;
	}

	public static UserPrincipal create(User user) {
     /*    List<GrantedAuthority> authorities = Stream.of(user.getRole())
        	.map(role -> new SimpleGrantedAuthority(role.getName().name()))
        	.collect(Collectors.toList()); */
       
        return new UserPrincipal(user.getUserId(),user.getEmail(),user.getEmail(),user.getPassword(), user.getFirstName(), user.getLastName()
        		, user.getCustomerId(), user.getPhoneNumber(), user.getBvn());
    }

	
	
	public String getBvn() {
		return bvn;
	}

	public void setBvn(String bvn) {
		this.bvn = bvn;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customercode) {
		this.customerId = customercode;
	}
	

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    public String getEmail() {
        return email;
    }
    
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    
    public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	
	@Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}