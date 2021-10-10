package com.example.CreditCard.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.CreditCard.Models.Payload;
import com.example.CreditCard.Models.Card;
import com.example.CreditCard.Models.Stat;
import com.example.CreditCard.Models.Stat2;


@RestController
@RequestMapping("/card-scheme/")
public class CardController {
	
	public static final Logger logger = LoggerFactory.getLogger(Stat.class);
	
	HashMap<String, Integer> idTime = new HashMap<>();
	ArrayList<String> ID = new ArrayList<>();
	

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
				stat.setPayload(payload);
				
				if (idTime.containsKey(id)) {
					idTime.merge(id, 1, Integer::sum);
					
				} else {
					int count = 1;
					idTime.put(id, count);
					ID.add(id);
				}
				
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

	@GetMapping("stats")
	public Stat2 getStat2(@RequestParam Integer start, @RequestParam Integer limit) {

		HashMap<String, Integer> map = new HashMap<>();
		
		try {
			String success = null;
			if (start <= limit) {
				success = "true";
				if (idTime.size() < 3) {
					limit = idTime.size();
					for (int i = start - 1; i < limit; i++) {
						map.put(ID.get(i), idTime.get(ID.get(i)));
					}
				} else {
					for (int i = start - 1; i < limit; i++) {
						map.put(ID.get(i), idTime.get(ID.get(i)));
					}
				}
			} else {
				logger.error("limit should be greater than or equal to start");
			}
			
			Stat2 stat2 = new Stat2();
			long noBytes = map.size() * 32 + 48;
			
			stat2.setSuccess(success);
			stat2.setSize(noBytes);
			stat2.setPayload(map);
			
			return stat2;
		} catch (Exception e) {
			logger.error("Error");
			return null;
		}
		
	}
}
