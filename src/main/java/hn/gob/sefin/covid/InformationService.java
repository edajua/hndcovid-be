package hn.gob.sefin.covid;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;



import hn.gob.sefin.covid.pojo.Egreso;
import hn.gob.sefin.covid.pojo.Ingreso;

@Path("rest")
public class InformationService {
	
	private static final String URL = "192.168.0.7";
	private static final int PORT = 11222 ;


	private RemoteCacheManager cacheManager;
	private RemoteCache<String, Object> cache;

    
	@GET
	@Path("/ingresos")
	@Produces({"application/json"})
    public List<Ingreso> getAllIngresos() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
              .host(URL)
              .port(PORT);
        cacheManager = new RemoteCacheManager(builder.build());

        cache = cacheManager.getCache("ingreso");
        
		return (List<Ingreso>) cache.get("ingreso");
    }
	

	@GET
	@Path("/egresos")
	@Produces({"application/json"})
    public List<Egreso> getAllEgresos() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
              .host(URL)
              .port(PORT);
        cacheManager = new RemoteCacheManager(builder.build());

        cache = cacheManager.getCache("ingreso");
        
		return (List<Egreso>) cache.get("egreso");
    }
	

	@GET
	@Path("/updateIngresos")
    public void updateIngresos() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
              .host(URL)
              .port(PORT);
        cacheManager = new RemoteCacheManager(builder.build());

        cache = cacheManager.getCache("ingreso");

		List<Ingreso> ingresos = new ArrayList<Ingreso>();
		for(int i=0;i<100;i++) {
			ingresos.add(new Ingreso("asdasda","dsadsada",Math.random()*10000));
			ingresos.add(new Ingreso("dsfdsf","dsadsada",Math.random()*10000));
			ingresos.add(new Ingreso("sdfdsf","dsadsada",Math.random()*10000));
			ingresos.add(new Ingreso("asdasda","dsfsd",Math.random()*10000));
			ingresos.add(new Ingreso("sdfdsf","dsadsada",Math.random()*10000));
		}
		cache.put("ingreso", ingresos);
		
    }

	@GET
	@Path("/updateEgresos")
    public void updateEgresos() {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addServer()
              .host(URL)
              .port(PORT);
        cacheManager = new RemoteCacheManager(builder.build());

        cache = cacheManager.getCache("ingreso");
		List<Egreso> egresos = new ArrayList<Egreso>();
        for(int i=0;i<100;i++) {
			egresos.add(new Egreso("asdasda","dsadsada",Math.random()*10000));
			egresos.add(new Egreso("dsfdsf","dsadsada",Math.random()*10000));
			egresos.add(new Egreso("sdfdsf","dsadsada",Math.random()*10000));
			egresos.add(new Egreso("asdasda","dsfsd",Math.random()*10000));
			egresos.add(new Egreso("sdfdsf","dsadsada",Math.random()*10000));
        }
		
		 cache.put("egreso", egresos);
		 
    }
	
	
}
