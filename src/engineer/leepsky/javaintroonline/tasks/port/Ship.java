package engineer.leepsky.javaintroonline.tasks.port;

/* Корабли заходят в порт для
разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
в порту и на корабле, должно быть неотрицательным и превышающим заданную
грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
У одного причала может стоять один корабль. Корабль может загружаться у причала
или разгружаться. */

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Ship {

    private final int containersCap;
    private final AtomicInteger containersCount = new AtomicInteger(0);

    public Ship(int containersCount, int containersCap) {
        if (containersCap < 1) {
            throw new IllegalArgumentException("Вместительность корабля должна быть больше 0.");
        }
        if (containersCount < 0) {
            throw new IllegalArgumentException("Количество контейнеров должно быть не меньше 0.");
        }
        if (containersCount > containersCap) {
            throw new IllegalArgumentException("Количество контейнеров на корабле не может превышать вместительность.");
        }
        this.containersCount.set(containersCount);
        this.containersCap = containersCap;
    }

    public int getContainersCap() {
        return containersCap;
    }

    public int getContainersCount() {
        return containersCount.get();
    }

    public synchronized void addContainer() {
        if (containersCount.get() < containersCap) {
            containersCount.incrementAndGet();
        }
    }

    public synchronized void removeContainer() {
        if (containersCount.get() > 0) {
            containersCount.decrementAndGet();
        }
    }

    @Override
    public String toString() {
        return "Ship{" +
                "containersCap=" + containersCap +
                ", containersCount=" + containersCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return containersCap == ship.containersCap && containersCount.equals(ship.containersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(containersCap, containersCount);
    }

}
