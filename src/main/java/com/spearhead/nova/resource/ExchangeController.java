package com.spearhead.nova.resource;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.spearhead.nova.config.CurrentUser;
import com.spearhead.nova.model.UserPrincipal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;



@Api(value = "Stock Exchange",tags={"Exchange and Stock Quotes"}, description = "Rest APIs that Returns Information about Stock Exchanges")
@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {

	List<String> quotes = new ArrayList<String>();
    {
        quotes.add(new String("Goodness"));
        quotes.add(new String("Doyin"));
        quotes.add(new String("Kenneth"));
        quotes.add(new String("Lanre"));
    }
    
    @GetMapping("/lists")
	public UserPrincipal getExchanges(@CurrentUser UserPrincipal userPrincipal) {



		return userPrincipal;
	}

	@GetMapping(value = "/quotes/{exchange}")
    public List<String> getQuotes(@PathVariable(value = "exchange") String exchange) {
        return quotes.stream().filter(x -> x.contains(exchange)).collect(Collectors.toList()); // .get(0); -- incase you want the first one
    }

    @GetMapping(value = "/quotes-live/{exchange}")
    public List<Object> getExternal(@PathVariable(value = "exchange") String exchange) {

        String url = "https://ag.leadinsight.ng/sysInternal/api/users";
        RestTemplate restplate = new RestTemplate();

        Object[] livequotes = restplate.getForObject(url, Object[].class);

        return Arrays.asList(livequotes); 
    }
    
}
