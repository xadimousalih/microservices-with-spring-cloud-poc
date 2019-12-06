package sn.touba.xadimousalih.zuulapigatewayserver.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	//Activation de ce filter ou pas?
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//Logique métier du filtre
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		log.info("******** xadimouSALIH requête provenant de zuul ==> {} dont l'url est {} *********", request, request.getRequestURI());
		
		return null;
	}

	//type de filtre à exécuter (avant l'exécution d'une requête == "pre", après l'exécution d'une requête == "post", ou simplement les requêtes contenant des erreurs == "error" 
	@Override
	public String filterType() {
		return "pre";
	}

	
	//Permet de spécifier la priorité des filtree en cas de filtres multiples
	@Override
	public int filterOrder() {
		return 1;
	}

}
