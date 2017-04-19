package se.nackademin.pagebeans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.nackademin.domain.User;
import se.nackademin.session.SessionBean;

@Named
@RequestScoped
public class AuthenticationPageBean {
    
    @Inject
    private SessionBean sessionHandler;

    private User selectedUser;
    
    // outcome
    public String doLogin(){
        if (getSessionHandler().retrieve(getSelectedUser().getId()) != null){
            throw new RuntimeException("You are already logged in " + getSelectedUser().getUserName());
        }
        getSessionHandler().persist(getSelectedUser());
        return"/userPages/welcome.xhtml";
    }
    
    public String doLogout(){
        getSessionHandler().remove(getSelectedUser().getId());
        return"/index.xhtml";
    }
    
    
    // get
    public SessionBean getSessionHandler() {
        return sessionHandler;
    }

    public User getSelectedUser() {
        if (selectedUser == null) {
            selectedUser = new User();
        }
        return selectedUser;
    }
    
    // set
    public void setSessionHandler(SessionBean sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

}