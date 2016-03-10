package mx.blogspot.decibelelektrobeat

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class ApplicationUser implements UserDetails, Serializable {

    String username
    String password
    Boolean accountNonExpired
    Boolean accountNonLocked
    Boolean credentialsNonExpired
    Boolean forceLocalLogin
    Boolean enabled

    static hasMany 		= [roles: ApplicationRole]

    static constraints = {
        username nullable:false, blank:false, unique:true
        password nullable:false, blank:false
        accountNonExpired nullable:false, blank:false
        accountNonLocked nullable:false, blank:false
        credentialsNonExpired nullable:false, blank:false
        forceLocalLogin nullable:false, blank:false
        enabled nullable:false, blank:false
    }

    @Override
    Collection <? extends GrantedAuthority> getAuthorities(){
        return roles.collect {ApplicationRole authority ->
            new SimpleGrantedAuthority(authority.name)
        }
    }

    @Override
    boolean isAccountNonExpired() {
        return accountNonExpired
    }

    @Override
    boolean isAccountNonLocked(){
        return accountNonLocked
    }

    @Override
    boolean isCredentialsNonExpired(){
        return credentialsNonExpired
    }

    @Override
    boolean isEnabled(){
        return enabled
    }

}
