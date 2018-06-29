package packt.book.jee.eclipse.ch7.web.servlet;

import static java.util.Arrays.asList;
import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

import java.util.HashMap;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class SimpleMapIdentityStore implements IdentityStore {
	class UserInfo {
		String userName;
		String password;
		String role;
		
		public UserInfo(String userName, String password, String role) {
			this.userName = userName;
			this.password = password;
			this.role = role;
		}
	}
	
	private HashMap<String, UserInfo> store = new HashMap<>();
	
	public SimpleMapIdentityStore() {
		UserInfo user1 = new UserInfo("user1", "user1_pass", "admin");
		UserInfo user2 = new UserInfo("user2", "user2_pass", "user");
		UserInfo user3 = new UserInfo("user3", "user3_pass", "manager");
		store.put(user1.userName, user1);
		store.put(user2.userName, user2);
		store.put(user3.userName, user3);
	}
	
	 public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
	    String userName = usernamePasswordCredential.getCaller();
	    String password = usernamePasswordCredential.getPasswordAsString();        
	    
	    UserInfo userInfo = this.store.get(userName.toLowerCase());
	    if (userInfo == null || !userInfo.password.equals(password)) {
	    		return INVALID_RESULT;
	    }
	    
       return new CredentialValidationResult(userInfo.userName, new HashSet<>(asList(userInfo.role)));
	 }	 	
}
