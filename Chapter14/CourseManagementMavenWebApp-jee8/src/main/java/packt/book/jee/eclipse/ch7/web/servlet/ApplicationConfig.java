package packt.book.jee.eclipse.ch7.web.servlet;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;

@DeclareRoles({"admin", "user", "manager"})
@ApplicationScoped
public class ApplicationConfig {
}
