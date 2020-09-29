import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href='mailto:sabrinee.ayachi@gmail.com">Sabrine Ayachi</a>
 *
 * @since 28 sept. 2020
 */
public final class ListOperations <T>  extends AbstractList<List<T>> {

    private final List<T> list;
    private final int splitSize;

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ListOperations.class));


    public ListOperations(List<T> list, int splitSize) {
        this.list = new ArrayList<>(list);
        this.splitSize = splitSize;
    }

    @Override
    public List<T> get(int index) {
        int beginIndex = index * splitSize;
        int endIndex = Math.min(beginIndex + splitSize, list.size());

        if (beginIndex > endIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of the list range" + (size() - 1) );
        }

        return new ArrayList<>(list.subList(beginIndex, endIndex));
    }

    @Override
    public int size() {
        return (int) Math.ceil((double) list.size() / (double) splitSize);
    }


    public  Collection<List<T>> partition() {
        AtomicInteger i= new AtomicInteger(-1);

        Collection<List<T>> result = list.stream()
                .collect(Collectors.groupingBy(it ->{ i.set(i.get()+1); return i.get() / splitSize;}))
                .values();

        return result;
    }

    public static void main(String [] args){
        List<Integer> inputList = Stream
                .of(args[0].split(", "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        ListOperations<Integer> l = new ListOperations<Integer>(inputList,Integer.parseInt(args[1]));

        LOGGER.info(l.partition().toString());
    }
}
