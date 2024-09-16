//package com.example.demo.securityConfig;
//
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.repository.EmployerDaoRepo;
//
//@Component
//public class CustomeUsersDetailsService implements UserDetailsService {
//
//	@Autowired
//	EmployerDaoRepo daoRepo;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		
//		  List<User> user = daoRepo.findByUserName(username);
//		  UserDetails userDetails = user.stream()
//				    .findFirst()
//				    .map(use->new CustomUserDetails(use))
//				    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//		  return (UserDetails) user;
//		  
////		  List<EmployerDAO> user = daoRepo.findByUserName(username);
////	        return user.map(CustomUserDetails::new)
////	                   .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//	         
//	}
//
//}
//
//class CustomUserDetails implements UserDetails {
//
//    private final User user;
//
//    public CustomUserDetails(User user) {
//        this.user = user;
//    }
//
//    
//
//	@Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
//
