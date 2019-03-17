package hello;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemFailureLoggerListener extends ItemListenerSupport<Person, Person> {

    private static Log logger = LogFactory.getLog(ItemFailureLoggerListener.class);

    public void onReadError(Exception ex) {
        logger.error("Encountered error on reading line : " + ((FlatFileParseException) ex).getInput() + "\n Line number : " + ((FlatFileParseException) ex).getLineNumber(), ex);
    }

    public void onWriteError(Exception ex, List items) {
        logger.error("Encountered error on write", ex);
    }
}