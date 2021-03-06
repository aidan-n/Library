package infrastructure;

import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import timing.Ticker;
import event.EventManager;

/**
 * The {@code Attachments} class is meant to hold a various amount of
 * attachments that help the overall Library.
 * 
 * @author Albert Beaupre
 */
public class Attachments {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); // This is used for any sort of console logging

    private static Ticker TICKER; // This is an attached Ticker that will globally handle Ticks
    private static EventManager EVENT_MANAGER; // This is an attached EventManager that will globally handle Events

    /**
     * Attaches the specified {@code ticker} to this {@code Attachments} class
     * scheduled to the specified {@code service} to run the {@code ticker}.
     * 
     * @param service
     *            the service to run the ticker
     * @param ticker
     *            the ticker to attach
     */
    public static void attachTicker(ScheduledExecutorService service, Ticker ticker) {
	if (Attachments.TICKER != null) {
	    LOGGER.warning("A Ticker has already been attached");
	    return;
	}
	Attachments.TICKER = Objects.requireNonNull(ticker, "The Ticker cannot be attached as NULL");
	service.scheduleAtFixedRate(ticker, 1, 1, TimeUnit.MILLISECONDS);
	LOGGER.info("A Ticker has successfully been attached");
    }

    /**
     * Returns the {@code Ticker} that has been attached to this
     * {@code Attachments} class that will globally handle Ticks.
     * 
     * @throws NullPointerException
     *             if the {@code Ticker} of this class is {@code null}
     * 
     * @return the {@code Ticker} that has been attached
     */
    public static Ticker getTicker() {
	if (Attachments.TICKER == null)
	    throw new NullPointerException("There is not a Ticker attached");
	return Attachments.TICKER;
    }

    /**
     * Attaches the specified {@code eventManager} to this {@code Attachments}
     * class so it may globally handle any {@code Event}.
     * 
     * @param eventManager
     *            the {@code EventMaanger} to attach
     */
    public static void attachEventManager(EventManager eventManager) {
	if (Attachments.EVENT_MANAGER != null) {
	    LOGGER.warning("An EventManager has already been attached");
	    return;
	}
	Attachments.EVENT_MANAGER = Objects.requireNonNull(eventManager, "The EventManager cannot be attached as NULL");
	LOGGER.info("An EventManager has successfully been attached");
    }

    /**
     * Returns the {@code EventManager} that has been attached to this
     * {@code Attachments} class that will globally handle any {@code Event}.
     * 
     * @throws NullPointerException
     *             if the {@code EventManager} of this class is {@code null}
     * 
     * @return the {@code EventManager} that has been attached
     */
    public static EventManager getEventManager() {
	if (Attachments.EVENT_MANAGER == null)
	    throw new NullPointerException("There is not an EventManager attached");
	return Attachments.EVENT_MANAGER;
    }
}
