import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlattenIterable {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Iterable<Iterable<String>> TwoDemensionIterable = new ArrayList<>();
       Stream<String> stringStream = StreamSupport
                .stream(TwoDemensionIterable.spliterator(), false).flatMap(
                        iterable -> StreamSupport
                            .stream(iterable.spliterator(), false)
                );
    }
}
