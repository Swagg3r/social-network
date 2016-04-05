package social.network.dao;

import social.network.Personne;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {
	static {
		ObjectifyService.register(Personne.class);
	}
	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}
	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
}