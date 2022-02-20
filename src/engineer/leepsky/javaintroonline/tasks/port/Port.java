package engineer.leepsky.javaintroonline.tasks.port;

/* Корабли заходят в порт для
разгрузки/загрузки контейнеров. Число контейнеров, находящихся в текущий момент
в порту и на корабле, должно быть неотрицательным и превышающим заданную
грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
У одного причала может стоять один корабль. Корабль может загружаться у причала
или разгружаться. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Port {

    class Pier {

        enum State {
            WORKING,
            IDLE
        }

        private Ship currentShip;
        private State state;

        public Pier(Ship ship) {
            this.currentShip = ship;
            state = State.WORKING;
        }

        public void setShip(Ship ship) {
            if (state == State.IDLE) {
                this.currentShip = ship;
                state = State.WORKING;
            }
        }

        public void process() {
            if ((float)currentShip.getContainersCount() / currentShip.getContainersCap() >= 0.5) {
                new Unloading().start();
            } else {
                new Loading().start();
            }
        }

        class Loading extends Thread {

            @Override
            public void run() {

                System.out.println("Started loading a ship.");
                AtomicInteger loaded = new AtomicInteger(0);

                while (currentShip.getContainersCap() > currentShip.getContainersCount()) {
                    try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
                    if (containersCount.get() > 0) {
                        loaded.incrementAndGet();
                        currentShip.addContainer();
                    } else { break; }
                }

                if (currentShip.getContainersCap() == currentShip.getContainersCount()) {
                    System.out.println("Fully loaded a ship with " + loaded.get() + "containers.");
                } else {
                    System.out.println("Partially loaded a ship with capacity (" +
                            loaded.get() +
                            "/" +
                            currentShip.getContainersCap() + ")");
                }

                state = Pier.State.IDLE;

            }
        }

        class Unloading extends Thread {

            @Override
            public void run() {

                System.out.println("Started unloading a ship.");
                AtomicInteger unloaded = new AtomicInteger(0);

                while (currentShip.getContainersCount() != 0) {
                    try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
                    if (containersCount.get() <= containersCap) {
                        unloaded.incrementAndGet();
                        currentShip.removeContainer();
                    } else { break; }
                }

                if (currentShip.getContainersCount() == 0) {
                    System.out.println("Fully unloaded a ship with " + unloaded.get() + "containers.");
                } else {
                    System.out.println("Partially unloaded a ship (" +
                            unloaded.get() +
                            "/" +
                            currentShip.getContainersCap() + ")");
                }

                state = Pier.State.IDLE;

            }
        }
    }

    private final List<Pier> pierList = Collections.synchronizedList(new ArrayList<>());
    private final int containersCap;
    private final AtomicInteger containersCount = new AtomicInteger();

    public Port(int containersCount, int containersCap) {
        this.containersCap = containersCap;
        this.containersCount.set((float)containersCount / containersCap <= 1 ? containersCount : containersCap);
    }

    public int getContainersCount() {
        return containersCount.get();
    }

    public int getContainersCap() {
        return containersCap;
    }

    public void addShip(Ship ship) {
        if (ship == null) return;
        for (Pier pier : pierList) {
            if (pier.state == Pier.State.IDLE) {
                pier.setShip(ship);
                pier.process();
                return;
            }
        }
        pierList.add(new Pier(ship));
        pierList.get(pierList.size() - 1).process();
    }
}
