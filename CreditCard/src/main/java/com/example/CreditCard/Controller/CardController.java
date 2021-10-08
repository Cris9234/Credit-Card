package com.example.CreditCard.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CreditCard.Models.Payload;
import com.example.CreditCard.Models.Card;
import com.example.CreditCard.Models.Stat;

@RestController
@RequestMapping("/card-scheme/")
public class CardController {
	
	public static final Logger logger = LoggerFactory.getLogger(Stat.class);

	@GetMapping("verify/{id}")
	public Stat getStat(@PathVariable String id) {
		String url = "https://lookup.binlist.net/";
		RestTemplate restTemplate = new RestTemplate();
		if (id.length() == 6 || id.length() == 8) {
			try {
				Card card = restTemplate.getForObject(url + id , Card.class);
				
				Payload payload = new Payload();
				payload.setScheme(card.getScheme());
				payload.setType(card.getType());
				payload.setBank(card.getBank().getName());
				
				
				Stat stat = new Stat();
				stat.setSuccess(card.getNumber().getLuhn());
				stat.setBody(payload);
				
				return stat;
			} catch (Exception e) {
				logger.error("Error");
				return null;
			}
		} else {
			logger.error("id must be 6 or 8 digits long");
			return null;
		}
		
		
		
		
	}
}
