package evanq.game.utils;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;


/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class DefaultAttributeMap implements AttributeMap{

    @SuppressWarnings("rawtypes")
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, Map> updater =
            AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, Map.class, "map");

    // Initialize lazily to reduce memory consumption; updated by AtomicReferenceFieldUpdater above.
    @SuppressWarnings("UnusedDeclaration")
    private volatile Map<AttributeKey<?>, Attribute<?>> map;

    @Override
    public <T> Attribute<T> attr(AttributeKey<T> key) {
        Map<AttributeKey<?>, Attribute<?>> map = this.map;
        if (map == null) {
            // Not using ConcurrentHashMap due to high memory consumption.
            map = new IdentityHashMap<AttributeKey<?>, Attribute<?>>(2);
            if (!updater.compareAndSet(this, null, map)) {
                map = this.map;
            }
        }

        synchronized (map) {
            @SuppressWarnings("unchecked")
            Attribute<T> attr = (Attribute<T>) map.get(key);
            if (attr == null) {
                attr = new DefaultAttribute<T>(map, key);
                map.put(key, attr);
            }
            return attr;
        }
    }

    private static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {

        private static final long serialVersionUID = -2661411462200283011L;

        private final Map<AttributeKey<?>, Attribute<?>> map;
        private final AttributeKey<T> key;

        DefaultAttribute(Map<AttributeKey<?>, Attribute<?>> map, AttributeKey<T> key) {
            this.map = map;
            this.key = key;
        }

        @Override
        public AttributeKey<T> key() {
            return key;
        }

        @Override
        public T setIfAbsent(T value) {
            while (!compareAndSet(null, value)) {
                T old = get();
                if (old != null) {
                    return old;
                }
            }
            return null;
        }

        @Override
        public T getAndRemove() {
            T oldValue = getAndSet(null);
            remove0();
            return oldValue;
        }

        @Override
        public void remove() {
            set(null);
            remove0();
        }

        private void remove0() {
            synchronized (map) {
                map.remove(key);
            }
        }
    }

}
