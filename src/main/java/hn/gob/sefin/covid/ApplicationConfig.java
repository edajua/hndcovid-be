package hn.gob.sefin.covid;
import java.util.HashSet;
import java.util.Set;
 
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 

@ApplicationPath("/")
public class ApplicationConfig  extends Application{
    private Set<Object> singletons = new HashSet<Object>();
    
    public ApplicationConfig() {
        singletons.add(new InformationService());
    }
 
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
