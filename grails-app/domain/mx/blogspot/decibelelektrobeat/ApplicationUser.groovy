package mx.blogspot.decibelelektrobeat

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class ApplicationUser implements UserDetails, Serializable {

    String username
    String password
    Boolean nonExpiredAccount
    Boolean nonLockedAccount
    Boolean nonExpiredCredentials
    Boolean forceLocalLogin
    Boolean isAccountEnabled

    static hasMany 		= [roles: ApplicationRole]

    static constraints = {
        username nullable:false, blank:false, unique:true
        password nullable:false, blank:false
        nonExpiredAccount nullable:false, blank:false
        nonLockedAccount nullable:false, blank:false
        nonExpiredCredentials nullable:false, blank:false
        forceLocalLogin nullable:false, blank:false
        isAccountEnabled nullable:false, blank:false
    }

    @Override
    Collection <? extends GrantedAuthority> getAuthorities(){
        return roles.collect {ApplicationRole authority ->
            new SimpleGrantedAuthority(authority.name)
        }
    }

    @Override
    boolean isAccountNonExpired() {
        return nonExpiredAccount
    }

    @Override
    boolean isAccountNonLocked(){
        return nonLockedAccount
    }

    @Override
    boolean isCredentialsNonExpired(){
        return nonExpiredCredentials
    }

    @Override
    boolean isEnabled(){
        return isAccountEnabled
    }

}
