//package com.ideas2it.employeeProject.service.impl;
//
//import com.ideas2it.employeeProject.service.EmployeeService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.orm.ObjectRetrievalFailureException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service("userDetailsService")
//public class AuthenticationServiceImpl implements UserDetailsService {
//
//    private final Log log = LogFactory.getLog(AuthenticationServiceImpl.class);
//
//    @Autowired
//    private EmployeeService userService;
//
//    /**
//     * Load a user for Spring Security.
//     */
//    @Transactional
//    public UserDetails loadUserByUsername(String login)
//            throws UsernameNotFoundException, DataAccessException {
//
//        login = login.toLowerCase();
//        if (log.isDebugEnabled()) {
//            log.debug("Security verification for user '" + login + "'");
//        }
//        User user;
//        try {
//            user = userService.findUser(login);
//        } catch (ObjectRetrievalFailureException orfe) {
//            throw new UsernameNotFoundException("User '" + login
//                    + "' could not be found.");
//        }
//        user.setLastAccessDate(Calendar.getInstance().getTime());
//
//        Set<Role> roles = user.getRoles();
//
//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (Role role : roles) {
//            authorities.add(new GrantedAuthorityImpl(role.getRole()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(login,
//                user.getPassword(), user.isEnabled(), true, true, true,
//                authorities);
//    }
//}
