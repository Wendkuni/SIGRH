package net.gestion.pgpu.common.util;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchFilterUtils {

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
    
    /**
     * <p>Methode permettand de filtrer une liste sur la base distinct avec plusieurs parametres
     * <p> Ex: listAFiltrer.stream()
     * .filter(distinctByKeyMultiple(p ->Arrays.asList( p.getKey,	p.getKey1,p.getKey2,...)))
	*.collect(Collectors.toList());	  
     * @param <T>
     * @param keyExtractor
     * @return Liste filtrer en fonction des parametres qui ont été passés
     * @author KIEMA T. W. ARNAUD
     */
    public static <T> Predicate<T> distinctByKeys(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
