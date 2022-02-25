public class Entrance implements Runnable{
    Controller controller;
    private int sleepScaler = 1000;
    private String name;
    Entrance (Controller controller, String name){
        this.controller = controller;
        this.name = name;
    }
    @Override
    public void run() {
        while (true){
            try {
                double random = Math.random();
                Thread.sleep((long) (random*sleepScaler));
                controller.enter();
                System.out.println(name + " arrive: " + controller.getSpaces());
            } catch (InterruptedException ex) {
                System.out.println("Interrupted Arrival Thread");
                return;
            }
        }
    }

}
