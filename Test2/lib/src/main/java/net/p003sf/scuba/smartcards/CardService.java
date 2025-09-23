package net.p003sf.scuba.smartcards;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CardService {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    protected static final int SESSION_STARTED_STATE = 1;
    protected static final int SESSION_STOPPED_STATE = 0;
    private static final Map<String, String> objectToServiceMap;
    private Collection<APDUListener> apduListeners = new HashSet();
    protected int state = 0;

    public abstract void close();

    public abstract byte[] getATR() throws CardServiceException;

    public abstract boolean isConnectionLost(Exception exc);

    public abstract boolean isOpen();

    public abstract void open() throws CardServiceException;

    public abstract ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException;

    static {
        HashMap map = new HashMap();
        objectToServiceMap = map;
        map.put("javax.smartcardio.CardTerminal", "net.sf.scuba.smartcards.TerminalCardService");
        objectToServiceMap.put("sun.security.smartcardio.TerminalImpl", "net.sf.scuba.smartcards.TerminalCardService");
        objectToServiceMap.put("android.nfc.tech.IsoDep", "net.sf.scuba.smartcards.IsoDepCardService");
    }

    public static CardService getInstance(Object object) throws ClassNotFoundException {
        Class<?> targetObjectClass;
        String serviceClassName;
        if (object == null) {
            throw new IllegalArgumentException();
        }
        Class<?> objectClass = object.getClass();
        String objectClassName = objectClass.getCanonicalName();
        for (Map.Entry<String, String> entry : objectToServiceMap.entrySet()) {
            String targetObjectClassName = entry.getKey();
            try {
                targetObjectClass = Class.forName(targetObjectClassName);
                serviceClassName = entry.getValue();
            } catch (ClassNotFoundException cnfe) {
                LOGGER.log(Level.FINEST, "Could not find class, trying next one", (Throwable) cnfe);
            }
            if (targetObjectClass.isInstance(object)) {
                try {
                    Class<?> cardServiceClass = Class.forName(serviceClassName);
                    return (CardService) cardServiceClass.getConstructor(targetObjectClass).newInstance(object);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            }
            continue;
        }
        throw new IllegalArgumentException("Could not find a CardService for object of class \"" + objectClassName + "\"");
    }

    public void addAPDUListener(APDUListener l) {
        Collection<APDUListener> collection = this.apduListeners;
        if (collection != null && l != null) {
            collection.add(l);
        }
    }

    public void removeAPDUListener(APDUListener l) {
        Collection<APDUListener> collection = this.apduListeners;
        if (collection != null) {
            collection.remove(l);
        }
    }

    public Collection<APDUListener> getAPDUListeners() {
        return Collections.unmodifiableCollection(this.apduListeners);
    }

    protected void notifyExchangedAPDU(APDUEvent event) {
        Collection<APDUListener> collection = this.apduListeners;
        if (collection == null || collection.isEmpty()) {
            return;
        }
        for (APDUListener listener : this.apduListeners) {
            listener.exchangedAPDU(event);
        }
    }

    public boolean isExtendedAPDULengthSupported() {
        return false;
    }
}
